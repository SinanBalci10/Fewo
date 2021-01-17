package com.example.application.views.Dashboard;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;

import java.util.Arrays;
import java.util.List;


@PageTitle("Dashboard")
@CssImport(value = "./styles/views/dashboard/dashboard-view.css", include = "lumo-badge")
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")

public class DashboardView extends Div implements AfterNavigationObserver {

    Grid<Musterhaus> grid = new Grid<>();

    public DashboardView() {
        setId("dashboard-view");
        addClassName("dashboard-view");
        setSizeFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(musterhaus -> createCard(musterhaus));
        add(grid);
    }



    private HorizontalLayout createCard(Musterhaus musterhaus) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");


        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        //kopflayout
        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");


        // bild des hauses
        Image image = new Image();
        image.setSrc(musterhaus.getBild0());

        //name des hauses
        Span name = new Span(musterhaus.getName());
        name.addClassName("name");
        header.add(name); // name oben hinzufügen

        //beschreibung des hauses
        Span post = new Span(musterhaus.getPost());
        post.addClassName("post");

        //preis des hauses
        Span preis = new Span(musterhaus.getPreis());
        preis.addClassName("preis");

        //actions
        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

        //symbole
        IronIcon likesymbol = new IronIcon("vaadin", "star");
        Span bewertung = new Span(musterhaus.getBewertung());
        bewertung.addClassName("bewertung");

        // anzeigen klicken und navigieren zu haus
        Button anzeigen = new Button("Anzeigen", event -> {
            UI.getCurrent().navigate("beispielhaus");
        });

        // symbole sichtbar machen durch befehl add
        actions.add(likesymbol, bewertung);
        // beschreibung sichtbar machen durch dem befehl add
        description.add(header, post,preis, actions);
        //die karte sichrbar machen (bild und beschreibungen)
        card.add(image,description, anzeigen);
        return card;
    }

    //Mietwohnungen Anzeige
    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        List<Musterhaus> musterhause = Arrays.asList( //
                createMusterhaus("https://pngimg.com/uploads/house/house_PNG50.png","Musterhaus 1", "6 Personen - 3 Schlafzimmer - 90 m²", "70€ / Nacht", "4/5"),
                createMusterhaus("https://pngimg.com/uploads/house/house_PNG48.png","Musterhaus 2", "6 Personen - 3 Schlafzimmer - 90 m²", "70€ / Nacht", "4/5"),
                createMusterhaus("https://pngimg.com/uploads/house/house_PNG61.png","Musterhaus 3", "6 Personen - 3 Schlafzimmer - 90 m²", "70€ / Nacht", "4/5")
        );

        grid.setItems(musterhause);

    }
    private static Musterhaus createMusterhaus(String bild0, String name, String post, String preis, String bewertung) {
        Musterhaus m = new Musterhaus();
        m.setBild0(bild0);
        m.setName(name);
        m.setPost(post);
        m.setPreis(preis);
        m.setBewertung(bewertung);

        return m;
    }
}