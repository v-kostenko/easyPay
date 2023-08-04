package web.steps;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.title;

public class RestoreSteps {


    public static boolean isRestorePageUrlContainsPath(String path) {
        return Objects.requireNonNull(title()).contains(path);
    }





}
