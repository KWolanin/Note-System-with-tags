package com.wolanin.watchos.repo;

import com.wolanin.watchos.data.Note;
import com.wolanin.watchos.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAll();

    List<Note> findAllByUser(User user);

    Optional<Note> findById(Long id);
}
