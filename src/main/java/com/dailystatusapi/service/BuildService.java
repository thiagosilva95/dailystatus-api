package com.dailystatusapi.service;

import com.dailystatusapi.model.Build;
import com.dailystatusapi.repository.BuildRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildService {

    @Autowired
    private BuildRepository buildRepository;

    public Build salvar(Build build) {
        return buildRepository.save(build);
    }

    public List<Build> listar() {
        return buildRepository.findAll();
    }

    public List<Build> listarPorProduto(Long codigo) {
        return buildRepository.listarPorProduto(codigo);
    }

    public Build getBuild(Long codigo) {
        return buildRepository.findOne(codigo);
    }

    public Build atualizar(Long codigo, Build build) {
        Build buildSalva = getBuild(codigo);

        BeanUtils.copyProperties(build, buildSalva, "codigo");
        return buildRepository.save(buildSalva);
    }
}
