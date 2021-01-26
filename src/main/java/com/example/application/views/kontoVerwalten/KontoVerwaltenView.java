package com.example.application.views.kontoVerwalten;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("kontoVerwalten")
@PageTitle("KontoVerwalten")
public class KontoVerwaltenView extends Composite<VerticalLayout> {

    public KontoVerwaltenView() {
        UI.getCurrent().getPage().setLocation("dashboard");
        VaadinSession.getCurrent().getSession().invalidate();
        VaadinSession.getCurrent().close();
    }

}
