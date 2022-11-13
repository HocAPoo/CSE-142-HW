//Alexander Vuu
//TA: Mitchell Massie
//CSE 142

//Program calculates income and expenses.
//Then determines if you are a saver or spender. 
import java.util.*;

public class Assignment_4 {
    public static final int DAYS_IN_MONTH = 31;
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        intro();

        double income = incomeExpenseAdd(console, "income");

        int month = month(console);

        double expense = incomeExpenseAdd(console, "expense");

        double manipulatedExpense = calculation(income, expense, month);

        finalStatement(income, manipulatedExpense);
        
    }

    //intoduces the program.
    public static void intro(){
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    }
    
    //provides the calculations to add income and expenses
    //parameters collect user input; string decides if its an income or an expense
    public static double incomeExpenseAdd(Scanner console, String incomeOrExpense){
        
        System.out.print("How many categories of " + incomeOrExpense + "? ");
        int numIncome = console.nextInt();//ask for catigories of income/expense. 
        
        double totalMoney = 0;
        for(int i = 1; i <= numIncome; i++){//runs catigories of income/expense number of times
            System.out.print("    Next " + incomeOrExpense + " amount? $");
            double moneyVal = console.nextDouble();//ask for amount of income/expense
            totalMoney += moneyVal;
        }
        System.out.println();
        return totalMoney;
    }
    
    //determines if expenses are monthly/daily expenses.
    //scanner parameter collects user input. 
    public static int month(Scanner console){
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        int numberOfMonths = console.nextInt();//ask number of months or day expenses.
        return numberOfMonths;
    }

    //method calculates money earned and spent
    //parameters needed are income expense and months for calculations.
    public static double calculation(double income, double expense, int month){
        
        double incomePerDay = income/DAYS_IN_MONTH;//converts monthly into daily income
        double expensePerDay = 0;//declares Expense per day
        
        //if user input 1
        if (month == 1){
            expensePerDay = expense/DAYS_IN_MONTH;
        }
        //if user input 2
        else{
            expensePerDay = expense;
            expense = (expense*DAYS_IN_MONTH);
        }

        //rounds numbers before output
        income = round2(income);
        incomePerDay = round2(incomePerDay);
        expense = round2(expense);
        expensePerDay = round2(expensePerDay);

        System.out.println("Total income = $" + income + " ($" + incomePerDay + "/day)");
        System.out.println("Total expenses = $" + expense + " ($" + expensePerDay + "/day)");
        System.out.println();

        return expense;
    }

    //produces the final verdict. Spender or Saver D:
    //parameters needed for final statement are income and expense
    public static void finalStatement(double income, double expense){
       

        double money = round2(income - expense);

        if (money > 0){//saved money

            System.out.println("You earned $" + money + " more than you spent this month.");
            if(money > 250){
                System.out.println("You're a big saver.");
                System.out.println("Sheesh you are raining in cash right now!");
            }
            else{
                System.out.println("You're a saver.");
                System.out.println("your doing a great job buddy!");
            }
        }
        else{//in debt      
            money = Math.abs(money);//converts negative to positive

            System.out.println("You spent $" + money + " more than you earned this month.");
            if(money >= 250){
                System.out.println("You're a big spender.");
                System.out.println("Okay, you've got to get the problem sorted out immediately!");
            }
            else{
                System.out.println("You're a spender.");
                System.out.println("you are a bit in the red buddy. Lets try and fix that!");
            }
        }
    }

    // Rounds the given value to two decimal places and returns the result.
    // double num - the number to round
    //parameter requires a value to round.
    public static double round2(double num) {
        return Math.round(num * 100.0) / 100.0;
    }   
}