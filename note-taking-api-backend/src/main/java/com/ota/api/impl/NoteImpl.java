/**
 * NoteImpl.java
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ota.api.handler.NoteNotFoundHandlerException;
import com.ota.api.model.Note;
import com.ota.api.repository.NoteRepository;
import com.ota.api.service.NoteService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NoteImpl implements NoteService{
	
	@Autowired
	private NoteRepository noteRepository;
	
	
	public Note saveNote(Note note) {
      return noteRepository.save(note);
    }

	public List<Note> retrieveAllNotes()  {
		Optional<List<Note>> noteDb = Optional.of(noteRepository.findAll());
		
		if(noteDb.isPresent() && !noteDb.get().isEmpty()) {
			return noteRepository.findAll();
		}else {
			throw new NoteNotFoundHandlerException("No Notes found");
		}
	}

	public Note getNoteById(long noteId) {

		Optional<Note> noteDb = this.noteRepository.findById(noteId);
		
		if (noteDb.isPresent()) {
			return noteDb.get();
		}else {
			throw new NoteNotFoundHandlerException("Note not exist with id :" + noteId);
		}
	}

	
	public Note updateNoteById(Note note, Long noteId)  {
		Optional<Note> noteDb = this.noteRepository.findById(noteId);
		
		if(noteDb.isPresent()) {
			Note noteUpdate = noteDb.get();
			noteUpdate.setNoteTitle(note.getNoteTitle());
			noteUpdate.setNoteBody(note.getNoteBody());
	    	noteRepository.save(noteUpdate);
			return noteUpdate;
		}else {
			throw new NoteNotFoundHandlerException("Note not exist with id :" + noteId);
		}		
	}

	public void deleteNoteById(long noteId) {
		Optional<Note> noteDb = this.noteRepository.findById(noteId);
		
		if(noteDb.isPresent()) {
			this.noteRepository.delete(noteDb.get());
		}else {
			throw new NoteNotFoundHandlerException("Note not exist with id :" + noteId);
		}
		
	}
}
