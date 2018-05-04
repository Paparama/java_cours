package serialisation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExtern implements Externalizable {
    private static final long serialVersionUID = 0L;
    private static final int VERSION = 0;

    private int launchCount;
    private Date lastLaunch;
    private String user;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeInt(launchCount);
        out.writeObject(lastLaunch);
        out.writeUTF(user);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION) {
            throw new IOException("unsupported version of class " + version);
        }
        launchCount = in.readInt();
        lastLaunch = (Date) in.readObject();
    }


    public boolean isFirstLaunch() {
        return launchCount == 0 && lastLaunch == null;
    }

    @Override
    public String toString() {
        return "LaunchStat(" + " launchCount=" + launchCount + ", lastLaunch=" + lastLaunch + ")";
    }


    public void updateStat() {
        launchCount++;
        lastLaunch = new Date();
        user = System.getProperty("user.name");
    }
}
