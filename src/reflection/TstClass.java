package reflection;

public class TstClass {
    private final int intData;
    private String strData;

    public String tstField = "ololo";

    public TstClass(int intData, String strData) {
        this.intData = intData;
        this.strData = strData;
    }


    public void setStrData(String strData) {

        this.strData = strData;
    }

    public String getStrData() {
        return strData;
    }

    public int getIntData() {

        return intData;
    }

    @Override
    public String toString() {
        return "TstClass{" +
                "intData=" + intData +
                ", strData='" + strData + '\'' +
                '}';
    }

    private void callPrivate() {
        System.out.println("Private method called");
    }
}
