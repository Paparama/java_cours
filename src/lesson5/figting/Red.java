package lesson5.figting;

class Red extends Solder{

    public Red(int hp, String name, int attack) {
        super(hp, name, attack);
    }
}

class White extends Solder{

    public White(int hp, String name, int attack) {
        super(hp, name, attack);
    }

    @Override
    protected void attack(Solder s) {
        int damage = (int) (Math.random() * this.attack) / 2;
        s.hp -= damage;
        if (s.hp <= 0) {
            System.out.println("Солдат " + this.name + " убил " + s.name);
            s.setKilled();
        } else {
            System.out.println("Солдат " + this.name + " нанес " + damage + " урона " + s.name);
        }
    }
}
