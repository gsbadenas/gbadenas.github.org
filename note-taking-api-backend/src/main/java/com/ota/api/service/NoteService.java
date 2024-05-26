/**
 * NoteService interface
 * @author Gener Badenas
 * Date Created: May 25, 2024
 */
package com.ota.api.service;

import java.util.List;

import com.ota.api.handler.NoteNotFoundHandlerException;
import com.ota.api.model.Note;

public interface NoteService {
	public Note saveNote(Note note);
	public List<Note> retrieveAllNotes();
	public Note getNoteById(long noteId);
	public Note updateNoteById(Note note, Long noteId);
	public void deleteNoteById(long noteId);
}
