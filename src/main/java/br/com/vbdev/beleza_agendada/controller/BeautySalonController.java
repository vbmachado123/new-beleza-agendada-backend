package br.com.vbdev.beleza_agendada.controller;

import br.com.vbdev.beleza_agendada.model.form.BeautySalonForm;
import br.com.vbdev.beleza_agendada.service.BeautySalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/api/v1/beauty_salon")
public class BeautySalonController {

    @Autowired
    private BeautySalonService service;

    @PostMapping("/create")
    public String createBeautySalon(@RequestBody BeautySalonForm salonForm) {
        Long idCreated = service.createBeautySalon(salonForm);
        return idCreated.toString();
    }

    @GetMapping("/{id}")
    public BeautySalonForm findById(@RequestParam @Valid Long id) {
        return service.findById(id);
    }

    @Description("Responsável por criar o horário de funcionamento do salão")
    @PostMapping("/create/openingHoursBeautySalon")
    public void createOpeningHoursBeautySalon() {

    }

    @DeleteMapping("/{id}")
    public void deleteBeautySalon(@RequestParam Long id) {

    }
}
