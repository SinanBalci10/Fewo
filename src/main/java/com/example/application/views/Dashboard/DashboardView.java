package com.example.application.views.Dashboard;

//import com.vaadin.flow.component.icon.IronIcon;
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

        Image image = new Image();
        image.setSrc(musterhaus.getBild());
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        Span name = new Span(musterhaus.getName());
        name.addClassName("name");
        header.add(name);

        Span post = new Span(musterhaus.getPost());
        post.addClassName("post");


        description.add(header, post);
        card.add(image, description);
        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        List<Musterhaus> musterhause = Arrays.asList( //
                createMusterhaus("https://randomuser.me/api/portraits/men/42.jpg","Musterhaus 1", "6 Personen - 3 Schlafzimmer - 90 m²"),
                createMusterhaus("https://randomuser.me/api/portraits/men/42.jpg","Musterhaus 2", "6 Personen - 3 Schlafzimmer - 90 m²"),
                createMusterhaus("https://randomuser.me/api/portraits/men/42.jpg","Musterhaus 3", "6 Personen - 3 Schlafzimmer - 90 m²")
                );

        grid.setItems(musterhause);

    }
    private static Musterhaus createMusterhaus(String bild, String name, String post) {
        Musterhaus m = new Musterhaus();
        m.setBild(bild);
        m.setName(name);
        m.setPost(post);

        return m;
    }
}
