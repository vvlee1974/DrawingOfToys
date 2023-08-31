package org.example.finalWorkJava.probability;

public class Probability implements IProbability{
    private int probability;

    public Probability() {
    }

    public Probability(int probability) {
        this.probability = probability;
    }

    @Override
    public int toProbability() {
        return probability;
    }


    @Override
    public String toString() {
        return String.valueOf(probability);
    }

}
