package org.example.finalWorkJava.data;

import org.example.finalWorkJava.probability.Probability;

public class Toy {
    private int id;
    private String name;
    private Probability probability;


    public Toy() {
    }

    public Toy(int id, String name,  Probability probability) {
        this.id = id;
        this.name = name;
        this.probability = probability;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return id + "," + name + "," + probability;
    }

    public String getName() {
        return name;
    }
}
