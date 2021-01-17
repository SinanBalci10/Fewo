package com.example.application.views.Dashboard;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.ui.TextArea;

import java.util.Arrays;
import java.util.List;

@PageTitle("Beispielhaus")
@CssImport(value = "./styles/views/beispielhaus/beispielhaus-view.css", include = "lumo-badge")
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")

public class Beispielhaus extends Div implements AfterNavigationObserver {

    Grid<Musterhaus> grid = new Grid<>();

    public Beispielhaus() {
        setId("beispielhaus-view");
        addClassName("beispielhaus-view");
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

        //hausbilder
        Image image0 = new Image();
        image0.setSrc(musterhaus.getBild0());
        Image image1 = new Image();
        image1.setSrc(musterhaus.getBild1());
        Image image2 = new Image();
        image2.setSrc(musterhaus.getBild2());
        Image image3 = new Image();
        image3.setSrc(musterhaus.getBild3());

        //beschreibung des hauses
        HorizontalLayout description = new HorizontalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        //kopflayout
        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");


        Span name = new Span(musterhaus.getName());
        name.addClassName("name");
        header.add(name); // name oben hinzufügen

        Span post = new Span(musterhaus.getPost());
        post.addClassName("post");

        //rechtebeschreibung
        TextArea hausbeschreibung = new TextArea();
        hausbeschreibung.setValue("The quick brown fox jumps over the lazy dog.");
        hausbeschreibung.setRows(10);
        hausbeschreibung.setSizeFull();

        //actions
        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

        //stern bewertung
        IronIcon likesymbol = new IronIcon("vaadin", "star");
        Span bewertung = new Span(musterhaus.getBewertung());
        bewertung.addClassName("bewertung");

        // symbole sichtbar machen durch befehl add
        actions.add(likesymbol, bewertung);
        // beschreibung sichtbar machen durch dem befehl add
        description.add(header, post, actions);
        //die karte sichrbar machen (bild und beschreibungen)
        card.add(image0,image1,image2,image3, description);
        return card;
    }

    //Mietwohnungen Anzeige
    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        List<Musterhaus> musterhause = Arrays.asList( //
                createMusterhaus("https://randomuser.me/api/portraits/men/42.jpg",
                        "https://randomuser.me/api/portraits/men/42.jpg",
                        "https://randomuser.me/api/portraits/men/42.jpg",
                        "https://randomuser.me/api/portraits/men/42.jpg")
                );

        grid.setItems(musterhause);

    }
    private static Musterhaus createMusterhaus(String bild0,String bild1,String bild2,String bild3) {
        Musterhaus m= new Musterhaus();
        m.setBild0(bild0);
        m.setBild1(bild1);
        m.setBild2(bild2);
        m.setBild3(bild3);

        return m;
    }
}

