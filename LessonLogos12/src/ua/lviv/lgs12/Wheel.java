package ua.lviv.lgs12;

public class Wheel extends Engine {

    private int diameter;
    private int material;

    public Wheel(int numberOfCylinders, int diameter, int material) {
        super(numberOfCylinders);
        this.diameter = diameter;
        this.material = material;
    }

    public static String getMat(int material) {
        if (material == 1) {
            String materials = "skin";
            return materials;
        } else {
            String materials = "alcantara";
            return materials;
        }
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

}
