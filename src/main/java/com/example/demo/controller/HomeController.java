package com.example.demo.controller;
import com.example.demo.model.entity.Karyawan;
import com.example.demo.model.repository.KaryawanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
   // private MockKaryawanRepo repo = new MockKaryawanRepo();

    @Autowired
    private KaryawanRepo repo;

    @GetMapping
    public String index(Model model)
    {
        Iterable<Karyawan> listKaryawan = repo.findAll();
        model.addAttribute("listofKaryawan", listKaryawan);
        return "index";
    }
}
