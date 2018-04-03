package lesson5.figting;

abstract class Solder {
    protected int hp;
    protected String  name;
    protected boolean isAlive = true;
    protected int attack;

    protected void attack(Solder s) {
        int damage = (int) (Math.random()*this.attack);
        s.hp -= damage;
        if (s.hp <= 0) {
            System.out.println("Солдат " + this.name + " убил " + s.name);
            s.setKilled();
        } else {
            System.out.println("Солдат " + this.name + " нанес " + damage + " урона " + s.name);
            damage = (int)(Math.random()*s.attack);
            this.hp -= damage/2;
            if (this.hp <= 0) {
                System.out.println("От полученных ранений " + this.name + " погиб");
            } else {
                System.out.println(s.name + " в ответ нанес " + damage + " урона");
            }
        }
    }

    protected boolean isAlive() {
        return this.isAlive;
    }

    protected void setKilled() {
        this.isAlive = false;
    }

    protected Solder(int hp, String name, int attack) {
        this.attack = attack;
        this.hp = hp;
        this.name = name;
    }
}
