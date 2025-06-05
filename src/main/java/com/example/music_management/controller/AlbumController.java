package com.example.music_management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.music_management.entity.Album;
import com.example.music_management.form.AlbumForm;
import com.example.music_management.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public String albums(Model model) {

        List<Album> albums = albumService.getAllAlbums();

        model.addAttribute("albums", albums);
        return "album/album-list";
    }
    
    @GetMapping("/new")
    public String albumForm(Model model) {
        AlbumForm albumForm = new AlbumForm();
        model.addAttribute("albumForm", albumForm);
        return "album/album-form";
    }

    @PostMapping("/new")
    public String createAlbum(AlbumForm albumForm, Model model) {
        albumService.createAlbum(albumForm);

        // List<Album> albums = albumService.getAllAlbums();
        // model.addAttribute("albums", albums);
        // return "album/album-list";

        return "redirect:/albums";
    }
    
}
