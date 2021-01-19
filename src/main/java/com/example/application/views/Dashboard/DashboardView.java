package com.example.application.views.Dashboard;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;


@PageTitle("Dashboard") // linke seite name
@Route(value = "dashboard") // /dashboard rute um url
@CssImport(value = "./styles/views/dashboard/dashboard-view.css", include = "lumo-badge")
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")

public class DashboardView<sample> extends Div implements AfterNavigationObserver {

    Grid<Suchleiste> grid = new Grid<>();

    public DashboardView() {
        setId("dashboard-view");
        addClassName("dashboard-view");
        setSizeFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(musterhausDashboard -> createCard(musterhausDashboard));
        add(grid);
    }

    private HorizontalLayout createCard(Suchleiste suchleiste) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");

        //layout von der beschreibung in der karte
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        //kopflayout
        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        //überschrift der karte
        Span uberschrift = new Span(suchleiste.getUberschrift());
        uberschrift.addClassName("uberschrift");
        header.add(uberschrift); // name oben hinzufügen

        //filtername der karte
        Span filter = new Span(suchleiste.getFilter());
        filter.addClassName("filter");

        //ort der karte
        Span ort = new Span(suchleiste.getOrt());
        ort.addClassName("ort");

        Span verfugbarkeit = new Span(suchleiste.getVerfugrbar());
        verfugbarkeit.addClassName("verfugbarkeit");

        Span personenzahl = new Span(suchleiste.getPersonenzahl());
        personenzahl.addClassName("personenzahl");

        Button suchen = new Button("Suchen", event -> {
            UI.getCurrent().navigate("musterhaus");
        });

        description.add(header, filter, ort, verfugbarkeit, personenzahl);
        //die karte sichrbar machen (bild und beschreibungen)
        card.add(description, suchen);
        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        List<Suchleiste> suchleistes = Arrays.asList(
               createSuchleiste("Häuser suchen","Filter","Ort", "Verfügbarkeit","Personenzahl")
        );

        grid.setItems(suchleistes);

    }

    private static Suchleiste createSuchleiste(String uberschrift, String filter, String ort, String verfugbar, String personenzahl) {
        Suchleiste s = new Suchleiste();
        s.setUberschrift(uberschrift);
        s.setFilter(filter);
        s.setOrt(ort);
        s.setVerfugrbar(verfugbar);
        s.setPersonenzahl(personenzahl);

        return s;
    }
}