package HW4.house;

import java.util.ArrayList;

public class House {
    private int enters, floor, flatOnFloor;
    private int[][] occupatedFlat;
    private int countOccupatedFlat = 0;
    private String address;

    public static void main(String[] args) {
        House h = new House(2, 4,5, "Kokoko");
        System.out.println(h.getOccupatedFlat());
        ArrayList<Human> hs = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            hs.add(new Human(0));
        }
        // для отладки, создаем очередь, 10 человек заселяются на 0 этаж, будем считать его за подвал
        // 3 человека в пролете, т.к. всего 10 квартир на этом этаже, дом 4 этажный, так что с 5 тоже проблема
        // и человек, который хочет 1 этаж - заселяется
        hs.add(new Human(1));
        hs.add(new Human(5));
        h.add(hs);
        h.add(hs);
        h.add(hs);
        h.add(hs);
        System.out.println(hs.size());

    }

    public int getCountFlats() {
        int all = this.enters * this.flatOnFloor * this.floor;
        return all;
    }

    public String getAddress() {
       return this.address;
    }

    public int getOccupatedFlat() {
        return this.countOccupatedFlat;
    }

    private int isFloorFree(int[] floor) {
        for (int i = 0; i < this.flatOnFloor * this.enters; i++) {
            if (floor[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public void add(ArrayList<Human> humans) {
        int countAdded = 0;
        int numberOfFreeFlat = -1;
        ArrayList<Human> originStack = new ArrayList<>(humans);
        for (int i = 0; i < originStack.size(); i++) {
            int floorExpectation = originStack.get(i).getFloorExpectation();
            if (floorExpectation > this.floor) {
                System.out.println("Иди в конец очереди");
                humans.add(originStack.get(i));
                humans.remove(originStack.get(i));
                continue;
            }
            numberOfFreeFlat = this.isFloorFree(this.occupatedFlat[floorExpectation]);
            if (numberOfFreeFlat != -1){
                this.occupatedFlat[originStack.get(i).getFloorExpectation()][numberOfFreeFlat] = 1;
                this.countOccupatedFlat++;
                originStack.get(i).changeAddress(this.getAddress());
                humans.remove(originStack.get(i));
                countAdded++;
                System.out.println("С новосельем");
                if (countAdded == 3) {
                    break;
                }
            } else if (this.getOccupatedFlat() != this.getCountFlats()) {
                humans.add(originStack.get(i));
                humans.remove(originStack.get(i));
                System.out.println("Иди в конец очереди");
            } else {
                System.out.println("Квартиры закончились");
                break;
            }
        }
    }

    protected House(int enters, int floor, int flatOnFloor, String address) {
        this.floor = floor;
        this.enters = enters;
        this.flatOnFloor = flatOnFloor;
        this.address = address;
        this.occupatedFlat = new int[floor][flatOnFloor * enters];
    }

}
