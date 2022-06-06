public class BufferTest
{
    public static void main(String[] args) throws InterruptedException
    {
        Buffer buffer = new Buffer();

        Producer p0 = new Producer(buffer);
        Producer p1 = new Producer(buffer);

        Consumer c0 = new Consumer(buffer);
        Consumer c1 = new Consumer(buffer);

        Thread tp0 = new Thread(p0);
        Thread tp1 = new Thread(p1);
        Thread tc0 = new Thread(c0);
        Thread tc1 = new Thread(c1);

        tp0.setName("Producer 0");
        tp1.setName("Producer 1");
        tc0.setName("Consumer 0");
        tc1.setName("Consumer 1");

        tp0.start();
        tp1.start();
        tc0.start();
        tc1.start();

        Thread.sleep(1000);
        p0.stop = true;
        p1.stop = true;
        c0.stop = true;
        c1.stop = true;


        try {
            tp0.join();
            tp1.join();
            tc0.join();
            tc1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
