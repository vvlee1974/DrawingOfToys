package org.example.finalWorkJava.controller;

import org.example.finalWorkJava.data.Toy;
import org.example.finalWorkJava.servises.ToysData;

import java.util.List;

public class Controller {
    private final ToysData toysData = new ToysData();

    public Toy inputToy(){
        return toysData.input();
    }

    public void send(Toy toy) {
        toysData.create(toy);
    }

    public List<Toy> show() {
        return toysData.read();
    }

    public void recBase(){
        toysData.recBaseFile();
    }

    public void readerBase(){
        toysData.readerBaseFile();
    }
}
