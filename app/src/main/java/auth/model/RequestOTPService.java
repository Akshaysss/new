package auth.model;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pranav on 14/06/17.
 */

public interface RequestOTPService {
    @FormUrlEncoded
    @POST("resend_otp/")
    Observable<RequestOTPResponse> request_otp(@Field("mobile") String mobile);
}
