package hu.unideb.inf.autokolcsonzo.service.impl;

import hu.unideb.inf.autokolcsonzo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.autokolcsonzo.data.entity.JogosultsagEntity;
import hu.unideb.inf.autokolcsonzo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.autokolcsonzo.data.repository.JogosultsagRepository;
import hu.unideb.inf.autokolcsonzo.service.AuthenticationService;
import hu.unideb.inf.autokolcsonzo.service.TokenService;
import hu.unideb.inf.autokolcsonzo.service.dto.BejelentkezesDto;
import hu.unideb.inf.autokolcsonzo.service.dto.RegisztracioDto;
import hu.unideb.inf.autokolcsonzo.service.mapper.FelhasznaloMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final FelhasznaloRepository repo;
    private final JogosultsagRepository jogrepo;
    private final FelhasznaloMapper mapper;
    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    @Override
    public void regisztracio(RegisztracioDto regisztracioDto) {
        FelhasznaloEntity e = mapper.regFelh(regisztracioDto);
        e.setJelszo(passwordEncoder.encode(e.getJelszo()));

        JogosultsagEntity jog = jogrepo.findByNev("FELHASZNALO");
        if(jog != null){
            e.setJogosultsag(jog);
        } else {
            jog = new JogosultsagEntity();
            jog.setNev("FELHASZNALO");
            jog = jogrepo.save(jog);

            e.setJogosultsag(jog);
        }

        repo.save(e);

    }

    @Override
    public String bejelentkezes(BejelentkezesDto bejelentkezesDto) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        bejelentkezesDto.getFelhasznalonev(),
                        bejelentkezesDto.getJelszo()
                )
        );
        context.setAuthentication(auth);
        SecurityContextHolder.setContext(context);

        FelhasznaloEntity f =
                repo.findByFelhasznaloNev(bejelentkezesDto.getFelhasznalonev());
        return tokenService.generateToken(f);

    }
}
