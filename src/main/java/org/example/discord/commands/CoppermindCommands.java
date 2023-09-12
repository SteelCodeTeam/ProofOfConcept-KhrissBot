package org.example.discord.commands;

import discord4j.core.object.command.ApplicationCommandOption;
import discord4j.discordjson.json.ApplicationCommandOptionChoiceData;
import discord4j.discordjson.json.ApplicationCommandOptionData;
import discord4j.discordjson.json.ApplicationCommandRequest;
import discord4j.rest.interaction.GlobalCommandRegistrar;
import org.example.coppermind.entities.OrderingType;
import org.example.discord.DiscordApi;

public class CoppermindCommands {
    public static ApplicationCommandRequest WOB_COMMAND;
    public static void init() {
        WOB_COMMAND = ApplicationCommandRequest.builder()
                .name("wob")
                .description("Search word in wobs.")
                .addOption(ApplicationCommandOptionData.builder()
                        .name("word")
                        .description("Must be a word or one expresion")
                        .type(ApplicationCommandOption.Type.STRING.getValue())
                        .required(true)
                        .build())
                .addOption(ApplicationCommandOptionData.builder()
                        .name("tag")
                        .description("Tag para clasificar")
                        .type(ApplicationCommandOption.Type.STRING.getValue())
                        .required(false)
                        .build())
                .addOption(ApplicationCommandOptionData.builder()
                        .name("ordering")
                        .description("default: NEWEST FIRST. must be: \"newest\", \"oldest\" or \"rank\"")
                        .type(ApplicationCommandOption.Type.STRING.getValue())
                        .addChoice(ApplicationCommandOptionChoiceData.builder().name("newest").value(OrderingType.NEWEST_FIRST.getLiteral()).build())
                        .addChoice(ApplicationCommandOptionChoiceData.builder().name("oldest").value(OrderingType.OLDEST_FIRST.getLiteral()).build())
                        .addChoice(ApplicationCommandOptionChoiceData.builder().name("rank").value(OrderingType.ACCURATED.getLiteral()).build())
                        .required(false)
                        .build())
                .build();


    }





}
