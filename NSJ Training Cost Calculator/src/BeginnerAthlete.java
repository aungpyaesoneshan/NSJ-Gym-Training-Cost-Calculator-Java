//Inheritance
public class BeginnerAthlete extends Athlete {
    //Encapsulated Data
    private static final double TRAINING_COST_PER_MONTH = 100.0;
    private static final double COMPETITION_COST_PER_EVENT =0;

    public BeginnerAthlete(String name) {
        super(name);
    }

    //Polymorphisms
//Overriding the Athlete class method (Getting Training Cost)
    @Override
    public double getTrainingCost() {
        return TRAINING_COST_PER_MONTH;
    }

    //Polymorphisms
//Overriding the Athlete class method (Getting competition Cost)
    @Override
    public double getCompetitionCost() {
        return COMPETITION_COST_PER_EVENT;
    }
}

