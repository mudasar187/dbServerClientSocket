package Server;

import Database.DatabaseHandler.DBHandler;
import Database.DTO.DTO;

/**
 * <p>ThreadManager class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class ThreadManager {

    private DBHandler dbHandler = new DBHandler();
    private DTO theDto;

    /**
     * <p>Constructor for ThreadManager.</p>
     */
    public ThreadManager() {
        theDto = new DTO();
    }

    /**
     * This method handling the request from client when client is asking for specific information
     * Denne håndterer forespørsel, f.eks hvis bruker skriver Per, skal dette gjenkjennes og hentes fra lecturer tabellen
     *
     * <p>getSpesificInformationFromDatabase.</p>
     *
     * @param messageFromClient a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getSpesificInformationFromDatabase(String messageFromClient) {
        String splitUpWords = "";
        String resultString = "";
        if (messageFromClient.contains("Lectures ")) {
            splitUpWords = messageFromClient.substring(0, 9);
            resultString = messageFromClient.replaceAll(splitUpWords, "");
            theDto = dbHandler.getLecturedInfo(resultString);
        } else if (messageFromClient.contains("Subject ")) {
            splitUpWords = messageFromClient.substring(0, 8);
            resultString = messageFromClient.replaceAll(splitUpWords, "");
            theDto = dbHandler.getInformationBySubjectCode(resultString);
        } else if (messageFromClient.contains("Room ")) {
            splitUpWords = messageFromClient.substring(0, 5);
            resultString = messageFromClient.replaceAll(splitUpWords, "");
            theDto = dbHandler.getRoomInformation(resultString);
        } else if (messageFromClient.contains("Program ")) {
            splitUpWords = messageFromClient.substring(0, 8);
            resultString = messageFromClient.replaceAll(splitUpWords, "");
            theDto = dbHandler.getProgramInformation(resultString);
        } else {
            theDto = new DTO("No match for search value " + messageFromClient);
        }
        return theDto;
    }

    //Denne bestemmer hva som skal bli returnert fra databasen til serverThread som deretter sender til client
    /**
     * <p>getInformationFromDataBase.</p>
     *
     * @param messageFromClient a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getInformationFromDataBase(String messageFromClient) {
        switch (messageFromClient) {
            case "Choose options here":
                theDto = makeWelcomeMessage();
                break;
            case "Lectures":
                theDto = dbHandler.getLectures();
                break;
            case "Subject":
                theDto = dbHandler.getSubjectCodes();
                break;
            case "Availability":
                theDto = dbHandler.getAvailability();
                break;
            case "Room":
                theDto = dbHandler.getRoomsOverview();
                break;
            case "Program":
                theDto = dbHandler.getProgramsOverview();
                break;
            default:
                theDto = getSpesificInformationFromDatabase(messageFromClient);
                break;
        }
        return theDto;
    }

    private DTO makeWelcomeMessage() {
        DTO dto = new DTO();
        dto.setParsedString(" Welcome !\n"+
                " You can click on the box above to select options.\n" +
                " You can choose to retrieve all teachers, topics, rooms, programs and accessibility for teachers.\n" +
                " When you select one of these options, you will get a name for these choices.\n" +
                "\n If you would like more information about teacher, subject, room or program, you can type it in the search field.\n"+
                "\n Enjoy !");
        return dto;
    }
}
