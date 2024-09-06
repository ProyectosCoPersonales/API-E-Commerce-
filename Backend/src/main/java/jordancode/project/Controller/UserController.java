package jordancode.project.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jordancode.project.Model.Category;
import jordancode.project.Model.Product;
import jordancode.project.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Obtiene todos los productos.
     *
     * @return Lista de todos los productos.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = userService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Busca un producto por su nombre.
     *
     * @param name Nombre del producto a buscar.
     * @return El producto encontrado o un código de estado 404 si no se encuentra.
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable String name) {
        Product product = userService.findProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Busca productos por categoría.
     *
     * @param category Categoría de los productos a buscar.
     * @return Lista de productos en la categoría especificada.
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> findProductsByCategory(@PathVariable Category category) {
        List<Product> products = userService.findProductsByCategory(category);
        return ResponseEntity.ok(products);
    }
}

