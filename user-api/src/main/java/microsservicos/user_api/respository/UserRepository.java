package microsservicos.user_api.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import microsservicos.user_api.models.User;
import java.util.List;


@Repository
public interface UserRepository extends MongoRepository<User, String>{

    User findByCpf(String cpf);
    List<User> queryByNomeLike(String nome);

}
