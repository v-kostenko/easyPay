package web.tests;

import org.junit.jupiter.api.Test;

import static web.pageObjects.MainPage.sideMenu;

public class Mobile extends BaseTestWeb {

    @Test
    public void rrr() {
        sideMenu.  forEach(e -> System.out.println(e.getText()));
    }


}
