package com.example.application.views.login;

import com.example.application.data.service.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value = "anmelden") // name auf developpermode
@PageTitle("Anmelden")
@CssImport("./styles/views/login/login-view.css")//bei frontend styles view zu sehen (design)
public class LoginView extends Div {

    public LoginView(AuthService authService) {
        setId("login-view");
        var email = new TextField("E-mail");
        var password = new PasswordField("Passwort");
        add(
                new H1("Anmelden"),
                email,
                password,
                new Button("Anmelden", event -> {
                    try {
                        authService.authenticate(email.getValue(), password.getValue());
                        UI.getCurrent().navigate("home");
                    } catch (AuthService.AuthException e) {
                        Notification.show("Falsche Angaben.");
                    }
                }),
                new RouterLink("Registrieren", RegisterView.class)
        );
    }

}
