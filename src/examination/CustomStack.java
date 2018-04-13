package examination;

public class CustomStack<T> {
    protected int size;
    protected Object[] list;

    public void add(T elem){
        Object[] newlist = new Object[list.length + 1];
        for (int i = 0; i < list.length; i++){
            newlist[i] = list[i];
        }
        newlist[list.length] = elem;
        this.list = newlist;
    }

    public T pop(){
        Object[] newlist = new Object[list.length - 1];
        for (int i = 0; i < list.length - 1; i++){
            newlist[i] = list[i];
        }
        T result = (T) list[list.length -1];
        this.list = newlist;
        return result;
    }

}
