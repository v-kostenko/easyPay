package pojo.check;

public class ApiCheckRequestBody {
    private String phone;
    private String channel;

    public ApiCheckRequestBody(String phone, String channel) {
        this.phone = phone;
        this.channel = channel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
