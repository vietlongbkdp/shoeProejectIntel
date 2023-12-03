package com.cg.shoeprojectmain.service.color;

import com.cg.shoeprojectmain.model.Color;
import com.cg.shoeprojectmain.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ColorService implements IColorService{
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> findById(Long id) {
        return colorRepository.findById(id);
    }

    @Override
    public void save(Color color) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
