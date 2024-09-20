package hellosql.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hellosql.repositories.PersonRepository;
import hellosql.utils.Database;
import hellosql.models.Person;;

public class PersonRepositoryImpl implements PersonRepository {
  private final Connection connection;

  public PersonRepositoryImpl() {
    try {
      this.connection = Database.getConnection();
    } catch (SQLException exception) {
      throw new RuntimeException(exception);

    }

  }

  public List<Person> findAll() {
    List<Person> people = new ArrayList<>();
    String sql = "SELECT * FROM people";

    try (PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()) {

      while (resultSet.next()) {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));

        people.add(person);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return people;
  }
}