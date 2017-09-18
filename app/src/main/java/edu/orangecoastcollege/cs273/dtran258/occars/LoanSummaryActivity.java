package edu.orangecoastcollege.cs273.dtran258.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This activity displays the car loan report based on the information sent by
 * <code>PurchaseActivity</code>.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 14, 2017
 */
public class LoanSummaryActivity extends AppCompatActivity
{

    // VIEWS
    private TextView mLoanReport;
    private TextView mLoanNote;

    /**
     * Initializes <code>LoanSummaryActivity</code> by inflating its UI.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // Receive the Intent (from PurchaseActivity)
        // Populate the text view with data
        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("loanReport");
        String note = intentFromPurchase.getStringExtra("loanNote");

        mLoanReport = (TextView) findViewById(R.id.loan_report_text_view);
        mLoanNote = (TextView) findViewById(R.id.loan_note_text_view);

        mLoanReport.setText(report);
        mLoanNote.setText(note);
    }

    /**
     * Launches <code>PurchaseActivity</code>.
     * @param view The <code>View</code> that called this method.
     */
    public void enterData(View view)
    {
        Intent launchPurchase = new Intent(this, PurchaseActivity.class);
        startActivity(launchPurchase);
    }
}
