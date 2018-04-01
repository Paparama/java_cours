package HW4.house;

public class Human {
    private int floorExpectation;
    private String address = "Hobo";

    public Human(int floorExpectation) {
        this.floorExpectation = floorExpectation;
    }

    public void getAddress() {
        System.out.println(this.address);
    }

    public void changeAddress(String address) {
        this.address = address;
    }

    public int getFloorExpectation() {
        return this.floorExpectation;
    }

}
