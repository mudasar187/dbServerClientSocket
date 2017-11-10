package Server;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadManagerTest {

    private ThreadManager threadManager;

    @Before
    public void setup() {
        threadManager = new ThreadManager();
    }

    @Test
    public void getLecturersTest() throws Exception {
        Assert.assertNotNull(threadManager.getInformationFromDataBase("Lectures").getParsedString());

    }

    @Test
    public void getLecturerTest() {
        Assert.assertNotNull(threadManager.getInformationFromDataBase("Lectures Per").getParsedString());
    }

    @Test
    public void getNullFromDatabase() {
        Assert.assertEquals(threadManager.getInformationFromDataBase("nonesense").getParsedString(), "No match for search value nonesense");
    }

    @Test
    public void testForNoMatchFromDatabase() {
        Assert.assertEquals(threadManager.getInformationFromDataBase("Lectures rep").getParsedString(), "");
    }

}