package examination;

public class CustomQueue<T> extends CustomStack {

    @Override
    public T pop(){
        Object[] newlist = new Object[list.length - 1];
        for (int i = 1; i < list.length; i++){
            newlist[i] = list[i];
        }
        T result = (T) list[0];
        this.list = newlist;
        return result;
    }

}
