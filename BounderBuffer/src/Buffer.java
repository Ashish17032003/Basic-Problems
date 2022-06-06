public class Buffer
{
    private int[] internalStorage = new int[10];
    // 0 1 2 3 4 5 6 7 8 9
    // | | |
    // | |
    private int readLocation = 0;
    private int writeLocation = 0;
    private int cellsOccupied = 0;

    // each object in java has a single monitor (lock , object lock)
    // only one thread at a time can hold that lock
    // only that thread can then execute synchronized methods
    // other threads will be blocked until notified
    // also, the one thread that has the lock can give up the lock by
    // 1. exiting the synchronized method
    // 2. calling wait on that object.

    public synchronized void store(int value) throws InterruptedException
    {
        while(cellsOccupied == internalStorage.length) // can't store if the buffer is full
        {
            System.out.println("Buffer is Full");
            // wait for it to get cleared
            wait();
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " stored " + value);
        internalStorage[writeLocation] = value;
        writeLocation = (writeLocation + 1) % internalStorage.length; // always keeps wrapping around
        cellsOccupied++;
        notifyAll(); // since other threads will be blocked until notified
        //it will notify all threads waiting on this object.
    }

    public synchronized int retrieve() throws InterruptedException
    {
        while (cellsOccupied == 0)
        {
            System.out.println("Buffer is Empty");
            wait();
        }

        int toReturn = internalStorage[readLocation];
        System.out.println("Thread " + Thread.currentThread().getName() + " retrieved " + toReturn + " from location " + readLocation );
        readLocation = (readLocation + 1) % internalStorage.length;
        cellsOccupied--;
        notifyAll();
        return toReturn;
    }
}
