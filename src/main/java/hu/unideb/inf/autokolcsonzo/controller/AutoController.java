package hu.unideb.inf.autokolcsonzo.controller;

import hu.unideb.inf.autokolcsonzo.service.AutoService;
import hu.unideb.inf.autokolcsonzo.service.dto.AutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auto")
public class AutoController {

    final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }
    @GetMapping("/init")
    public void init() {
        autoService.registerWithRendszam(AutoDto.builder()
                .gyartmany("Suzuki")
                .modell("Vitara")
                .leiras("Nyugdíjas bevásárlókocsi")
                .build(),"XYZ-123");

        autoService.registerWithRendszam(AutoDto.builder()
                .gyartmany("Suzuki")
                .modell("Vitara")
                .leiras("Nyugdíjas bevásárlókocsi")
                .build(),"XYZ-567");

        autoService.registerWithRendszam(AutoDto.builder()
                .gyartmany("Suzuki")
                .modell("Vitara")
                .leiras("Nyugdíjas bevásárlókocsi")
                .build(),"XYZ-789");
    }

    @GetMapping("/byId")
    public AutoDto getAutoById(@RequestParam Long id){
        return autoService.getById(id);
    }

    @GetMapping("/byRendszam/{rsz}")
    public AutoDto getAutoByRendszam(@PathVariable String rsz){
        return autoService.getByRendszam(rsz);
    }
}
