package serialisation;

import java.io.Serializable;
import java.util.Date;

public class LaunchStat implements Serializable {
    private Date lastLaunch;
    private int launchCount;
    private String lastUser;

    public boolean isFirstLaunch() {
        return launchCount == 0 && lastLaunch == null;
    }

    public void updateStat() {
        launchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name");
    }

    @Override
    public String toString() {
        return "LaunchStat(" + " launchCount=" + launchCount + ", lastLaunch=" + lastLaunch + ", last user" + lastUser + ")";
    }
}
