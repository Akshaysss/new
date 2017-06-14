package auth.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by pranav on 14/06/17.
 */

public class RequestOTPManagerImpl implements RequestOTPManager {

    private RequestOTPService service;

    public RequestOTPManagerImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                // Base URL can change for endpoints (dev, staging, live..)
                .baseUrl("http://api.nobrokerage.com/api/advisor/")
                // Takes care of converting the JSON response into java objects
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        // Create the Google Book API Service
        service = retrofit.create(RequestOTPService.class);
    }

    @Override
    public Observable<RequestOTPResponse> requestOTP(String mobile) {
        return service.request_otp(mobile).subscribeOn(Schedulers.io());
    }
}
