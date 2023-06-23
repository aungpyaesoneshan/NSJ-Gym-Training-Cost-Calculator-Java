//Inheritance
public class EliteAthlete extends Athlete {
    //Encapsulated Data
    private static final double TRAINING_COST_PER_MONTH = 135;

    public EliteAthlete(String name) {
        super(name);
    }

    //Polymorphisms
//Overriding the Athlete class method (Getting Training Cost)
    @Override
    public double getTrainingCost() {
        return TRAINING_COST_PER_MONTH;
    }

}