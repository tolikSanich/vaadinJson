package com.example.application.views.helloworld;

import com.example.application.model.Personal;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    private TextField field;
    private Button find;
    private Grid<Personal> grid = new Grid<>(Personal.class);



    public HelloWorldView() {
        field = new TextField("Your name");
        find = new Button("Say hello");
        find.addClickListener(e -> {
            Notification.show("Hello " + field.getValue());
        });
        find.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, field, find);

        add(field, find);
    }

}
