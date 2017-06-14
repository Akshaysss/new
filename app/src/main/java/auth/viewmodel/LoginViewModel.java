package auth.viewmodel;

import auth.model.RequestOTPManager;
import auth.model.RequestOTPResponse;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by pranav on 14/06/17.
 */

public class LoginViewModel {

    private RequestOTPManager requestOTPManager;
    private Scheduler scheduler;

    public LoginViewModel(RequestOTPManager requestOTPManager, Scheduler scheduler) {
        this.requestOTPManager = requestOTPManager;
        this.scheduler = scheduler;
    }

    public Observable<RequestOTPResponse> requestOTP(String mobile){

        return requestOTPManager.requestOTP(mobile).observeOn(scheduler);
    }
}
