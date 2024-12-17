package com.alura.ChallegeLiteralura.service;

import com.alura.ChallegeLiteralura.model.DatosLibro;

import java.util.List;

public class ApiResponse {
    private int count;
    private String next;
    private String previous;
    private List<DatosLibro> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
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

    public List<DatosLibro> getResults() {
        return results;
    }

    public void setResults(List<DatosLibro> results) {
        this.results = results;
    }


}
