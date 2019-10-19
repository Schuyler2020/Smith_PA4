public class Smith_P2 {

    static class SavingsAccount {
        //declared double variable for annualInterestRate
        public static double annualInterestRate = 0.0;

        //declared double variable for savingsBalance
        private double savingsBalance;

        // Constructor
        public SavingsAccount(double tot_Balance) {
            this.savingsBalance = tot_Balance;
        }

        // to calculate the monthly interest
        public void calculateMonthlyInterest() {
            double interest;
            interest = (this.savingsBalance * (annualInterestRate / 100)) / 12;
            this.savingsBalance += interest;
        }

        // to display balance
        public void print_Balance() {
            System.out.printf("$%.2f", this.savingsBalance);
        }

        // to set the static variable
        public static void modifyInterestRate(double interestRate) {
            annualInterestRate = interestRate;
        }
    }

    public static class Application {
        public static void main(String[] args) {
            //sets data for saver1
            SavingsAccount saver1 = new SavingsAccount(2000.0);

            //sets data for saver2
            SavingsAccount saver2 = new SavingsAccount(3000.0);

            //sets interest rate to 4%
            SavingsAccount.modifyInterestRate(4.0);

            System.out.println("Month \t\t Client1 \t Client2");

            //for loop to calculate and show balances and interest rate over a 12 month period
            for (int i = 1; i <= 12; ++i) {

                saver1.calculateMonthlyInterest();
                saver2.calculateMonthlyInterest();

                System.out.print("Month " + i + ": \t");

                saver1.print_Balance();
                System.out.print("\t");

                saver2.print_Balance();
                System.out.println();
            }
            System.out.println();

            System.out.println("The Interest has been changed to 5%");
            System.out.println();

            //change monthly interest rate to 5%
            SavingsAccount.modifyInterestRate(5.0);

            //to calculate new balance for saver 1 and saver 2
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();

            //Here is where I print out the final month with the interest rate
            System.out.print("With 5%: \t");

            //print out balance for saver 1
            saver1.print_Balance();
            System.out.print("\t");

            //print out balance for saver 2
            saver2.print_Balance();
            System.out.println();
        }
    }
}
