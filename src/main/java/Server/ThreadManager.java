package Server;

import Database.DatabaseHandler.DBManager;
import Database.DTO.DTO;

public class ThreadManager {

    private DBManager dbManager = new DBManager();
    private DTO theDto;

    public ThreadManager() {
        theDto = new DTO();
    }

    public DTO getSpesificInformationFromDatabase(String messageFromClient) {
        String splitUpWords = "";
        String resultString = "";
        if (messageFromClient.contains("Lectures ")) {
            splitUpWords = messageFromClient.substring(0, 9);
            resultString = messageFromClient.replaceAll(splitUpWords, "");
            System.out.println("Mottat etter delt opp string: " + resultString);
            theDto = dbManager.getLecturedInfo(resultString);
        } else if (messageFromClient.contains("Subject ")) {
            splitUpWords = messageFromClient.substring(0, 8);
            resultString = messageFromClient.replaceAll(splitUpWords, "");
            theDto = dbManager.getInformationBySubjectCode(resultString);
        } else if (messageFromClient.contains("Room ")) {
            splitUpWords = messageFromClient.substring(0, 5);
            resultString = messageFromClient.replaceAll(splitUpWords, "");
            theDto = dbManager.getRoomInformation(resultString);
        } else if (messageFromClient.contains("Program ")) {
            splitUpWords = messageFromClient.substring(0, 8);
            resultString = messageFromClient.replaceAll(splitUpWords, "");
            theDto = dbManager.getProgramInformation(resultString);
        } else {
            theDto = new DTO("No match for search value " + messageFromClient);
        }
        return theDto;
    }

    //Denne bestemmer hva som skal bli returnert fra databasen til serverThread som deretter sender til client
    public DTO getInformationFromDataBase(String messageFromClient) {
        switch (messageFromClient) {
            case "Welcome":
                theDto = makeWelcomeMessage();
                break;
            case "Lectures":
                theDto = dbManager.getLectures();
                break;
            case "Subject":
                theDto = dbManager.getSubjectCodes();
                break;
            case "Availability":
                theDto = dbManager.getAvailability();
                break;
            case "Room":
                theDto = dbManager.getRoomsOverview();
                break;
            case "Program":
                theDto = dbManager.getProgramsOverview();
                break;
            default:
                theDto = getSpesificInformationFromDatabase(messageFromClient);
                break;
        }
        return theDto;
    }

    private DTO makeWelcomeMessage() {
        DTO dto = new DTO();
        dto.setParsedString("Welcome");
        return dto;
    }
}
