package ru.job4j.middle.multithreading.synchronize.task2;

public class User {

    private int id;
    private  int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
