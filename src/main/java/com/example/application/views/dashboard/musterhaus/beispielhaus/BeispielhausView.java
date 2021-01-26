package com.example.application.views.dashboard.musterhaus.beispielhaus;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;


@PageTitle("Beispielhaus") // z
@Route(value = "beispielhaus") // gibt die route, aber wird nicht im dashboard angezeigt
@CssImport(value = "./styles/views/beispielhaus/beispielhaus-view.css", include = "lumo-badge")
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")

public class BeispielhausView extends Div implements AfterNavigationObserver {

    Grid<Beispielhaus> grid = new Grid<>();

    public BeispielhausView() {
        setId("beispielhaus-view");
        addClassName("beispielhaus-view");
        setSizeFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(musterhaus -> createCard(musterhaus));
        add(grid);
    }

    private HorizontalLayout createCard(Beispielhaus musterhaus) {
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

        //hausbilder
        Image image0 = new Image();
        image0.setSrc(musterhaus.getBild0());
        Image image1 = new Image();
        image1.setSrc(musterhaus.getBild1());
        Image image2 = new Image();
        image2.setSrc(musterhaus.getBild2());
        Image image3 = new Image();
        image3.setSrc(musterhaus.getBild3());





        var lage = new com.vaadin.flow.component.details.Details("Lage", new Text("Ort: Ort 1\n" +
                "Personenzahl: 6   " +
                " Schlafzimmerzahl: 3   " +
                " Badezimmerzahl: 2   " +
                " Mindestaufenthaltsdauer: 3 Tage   " +
                " Wohnfläche: 90 m²   " +
                " Bewertung: 4/5   " +
                " Preis: 70 € / Übernachtung"));



        var beschr = new com.vaadin.flow.component.details.Details("Beschreibung", new Text(""));

        Span beschreibung = new Span(musterhaus.getBeschreibung());
        beschreibung.addClassName("beschreibung");

        // anzeigen klicken und navigieren zu buchen
        Button buchen = new Button("Buchen", event -> {
            UI.getCurrent().navigate("buchen");
        });

        description.add(image0,image1,image2,image3,lage, beschr,  beschreibung,  buchen);
        //die karte sichrbar machen (bild)
        card.add(description);
        return card;
    }

    //Bilder des Hauses Anzeige
    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        List<Beispielhaus> musterhaus = Arrays.asList( //
                createMusterhaus("https://pngimg.com/uploads/house/house_PNG50.png",
                        "https://pngimg.com/uploads/house/house_PNG6.png",
                        "https://pngimg.com/uploads/house/house_PNG50.png",
                        "https://pngimg.com/uploads/tree/tree_PNG92786.png",
                        "Beschreibung"
                        ,"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\n" +
                                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n" +
                                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et\n" +
                                "quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores\n" +
                                "eos qui ratione voluptatem sequi nesciunt.")
                );

        grid.setItems(musterhaus);

    }
    private static Beispielhaus createMusterhaus(String bild0, String bild1, String bild2, String bild3,String uberschrift, String beschreibung) {
        Beispielhaus m= new Beispielhaus();
        m.setBild0(bild0);
        m.setBild1(bild1);
        m.setBild2(bild2);
        m.setBild3(bild3);
        m.setUberschrift(uberschrift);
        m.setBeschreibung(beschreibung);


        return m;
    }

}

