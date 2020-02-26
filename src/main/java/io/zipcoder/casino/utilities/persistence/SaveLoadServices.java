package io.zipcoder.casino.utilities.persistence;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.zipcoder.casino.players.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaveLoadServices {

    public static String SAVE_FILE_NAME = "PlayerData";

    public static void saveJSON(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        String playerSaveFile = "/Users/Casino/" + fileName + ".json";
        if (!fileName.equals("")) {
            try {
                writer.writeValue(new File(playerSaveFile), Database.getAllPlayers());
            } catch (IOException e) {}
        }
    }

    public static void loadJSONData(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        String fullFile = "/Users/Casino/" + fileName + ".json";
        try {
            Database.reloadAllUsers(objectMapper.readValue(new File(fullFile), new TypeReference<ArrayList<Player>>(){}));
        } catch (JsonParseException e) {} catch (JsonMappingException e) {} catch (IOException e) {}
    }


}
