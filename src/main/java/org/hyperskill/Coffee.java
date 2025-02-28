package org.hyperskill;

public enum Coffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12,1, 6);


    public final int requiredWater;
    public final int requiredMilk;
    public final int requiredBeans;
    public final int requiredCup;
    public final int cost;

    Coffee(int requiredWater, int requiredMilk, int requiredBeans, int requiredCup, int cost) {
        this.requiredWater = requiredWater;
        this.requiredMilk = requiredMilk;
        this.requiredBeans = requiredBeans;
        this.requiredCup = requiredCup;
        this.cost = cost;
    }
}
