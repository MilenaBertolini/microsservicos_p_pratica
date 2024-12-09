package microsservicos.user_api.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import microsservicos.user_api.models.User;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class UserDTO {

    private String id;
    @NotBlank(message= "Nome é obrigatório")
    private String nome;
    @NotBlank(message= "CPF é obrigatório")
    private String cpf;
    private String endereco;
    @NotBlank(message= "E-mail é obrigatório")
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    public static UserDTO convert(User user){
        
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;

    }
}
