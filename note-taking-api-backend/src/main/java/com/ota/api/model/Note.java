package com.ota.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long noteId;	

	@Column(name = "note_title")
	private String noteTitle;

	@Column(name = "note_body")
	private String noteBody;
	
	
	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteBody() {
		return noteBody;
	}

	public void setNoteBody(String noteBody) {
		this.noteBody = noteBody;
	}

	
	public Note() {
		
	}
	
	public Note(String noteTitle, String noteBody) {
		super();
		this.noteTitle = noteTitle;
		this.noteBody = noteBody;
	}
	
}
