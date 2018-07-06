package eu.tpawlik.SpringVaadinTutorial.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import eu.tpawlik.SpringVaadinTutorial.model.Greeter;
import eu.tpawlik.SpringVaadinTutorial.model.ViewGreeter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "view";

    //Ten ma zasięg @ViewScope - jego nowa instancja powstanie dla każdego stworzonego View
    @Autowired
    private ViewGreeter viewGreeter;

    //Ten ma zasięg @UIScope - ta sama instancja będzie wykorzystywana przez wszystkie View w ramach tego UI
    @Autowired
    private Greeter uiGreeter;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    @PostConstruct
    void init() {
        addComponent(new Label("This is a view scoped View"));
        addComponent(new Label(uiGreeter.sayHello()));
        addComponent(new Label(viewGreeter.sayHello()));
    }
}
