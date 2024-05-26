/**
 * UpdateNoteController.java
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.controller;

//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ota.api.model.Note;
import com.ota.api.service.NoteService;

@RestController
@RequestMapping("/notes/{id}")
public class UpdateNoteController {

    @Autowired
    NoteService noteService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Note> updateUser_whenPutUser(@PathVariable Long id, @RequestBody Note noteDetails) {
    	return ResponseEntity.ok().body(this.noteService.updateNoteById(noteDetails,id));
    }
    

}
