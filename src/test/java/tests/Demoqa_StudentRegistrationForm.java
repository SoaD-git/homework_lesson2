package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Demoqa_StudentRegistrationForm {

    String  firstName = "dmitriy",
            lastName = "lupachev",
            email = "user@stable.ru",
            mobile = "0123456789",
            dayBirth = "09",
            monthBirth = "April",
            yearBirth = "1987",
            subject1 = "Maths",
            subject1prefix = "m",
            subject2 = "Physics",
            subject2prefix = "p",
            hobby1 = "Reading",
            hobby2 = "Sports",
            picture = "3.jpg",
            currentAddress = "New address, 1",
            state = "Haryana",
            city = "Panipat";

    @Test
    void positiveStudentRegistrationFormTest() {

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").scrollTo().val(firstName);

        $("#lastName").scrollTo().val(lastName);

        $("#userEmail").scrollTo().val(email);

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").scrollTo().val(mobile);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthBirth);
        $(".react-datepicker__year-select").selectOption(yearBirth);
        $(".react-datepicker__day--0" + dayBirth).click();

        $("#subjectsInput").val(subject1prefix);
        $(".subjects-auto-complete__menu-list").$(byText(subject1)).click();
        $("#subjectsInput").val(subject2prefix);
        $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();

        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();

        $("#uploadPicture").uploadFromClasspath(picture);

        $("#currentAddress").scrollTo().val(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").scrollTo().click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").scrollTo().click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text( firstName + " " + lastName), text(email), text("Male"));

        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));

        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayBirth + " " + monthBirth + "," + yearBirth));

        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1 + ", " + subject2));

        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1 + ", " + hobby2));

        $x("//td[text()='Picture']").parent().shouldHave(text(picture));

        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));

        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));


    }

    @Test
    void negativeRequiredFieldFirstNameStudentRegistrationFormTest() {

        open("https://demoqa.com/automation-practice-form");

        $("#lastName").scrollTo().val(lastName);
        $("#userNumber").scrollTo().val(mobile);
        $("#genterWrapper").$(byText("Female")).click();
        $("#submit").scrollTo().click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
//        $("#firstName").shouldHave(cssClass("form-control:invalid"));
    }
}
