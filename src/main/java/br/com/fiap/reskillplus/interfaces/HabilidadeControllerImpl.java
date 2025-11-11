package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.application.HabilidadeServiceImpl;
import br.com.fiap.reskillplus.dto.input.HabilidadeInputDTO;
import br.com.fiap.reskillplus.dto.output.HabilidadeOutputDTO;
import br.com.fiap.reskillplus.mapper.HabilidadeMapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class HabilidadeControllerImpl implements HabilidadeController {

    private final HabilidadeServiceImpl habilidadeServiceImpl;

    public HabilidadeControllerImpl(HabilidadeServiceImpl habilidadeServiceImpl) {
        this.habilidadeServiceImpl = habilidadeServiceImpl;
    }

    @Override
    public HabilidadeOutputDTO cadastrar(HabilidadeInputDTO dto) {
        return HabilidadeMapper.toOutputDTO(habilidadeServiceImpl.cadastrar(HabilidadeMapper.toEntity(dto)));
    }

    @Override
    public HabilidadeOutputDTO buscarPorId(int id) {
        return HabilidadeMapper.toOutputDTO(habilidadeServiceImpl.buscarPorId(id));
    }

    @Override
    public List<HabilidadeOutputDTO> listarTodas() {
        return HabilidadeMapper.toOutputList(habilidadeServiceImpl.listarTodas());
    }

    @Override
    public void deletar(int id) {
        habilidadeServiceImpl.deletar(id);
    }
}
