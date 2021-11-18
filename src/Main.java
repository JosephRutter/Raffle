import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<Integer, String> raffleTickets = new HashMap<Integer, String>();
    public static Scanner input = new Scanner(System.in);
    public static int ticketNumber;

    public static String prize() {
        int prizeNum = (int) (Math.random() * 9);

        switch (prizeNum) {
            case (0):
                return "kfc console";

            case (1):
                return "some sweets";

            case (2):
                return "Mark Zuckerberg's personal data";

            case (3):
                return "an RTX 3090 Ti";

            case (4):
                return "[[5 kromer]]";

            case (5):
                return "a once in a lifetime trip to absolutely nowhere";

            case (6):
                return "the chance to be a [[big shot]]";

            case (7):
                return "a supreme sticker";

            case (8):
                return "like a mug or something idk";
        }

        return null;
    }

    public static int ticketselect() {
        while (true) {
            System.out.println("select the ticket number");
            ticketNumber = input.nextInt();
            if (raffleTickets.containsKey(ticketNumber)) {
                System.out.println("that ticket has already been bought");

            } else {
                System.out.println("your ticket has been purchased");
                System.out.println("please enter your name");
                return ticketNumber;
            }
        }


    }

    public static boolean isPrime() {
        boolean prime = true;
        if (ticketNumber == 0 || ticketNumber == 1) {
            return false;
        } else {
            for (int i = 2; i <= ticketNumber / 2; i++) {
                if (ticketNumber % i == 0) {
                    prime = false;
                } else {
                    prime = true;
                }

            }
            return prime;

        }

    }


    public static void ticketChecker() {
        System.out.println("please input the ticket you wish to check");
        ticketNumber = input.nextInt();

        if (raffleTickets.containsKey(ticketNumber)) {
            System.out.println("please enter the name you bought the ticket under");
                String compareName = input.next();
            if (raffleTickets.get(ticketNumber).equals(compareName) && isPrime()) {
                System.out.println("congratulations you have won " + prize());
            } else if (raffleTickets.get(ticketNumber).equals(compareName)&& !isPrime()) {
                System.out.println("you didnt win anything");
            } else {
                System.out.println("you do not own that ticket");
            }
        } else {
            System.out.println("that ticket has not been bought");

        }

    }

    public static void main(String[] args) {
        String buyOrCheck = "";

        System.out.println("welcome to the raffle!");
        while (true) {
            System.out.println("would you like to buy a ticket or check a ticket");

            switch (buyOrCheck = input.next()) {
                case "buy":
                    raffleTickets.put(ticketselect(), input.next());
                    break;

                case "check":
                    ticketChecker();

                    break;

                default:
                    System.out.println("please input a valid choice");
            }
        }

    }
}

