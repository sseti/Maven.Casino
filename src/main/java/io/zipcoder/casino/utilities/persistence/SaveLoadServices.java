package io.zipcoder.casino.utilities.persistence;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.zipcoder.casino.App;
import io.zipcoder.casino.models.Chip;
import io.zipcoder.casino.models.PlayingCard;
import io.zipcoder.casino.players.Player;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class SaveLoadServices {

    public static String SAVE_FILE_NAME = "PlayerData";

    public static void saveJSON(String fileName) {
        Player toProcessStatsFor = App.getCurrentPlayer();
        toProcessStatsFor = Database.processStats(toProcessStatsFor);
        Database.addUser(toProcessStatsFor);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        String playerSaveFile = "/Users/Casino/" + fileName + ".json";
        try {
            writer.writeValue(new File(playerSaveFile), Database.getAllPlayers());
            Logger.getGlobal().info("Saved JSON data successfully!");
        } catch (IOException e) {
            Logger.getGlobal().info("IOException when attemtping to save JSON data!");
        }
    }

    public static void loadJSONData(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        String fullFile = "/Users/Casino/" + fileName + ".json";
        try {
            Database.reloadAllUsers(objectMapper.readValue(new File(fullFile), new TypeReference<ArrayList<Player>>(){}));
            Logger.getGlobal().info("Loaded JSON player data successfully. DatabaseUsers.size()=" + Database.getAllPlayers().size());
        } catch (JsonParseException e) {} catch (JsonMappingException e) {} catch (IOException e) {
            Logger.getGlobal().info("IOException when attempting to load JSON player data!");
        }
    }


}
