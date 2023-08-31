package org.example.finalWorkJava.servises;

import org.example.finalWorkJava.data.Toy;

import java.util.List;

public interface ICreateService {
    void create(Toy toy);

    List<Toy> read();

    Toy input();
}
