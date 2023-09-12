package org.example.coppermind.entities;

public class WobLinesEntity {
    public String speaker;
    public String text;

    public WobLinesEntity(String speaker, String text) {
        this.speaker = speaker;
        this.text = text;
    }

    public WobLinesEntity() {
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "WobLinesEntity{" +
                "speaker='" + speaker + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
