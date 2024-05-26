///**
// * NoteController.java
// * @author Gener Badenas
// * Date Created: May 25, 2024
// */
//package com.ota.api.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ota.api.handler.NoteHandlerException;
//import com.ota.api.model.Note;
//import com.ota.api.repository.NoteRepository;
//import com.ota.api.service.NoteService;
//
//@RestController
//@RequestMapping("/")
//public class NoteController {
//
//	
//	@Autowired
//	private NoteService noteService;
//
//	
//	//GET method end point: /notes: Retrieve all notes.
//	@GetMapping("/notes")
//	public ResponseEntity<List<Note>> getAllNotes(){
//		return ResponseEntity.ok().body(noteService.retrieveAllNotes());
//	}		
//	
//	//POST method end point /notes: Create a new note.
//	@PostMapping("/notes")
//    public ResponseEntity < Note > createNote(@RequestBody Note note)  {
//        return  ResponseEntity.ok().body(this.noteService.saveNote(note));
//    }
//	
//	
//	//GET method end point /notes/:id: Retrieve a specific note by ID
//	@GetMapping("/notes/{id}")
//	public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
//		return ResponseEntity.ok().body(noteService.getNoteById(id));
//	}
//	
//	
//	//PUT method end point /notes/:id: Update a specific note
//	@PutMapping("/notes/{id}")
//	public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
//		return ResponseEntity.ok().body(this.noteService.updateNoteById(noteDetails,id));
//	}
//	
//	//DELETE method end point /notes/:id: Delete a specific note
//	@DeleteMapping("/notes/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteNote(@PathVariable Long id) {
//		this.noteService.deleteNoteById(id);
//    	Map < String, Boolean > response = new HashMap < > ();
//        response.put("Deleted ", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}	
//}
