package com.example.btchuong4_;// MainActivity.java
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText loanAmountInput, interestRateInput, loanTermInput;
    TextView monthlyPaymentText, totalPaymentText;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loanAmountInput = findViewById(R.id.loan_amount_input);
        interestRateInput = findViewById(R.id.interest_rate_input);
        loanTermInput = findViewById(R.id.loan_term_input);
        monthlyPaymentText = findViewById(R.id.monthly_payment_text);
        totalPaymentText = findViewById(R.id.total_payment_text);
        calculateButton = findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMortgage();
            }
        });
    }

    private void calculateMortgage() {
        String loanAmountStr = loanAmountInput.getText().toString();
        String interestRateStr = interestRateInput.getText().toString();
        String loanTermStr = loanTermInput.getText().toString();

        if (loanAmountStr.isEmpty() || interestRateStr.isEmpty() || loanTermStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double loanAmount = Double.parseDouble(loanAmountStr);
            double interestRate = Double.parseDouble(interestRateStr);
            int loanTerm = Integer.parseInt(loanTermStr);

            double monthlyPayment = MortgageCalculator.calculateMortgage(loanAmount, interestRate, loanTerm);
            double totalPayment = MortgageCalculator.calculateTotalPayment(monthlyPayment, loanTerm);

            monthlyPaymentText.setText(String.format("Monthly Payment: $%.2f", monthlyPayment));
            totalPaymentText.setText(String.format("Total Payment: $%.2f", totalPayment));
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
        }
    }
}
