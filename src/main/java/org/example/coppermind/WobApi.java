package org.example.coppermind;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.example.Main;
import org.example.coppermind.entities.OrderingType;
import org.example.coppermind.entities.WobEntity;
import org.example.coppermind.entities.WobLinesEntity;
import org.example.discord.DiscordApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WobApi {


    public static WobEntity searchInWobs(@NonNull String word, @Nullable String tag, @NonNull OrderingType ordering) {

        try {

            StringBuilder resultBuilder = new StringBuilder();
            StringBuilder urlBuilder = new StringBuilder();

            urlBuilder.append("https://wob.coppermind.net/api/search_entry");
            urlBuilder.append("?query=").append(word);
            if (tag != null) {
                urlBuilder.append("&tags=").append(tag);
            }
            urlBuilder.append("&ordering=").append(ordering);
            urlBuilder.append("&format=json");

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = buffReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            buffReader.close();
            WobEntity entity = Main.GSON.fromJson(resultBuilder.toString(), WobEntity.class);

            Main.LOGGER.info("LOG ENTITY = " + entity.toString());

            return entity;


        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return null;
    }
}
