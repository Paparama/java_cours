package manyFlowsProgramming;

public class Deamon {
    public static boolean run = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(count++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt(); // поднимаем флаг - это бест практес

                    }
                }
            }
        };
        t.setDaemon(true); // из-за того, что мейн умрет - поток завершится сразу
        t.start();

        Thread.sleep(3000);


        t.interrupt(); // бросает эксепшн, надо правильно обрабатывать

        run = false;

        System.out.println(Thread.currentThread().getName() + "Finish");

        // t.stop - метод примитивный ,просто убивает поток (перевод денег начали, но не закончили)
        // вмето этого можно использовать переменные, т.о. позволяем потоку правильно завершиться
        // но такой флаг есть внутри потока isInterrupted

    }
}
