package com.wolanin.watchos.repo;

import com.wolanin.watchos.data.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

   Optional<Tag> findById(Long id);

   Optional<Tag> findByTagName(String name);

}
