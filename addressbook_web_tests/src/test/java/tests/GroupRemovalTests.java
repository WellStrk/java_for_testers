package tests;

import manager.ApplicationManager;
import model.Group;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

       @Test
    public void canRemoveGroup() {
           app.openGroupsPage();
           if (app.isGroupPresent()) {
            ApplicationManager.createGroup(new Group("", "", ""));
        }
           app.removeGroup();

       }
}
