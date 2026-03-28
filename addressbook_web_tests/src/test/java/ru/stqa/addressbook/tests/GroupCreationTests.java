package ru.stqa.addressbook.tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.Group;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupCreationTests extends TestBase {


    public static List<Group> groupProvider() throws IOException {
        var result = new ArrayList<Group>();

        // var json = ""; -- другой способ начало
        //  try (var reader = new FileReader("groups.json");
        //  var breader = new BufferedReader(reader)
        //  ) {
        //       var line = breader.readLine();
        //      while (line != null) {
        //        json = json + line;
        //        line = breader.readLine();
        //     }
        //     } -- другой способ конец

        var json = Files.readString(Paths.get("groups.json"));  // более короткий способ того что выше
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<Group>>() {
        });
        result.addAll(value);

        //   var mapper = new XmlMapper();
        //  Group[] groups = mapper.readValue(new File("groups.xml"), Group[].class); // читаем как массив
        //  result.addAll(Arrays.asList(groups));

        return result;
    }

    public static Stream<Group> randomGroups() {
        Supplier<Group> randomGroup = () -> new Group()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(20))
                .withFooter(CommonFunctions.randomString(30));
        return Stream.generate(randomGroup).limit(1);
    }

    @ParameterizedTest
    @MethodSource ("randomGroups")
    public void canCreateGroup(Group group) {
        var oldGroups = app.hbm().getGroupList(); //загрузка списка групп из веб приложения
        app.groups().createGroup(group);
        var newGroups = app.hbm().getGroupList();

        var extraGroups = newGroups.stream().filter(g -> ! oldGroups.contains(g)).toList(); // поиск ид который отсутствовал в старом списке
        var newId = extraGroups.get(0).id(); // ид который отсутствовал в старом списке

        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newId));
        Allure.step("Validating results", step -> {
        Assertions.assertEquals(Set.copyOf(newGroups),  Set.copyOf(expectedList));
        });
    }


    public static List<Group> negativeGroupProvider() {
        var result = new ArrayList<Group>(List.of(
                new Group("", "group name'", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource ("negativeGroupProvider")
    public void cannotCreateGroup(Group group) {
        var oldGroups = app.hbm().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.hbm().getGroupList();
        Comparator<Group> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.sort(compareById);
        Allure.step("Validating results", step -> {
        Assertions.assertEquals(newGroups,  oldGroups);
        });
    }
}
