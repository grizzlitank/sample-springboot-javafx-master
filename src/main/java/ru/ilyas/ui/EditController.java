package ru.ilyas.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import ru.ilyas.entity.Contact;
import ru.ilyas.service.ContactService;

import javax.annotation.PostConstruct;
import java.util.Date;

public class EditController {

    @Autowired
    private ContactService contactService;;





    @FXML private TextField txtName;

    @FXML
    protected static Label txtDate;








    @FXML
    public void add(ActionEvent actionEvent){

        String name = txtName.getText();
        String date = txtDate.getText();


        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(date)) {
            return;
        }

        Contact contact = new Contact(name, date);
        contactService.save(contact);
        MainController.data.add(contact);
        txtName.setText("");
        // чистим поля

        actionClose(actionEvent);





    }



    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public static void setDate(){
        if (txtDate != null) {
            txtDate.setText(new Date().toString());
        } else {
            txtDate = new Label(new Date().toString());
        }

    }

    public Label getDate(){
        return txtDate;
    }


}
