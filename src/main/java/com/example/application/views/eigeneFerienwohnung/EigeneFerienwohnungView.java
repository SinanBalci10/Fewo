package com.example.application.views.eigeneFerienwohnung;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("eigeneFerienwohnung")
@PageTitle("EigeneFerienwohnung")
public class EigeneFerienwohnungView extends Composite<VerticalLayout> {

    public EigeneFerienwohnungView() {
        UI.getCurrent().getPage().setLocation("eigeneFerienwohnung");
        VaadinSession.getCurrent().getSession().invalidate();
        VaadinSession.getCurrent().close();
    }

}