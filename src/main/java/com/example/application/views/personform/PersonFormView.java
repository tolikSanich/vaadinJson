package com.example.application.views.personform;

import com.example.application.model.Personal;
import com.example.application.service.PersonalService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Person Form")
@Route(value = "person-form", layout = MainLayout.class)
public class PersonFormView extends Composite<VerticalLayout> {
    private final TextField firstName = new TextField();
    private final TextField lastName = new TextField();
    private final DatePicker birthdate = new DatePicker();
    private final TextField personnelNumber = new TextField();

    private final TextField telephone = new TextField();
    private final EmailField email = new EmailField();

    private final PersonalService personalService;
    private Personal personal = new Personal();
    private Binder<Personal> binder = new Binder<>(Personal.class);

    public PersonFormView(
            PersonalService personalService
    ) {
        this.personalService = personalService;
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        setBinder();
        FormLayout formLayout2Col = new FormLayout();

        HorizontalLayout layoutRow = new HorizontalLayout();
        Button save = new Button();
        Button cancel = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");
        h3.setText("Персональная инофрмация");
        h3.setWidth("100%");
        formLayout2Col.setWidth("100%");
        firstName.setLabel("Имя");
        lastName.setLabel("Фамилия");
        birthdate.setLabel("День рождения");
        telephone.setLabel("Телефонный номер");
        email.setLabel("Email");
        personnelNumber.setLabel("Табельный номер");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        save.setText("Save");
        save.setWidth("min-content");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.setText("Cancel");
        cancel.setWidth("min-content");
        save.addClickListener(e->{
           personalService.save(personal);
        });
        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(firstName);
        formLayout2Col.add(lastName);
        formLayout2Col.add(birthdate);
        formLayout2Col.add(telephone);
        formLayout2Col.add(email);
        formLayout2Col.add(personnelNumber);
        layoutColumn2.add(layoutRow);
        layoutRow.add(save);
        layoutRow.add(cancel);
    }

    private void setBinder() {
        binder.setBean(personal);
        binder.forField(firstName)
                .bind(Personal::firstName,
                        Personal::firstName);
        binder.forField(lastName)
                .bind(Personal::lastName,
                        Personal::lastName);
        binder.forField(birthdate)
                .bind(Personal::birthdate,
                        Personal::birthdate);
        binder.forField(personnelNumber)
                .bind(Personal::personnelNumber,
                        Personal::personnelNumber);
        binder.forField(telephone)
                .bind(p->p.getPersonalInfo("telephone"),
                        Personal::setTeleponeNumber);
        binder.forField(email)
                .bind(p->p.getPersonalInfo("email"),
                        Personal::setEmail);
    }
}
