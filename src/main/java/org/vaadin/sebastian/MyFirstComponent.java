package org.vaadin.sebastian;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A Designer generated component for the my-first-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("my-first-component")
@JsModule("./src/my-first-component.js")
public class MyFirstComponent extends PolymerTemplate<MyFirstComponent.MyFirstComponentModel> {

    @Id("vaadinButton")
    private Button vaadinButton;
    @Id("vaadinTextField")
    private TextField vaadinTextField;
    @Id("label")
    private Span label;

    SerializableConsumer<MyFirstView.PersonDTO> personDTOConsumer = null;

    public void setPersonDTOConsumer(SerializableConsumer<MyFirstView.PersonDTO> personDTOConsumer) {
        this.personDTOConsumer = personDTOConsumer;
    }

    /**
     * Creates a new MyFirstComponent.
     */
    public MyFirstComponent() {

        vaadinButton.addClickListener(buttonClickEvent -> {
            //create dto for input data
            final MyFirstView.PersonDTO personDTO = new MyFirstView.PersonDTO(vaadinTextField.getValue(), LocalDateTime.now());

            //set input data to label
            label.setText(String.format("Hello %s, it is %s",
                        personDTO.getName(),
                        personDTO.getSubmitTime().toString()));

            //accept data if consumer exist
            if (personDTOConsumer != null) {
                personDTOConsumer.accept(personDTO);
            }
        });
    }

    /**
     * This model binds properties between MyFirstComponent and my-first-component
     */
    public interface MyFirstComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
