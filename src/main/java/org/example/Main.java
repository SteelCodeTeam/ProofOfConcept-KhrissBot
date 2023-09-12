package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.discord.DiscordApi;
import org.example.discord.commands.CoppermindCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public static Logger LOGGER = LoggerFactory.getLogger("KHRISS BOT");


    public static void main(String[] args) {
        DiscordApi.init();
    }
}