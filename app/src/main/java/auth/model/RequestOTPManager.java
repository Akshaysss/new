package auth.model;

import rx.Observable;

/**
 * Created by pranav on 14/06/17.
 */

public interface RequestOTPManager {
    Observable<RequestOTPResponse> requestOTP(String mobile);
}
