package com.ota.api.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

@RunWith(SpringRunner.class)
@WebMvcTest(DeleteNoteController.class)
public class DeleteNoteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NoteService deleteNoteService;

    @Test
    public void removeNoteById_whenDeleteMethod() throws Exception {
    	Note note = new Note();
   	    note.setNoteId(1);
        note.setNoteTitle("Test Note");
        note.setNoteBody("Test Body");

        doNothing().when(deleteNoteService).deleteNoteById(1);

        mvc.perform(delete("/notes/" + note.getNoteId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
