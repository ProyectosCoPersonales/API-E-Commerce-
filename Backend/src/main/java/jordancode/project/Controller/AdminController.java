package jordancode.project.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jordancode.project.User.User;
import jordancode.project.Model.Product;
import jordancode.project.Service.AdminService;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * Asigna el rol de administrador a un usuario existente.
     *
     * @param userId ID del usuario a promover.
     * @return ResponseEntity con el usuario actualizado.
     */
    @PostMapping("/promote/{userId}")
    public ResponseEntity<User> promoteUserToAdmin(@PathVariable Long userId) {
        try {
            User updatedUser = adminService.promoteToAdmin(userId);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo producto.
     *
     * @param product El producto a crear.
     * @return El producto creado.
     */
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = adminService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param productId ID del producto a eliminar.
     */
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        try {
            adminService.deleteProduct(productId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param userId ID del usuario a eliminar.
     */
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        try {
            adminService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de todos los usuarios.
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = adminService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
