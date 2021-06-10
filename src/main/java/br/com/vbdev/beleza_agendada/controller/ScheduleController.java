package br.com.vbdev.beleza_agendada.controller;

import br.com.vbdev.beleza_agendada.model.form.ScheduleForm;
import br.com.vbdev.beleza_agendada.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity create_schedule(@RequestBody @Valid ScheduleForm form){
        return ok(service.create_schedule(form));
    }
}
