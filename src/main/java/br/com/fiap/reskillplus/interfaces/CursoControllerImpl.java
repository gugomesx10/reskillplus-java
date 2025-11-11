package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.application.CursoServiceImpl;
import br.com.fiap.reskillplus.dto.input.CursoInputDTO;
import br.com.fiap.reskillplus.dto.output.CursoOutputDTO;
import br.com.fiap.reskillplus.mapper.CursoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CursoControllerImpl implements CursoController {

    private final CursoServiceImpl cursoServiceImpl;

    @Inject
    public CursoControllerImpl(CursoServiceImpl cursoServiceImpl) {
        this.cursoServiceImpl = cursoServiceImpl;
    }

    @Override
    public CursoOutputDTO cadastrar(CursoInputDTO dto) {
        return CursoMapper.toOutputDTO(cursoServiceImpl.cadastrar(CursoMapper.toEntity(dto)));
    }

    @Override
    public CursoOutputDTO buscarPorId(int id) {
        return CursoMapper.toOutputDTO(cursoServiceImpl.buscarPorId(id));
    }

    @Override
    public List<CursoOutputDTO> listarTodos() {
        return CursoMapper.toOutputList(cursoServiceImpl.listarTodos());
    }

    @Override
    public void deletar(int id) {
        cursoServiceImpl.deletar(id);
    }
}
