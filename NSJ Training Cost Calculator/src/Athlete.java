//Encapsulation
public class Athlete {
    //Encapsulated data
    private String name;
    private double currentWeight;
    private double competitionWeight;
    private int numCompetitions;
    private double numPrivateCoachingHours;

    //Athlete constructor
    public Athlete(String name) {
        this.name = name;

    }

    //Getting name
    public String getName() {
        return name;
    }

    //Getting current weight
    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    //Getting competition weight
    public void setCompetitionWeight(double competitionWeight) {
        this.competitionWeight = competitionWeight;
    }

    //Setting number of competitions
    public void setNumCompetitions(int numCompetitions) {
        this.numCompetitions = numCompetitions;
    }

    //Setting number of private coaching hours
    public void setPrivateCoaching(double numPrivateCoachingHours) {
        this.numPrivateCoachingHours = numPrivateCoachingHours;
    }

    //Getting training cost
    public double getTrainingCost() {
        return 0;
    }

    //Getting competition cost
    public double getCompetitionCost() {
        return 22.0 * numCompetitions;
    }

    //Getting private coaching cost
    public double getPrivateCoachingCost() {
        return 9.0 * numPrivateCoachingHours;
    }

    //Calculating total cost
    public double calculateTotalCost() {
        return getTrainingCost() + getCompetitionCost() + getPrivateCoachingCost();
    }

    //Showing desired weight or competition weight category
    public void weightCategory(double desiredWeight) {
        if (desiredWeight <= 66) {
            System.out.println("Your desired Weight category: Fly Weight...");
        } else if (desiredWeight > 66 && desiredWeight <= 73) {
            System.out.println("Your desired Weight category: Light Weight");
        } else if (desiredWeight > 73 && desiredWeight <= 81) {
            System.out.println("Your desired Weight category: Light-Middle Weight");
        } else if (desiredWeight > 81 && desiredWeight <= 90) {
            System.out.println("Your desired Weight category: Middle Weight");
        } else if (desiredWeight > 90 && desiredWeight <= 100) {
            System.out.println("Your desired Weight category: Light-Heavy Weight");
        } else {
            System.out.println("Your desired Weight category: Heavy Weight");
        }
    }

    //Show desired weight category and weight difference
    public String getWeightCategory() {
        double weightDifference;
        if (currentWeight < competitionWeight) {
            weightCategory(competitionWeight);
            weightDifference=competitionWeight-currentWeight;
            return "You need to gain "+String.format("%.2f",weightDifference)+" kg";
//            return "You need to gain "+weightDifference+"kg";
        } else if (currentWeight > competitionWeight) {
            weightCategory(competitionWeight);
            weightDifference=currentWeight-competitionWeight;
            return "You need to lose "+String.format("%.2f",weightDifference)+"kg";
//            return "You need to lose "+weightDifference+"kg";

        } else {
            weightCategory(competitionWeight);
            return "In weight category";
        }

    }


}
