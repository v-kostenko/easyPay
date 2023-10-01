package api.easyPayApi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Locale {

    @JsonProperty("locale")
    private String locale;

    public Locale(String locale) {
        this.locale = locale;
    }

    public String getLocale() {
        return locale;
    }
}