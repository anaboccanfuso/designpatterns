package factory;

public class ContemporaryPlan extends HousePlan {
   
    public ContemporaryPlan() {
        super(5, 40, 3000);
    }

    protected void setMaterials() {
        this.materials.add("Ceramics");
        this.materials.add("High-Strength Alloys");
        this.materials.add("Composites");
    }

    protected void setFeatures() {
        this.features.add("Oversized Windows");
        this.features.add("Unconventional Roofs");
        this.features.add("Minimalism");
        this.features.add("Open Floor Plan");
    }

    public String toString() {
        return "Contemporary Home\n" + super.toString();
    }
}
