package ua.lviv.lgs12;

public class Car extends Wheel {

    private int horsepower;
    private int yearOfRelease;
    private String materials;

    public Car(int horsepower, int yearOfRelease, int numberOfCylinders, int diameter, int material) {
        super(numberOfCylinders, diameter, material);
        this.horsepower = horsepower;
        this.yearOfRelease = yearOfRelease;
        this.materials = Wheel.getMat(material);
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Car [horsepower= " + horsepower + "hp, yearOfRelease= " + yearOfRelease + " year, diameter= "
                + getDiameter() + "mm, numberOfCylinders()= " + getNumberOfCylinders() + "PCS, materials= "
                + getMaterials() + "]";
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

}
