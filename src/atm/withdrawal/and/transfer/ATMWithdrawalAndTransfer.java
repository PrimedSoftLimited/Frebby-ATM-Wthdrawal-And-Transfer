/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.withdrawal.and.transfer;

import java.util.Scanner;

/**
 *
 * @author Frebby
 */
public class ATMWithdrawalAndTransfer {

    static final int userPin = 1234;
    static final long currentBalance = 10000;
    static final String acctType = "savings";
    static Scanner scanner = new Scanner(System.in);
    static long deduct;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int pin;
        System.out.println("Enter your card pin >>> ");

        pin = scanner.nextInt();
        pinEntry(pin);

    }

    public static void pinEntry(int pin) {
        int trials = 0;
        for (int i = 5; i > trials; --i) {

            if (pin == userPin) {

                System.out.println("Your pin is correct");
                System.out.println("Choose your Account type. Select 1 for current and "
                        + "2 for savings");
                showAccountType();
                break;
            } else {
                if (i == 1) {
                    System.out.println("Limit exceeded. Account blocked. Visit "
                            + "your bank for verification.");
                    break;
                }

                System.out.println("Your pin is incorrect");
                System.out.println("You have " + (i - 1) + "  trial(s) remaining");

                pin = scanner.nextInt();

            }

        }

    }

    public static void showAccountType() {
        int trials = 0;

        int input = scanner.nextInt();
        for (int i = 5; i > trials; --i) {

            if (input == 1) {
                if (i == 1) {
                    System.out.println("Account Blocked");
                    break;
                }
                System.out.println("Wrong account type");
                System.out.println("Choose your Account type. Select 1 for current and "
                        + "2 for savings");
                input = scanner.nextInt();

            } else if (input == 2) {
                System.out.println("Choose an option. 1. Withdrawal. 2. Transfer. "
                        + "3. Balance check.");
                actionToTake();
                break;
            } else {
                System.out.println("Not a valid number");
                input = scanner.nextInt();

            }
        }

    }

    public static void actionToTake() {
        int input = scanner.nextInt();
        int trials = 1;
        for (int i = 5; i > trials; --i) {
            if (input == 1) {
                withdrawal();
                break;
            } else if (input == 2) {
                transfer();
                break;

            } else if (input == 3) {
                balanceCheck();
                break;

            } else {
                System.out.println("Not a valid number");
                input = scanner.nextInt();
            }
        }
    }

    public static void withdrawal() {

        System.out.println("How much would like to withdraw. Your input pls >>>");
        int input = scanner.nextInt();
        int trials = 1;
        for (int i = 5; i > trials; --i) {
            if (input > currentBalance) {
                System.out.println("Insufficient fund. Poor man!!!. You "
                        + "can check your current balance. Press 0 to check");
                input = scanner.nextInt();
                if (input == 0) {
                    balanceCheck();
                    break;
                }
            } else {
                long deduct = currentBalance - input;
                System.out.println("Would you like to check your account balance?"
                        + " press 0 to do that");
                input = scanner.nextInt();

                if (input == 0) {
                    balanceCheck(deduct);
                    break;

                }

            }

        }
    }

    public static void transfer() {
        System.out.println("Account number to transfer to >>> ");
        long input = scanner.nextLong();
        String convertInput = String.valueOf(input);
        if (convertInput.length() > 14) {
            System.out.println("How much are you transferring? >>> ");
            int amount = scanner.nextInt();
            int trials = 1;
            for (int i = 5; i > trials; --i) {
                if (amount > currentBalance) {
                    System.out.println("Insufficient fund. Poor man!!!. You "
                            + "can check your current balance. Press 0 to check");
                    input = scanner.nextInt();
                    if (input == 0) {
                        balanceCheck();
                        break;
                    }
                } else {
                    long deduct = currentBalance - amount;
                    System.out.println("Money transfered to account number - " + input
                            + " Would you like to check your account balance?"
                            + " press 0 to do that");
                    input = scanner.nextInt();

                    if (input == 0) {
                        balanceCheck(deduct);
                        break;

                    }else{
                        break;
                    }

                }

            }
        } else {
            System.out.println("This is too low for an account number.");
            int trials = 1;
            for (int i = 5; i > trials; --i) {
                System.out.println("Account number to transfer to >>> ");
                long input2 = scanner.nextLong();
                String convertInput2 = String.valueOf(input2);
                if (convertInput2.length() > 14) {
                    System.out.println("How much are you transferring? >>> ");
                    int amount = scanner.nextInt();
                        if (amount > currentBalance) {
                            System.out.println("Insufficient fund. Poor man!!!. You "
                                    + "can check your current balance. Press 0 to check");
                            input = scanner.nextInt();
                            if (input == 0) {
                                balanceCheck();
                                break;
                            }
                        } else {
                            long deduct = currentBalance - amount;
                            System.out.println("Money transfered to account number - " + input2
                                    + " Would you like to check your account balance?"
                                    + " press 0 to do that");
                            input = scanner.nextInt();

                            if (input == 0) {
                                balanceCheck(deduct);
                                break;

                            }else{
                                break;
                            }

                        }
                    }
                }
            }
        }
    

    public static void balanceCheck() {
        System.out.println("Your current account balance figure is "
                + "= " + currentBalance);
    }

    public static void balanceCheck(long balance) {
        System.out.println("Your current account balance figure is "
                + "= " + balance);
    }

}
