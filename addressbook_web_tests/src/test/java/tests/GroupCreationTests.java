package tests;

import manager.ApplicationManager;
import model.Group;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        app.openGroupsPage();
        ApplicationManager.createGroup(new Group("group name", "group header", "group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.openGroupsPage();
        ApplicationManager.createGroup(new Group());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.openGroupsPage();
        var emptyGroup = new Group();
        var groupWithName = emptyGroup.withName("someName");
        ApplicationManager.createGroup(groupWithName);
    }
}
