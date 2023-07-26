package api.easyPay_Api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("name")
    private String name;

    @JsonProperty("isPriority")
    private boolean isPriority;

    public Contact(String phone, String surname, String name, boolean isPriority) {
        this.phone = phone;
        this.surname = surname;
        this.name = name;
        this.isPriority = isPriority;
    }

    public Contact() {
    }

    public String getPhone() {
        return phone;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public boolean isIsPriority() {
        return isPriority;
    }
}