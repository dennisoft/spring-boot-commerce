package commerce.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import commerce.users.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserErrors extends User{
    private String response_code;
    private String response_msg;

    public UserErrors() {
        super();
    }

    public String getResponseCode() {
        return response_code;
    }

    public void setResponseCode(String responseCode) {
        this.response_code = responseCode;
    }

    public String getResponseMsg() {
        return response_msg;
    }

    public void setResponseMsg(String responseMsg) {
        this.response_msg = responseMsg;
    }
}
