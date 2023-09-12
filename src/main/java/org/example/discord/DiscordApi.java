package org.example.discord;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ApplicationCommandInteractionEvent;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.command.ApplicationCommandInteraction;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import discord4j.rest.interaction.GlobalCommandRegistrar;
import org.example.Main;
import org.example.coppermind.WobApi;
import org.example.coppermind.entities.OrderingType;
import org.example.coppermind.entities.WobEntity;
import org.example.coppermind.entities.WobLinesEntity;
import org.example.discord.commands.CoppermindCommands;

import java.util.Collections;
import java.util.Optional;


public class DiscordApi {

    public static GatewayDiscordClient DISCORD;


    public static void init() {
        DISCORD = DiscordClient.create(token).login().block();

        DISCORD.on(ReadyEvent.class)
                            .subscribe(whenIsReady -> Main.LOGGER.info("Logged in as: " + whenIsReady.getSelf().getUsername()));


        CoppermindCommands.init();

        GlobalCommandRegistrar.create(DISCORD.getRestClient(), Collections.singletonList(CoppermindCommands.WOB_COMMAND))
            .registerCommands()
                .subscribe(commands -> Main.LOGGER.info("Registered command: " + commands.toString()));

        DISCORD.on(ApplicationCommandInteractionEvent.class, event -> {

                System.out.println("HOALAAAA");

                if (event.getCommandName().equals("wob")) {
                    Optional<ApplicationCommandInteraction> interaction = event.getInteraction().getCommandInteraction();

                    if (interaction.isPresent()) {
                        String word = interaction.get().getOption("word").flatMap(ApplicationCommandInteractionOption::getValue)
                                .map(ApplicationCommandInteractionOptionValue::asString)
                                .orElseThrow();

                        String tag = interaction.get().getOption("tag").flatMap(ApplicationCommandInteractionOption::getValue)
                                .map(ApplicationCommandInteractionOptionValue::asString)
                                .orElse(null);

                        String order = interaction.get().getOption("ordering").flatMap(ApplicationCommandInteractionOption::getValue)
                                .map(ApplicationCommandInteractionOptionValue::asString)
                                .orElse(OrderingType.NEWEST_FIRST.getLiteral());

                        Main.LOGGER.info("word:" + word + ", tag: " + tag + ", order: " + order);

                        OrderingType type;
                        if (order.equals("oldest"))
                            type = OrderingType.OLDEST_FIRST;
                        else if (order.equals("rank")) {
                            type = OrderingType.ACCURATED;
                        } else {
                            type = OrderingType.NEWEST_FIRST;
                        }

                        WobEntity result = WobApi.searchInWobs(word, tag, type);

                        StringBuilder message = new StringBuilder();
                        message.append("## Event: ").append(result.getResults().get(0).getEvent_name()).append("\n");
                        message.append("## Date: ").append(result.getResults().get(0).getDate()).append("\n");
                        message.append("\n");

                        for (WobLinesEntity line: result.getResults().get(0).getLines()) {
                            message.append("## " + line.getSpeaker() + "\n");
                            message.append(line.getText()+"\n");
                        }

                        message.append("\n tags:" + result.getResults().get(0).getTags());

                        return event.reply(message.toString());
                    }

                }

                return event.reply("Error");


        }).blockLast();
    }

}
