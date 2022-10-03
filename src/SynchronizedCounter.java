public class SynchronizedCounter {

    protected long count = 0;

    public SynchronizedCounter() {
        this.count = 0;
    }

    public SynchronizedCounter(long n) {
        this.count = n;

    }

    public synchronized void add(long value) {
        //synchronized (this) {
        this.count = this.count + value;
        // }
    }

    public long get() {
        return this.count;
    }

}