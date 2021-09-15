package factory;

public class TinyHomePlan extends HousePlan {
   
    public TinyHomePlan() {
        super(1, 5, 200);
    }

    protected void setMaterials() {
        this.materials.add("Lumber");
        this.materials.add("Insulation");
        this.materials.add("Metal Roofing");
        this.materials.add("Hardware");
    }

    protected void setFeatures() {
        this.features.add("Natural Light");
        this.features.add("Creative Storage");
        this.features.add("Multipurpose Areas");
        this.features.add("Mutli-Use Applications");
    }

    public String toString() {
        return "Tiny House\n" + super.toString();    
    }
}
