package com.algo.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Represents closed loop visiting all cities (Hamiltonian path and cycle).
 *
 * A valid tour visits all cities and ends where it started (Hamiltonian cycle).
 *
 * The goal of TSP is to minimize the distance in this tour.
 *
 * This will store a single solution and Simulated annealing will choose between these tours.
 *
 */
public class SingleTour {
  private List<City> tour = new ArrayList<>();
  private double distance = 0;

  public SingleTour() {
    IntStream.range(0, Repository.getNumOfCities())
      .forEach(i -> tour.add(null));
  }

  public SingleTour(List<City> tour) {
    List<City> currentTour = new ArrayList<>();

    // initialize the current tour to avoid NPE's.
    IntStream.range(0, tour.size())
      .forEach(i -> currentTour.add(null));

    // set the tour according to index.
    IntStream.range(0, tour.size())
      .forEach(i -> currentTour.set(i, tour.get(i)));

    this.tour = currentTour;
  }

  public double getDistance() {
    if (distance == 0) {

      int tourDistance = 0;
      for (int i = 0; i < getTourSize(); i++) {
          City fromCity = getCity(i);
          City destinationCity;

          // make sure we're not overlapping the start city.
          if (i + 1 < getTourSize()) {
            destinationCity = getCity(i + 1);
          }
          else {
            destinationCity = getCity(0);
          }

          tourDistance += fromCity.distanceTo(destinationCity);
      }

      this.distance = tourDistance;
    }
    return distance;
  }

  public List<City> getTour() {
    return tour;
  }

  /**
   * Generates an individual tour.
   */
  public void generateIndividual() {
    IntStream.range(0, Repository.getNumOfCities())
      .forEach(i -> setCity(i, Repository.getCity(i)));

    // Shuffle for Monte-Carlo randomization algorithm.
    Collections.shuffle(tour);
  }

  public void setCity(int cityIndex, City city) {
    this.tour.set(cityIndex, city);
    this.distance = 0;
  }

  public City getCity(int tourPosition) {
    return tour.get(tourPosition);
  }

  public int getTourSize() {
    return this.tour.size();
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    tour.forEach(city -> sb.append(city).append(" -> "));
    return sb.toString();
  }
}
