package edu.orangecoastcollege.cs273.dtran258.occars;

/**
 * Represents a car loan. Contains information about the price of the car, the down payment on the
 * car, and the loan term in years.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 14, 2017
 */

public class CarLoan
{
    private static final double TAX_RATE = 0.08;
    private static final double APR_3_YEARS = 0.0462;   // Annual Percentage Rates
    private static final double APR_4_YEARS = 0.0419;
    private static final double APR_5_YEARS = 0.0416;

    private double mPrice;
    private double mDownPayment;
    private int mTerm;

    /**
     * Instantiates a new <code>CarLoan</code> object with the car price, down payment, and loan
     * term initialized to zero.
     */
    public CarLoan() {}

    /**
     * Gets the price of the car.
     * @return The price of the car.
     */
    public double getPrice()
    {
        return mPrice;
    }

    /**
     * Sets the price of the car.
     * @param price The price of the car.
     */
    public void setPrice(double price)
    {
        mPrice = price;
    }

    /**
     * Gets the down payment on the car.
     * @return The down payment on the car.
     */
    public double getDownPayment()
    {
        return mDownPayment;
    }

    /**
     * Sets the down payment on the car.
     * @param downPayment The down payment on the car.
     */
    public void setDownPayment(double downPayment)
    {
        mDownPayment = downPayment;
    }

    /**
     * Gets the loan term of the car loan in years.
     * @return The loan term of the car loan in years.
     */
    public int getTerm()
    {
        return mTerm;
    }

    /**
     * Sets the loan term of the car loan in years.
     * @param term The loan term of the car loan in years.
     */
    public void setTerm(int term)
    {
        mTerm = term;
    }

    /**
     * Gets the borrowed amount on the car loan.
     * @return The borrowed amount on the car loan.
     */
    public double getBorrowedAmount()
    {
        return mPrice - mDownPayment;
    }

    /**
     * Gets the tax amount added to the car price.
     * @return The tax amount added to the car price.
     */
    public double getTaxAmount()
    {
        return mPrice * TAX_RATE;
    }

    /**
     * Gets the total amount for purchasing the car.
     * @return The total amount for purchasing the car.
     */
    public double getTotalAmount()
    {
        return mPrice + getTaxAmount();
    }

    /**
     * Gets the interest amount accrued on the car loan.
     * @return The interest amount accrued on the car loan.
     */
    public double getInterestAmount()
    {
        return mTerm * 12 * getMonthlyPayment() - getBorrowedAmount();
    }

    /**
     * Gets the monthly payment on the car loan.
     * @return The monthly payment on the car loan.
     */
    public double getMonthlyPayment()
    {
        double monthlyInterestRate = 0.0;

        switch (mTerm)
        {
            case 3:
                monthlyInterestRate = APR_3_YEARS / 12;
                break;
            case 4:
                monthlyInterestRate = APR_4_YEARS / 12;
                break;
            case 5:
                monthlyInterestRate = APR_5_YEARS / 12;
                break;
            default:
                // should NOT get to this point
        }

        double interestExpression = Math.pow(1 + monthlyInterestRate, mTerm * 12.0);

        return getBorrowedAmount() * monthlyInterestRate * interestExpression / (interestExpression - 1);
    }

}
