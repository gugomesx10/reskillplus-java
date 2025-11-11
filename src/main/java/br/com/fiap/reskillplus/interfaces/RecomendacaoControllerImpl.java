package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.application.RecomendacaoServiceImpl;
import br.com.fiap.reskillplus.dto.input.RecomendacaoInputDTO;
import br.com.fiap.reskillplus.dto.output.RecomendacaoOutputDTO;
import br.com.fiap.reskillplus.mapper.RecomendacaoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RecomendacaoControllerImpl implements RecomendacaoController {

    private final RecomendacaoServiceImpl recomendacaoServiceImpl;

    public RecomendacaoControllerImpl(RecomendacaoServiceImpl recomendacaoServiceImpl) {
        this.recomendacaoServiceImpl = recomendacaoServiceImpl;
    }

    @Override
    public RecomendacaoOutputDTO gerar(RecomendacaoInputDTO dto) {
        return RecomendacaoMapper.toOutputDTO(recomendacaoServiceImpl.gerar(RecomendacaoMapper.toEntity(dto)));
    }

    @Override
    public List<RecomendacaoOutputDTO> listarTodas() {
        return RecomendacaoMapper.toOutputList(recomendacaoServiceImpl.listarTodas());
    }

    @Override
    public List<RecomendacaoOutputDTO> listarPorUsuario(int usuarioId) {
        return RecomendacaoMapper.toOutputList(recomendacaoServiceImpl.listarPorUsuario(usuarioId));
    }

    @Override
    public void deletar(int id) {
        recomendacaoServiceImpl.deletar(id);
    }
}
