/**
 * DeleteNoteController.java
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.controller;

import java.util.HashMap;
import java.util.Map;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ota.api.service.NoteService;

@RestController
@RequestMapping("/notes/{id}")
public class DeleteNoteController {

    @Autowired
    NoteService noteService;

    @DeleteMapping
	public ResponseEntity<Map<String, Boolean>> deleteNote(@PathVariable Long id) {
		this.noteService.deleteNoteById(id);
    	Map < String, Boolean > response = new HashMap < > ();
        response.put("Deleted ", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	
}