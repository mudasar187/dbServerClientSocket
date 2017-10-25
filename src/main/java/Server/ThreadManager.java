package Server;

import Database.DatabaseHandler.DBManager;
import Database.DTO.DTO;

public class ThreadManager {

    private DBManager dbManager = new DBManager();
    private DTO theDto;

    public ThreadManager() {
        theDto = new DTO();
    }

    //For oversikt
    // private String [] comboBox = {"Choose your table", "Lectures", "Subject", "Room", "Program", "Semester", "Availability"};

    public DTO getSpesificInformationFromDatabase(String messageFromClient) {
        String deltOppString = "";
        String resultString = "";
        if (messageFromClient.contains("Lectures ")) {
            deltOppString = messageFromClient.substring(0, 9);
            resultString = messageFromClient.replaceAll(deltOppString, "");
            System.out.println("Mottat etter delt opp string: " + resultString);
            theDto = dbManager.getForeleserByName(resultString);
        } else {
            theDto = new DTO("Default");
        }
        return theDto;
    }

    //Denne bestemmer hva som skal bli returnert fra databasen til serverThread som deretter sender til client
    public DTO getInformationFromDataBase(String messageFromClient) {
        switch (messageFromClient) {
            case "Choose your table":
                theDto = dbManager.getTables();
                break;
            case "Lectures":
                theDto = dbManager.getLectures();
                //Assign dto
                break;
            default:
                theDto = getSpesificInformationFromDatabase(messageFromClient);
                break;
        }
        return theDto;
    }
}
