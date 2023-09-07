package com.example.tutor_hiring_app;

import static com.example.tutor_hiring_app.ConfirmParent.PARENT_DETAILS;
import static com.example.tutor_hiring_app.ConfirmParent.TUTOR_DETAILS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    TextView paymentText_View;
    TextView paymentConfirmationText_View;

    String parentDetails;
    String tutorDetails;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        parentDetails = getIntent().getStringExtra(PARENT_DETAILS);
        tutorDetails = getIntent().getStringExtra(TUTOR_DETAILS);

        //get the view of paymentText_View
        paymentText_View = (TextView) findViewById(R.id.payment_text_view);
        paymentText_View.setText(tutorDetails+"\n\nReserved by\n\n"+parentDetails);

        message = "Please contact with the tutor for the method of acceptance payment.";
        //get the view of paymentConfirmationText_View
        paymentConfirmationText_View = (TextView) findViewById(R.id.payment_confirmation_text_view);
        paymentConfirmationText_View.setText(message);
    }
}