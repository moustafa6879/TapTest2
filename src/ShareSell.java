class ShareSell extends ShareTransaction {
    private boolean last = false;
    public ShareSell(int c2) {
        super(c2);
    }

    @Override
    protected boolean shouldExecuteTransaction(int price) {

        return price >= threshold && shares > 0 || shares > 0  && last;
    }


    @Override
    protected void executeTransaction(int price) {

        balance += shares * price;
        shares = 0;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}