package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new Group("group name", "group header", "group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new Group());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().openGroupsPage();
        var emptyGroup = new Group();
        var groupWithName = emptyGroup.withName("someName");
        app.groups().createGroup(groupWithName);
    }
}
