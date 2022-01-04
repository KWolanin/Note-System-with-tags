package com.wolanin.watchos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAll();

    Note save(Note note);
}
