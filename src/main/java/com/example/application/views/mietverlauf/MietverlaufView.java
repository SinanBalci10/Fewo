package com.example.application.views.mietverlauf;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("mietverlauf")
@PageTitle("Mietverlauf")
public class MietverlaufView extends Composite<VerticalLayout> {

    public MietverlaufView() {
        UI.getCurrent().getPage().setLocation("dashboard");
        VaadinSession.getCurrent().getSession().invalidate();
        VaadinSession.getCurrent().close();
    }
}
