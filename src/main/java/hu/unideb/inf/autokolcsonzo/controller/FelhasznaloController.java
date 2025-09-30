package hu.unideb.inf.autokolcsonzo.controller;

import hu.unideb.inf.autokolcsonzo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.autokolcsonzo.data.repository.FelhasznaloRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("api/felhasznalo")
public class FelhasznaloController {

    @Autowired
    FelhasznaloRepository felhasznaloRepository;

    @GetMapping("/createmock")
    public String createMock(){
        felhasznaloRepository.save(
                new FelhasznaloEntity(
                        null,
                        "n1",
                        Date.from(Instant.now()),
                        "felh",
                        "pass",
                        "jogositvany"
                )
        );
    return "Sikeres mentés";
    }


}
