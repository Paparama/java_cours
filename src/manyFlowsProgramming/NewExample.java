package manyFlowsProgramming;

public class NewExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                Thread curThread = Thread.currentThread();
                System.out.println(curThread.getName() + "isAlive " + curThread.isAlive() + " state " + curThread.getState());
            }
        };
        System.out.println("" + t.isAlive() + " state " + t.getState());
        t.start();
        t.join();  // ждем окончания выполнения потока
        System.out.println(t.isAlive() + " state " + t.getState());
    }
}
