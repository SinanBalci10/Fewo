package com.example.application.views.stornieren;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("stornieren")
@PageTitle("Stornieren")
public class StornierenView extends Composite<VerticalLayout> {

    public StornierenView() {
        UI.getCurrent().getPage().setLocation("dashboard");
        VaadinSession.getCurrent().getSession().invalidate();
        VaadinSession.getCurrent().close();
    }

}