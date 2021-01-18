package com.example.application.views.login;

import com.example.application.data.service.AuthService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("registrieren") // name auf developpermode

public class RegisterView extends Composite {

    private final AuthService authService;

    public RegisterView(AuthService authService) {
        this.authService = authService;
    }

    @Override
    protected Component initContent() {

        TextField email = new TextField("E-mail");
        email.setPlaceholder("E-mail");
        PasswordField password1 = new PasswordField("Passwort festlegen");
        password1.setPlaceholder("mind. 8 Zeichen");
        PasswordField password2 = new PasswordField("Passwort wiederholen");
        password2.setPlaceholder("passwort wiederholen");

        return new VerticalLayout(
                new H2("Registrieren"),
                email,
                password1,
                password2,
                new Button("Registrieren", event -> register(
                        email.getValue(),
                        password1.getValue(),
                        password2.getValue()
                ))
        );
    }

    private void register(String email, String password1, String password2) {
        if (email.trim().isEmpty()) {
            Notification.show("Geben Sie eine Email ein");
        } else if (password1.isEmpty()) {
            Notification.show("Geben Sie ein Passwort ein");
        } else if (password1.length() > 8) {
            Notification.show("Das Passwort muss mindestens 8 Zeichen lang sein");
        } else if (!password1.equals(password2)) {
            Notification.show("Passwörter stimmen nicht überein");
        } else {
            authService.register(email, password1);
            Notification.show("Link ist gesendet");
        }
    }
}
