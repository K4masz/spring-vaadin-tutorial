package eu.tpawlik.SpringVaadinTutorial;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
public class MyUI extends UI {

    @Autowired
    private Greeter greeter;

    @Override
    protected void init(VaadinRequest request) {
        setContent(new Label(greeter.sayHello()));
    }
}