package org.exampledriven.springcache.domain;

public class Transfer {

    public enum STATUS{IN_PROGRESS, COMPLETE}

    private int id;
    private int amount;
    private STATUS status;
    private Account fromAccount;
    private Account toAccount;

    public int getAmount() {
        return amount;
    }

    public STATUS getStatus() {
        return status;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", amount=" + amount +
                ", status=" + status +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                '}';
    }

}
