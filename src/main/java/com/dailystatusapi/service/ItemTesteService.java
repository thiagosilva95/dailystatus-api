package com.dailystatusapi.service;

import com.dailystatusapi.model.ItemTeste;
import com.dailystatusapi.model.MovItemTeste;
import com.dailystatusapi.repository.ItemTesteRepository;
import com.dailystatusapi.repository.MovItemTesteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemTesteService {

    @Autowired
    private ItemTesteRepository itemRepository;

    @Autowired
    private MovItemTesteRepository movItemRepository;

    @Autowired
    private MovItemTesteService movItemService;

    public ItemTeste salvar(ItemTeste itemTeste) {
        ItemTeste itemAntigo = null;
        MovItemTeste movItemAntigo = null;

        if (itemTeste.getCodigo() != null) {
            itemAntigo = this.getItemTeste(itemTeste.getCodigo());

            movItemAntigo = movItemRepository.getUltimaMovimentacaoItem(itemTeste.getCodigo());
        }
        ItemTeste itemSalvo = itemRepository.save(itemTeste);

        if(itemAntigo != null) {
            if (!itemSalvo.getTpStatus().equals(itemAntigo.getTpStatus())) {
                movItemAntigo.setDtFimMov(LocalDateTime.now());
                //movItemAntigo.setUsuarioFimMov();

                movItemService.salvar(movItemAntigo);
            }

            MovItemTeste movItem = new MovItemTeste();

            movItem.setItemTeste(itemTeste);
            movItem.setDtInicioMov(LocalDateTime.now());
            movItem.setTpStatusItem(itemSalvo.getTpStatus());
            //movItem.setUsuarioInicioMov();

            movItemService.salvar(movItem);
        }

        return itemSalvo;
    }

    public List<ItemTeste> listar() {
        return itemRepository.findAll();
    }

    public List<ItemTeste> listarPorBuild(Long codigoBuild) {
        return itemRepository.listarPorBuild(codigoBuild);
    }

    public List<ItemTeste> listarPorProduto(Long codigoProduto) {
        return itemRepository.listarPorProduto(codigoProduto);
    }

    public ItemTeste getItemTeste(Long codigo) {
        return itemRepository.findOne(codigo);
    }

    public ItemTeste atualizar(Long codigo, ItemTeste itemTeste) {
        ItemTeste pessoaSalva = getItemTeste(codigo);

        if (!pessoaSalva.getTpStatus().equals(itemTeste.getTpStatus())) {
            MovItemTeste movItemAntigo = movItemRepository.getUltimaMovimentacaoItem(itemTeste.getCodigo());

            movItemAntigo.setDtFimMov(LocalDateTime.now());
            //movItemAntigo.setUsuarioFimMov();

            movItemService.salvar(movItemAntigo);

            MovItemTeste movItem = new MovItemTeste();

            movItem.setItemTeste(itemTeste);
            movItem.setDtInicioMov(LocalDateTime.now());
            movItem.setTpStatusItem(itemTeste.getTpStatus());
            //movItem.setUsuarioInicioMov();

            movItemService.salvar(movItem);
        }


        BeanUtils.copyProperties(itemTeste, pessoaSalva, "codigo");
        return itemRepository.save(pessoaSalva);
    }
}
