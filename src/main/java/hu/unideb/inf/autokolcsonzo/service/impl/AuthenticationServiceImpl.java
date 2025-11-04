package hu.unideb.inf.autokolcsonzo.service.impl;

import hu.unideb.inf.autokolcsonzo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.autokolcsonzo.data.entity.JogosultsagEntity;
import hu.unideb.inf.autokolcsonzo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.autokolcsonzo.data.repository.JogosultsagRepository;
import hu.unideb.inf.autokolcsonzo.service.AuthenticationService;
import hu.unideb.inf.autokolcsonzo.service.dto.BejelentkezesDto;
import hu.unideb.inf.autokolcsonzo.service.dto.RegisztracioDto;
import hu.unideb.inf.autokolcsonzo.service.mapper.FelhasznaloMapper;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final FelhasznaloRepository repo;
    private final JogosultsagRepository jogrepo;
    private final FelhasznaloMapper mapper;
    private final AuthenticationManager authManager;

    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder, FelhasznaloRepository repo, JogosultsagRepository jogrepo, FelhasznaloMapper mapper, AuthenticationManager authManager) {
        this.passwordEncoder = passwordEncoder;
        this.repo = repo;
        this.jogrepo = jogrepo;
        this.mapper = mapper;
        this.authManager = authManager;
    }

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
    public void bejelentkezes(BejelentkezesDto bejelentkezesDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        bejelentkezesDto.getFelasznalonev(),
                        bejelentkezesDto.getJelszo()
                )
        );

    }
}
