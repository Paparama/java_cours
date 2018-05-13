package manyFlowsProgramming;

public class HelloMulteThreading {
    public static void main(String[] args) {
        for (int i = 0; i<15 ; i++) {
            Thread myThread = new MyThread();
            myThread.run();
            new Thread(new MyRunnable(), "New Thread" + i).start();
            // есть метод isAlive - проверяет жизнь потока
            // есть метод join - дожидается завершения какого-то потока
        }

        System.out.println(Thread.currentThread().getName());  // можно получить имя
    }
    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello, There is" + getName());
        }
    }


    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Runnable Thread" + Thread.currentThread().getName());
        }
    }
}


