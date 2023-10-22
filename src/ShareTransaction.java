abstract class ShareTransaction {
    protected int threshold;
    protected static int shares = 0;
    protected int balance = 0;

    protected static boolean start = false;

    public ShareTransaction(int threshold) {
        this.threshold = threshold;
    }

    public void process(int price) {
        if (shouldExecuteTransaction(price)) {
            executeTransaction(price);
        }
    }

    protected abstract boolean shouldExecuteTransaction(int price);

    protected abstract void executeTransaction(int price);

    public int getBalance() {
        return balance;
    }
}