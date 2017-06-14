package auth.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sbs.gp.sbsgpandroidapp.R;

import auth.model.RequestOTPManagerImpl;
import auth.model.RequestOTPResponse;
import auth.viewmodel.LoginViewModel;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
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
        loginViewModel = new LoginViewModel(new RequestOTPManagerImpl(),
                AndroidSchedulers.mainThread());
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
        String mobileText = mobile.getText().toString();
        subscriptions.add(loginViewModel.requestOTP(mobileText).subscribe(new Observer<RequestOTPResponse>() {
            @Override
            public void onCompleted() {
                Toast.makeText(LoginActivity.this,"completed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(LoginActivity.this,"error"+e.getMessage(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNext(RequestOTPResponse requestOTPResponse) {
                Toast.makeText(LoginActivity.this,requestOTPResponse.toString(),
                        Toast.LENGTH_SHORT).show();

            }
        }));
    }
}
