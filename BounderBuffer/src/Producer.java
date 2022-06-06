import java.util.Random;

public class Producer implements Runnable
{
    private Buffer buffer;
    public boolean stop = false;
    public Producer( Buffer buffer )
    {
        this.buffer = buffer;
    }
    @Override
    public void run()
    {
        Random random = new Random();
        while (!stop)
        {
            int generatedInt = random.nextInt(0,100);

            try {
                Thread.sleep(100);
                buffer.store(generatedInt);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}
