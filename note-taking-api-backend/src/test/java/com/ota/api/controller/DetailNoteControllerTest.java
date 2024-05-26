package com.ota.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ota.api.handler.NoteNotFoundHandlerException;
import com.ota.api.model.Note;
import com.ota.api.service.NoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(DetailNoteController.class)
public class DetailNoteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NoteService detailNoteService;

    @Test
    public void listNoteById_whenGetMethod() throws Exception {

        Note note = new Note();
        note.setNoteTitle("Test Title");
        note.setNoteBody("Test Body");
        note.setNoteId(1);

        given(detailNoteService.getNoteById(note.getNoteId())).willReturn(note);

        mvc.perform(get("/notes/" + note.getNoteId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("noteTitle", is(note.getNoteTitle())))
                .andExpect(jsonPath("noteBody", is(note.getNoteBody())));

    }

    @Test
    public void should_throw_exception_when_note_doesnt_exist() throws Exception {
    	   Note note = new Note();
           note.setNoteTitle("Test Title");
           note.setNoteBody("Test Body");
           note.setNoteId(1);

        Mockito.doThrow(new NoteNotFoundHandlerException("Note Id does not exist")).when(detailNoteService).getNoteById(2121);

        mvc.perform(get("/notes/" + note.getNoteId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}