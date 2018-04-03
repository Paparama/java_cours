package HW5.daily.daily;

import java.util.Date;
import java.util.GregorianCalendar;

class Plan {
    private String title;
    private String  plan;
    private GregorianCalendar planDate;

    protected String getTitle() {
        return this.title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected Plan(String title, String plan, int year, int month, int day) {
        this.title = title;
        this.plan = plan;
        this.planDate = new GregorianCalendar(year, month, day);
    }

    protected String getPlan() {
        return this.plan;
    }

    protected void setPlan(String plan) {
        this.plan = plan;
    }

    protected Date getTime(){
        return this.planDate.getTime();
    }

    protected void setPlan(int year, int month, int day) {
        this.planDate = new GregorianCalendar(year, month, day);
    }
}
