package HW_caffe;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.PriorityQueue;
import java.util.Queue;

public class Caffe {
    private Queue<String> orders = new PriorityQueue<>();
    private boolean waiterReady = false;
    private boolean cookerReady = false;
    private boolean clientReady = true;
    private boolean orderReady = false;


    public static void main(String[] args) throws InterruptedException {
        Caffe caffe = new Caffe();
        Client cl = caffe.new Client();
        Waiter wt = caffe.new Waiter();
        Cooker ck = caffe.new Cooker();
        ck.start();
        Thread.sleep(100);  // важно, чтобы потоки запускались последовательно, иначе можем зависнуть на ожидании события
        wt.start();
        Thread.sleep(100);
        cl.start();
        cl.join();
        if ((!caffe.orderReady && !caffe.clientReady && !caffe.waiterReady && caffe.orders.size() == 0)){
            ck.interrupt();
            wt.interrupt();
            cl.interrupt();
        }

    }

    class Client extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (Caffe.this) {
                    try {
                        if (!clientReady) {
                            Caffe.this.wait();
                        }

                        if (clientReady && orderReady) {

                            System.out.println("nym-num");
                            orderReady = false;
                            clientReady = false;
                            Caffe.this.notifyAll();
                            interrupt();

                        } else if (clientReady) {
                            Caffe.this.orders.add("Peperoni");
                            waiterReady = true;
                            clientReady = false;
                            Caffe.this.notifyAll();
                        }

                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }
    }

    class Waiter extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (Caffe.this) {
                    try {
                        Caffe.this.wait();

                        if (waiterReady && orderReady) {

                            clientReady = true;
                            waiterReady = false;
                            Caffe.this.notifyAll();


                        } else if (waiterReady){
                            cookerReady = true;
                            waiterReady = false;
                            Caffe.this.notifyAll();
                        }

                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }
    }

    class Cooker extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (Caffe.this) {
                    try {

                        Caffe.this.wait();

                        if (cookerReady) {

                            System.out.println(orders.poll());
                            cookerReady = false;
                            waiterReady = true;
                            orderReady = true;
                            Caffe.this.notifyAll();

                        }
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }
    }
}
