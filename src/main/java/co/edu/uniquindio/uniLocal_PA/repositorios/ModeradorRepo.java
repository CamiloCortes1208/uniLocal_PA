package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.modelo.Moderador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeradorRepo extends MongoRepository<Moderador, String> {
}
