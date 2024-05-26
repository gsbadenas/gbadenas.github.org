package com.ota.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ota.api.model.Note;
import com.ota.api.repository.NoteRepository;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    @Test
    public void whenSaveNote_shouldReturnNote() {
        Note note = new Note();
        note.setNoteId(1);
        note.setNoteTitle("Test Title");
        note.setNoteBody("Test Body");
        when(noteRepository.save(ArgumentMatchers.any(Note.class))).thenReturn(note);

        Note created = noteService.saveNote(note);

        assertThat(created.getNoteTitle()).isSameAs(note.getNoteTitle());
        assertThat(created.getNoteBody()).isSameAs(note.getNoteBody());
        verify(noteRepository).save(note);
    }
    
    
    @Test
    public void whenGivenId_shouldReturnNote_ifFound() {
        Note note = new Note();
        note.setNoteId(1);

        when(noteRepository.findById(note.getNoteId())).thenReturn(Optional.of(note));

        Note expected = noteService.getNoteById(note.getNoteId());

        assertThat(expected).isSameAs(note);
        verify(noteRepository).findById(note.getNoteId());
    }

    
    @Test
    public void shouldReturnAllNotes() {
        List<Note> notes = new ArrayList();
        notes.add(new Note());

        //given(noteRepository.findAll()).willReturn(notes);

        List<Note> expected = noteService.retrieveAllNotes();

        assertEquals(expected, notes);
        verify(noteRepository).findAll();
    }
    
    
    @Test
    public void whenGivenId_shouldUpdateNote_ifFound() {
    	  Note note = new Note();
          note.setNoteId(1);
          note.setNoteTitle("Test Title");
          note.setNoteBody("Test Body");

        Note newNote = new Note();
        newNote.setNoteTitle("New Test Title");
        note.setNoteBody("Test New Body");

        //given(noteRepository.findById(note.getNoteId())).willReturn(Optional.of(note));
        noteService.updateNoteById(newNote, note.getNoteId());

        verify(noteRepository).save(newNote);
        verify(noteRepository).findById(note.getNoteId());
    }


    @Test
    public void whenGivenId_shouldDeleteNote_ifFound(){
    	Note note = new Note();
        note.setNoteId(1);
        note.setNoteTitle("Test Name");
        note.setNoteBody("Test Body");

        when(noteRepository.findById(note.getNoteId())).thenReturn(Optional.of(note));

        noteService.deleteNoteById(note.getNoteId());
        verify(noteRepository).deleteById(note.getNoteId());
    }
    
}