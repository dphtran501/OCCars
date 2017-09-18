package edu.orangecoastcollege.cs273.dtran258.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

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

    protected void reportSummary(View view)
    {
        collectCarLoanData();
        String report = "Monthly Payment: $" + mCarLoan.getMonthlyPayment();
        // TODO: Keep going, more to report!!!

        // Intents start new activities and can share data with them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        // Put data into the Intent for Loan Summary to receive
        launchLoanSummary.putExtra("loanReport", report);
        // Start second activity
        startActivity(launchLoanSummary);
    }
}
