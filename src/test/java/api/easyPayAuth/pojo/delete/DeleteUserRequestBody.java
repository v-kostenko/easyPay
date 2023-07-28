package api.easyPayAuth.pojo.delete;

public class DeleteUserRequestBody {
    private int reason;
    private String reasonContent;
    private String confirmCode;


    public DeleteUserRequestBody(int reason, String reasonContent, String confirmCode) {
        this.reason = reason;
        this.reasonContent = reasonContent;
        this.confirmCode = confirmCode;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

    public String getReasonContent() {
        return reasonContent;
    }

    public void setReasonContent(String reasonContent) {
        this.reasonContent = reasonContent;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }
}
