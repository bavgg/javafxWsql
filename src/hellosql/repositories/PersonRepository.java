package hellosql.repositories;

import java.util.List;

import hellosql.models.Person;

public interface PersonRepository {
  List<Person> findAll();
}
