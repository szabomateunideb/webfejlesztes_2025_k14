package hu.unideb.inf.autokolcsonzo.controller;

import hu.unideb.inf.autokolcsonzo.service.AutoService;
import hu.unideb.inf.autokolcsonzo.service.dto.AutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auto")
public class AutoController {

    final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }
    @GetMapping("/init")
    @PreAuthorize("hasAnyAuthority('Felhasznalo','ADMIN')")
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

    @PostMapping("/register/{rendszam}")
    @PreAuthorize("hasAnyAuthority('Felhasznalo')")
    public AutoDto registerWithRendszam(@RequestBody AutoDto car, @PathVariable String rendszam){
        return autoService.registerWithRendszam(car,rendszam);
    }

    @GetMapping("/byId")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public AutoDto getAutoById(@RequestParam Long id){
        return autoService.getById(id);
    }

    @GetMapping("/byRendszam/{rsz}")
    public AutoDto getAutoByRendszam(@PathVariable String rsz){
        return autoService.getByRendszam(rsz);
    }

    @DeleteMapping("/{gyartmany}")
    public void removeByGyartmany(String gyartmany){
        autoService.deleteByGyartmany(gyartmany);
    }

    @GetMapping("/findAll")
    public List<AutoDto> findAll(){
        return autoService.getAll();
    }

    @PostMapping("/update/{rsz}")
    public AutoDto update(@RequestBody AutoDto a, @PathVariable String rsz){
        return autoService.updateByRendszam(a,rsz);
    }
}
