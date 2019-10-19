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
            SavingsAccount saver1 = new SavingsAccount(2000.0); // initializing first instance
            SavingsAccount saver2 = new SavingsAccount(3000.0); // initializing second instance
            SavingsAccount.modifyInterestRate(4.0); // setting interest rate to 4.0%
            System.out.println("Month \t\t Saver1 \t Saver2");

// Displaying data of two instances for 12 months
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

            saver1.print_Balance();
            System.out.print("\t");

            saver2.print_Balance();
            System.out.println();
        }
    }
}
