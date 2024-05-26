package com.ota.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ota.api.model.Note;
import com.ota.api.service.NoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(UpdateNoteController.class)
public class UpdateNoteControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private NoteService updateNoteService;

    @Test
    public void updateNote_whenPutNote() throws Exception {
    	 Note note = new Note();
    	 note.setNoteId(1);
         note.setNoteTitle("Test Name");
         note.setNoteBody("Test Body");
         given(updateNoteService.updateNoteById(note,note.getNoteId())).willReturn(note);

        ObjectMapper mapper = new ObjectMapper();

        mvc.perform(put("/notes/" + note.getNoteId())
                .content(mapper.writeValueAsString(note))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("noteTitle", is(note.getNoteTitle())))
                .andExpect(jsonPath("noteBody", is(note.getNoteBody())));
    }

}
