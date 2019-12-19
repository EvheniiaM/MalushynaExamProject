package suits;

import listsTests.MyListsTest;
import listsTests.SeenListTest;
import listsTests.WatchListTest;
import loginTest.InvalidLoginTest;
import loginTest.ValidLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import profileTests.AvatarTest;
import profileTests.StatusTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidLoginTest.class,
                InvalidLoginTest.class,
                AvatarTest.class,
                StatusTest.class,
                MyListsTest.class,
                SeenListTest.class,
                WatchListTest.class
        }
)
public class AllTests {
}
