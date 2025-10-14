package hu.unideb.inf.autokolcsonzo.service.impl;

import hu.unideb.inf.autokolcsonzo.data.entity.AutoEntity;
import hu.unideb.inf.autokolcsonzo.data.repository.AutoRepository;
import hu.unideb.inf.autokolcsonzo.service.AutoService;
import hu.unideb.inf.autokolcsonzo.service.dto.AutoDto;
import hu.unideb.inf.autokolcsonzo.service.mapper.AutoMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    final   ModelMapper modelMapper;

    final   AutoRepository repo;

    final AutoMapper autoMapper;

    public AutoServiceImpl(ModelMapper modelMapper, AutoRepository repo, AutoMapper autoMapper) {
        this.modelMapper = modelMapper;
        this.repo = repo;
        this.autoMapper = autoMapper;
    }

    @Override
    public AutoDto getById(Long id) {
        return modelMapper.map(repo.getReferenceById(id),AutoDto.class);

        /*AutoEntity autoEntity = repo.getReferenceById(id);
        AutoDto autoDto = modelMapper.map(autoEntity, AutoDto.class);
        return autoDto;*/
    }

    @Override
    public AutoDto getByRendszam(String rsz) {
        AutoEntity e = repo.getByRendszam(rsz);
        AutoDto d = modelMapper.map(e,AutoDto.class);
        return d;

        /*AutoEntity e = null;
        for(AutoEntity e1: repo.findAll()){
            if(e1.getRendszam().equals(rsz)){
                e = e1;
            }
        }
        return modelMapper.map(e, AutoDto.class);*/
    }

    @Override
    public AutoDto removeById(Long id) {
        return null;
    }

    @Override
    public AutoDto updateByRendszam(AutoDto autoDto, String rsz) {
        AutoEntity e = repo.getByRendszam(rsz);
        
        e.setGyartmany(autoDto.getGyartmany());
        e.setModell(autoDto.getModell());
        e.setEvjarat(autoDto.getEvjarat());
        e.setUzemanyag(autoDto.getUzemanyag());
        e.setSzin(autoDto.getSzin());
        e.setKlima(autoDto.getKlima());
        e.setLeiras(autoDto.getLeiras());

        e = repo.save(e);

        return autoMapper.autoEntityToDto(e);

    }

    @Override
    public List<AutoDto> getAll() {
        List<AutoEntity> entities = repo.findAll();
        return autoMapper.autoEntityToDto(entities);

        //Type t = new TypeToken<List<AutoDto>>(){}.getType();
       // return modelMapper.map(entities,t);


    }

    @Override
    public AutoDto registerWithRendszam(AutoDto autoDto, String rendszam) {
        AutoEntity autoEntity = modelMapper.map(autoDto,AutoEntity.class);
        autoEntity.setRendszam(rendszam);
        return modelMapper.map(repo.save(autoEntity),AutoDto.class);
    }

    @Override
    public void deleteByGyartmany(String gyartmany) {
        repo.deleteByGyartmany(gyartmany);
    }
}
