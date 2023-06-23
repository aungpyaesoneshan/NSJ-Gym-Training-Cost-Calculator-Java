//Inheritance
public class IntermediateAthlete extends Athlete {
    //Encapsulated Data
    private static final double TRAINING_COST_PER_MONTH = 120;

    public IntermediateAthlete(String name) {
        super(name);
    }

    //Polymorphisms
//Overriding the Athlete class method (Getting Training Cost)
    @Override
    public double getTrainingCost() {
        return TRAINING_COST_PER_MONTH;
    }

}