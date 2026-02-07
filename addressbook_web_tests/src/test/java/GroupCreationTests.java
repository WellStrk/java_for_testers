import model.Group;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        openGroupsPage();
        createGroup(new Group("group name", "group header", "group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup(new Group());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        openGroupsPage();
        var emptyGroup = new Group();
        var groupWithName = emptyGroup.withName("someName");
        createGroup(groupWithName);
    }
}
