/**
 * CreateNoteController.java
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.controller;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ota.api.model.Note;
import com.ota.api.service.NoteService;

@RestController
@RequestMapping("/notes")
public class CreateNoteController {

	@Autowired
	private NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Note> createNewNote_whenPostUser(@RequestBody Note user) {

    	Note note = noteService.saveNote(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(note.getNoteTitle(), note.getNoteBody())
                .toUri();

        return ResponseEntity.created(uri).body(note);
    }
}