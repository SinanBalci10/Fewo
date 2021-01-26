package com.example.application.views.postfach;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("postfach")
@PageTitle("Postfach")
public class PostfachView extends Composite<VerticalLayout> {

    public PostfachView() {
        UI.getCurrent().getPage().setLocation("dashboard");
        VaadinSession.getCurrent().getSession().invalidate();
        VaadinSession.getCurrent().close();
    }

}
