package edu.orangecoastcollege.cs273.dtran258.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * This activity allows the user to input information about their car loan, specifically the price
 * of the car, the down payment on the car, and the loan term. The information can then be passed to
 * <code>LoanSummaryActivity</code> for calculations.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 14, 2017
 */
public class PurchaseActivity extends AppCompatActivity
{

    // Connections to VIEW
    private EditText mCarPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearRadioButton;
    private RadioButton mFourYearRadioButton;
    private RadioButton mFiveYearRadioButton;

    // Connection to the MODEL
    private CarLoan mCarLoan = new CarLoan();

    /**
     * Initializes <code>PurchaseActivity</code> by inflating its UI.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        // Use findViewById to connect controller to each view
        mCarPriceEditText = (EditText) findViewById(R.id.car_price_edit_text);
        mDownPaymentEditText = (EditText) findViewById(R.id.down_payment_edit_text);
        mThreeYearRadioButton = (RadioButton) findViewById(R.id.three_years_radio_button);
        mFourYearRadioButton = (RadioButton) findViewById(R.id.four_years_radio_button);
        mFiveYearRadioButton = (RadioButton) findViewById(R.id.five_years_radio_button);
    }

    private void collectCarLoanData()
    {
        mCarLoan.setPrice(Double.parseDouble(mCarPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if (mThreeYearRadioButton.isChecked()) mCarLoan.setTerm(3);
        else if (mFourYearRadioButton.isChecked()) mCarLoan.setTerm(4);
        else mCarLoan.setTerm(5);
    }

    /**
     * Retrieves data input from this activity, sends the data to <code>LoanSummaryActivity</code>,
     * and launches <code>LoanSummaryActivity</code>.
     *
     * @param view The <code>View</code> that called this method.
     */
    protected void reportSummary(View view)
    {
        collectCarLoanData();
        StringBuilder reportSB = new StringBuilder(R.string.report_line1);
        reportSB.append(mCarLoan.getMonthlyPayment()).append(R.string.report_line2).append(mCarLoan.getPrice()).append(R.string.report_line3).append(mCarLoan.getTaxAmount()).append(R.string.report_line4).append(mCarLoan.getTotalAmount()).append(R.string.report_line5).append(mCarLoan.getDownPayment()).append(R.string.report_line6).append(mCarLoan.getBorrowedAmount()).append(R.string.report_line7).append(mCarLoan.getInterestAmount()).append(R.string.report_line8).append(mCarLoan.getTerm()).append(" years.");

        StringBuilder noteSB = new StringBuilder(R.string.report_line9);
        noteSB.append(R.string.report_line10).append(R.string.report_line11).append(R.string.report_line12);

        // Intents start new activities and can share data with them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        // Put data into the Intent for Loan Summary to receive
        launchLoanSummary.putExtra("loanReport", reportSB.toString());
        launchLoanSummary.putExtra("loanNote", noteSB.toString());
        // Start second activity
        startActivity(launchLoanSummary);
    }
}
