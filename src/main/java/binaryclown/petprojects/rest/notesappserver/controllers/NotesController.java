package binaryclown.petprojects.rest.notesappserver.controllers;

import binaryclown.petprojects.rest.notesappserver.daos.impl.NoteDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotesController {

    private final NoteDaoImpl noteDao;

    @Autowired
    public NotesController(NoteDaoImpl noteDao) {
        this.noteDao = noteDao;
    }

    @GetMapping(value = "/notes")
    public String showNotesList(Model model) {
        model.addAttribute("notes", noteDao.getAll());
        return "notes";
    }
}
