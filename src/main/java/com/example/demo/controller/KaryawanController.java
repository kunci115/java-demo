package com.example.demo.controller;

import com.example.demo.dto.ErrorMessageDTO;
import com.example.demo.dto.KaryawanDTO;
import com.example.demo.model.entity.Karyawan;
import com.example.demo.model.repository.KaryawanRepo;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/karyawan")
public class KaryawanController {

    @Autowired
    private KaryawanRepo repo;

    @GetMapping("/input")
    public String input(Model model)
    {
        model.addAttribute("karyawanForm", new KaryawanDTO());
        return "input";
    }

    @PostMapping("/save")
    public String save(@Valid KaryawanDTO karyawanForm, BindingResult resultErrors, Model model){

        if(!resultErrors.hasErrors()){

            Karyawan karyawan = new Karyawan();
            karyawan.setNIP(karyawanForm.getNIP());
            karyawan.setFirstName(karyawanForm.getFirstName());
            karyawan.setLastName(karyawanForm.getLastName());
            karyawan.setAddress(karyawanForm.getAddress());
            karyawan.setPhoneNumber(karyawanForm.getPhoneNumber());
            karyawan.setEmailAddress(karyawanForm.getEmailAddress());
            Karyawan response = repo.save(karyawan);
            model.addAttribute("newKaryawan", response);

            return "redirect:/";
        } else {
            ErrorMessageDTO messages = new ErrorMessageDTO();
            for (ObjectError err: resultErrors.getAllErrors()){
                messages.getMessages().add(err.getDefaultMessage());

            }
            model.addAttribute("karyawanForm", karyawanForm);
            model.addAttribute("ERROR", messages);
            return "input";
        }

    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
        repo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        Karyawan karyawan = repo.findById(id).get();
        model.addAttribute("karyawanForm", karyawan);
        return "edit";
    }

    @PostMapping("/update")
    public String update(){
        return "redirect:/";
    }
}
