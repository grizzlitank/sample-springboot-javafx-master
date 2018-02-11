package ru.ilyas.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.ilyas.ControllersConfiguration;
import ru.ilyas.entity.Contact;
import ru.ilyas.service.ContactService;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.List;


@SuppressWarnings("SpringJavaAutowiringInspection")
public class MainController {


    @Autowired private ContactService contactService;


    @FXML private TableView<Contact> table;


    @Qualifier("editView")
    @Autowired
    private ControllersConfiguration.ViewHolder view;



    private Stage editDialogStage;

    private Stage mainStage;



    // Variables
    static ObservableList<Contact> data;


    @FXML
    public void initialize() {
        // Этап инициализации JavaFX
    }

    /**
     * На этом этапе уже произведены все возможные инъекции.
     */
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        List<Contact> contacts = contactService.findAll();
        data = FXCollections.observableArrayList(contacts);



        TableColumn<Contact, String> nameColumn = new TableColumn<>("Заметка");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Contact, String> dateColumn = new TableColumn<>("Дата создания");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));



        table.getColumns().setAll(nameColumn, dateColumn);

        // Данные таблицы
        table.setItems(data);
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Добавить".
     * Привязан к кнопке в FXML файле представления.
     */
    @FXML
    public void addContact() throws IOException {


        if (editDialogStage == null){
            editDialogStage = new Stage();
            editDialogStage.setTitle("Добавление");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(view.getView()));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }
        EditController.setDate();
        editDialogStage.showAndWait();

    }




}
