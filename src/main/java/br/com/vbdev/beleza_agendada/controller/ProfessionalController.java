package br.com.vbdev.beleza_agendada.controller;

import br.com.vbdev.beleza_agendada.model.form.BreakTimeForm;
import br.com.vbdev.beleza_agendada.model.form.ScheduleForm;
import br.com.vbdev.beleza_agendada.service.ProfessionalService;
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
@RequestMapping("/api/v1/professional")
public class ProfessionalController {

    @Autowired
    private ProfessionalService service;

    @PostMapping("/create")
    @ResponseBody
    public void create(){

    }

    @PostMapping("/create/break_time")
    @ResponseBody
    public ResponseEntity create_breakTime(@RequestBody @Valid BreakTimeForm form) {
        return ok(service.create_breakTime(form));
    }
}
