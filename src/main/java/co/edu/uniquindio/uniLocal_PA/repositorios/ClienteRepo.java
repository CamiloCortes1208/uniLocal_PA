package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {
    List<Cliente> findAllByEmail(String email);
    List<Cliente> findAllByNickname(String nickname);
}
