package pl.awsome.workshops.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.awsome.workshops.service.model.Note;

@Repository
public interface NotePostgresRepository extends CrudRepository <Note, String>{

}
