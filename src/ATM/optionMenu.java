package ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class optionMenu extends account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'₹'###,##0.00");
    HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(952141, 5645);
                data.put(653315, 4594);
                data.put(276222, 1600);
                System.out.println("Welcome to the ATM Project");
                System.out.println("Enter your Customer number: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter your PIN number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s)." + "\n");
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else {System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");}
        } while (x == 1);
    }
    private void getAccountType() {
        System.out.println("Select The Account You Want To Access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        int selection = menuInput.nextInt();
        switch (selection) {
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thank you for using this ATM" + "\n" + "Have a great day!");
            default -> {
                System.out.println("\n" + "Invalid Choice" + "\n");
                getAccountType();
            }
        }

    }

    private void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");
        int selection = menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: "+ moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM" + "\n" + "Have a great day!");
                break;
            default:
                System.out.println("\n"+"Invalid Choice"+"\n");
                getChecking();
        }
    }

    private void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");
        int selection = menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: "+ moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM" + "\n" + "Have a great day!");
                break;
            default:
                System.out.println("\n"+"Invalid Choice"+"\n");
                getChecking();
        }
    }

}
