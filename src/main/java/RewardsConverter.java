import java.util.Scanner;

public class RewardsConverter {
    private final double nilai_cash;
    private final int nilai_miles;
    public static final double konversi = 0.0035;

    public RewardValue(double nilai_cash) {
        this.nilai_cash = nilai_cash;
        this.nilai_miles = (int) (nilai_cash / konversi);
    }

    public RewardValue(int nilai_miles) {
        this.nilai_miles = nilai_miles;
        this.nilai_cash = nilai_miles * konversi;
    }

    public double getCashValue() {
        return this.nilai_cash;
    }

    public int getMilesValue() {
        return this.nilai_miles;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Credit Card Rewards Converter!");
        System.out.println("Please enter a cash value to convert to airline miles: ");
        var input_value = scanner.nextLine();
        double cashValue;
        try {
            cashValue = Double.parseDouble(input_value);
        } catch (NumberFormatException exception) {
            System.out.println("Could not parse input value as a double, exiting");
            return;
        }
        System.out.println("converting $" + input_value + " to miles");
        var rewardsValue = new RewardValue(cashValue);
        System.out.println("$" + input_value + " is worth " + rewardsValue.getMilesValue() + " miles");
    }
}