package auth.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sbs.gp.sbsgpandroidapp.R;

import auth.viewmodel.LoginViewModel;
import rx.subscriptions.CompositeSubscription;

public class LoginActivity extends AppCompatActivity {

    private EditText mobile;
    private Button requestOTPButton;

    private CompositeSubscription subscriptions = new CompositeSubscription();
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
    }

    private void bindViews() {

        mobile = (EditText)findViewById(R.id.mobile);
        requestOTPButton = (Button)findViewById(R.id.request_otp_btn);
        requestOTPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestOTP();
            }
        });

    }

    private void requestOTP() {

    }
}
