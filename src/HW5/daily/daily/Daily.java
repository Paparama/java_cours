package HW5.daily.daily;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Daily {
    private ArrayList<Plan> plans = new ArrayList<>();

    protected void addPlan(Plan plan) {
        plans.add(plan);
    }

    private ArrayList<Plan> getPlans() {
        return this.plans;
    }

    private ArrayList<Plan> getPlanOnDate(int year, int month, int day) {
        Date d = new GregorianCalendar(year, month, day).getTime();
        ArrayList<Plan> result = new ArrayList<>();
        for (Plan p: this.getPlans()) {
            if (p.getTime().equals(d)) {
                result.add(p);
            }
        }
        return result;
    }

    protected Plan getPlanOnTitle(String title) {
        for (Plan p: this.plans) {
            if (p.getTitle().equals(title)) {
                return p;
            }
        } return null;
    }

    static private Plan getPlanOnTitle(String title, ArrayList<Plan> plans) {
        for (Plan p: plans) {
            if (p.getTitle().equals(title)) {
                return p;
            }
        } return null;
    }

    protected void correctPlan(String title, String corrections, int year, int month, int day) {
        ArrayList<Plan> plansOnDAy = this.getPlanOnDate(year, month, day);
        Plan planToCorrect = Daily.getPlanOnTitle(title, plansOnDAy);
        if (planToCorrect == null) {
            System.out.println("По вашему запросу заметок не найдено");
        } else {
            planToCorrect.setPlan(corrections);
        }

    }



}
