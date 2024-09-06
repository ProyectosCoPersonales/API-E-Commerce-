package jordancode.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jordancode.project.Model.Category;
import jordancode.project.Model.Product;
import jordancode.project.Repository.ProductRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Obtiene todos los productos.
     *
     * @return Lista de todos los productos.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Busca un producto por su nombre.
     *
     * @param name Nombre del producto a buscar.
     * @return El producto encontrado, o null si no se encuentra.
     */
    public Product findProductByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }

    /**
     * Busca productos por categoría.
     *
     * @param category Categoría de los productos a buscar.
     * @return Lista de productos en la categoría especificada.
     */
    public List<Product> findProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
}

