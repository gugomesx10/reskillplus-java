package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.application.MatriculaServiceImpl;
import br.com.fiap.reskillplus.dto.input.MatriculaInputDTO;
import br.com.fiap.reskillplus.dto.output.MatriculaOutputDTO;
import br.com.fiap.reskillplus.mapper.MatriculaMapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MatriculaControllerImpl implements MatriculaController {

    private final MatriculaServiceImpl matriculaServiceImpl;

    public MatriculaControllerImpl(MatriculaServiceImpl matriculaServiceImpl) {
        this.matriculaServiceImpl = matriculaServiceImpl;
    }

    @Override
    public MatriculaOutputDTO cadastrar(MatriculaInputDTO dto) {
        return MatriculaMapper.toOutputDTO(matriculaServiceImpl.cadastrar(MatriculaMapper.toEntity(dto)));
    }

    @Override
    public List<MatriculaOutputDTO> listarTodas() {
        return MatriculaMapper.toOutputList(matriculaServiceImpl.listarTodas());
    }

    @Override
    public List<MatriculaOutputDTO> listarPorUsuario(int usuarioId) {
        return MatriculaMapper.toOutputList(matriculaServiceImpl.listarPorUsuario(usuarioId));
    }

    @Override
    public void deletar(int id) {
        matriculaServiceImpl.deletar(id);
    }
}
