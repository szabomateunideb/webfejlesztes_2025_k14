package hu.unideb.inf.autokolcsonzo.controller;

import hu.unideb.inf.autokolcsonzo.service.AuthenticationService;
import hu.unideb.inf.autokolcsonzo.service.UserService;
import hu.unideb.inf.autokolcsonzo.service.dto.BejelentkezesDto;
import hu.unideb.inf.autokolcsonzo.service.dto.RegisztracioDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/regisztracio")
    public void regisztracio(@RequestBody RegisztracioDto regisztracioDto) {
        authService.regisztracio(regisztracioDto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto bejelentkezesDto) {
        return authService.bejelentkezes(bejelentkezesDto);
    }
}
