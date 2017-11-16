package Server;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


public class ThreadManagerTest {

    /**
     * Start server and xampp to test
     */

    private ThreadManager threadManager;

    @Before
    public void setup() {
        threadManager = new ThreadManager();
    }

    @Test
    public void testGetGetAllLecturers() throws Exception {
        assertNotNull(threadManager.getInformationFromDataBase("Lectures").getParsedString());

    }

    @Test
    public void testGetSpecificLecturer() {
        assertNotNull(threadManager.getInformationFromDataBase("Lectures Per").getParsedString());
    }

    @Test
    public void getNullFromDatabase() {
        assertEquals(threadManager.getInformationFromDataBase("nonesense").getParsedString(), "### No match for search value nonesense ###");
    }

    @Test
    public void testForNoMatchFromDatabase() {
        assertEquals(threadManager.getInformationFromDataBase("Lectures rep").getParsedString(), "");
    }

    @Test
    public void testGetAllSubjects() throws Exception {
        assertEquals(threadManager.getInformationFromDataBase("Subject").getParsedString(), "\n" +
                "\n" +
                " Subject code: DB1100\n" +
                "\n" +
                " Subject code: PGR100\n" +
                "\n" +
                " Subject code: PGR101\n" +
                "\n" +
                " Subject code: PGR200\n" +
                "\n" +
                " Subject code: PRO200\n" +
                "\n" +
                " Subject code: TK1100\n" +
                "\n" +
                " Subject code: TK2100\n" +
                "\n" +
                " Subject code: PG4200\n" +
                "\n" +
                " Subject code: PGR201\n" +
                "\n" +
                " Subject code: PRO202\n" +
                "\n" +
                " Subject code: PG3300");
    }

    @Test
    public void testGetSpecificSubject () throws Exception {
        assertEquals(threadManager.getSpesificInformationFromDatabase("Subject PGR200").getParsedString(), "\n" +
                "SubjectCode: PGR200\n" +
                "Subject name: Avansert javaprogrammering\n" +
                "Particants: 60\n" +
                "Teacher: Per Lauvås\n");
    }

    @Test
    public void testGetAllAvailabilities() throws Exception {
        assertNotNull(threadManager.getInformationFromDataBase("Availability").getParsedString());
    }

    @Test
    public void testGetAllRooms() throws Exception {
        assertNotNull(threadManager.getInformationFromDataBase("Room").getParsedString());
    }

    @Test
    public void testGetSpecificRoom() throws Exception {
        assertEquals(threadManager.getSpesificInformationFromDatabase("Room F101").getParsedString(), "\n" +
                " Roomnumber: F101\n" +
                "Capacity: 150\n" +
                "Roomtype: Stor auditorium,med overhead\n");
    }

    @Test
    public void testGetAllPrograms() throws Exception {
        assertNotNull(threadManager.getInformationFromDataBase("Program").getParsedString());
    }

    @Test
    public void testGetSpecificProgram() throws Exception {
        assertEquals(threadManager.getSpesificInformationFromDatabase("Program E-Buiness").getParsedString(), "\n" +
                "Id: 4\n" +
                "Program ame: E-Buiness\n" +
                "Participants: 60\n" +
                "Start: 2017-08-20\n" +
                "End: 2017-12-22\n");
    }

    @Test
    public void testGetInformationFromDatabaseWithEmptyString() throws Exception {
        assertEquals(threadManager.getInformationFromDataBase("").getParsedString(), "### No match for search value  ###");
    }
}