/**
 * ListNoteController.java
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.controller;

import java.util.List;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ota.api.model.Note;
import com.ota.api.service.NoteService;

@RestController
@RequestMapping("/notes")
public class ListNoteController {
	
    @Autowired
    NoteService noteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Note>> listAllUsers_whenGetUsers() {
        return ResponseEntity.ok().body(noteService.retrieveAllNotes());
    }
}