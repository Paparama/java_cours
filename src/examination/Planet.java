package examination;

class Planet{
    public enum Planets {
        ERTH("Масса: 5,9726·10^24 кг, радиус: 6356,8 км, радиус орбиты: какое-то большое число "),
        MARS("Масса: 6,4171·10^23 кг, радиус: 3389,5 км, радиус орбиты: какое-то другое большое число"),
        VENERA("Масса: 4,8675·10^24 кг, радиус: 6051,8 км, радиус орбиты: какое-то число поменьше, но все равно большое");


        private String description;

        private Planets(String description) {
            this.description = description;
        }

        public String getDescription() {return description;}
    }

    public static void main(String[] args) {
        for (Planets p : Planets.values())
            System.out.println(p + ": " + p.getDescription());
    }
}
