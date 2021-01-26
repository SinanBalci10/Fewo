package com.example.application.views.dashboard.musterhaus.beispielhaus.buchen;

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


@PageTitle("Buchen") // linke seite name
@Route(value = "buchen") // /dashboard rute um url
@CssImport(value = "./styles/views/buchen/buchen-view.css", include = "lumo-badge")
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")

public class BuchenView<sample> extends Div implements AfterNavigationObserver {

    Grid<Buchen> grid = new Grid<>();

    public BuchenView() {
        setId("buchen-view");
        addClassName("buchen-view");
        setSizeFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(buchen -> createCard(buchen));
        add(grid);
    }

    private HorizontalLayout createCard(Buchen buchen) {
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
        Span uberschrift = new Span(buchen.getUberschrift());
        uberschrift.addClassName("uberschrift");
        header.add(uberschrift); // name oben hinzufügen


        var zeitraum = new com.vaadin.flow.component.datepicker.DatePicker("Zeitraum");

        var bis = new com.vaadin.flow.component.datepicker.DatePicker("bis");

        var texfeldpersonen = new com.vaadin.flow.component.textfield.TextField("Personenzahl: ");

        var methode = new com.vaadin.flow.component.textfield.TextField("Bezahlmethode");



        Button abbrechen = new Button("Abbrechen", event -> {
            UI.getCurrent().navigate("beispielhaus");
        });

        Button buchenbest = new Button("Buchung Bestätigen", event -> {
            UI.getCurrent().navigate("dashboard");
        });

        description.add(header, zeitraum, bis,texfeldpersonen, methode, abbrechen, buchenbest);
        //die karte sichrbar machen (bild und beschreibungen)
        card.add(description);
        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        List<Buchen> buchen = Arrays.asList(
                createBuchen("Buchen", "", "Personenzahl: ", "Bezahlmethode: ", "Preis: 210€")
        );

        grid.setItems(buchen);

    }

    private static Buchen createBuchen(String uberschrift, String zeitraum, String personenzahl, String bezahlmethode, String preis) {
        Buchen b = new Buchen();
        b.setUberschrift(uberschrift);
        b.setZeitraum(zeitraum);
        b.setPersonenzahl(personenzahl);
        b.setBezahlmethode(bezahlmethode);
        b.setPreis(preis);

        return b;
    }
}