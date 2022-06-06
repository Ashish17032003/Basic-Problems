public class Consumer implements Runnable
{
    private Buffer buffer;
    public boolean stop = false;
     public Consumer (Buffer buffer)
     {
         this.buffer = buffer;
     }

    @Override
    public void run()
    {
        while (!stop)
        {
            try {
                int retrievedValue = buffer.retrieve();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
