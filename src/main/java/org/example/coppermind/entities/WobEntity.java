package org.example.coppermind.entities;

import java.util.List;

public class WobEntity {
    public Long count;
    public String next;
    public String previous;
    public List<WobResultEntity> results;

    public WobEntity() {
    }

    public WobEntity(Long count, String next, String previous, List<WobResultEntity> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<WobResultEntity> getResults() {
        return results;
    }

    public void setResults(List<WobResultEntity> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WobEntity{");
        sb.append("count=").append(count);
        sb.append(", next='").append(next).append('\'');
        sb.append(", previous='").append(previous).append('\'');
        sb.append(", results=").append(results);
        sb.append('}');
        return sb.toString();
    }
}
