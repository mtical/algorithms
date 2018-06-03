package com.algo.tsp;

public class SimulatedAnnealing {
  private SingleTour best;

  public void simulation() {
    double temperature = 10000;
    double coolingRate = 0.003;

    SingleTour currentSolution = new SingleTour();
    currentSolution.generateIndividual();

    System.out.println("Initial solution distance: " + currentSolution.getDistance());

    best = new SingleTour(currentSolution.getTour());

    while (temperature > 1) {
      SingleTour newSolution = new SingleTour(currentSolution.getTour());

      int randomIdx1 = (int) (newSolution.getTourSize() * Math.random());
      City city1 = newSolution.getCity(randomIdx1);

      int randomIdx2 = (int) (newSolution.getTourSize() * Math.random());
      City city2 = newSolution.getCity(randomIdx2);

      // swap cities to generate a new solution.
      newSolution.setCity(randomIdx2, city1);
      newSolution.setCity(randomIdx1, city2);

      // we're trying to decide which is the better solution in regards to distance.
      // Ex: if the tour has a huge distance, it won't be a good/accepted solution.
      double currentEnergy = currentSolution.getDistance();
      double neighborEnergy = newSolution.getDistance();

      // if we can accept the solution:
      // update the current, best and decrease temperature.
      if (acceptanceProbability(currentEnergy, neighborEnergy, temperature) > Math.random()) {
        currentSolution = new SingleTour(newSolution.getTour());
      }

      if (currentSolution.getDistance() < best.getDistance()) {
        best = new SingleTour(currentSolution.getTour());
      }

      // decrement the temperature.
      temperature *= 1 - coolingRate;
    }
  }

  /**
   * Determine acceptance probability.
   *
   * We can accept bad moves because we're aiming at the approximate solution.
   *
   * @param currentEnergy  current distance
   * @param neighborEnergy neighbor distance
   * @param temperature    temperature
   * @return acceptance probability
   */
  private double acceptanceProbability(double currentEnergy, double neighborEnergy, double temperature) {
    if (neighborEnergy < currentEnergy) {
      return 1;
    }
    return Math.exp((currentEnergy - neighborEnergy) / temperature);
  }

  public SingleTour getBest() {
    return best;
  }
}
