package br.com.vbdev.beleza_agendada.controller;

import br.com.vbdev.beleza_agendada.model.MonthModel;
import br.com.vbdev.beleza_agendada.model.WeekdayModel;
import br.com.vbdev.beleza_agendada.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @PostMapping("/add/weekday")
    public List<WeekdayModel> addWeekday() {
        return settingsService.addWeekday();
    }

    @PostMapping("/add/month")
    public List<MonthModel> addMonths() {
        return settingsService.addMonths();
    }
}