package Server;

import Database.DBManager;
import Database.DTO.DTO;

import java.sql.ResultSet;

public class ThreadManager {

    private DBManager dbManager = new DBManager();
    
    // Her parser vi beskjed fra client til server, og server retunerer beskjed utfra getValue

    public DTO getInformationFromDataBase(String messageFromClient) {
        DTO dto;
            switch(messageFromClient) {

                case "Get emner":
                   dto = dbManager.getEmneByEmneKode(messageFromClient);
                    break;

                    default:
                        dto = null;
                        break;
            }
            return dto;
        }
}
