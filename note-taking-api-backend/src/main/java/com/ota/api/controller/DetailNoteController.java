/**
 * DetailNoteController.java
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.controller;

import com.ota.api.model.Note;
import com.ota.api.service.NoteService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notes/{id}")
public class DetailNoteController {

    @Autowired
    NoteService noteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Note> list(@PathVariable Long id) {
        return ResponseEntity.ok().body(noteService.getNoteById(id));
    }
}

