package com.algo.tsp;

import java.util.stream.IntStream;

public class App {
  public static void main(String[] args) {
    IntStream.range(0, 1000)
      .forEach(i -> Repository.addCity(new City()));

    SimulatedAnnealing annealing = new SimulatedAnnealing();
    annealing.simulation();

    System.out.println("Final approximated solution's distance is: " + annealing.getBest().getDistance());
    System.out.println("Tour (x, y): " + annealing.getBest());
  }
}
