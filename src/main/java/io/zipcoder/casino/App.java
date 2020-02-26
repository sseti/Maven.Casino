package io.zipcoder.casino;

import io.zipcoder.casino.models.Wallet;
import io.zipcoder.casino.players.Player;
import io.zipcoder.casino.utilities.builders.PlayerBuilder;
import io.zipcoder.casino.utilities.io.AbstractConsole;
import io.zipcoder.casino.utilities.io.LoginConsole;
import io.zipcoder.casino.utilities.persistence.SaveLoadServices;

public class App {

    public static void main(String[] args) {
        App application = new App();
        application.initialize();


        // How to use builders
        Player playTest = new PlayerBuilder().setAge(1).setName("").setPassword("").setWallet(new Wallet()).createPlayer();

    }

    public void initialize() {
        SaveLoadServices.loadJSONData(SaveLoadServices.SAVE_FILE_NAME);
        LoginConsole login = new LoginConsole();
        login.printPrompt(AbstractConsole.PromptMessage.WELCOME, true);
    }

}
