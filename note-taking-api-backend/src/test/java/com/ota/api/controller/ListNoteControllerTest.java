package com.ota.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ota.api.model.Note;
import com.ota.api.service.NoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(ListNoteController.class)
public class ListNoteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NoteService listNoteService;

    @Test
    public void listAllUsers_whenGetMethod()
            throws Exception {

        Note note = new Note();
        note.setNoteTitle("Test Title");

        List<Note> allNotes = Arrays.asList(note);

        given(listNoteService
                .retrieveAllNotes())
                .willReturn(allNotes);

        mvc.perform(get("/notes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].noteTitle", is(note.getNoteTitle())))
                .andExpect(jsonPath("$[1].noteBody", is(note.getNoteBody())));
    }
}
