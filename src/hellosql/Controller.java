package hellosql;

import java.sql.ResultSet;

import java.util.List;


import hellosql.models.Person;
import hellosql.repositories.PersonRepository;
import hellosql.repositories.PersonRepositoryImpl;

import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TableView<Person> peopleTable;
    @FXML
    private TableColumn<Person, Integer> idColumn;
    @FXML
    private TableColumn<Person, String> nameColumn;

    public void initialize() {
        this.idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        
        this.peopleTable.setItems(this.getPeople());
    }

    private ObservableList<Person> getPeople() {
        PersonRepository personRepository = new PersonRepositoryImpl();
        List<Person> personList = personRepository.findAll();
        return FXCollections.observableArrayList(personList);
    }
}