package jordancode.project.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jordancode.project.Model.Product;
import jordancode.project.User.Role;
import jordancode.project.User.User;
import jordancode.project.Repository.ProductRepository;
import jordancode.project.Repository.UserRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Crea un nuevo producto.
     *
     * @param product El producto a crear.
     * @return El producto creado.
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param productId ID del producto a eliminar.
     */
    public void deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw new IllegalArgumentException("Product does not exist");
        }
    }

    /**
     * Asigna el rol de administrador a un usuario existente.
     *
     * @param userId ID del usuario al que se le asignará el rol de administrador.
     * @return El usuario actualizado.
     */
    public User promoteToAdmin(Long userId) {
        // Buscar el usuario por ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        // Establecer el rol de administrador
        user.setRole(Role.ADMIN);  // Asegúrate de que el enum Role tenga ADMIN

        // Guardar los cambios en la base de datos
        return userRepository.save(user);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param userId ID del usuario a eliminar.
     */
    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new IllegalArgumentException("User does not exist");
        }
    }
    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de todos los usuarios.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

