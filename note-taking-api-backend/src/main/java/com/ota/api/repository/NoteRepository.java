/**
 * NoteRepository.java
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ota.api.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
}
