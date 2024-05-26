package com.ota.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.ota.api.util.JsonUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateNoteController.class)
public class CreateNoteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService service;

    @Test
    public void createNOte_whenPostMethod() throws Exception {

        Note note = new Note();
        note.setNoteTitle("Test Title");
        note.setNoteBody("Test Body");
        given(service.saveNote(note)).willReturn(note);

        mockMvc.perform(post("/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(note)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.noteTitle", is(note.getNoteTitle())))
                .andExpect(jsonPath("$.noteBody", is(note.getNoteBody())));

    }
}
