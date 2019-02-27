package com.renault.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.myown.lib.OTPListener;
import com.myown.lib.OtpTextView;

public class MainActivity extends AppCompatActivity {
    private OtpTextView otpTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.black));

        Button errorButton = findViewById(R.id.button);
        Button successButton = findViewById(R.id.button2);
        otpTextView = findViewById(R.id.otp_view);
        otpTextView.requestFocusOTP();
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            @Override
            public void onOTPComplete(String otp) {
                Toast.makeText(MainActivity.this, "The OTP is " + otp, Toast.LENGTH_SHORT).show();
                if(otp.equals("123456"))
                    otpTextView.showSuccess();
                else
                    otpTextView.showError();

            }
        });
        errorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpTextView.showError();
            }
        });
        successButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpTextView.showSuccess();
            }
        });
    }
}
