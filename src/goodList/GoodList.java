package goodList;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoodList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        while (true){
            String comand = sc.nextLine();
            if (comand.equals("close")){
                break;
            }
            else if (comand.equals("add data")) {
                String name = getCorrectString(sc);
                boolean isFinish = false;
                for (Customer cust: customers) {
                    if (cust.name.equals(name)) {
                        String good = getCorrectString(sc);
                        int value = getCorrectInt(sc);
                        cust.addGood(good, value);
                        isFinish = true;
                    }
                }
                if (!isFinish) {
                    Customer customer = new Customer(name);
                    customer.addGood(getCorrectString(sc), getCorrectInt(sc));
                    customers.add(customer);
                }

            }
            else if (comand.equals("show data")) {
                for (Customer cust: customers){
                    System.out.println(cust.name + ":");
                    cust.goods.entrySet().forEach(System.out::println);
                    }
                } else {
                System.out.println("Введи команду уже!");
            }
            }
        }

        public static String getCorrectString(Scanner sc) {
        String someText = sc.nextLine();
        while (someText.equals("")) {
            System.out.println("Введите текст");
            someText = sc.nextLine();
        }
        return someText;
        }

        public static int getCorrectInt(Scanner sc) {
            String s = null;
            Pattern p = Pattern.compile("^\\d+$");
            Matcher m = null;

            do
            {
                System.out.println("Введите целое число");
                s = sc.nextLine();
                m = p.matcher(s);
            } while(!m.matches());

            return Integer.parseInt(s);
        }
}



class Customer{
    String name;
    Map<String, Integer> goods = new HashMap<>();

    public Customer(String name){
        this.name = name;
    }

    public void addGood(String good, Integer count){
        if (goods.keySet().contains(good)) {
            int oldCount = goods.get(good);
            goods.put(good, oldCount+count);
        } else {
            goods.put(good, count);
        }
    }
}
