package org.example.coppermind.entities;

import java.util.List;

public class WobResultEntity {

    private Long id;
    private Long event;
    private String event_name;
    private String event_date;
    private String event_state;
    private String date;
    private boolean paraphrased;
    private String modified_date;

    private List<String> tags;
    private List<WobLinesEntity> lines;

    private String note;


    public WobResultEntity(Long id, Long event, String event_name, String event_date, String event_state, String date,
                           boolean paraphrased, String modified_date, List<String> tags, List<WobLinesEntity> lines, String note) {
        this.id = id;
        this.event = event;
        this.event_name = event_name;
        this.event_date = event_date;
        this.event_state = event_state;
        this.date = date;
        this.paraphrased = paraphrased;
        this.modified_date = modified_date;
        this.tags = tags;
        this.lines = lines;
        this.note = note;
    }

    public WobResultEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEvent() {
        return event;
    }

    public void setEvent(Long event) {
        this.event = event;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_state() {
        return event_state;
    }

    public void setEvent_state(String event_state) {
        this.event_state = event_state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isParaphrased() {
        return paraphrased;
    }

    public void setParaphrased(boolean paraphrased) {
        this.paraphrased = paraphrased;
    }

    public String getModified_date() {
        return modified_date;
    }

    public void setModified_date(String modified_date) {
        this.modified_date = modified_date;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<WobLinesEntity> getLines() {
        return lines;
    }

    public void setLines(List<WobLinesEntity> lines) {
        this.lines = lines;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "WobResultEntity{" +
                "id=" + id +
                ", event=" + event +
                ", event_name='" + event_name + '\'' +
                ", event_date='" + event_date + '\'' +
                ", event_state='" + event_state + '\'' +
                ", date='" + date + '\'' +
                ", paraphrased=" + paraphrased +
                ", modified_date='" + modified_date + '\'' +
                ", tags=" + tags +
                ", lines=" + lines +
                ", note='" + note + '\'' +
                '}';
    }
}
