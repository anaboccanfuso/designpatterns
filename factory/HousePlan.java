package factory;

import java.util.ArrayList;

public abstract class HousePlan {
    protected ArrayList<String> materials;
    protected ArrayList<String> features;
    private int numRooms;
    private int numWindows;
    private int squareFeet;

    public HousePlan(int numRooms, int numWindows, int squareFeet) {
        this.numRooms = numRooms;
        this.numWindows = numWindows;
        this.squareFeet = squareFeet;
        this.materials = new ArrayList<String>();
        this.features = new ArrayList<String>();
        this.setFeatures();
        this.setMaterials();
    }

    protected abstract void setMaterials();
    protected abstract void setFeatures();

    public ArrayList<String> getMaterials() {
        return this.materials;
    }

    public ArrayList<String> getFeatures() {
        return this.features;
    }

    public int getNumRooms() {
        return this.numRooms;
    }

    public int getNumWindows() {
        return this.numWindows;
    }

    public int getSquareFeet() {
        return this.squareFeet;
    }

    public String toString() {
        String allMaterials = "";
        for(String material : this.materials) {
            allMaterials = allMaterials + " - " + material + "\n"; 
        }
        String allFeatures = "";
        for(String feature : this.features) {
            allFeatures = allFeatures + " - " + feature + "\n";
        }
        return "Square Feet: " + this.getSquareFeet() + "\n" 
            + "Room: " + this.getNumRooms() + "\n"
            + "Windows: " + this.getNumWindows() + "\n\n"
            + "Materials:\n" + allMaterials + "\n"
            + "Features:\n" + allFeatures;
    }
}
