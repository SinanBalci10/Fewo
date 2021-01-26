package com.example.application.views.nachrichtSenden;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("nachrichtSenden")
@PageTitle("NachrichtSenden")
public class NachrichtSendenView extends Composite<VerticalLayout> {

    public NachrichtSendenView() {
        UI.getCurrent().getPage().setLocation("dashboard");
        VaadinSession.getCurrent().getSession().invalidate();
        VaadinSession.getCurrent().close();
    }

}