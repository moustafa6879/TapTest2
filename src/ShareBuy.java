class ShareBuy extends ShareTransaction {
    public ShareBuy(int c1) {
        super(c1);
    }

    @Override
    protected boolean shouldExecuteTransaction(int price) {

        return price <= threshold ;
    }

    @Override
    protected void executeTransaction(int price) {
        shares++;
        balance -= price;
    }
}