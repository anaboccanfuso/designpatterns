package factory;

public class HousePlanFactory {
    public static HousePlan createHousePlan(String type) {
        HousePlan housePlan = null;

        if(type.equalsIgnoreCase("log cabin")) {
            housePlan = new LogCabinPlan();
        }
        else if(type.equalsIgnoreCase("tiny home")){
            housePlan = new TinyHomePlan();
        }
        else {
            housePlan = new ContemporaryPlan();
        }
        return housePlan;
    }
}