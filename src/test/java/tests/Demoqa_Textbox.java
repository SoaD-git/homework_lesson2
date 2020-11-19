package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Demoqa_Textbox {

    @Test
    void positiveTextBoxTest() {

        String username = "dnl",
                mail = "user@stable.com",
                currentAddress = "Saint Petersburg",
                permanentAddress = "new street, 1";


        open("https://demoqa.com/text-box");

        $("#userName").setValue(username);
        $("#userEmail").setValue(mail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").scrollTo().click();

        $("#name").scrollTo().shouldHave(text(username));
        $("#email").scrollTo().shouldHave(text(mail));
        $("#currentAddress").scrollTo().shouldHave(value(currentAddress));
        $("#permanentAddress").scrollTo().shouldHave(value(permanentAddress));

    }

    @Test
    void negativeTextBoxMail() {

        open("https://demoqa.com/text-box");
        $("#userEmail").setValue("None");
        $("#submit").scrollTo().click();
        $("#userEmail").scrollTo().shouldHave(cssClass("field-error"));
    }
}
