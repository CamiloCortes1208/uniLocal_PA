package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevisionRepo extends MongoRepository<Revision, String> {
    List<Revision> findAllByCodigoModerador(String codigoModerador);

    List<Revision> findAllByCodigoNegocio(String codigoNegocio);
}
