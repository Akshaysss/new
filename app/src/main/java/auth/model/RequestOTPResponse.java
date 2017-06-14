package auth.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pranav on 14/06/17.
 */

public class RequestOTPResponse {
    @SerializedName("result")
    Integer result;
    @SerializedName("message")
    String message;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
