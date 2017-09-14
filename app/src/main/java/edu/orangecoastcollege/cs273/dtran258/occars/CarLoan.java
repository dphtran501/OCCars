package edu.orangecoastcollege.cs273.dtran258.occars;

/**
 * Created by Jeannie on 9/14/2017.
 */

public class CarLoan
{
    private static final double STATE_TAX = 0.08;

    private double mPrice;
    private double mDownPayment;
    private int mTerm;

    public double getPrice()
    {
        return mPrice;
    }

    public void setPrice(double price)
    {
        mPrice = price;
    }

    public double getDownPayment()
    {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment)
    {
        mDownPayment = downPayment;
    }

    public int getTerm()
    {
        return mTerm;
    }

    public void setTerm(int term)
    {
        mTerm = term;
    }

    public double borrowedAmount()
    {
        return mPrice - mDownPayment;
    }

    public double taxAmount()
    {
        return mPrice * STATE_TAX;
    }

    public double totalAmount()
    {
        return mPrice + taxAmount();
    }

    public double interestAmount()
    {
        double interestRate = (mTerm == 3) ? 0.0462 : ((mTerm == 4) ? 0.419 : 0.0416);
        /*
        3 year APR = 4.62%
        4 year APR = 4.19%
        5 year APR = 4.16%
         */
        return borrowedAmount() * interestRate;
    }

    public double monthlyPayment()
    {
        return (borrowedAmount() + interestAmount()) / (mTerm * 12);
    }
}
