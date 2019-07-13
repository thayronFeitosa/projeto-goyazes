package model;
import java.util.List;

public interface IUser {
	void create(User user);
    void delete(User user);
    void update(User user);
    boolean isEmpty(User user);
    List<User> all();
    User login(String email, String senha);
    User findById(int id);
    List<User> findByName(String name);
    boolean verifyCpf(String cpf);
}


