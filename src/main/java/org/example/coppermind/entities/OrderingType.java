package org.example.coppermind.entities;

public enum OrderingType {
    NEWEST_FIRST("-date"),
    OLDEST_FIRST("+date"),
    ACCURATED("rank");

    private String literal;

    OrderingType(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
