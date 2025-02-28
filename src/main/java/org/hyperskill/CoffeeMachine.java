package org.hyperskill;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static int totalMade = 9;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;
        do{
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            action = scanner.next();

            if(totalMade == 10 && !"clean".equals(action)){
                System.out.println("I need cleaning!");
                continue;
            }

            if("buy".equals(action)) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String coffeeType = scanner.next();
                if("back".equals(coffeeType)){
                    continue;
                }
                int coffeeTypeInt = Integer.parseInt(coffeeType);
                Coffee coffee = null;
                switch (coffeeTypeInt){
                    case 1:
                        coffee = Coffee.ESPRESSO;
                        break;
                    case 2:
                        coffee = Coffee.LATTE;
                        break;
                    case 3:
                        coffee = Coffee.CAPPUCCINO;
                        break;
                    default:
                        break;
                }
                if(coffee != null && water >= coffee.requiredWater && milk >= coffee.requiredMilk && beans >= coffee.requiredBeans && cups >= coffee.requiredCup){
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= coffee.requiredWater;
                    milk -= coffee.requiredMilk;
                    beans -= coffee.requiredBeans;
                    cups -= coffee.requiredCup;
                    money += coffee.cost;
                    totalMade++;
                }
                else{
                    String resource = "";
                   boolean enoughWater = water >= coffee.requiredWater;
                   boolean enoughMilk = milk >= coffee.requiredMilk;
                   boolean enoughBeans = beans >= coffee.requiredBeans;
                   if(!enoughWater){
                       resource = "water";
                   }
                   else if(!enoughMilk){
                       resource = "milk";
                   }
                   else{ // not enough beans
                       resource = "beans";
                   }
                    System.out.printf("Sorry, not enough %s!%n", resource);
                }

            }
            else if("fill".equals(action)){
                System.out.println("Write how many ml of water you want to add: ");
                int addedWater = scanner.nextInt();

                System.out.println("Write how many ml of milk you want to add: ");
                int addedMilk = scanner.nextInt();

                System.out.println("Write how many grams of coffee beans you want to add: ");
                int addedBeans = scanner.nextInt();

                System.out.println("Write how many disposable cups you want to add: ");
                int addedCups = scanner.nextInt();

                water += addedWater;
                milk += addedMilk;
                beans += addedBeans;
                cups += addedCups;
            }
            else if("take".equals(action)){
                System.out.printf("I gave you $%d%n", money);
                money = 0;
            }
            else if("remaining".equals(action)){
                printMachineStatus();
            }
            else if("clean".equals(action)){
                totalMade = 0;
                System.out.println("I have been cleaned!");
            }
        }while(!"exit".equals(action));


    }
    private static void printMachineStatus(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n" +
                "%d ml of milk%n" +
                "%d g of coffee beans%n" +
                "%d disposable cups%n" +
                "$%d of money%n%n", water, milk, beans, cups, money);
    }
}
