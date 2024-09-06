package jordancode.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jordancode.project.Model.Cart;
import jordancode.project.Model.Item;
import jordancode.project.Model.Status;
import jordancode.project.Model.Product;
import jordancode.project.Repository.CartRepository;
import jordancode.project.Repository.ItemRepository;
import jordancode.project.Repository.ProductRepository;

@Service
public class Buy {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartRepository cartRepository;

    /**
     * Verifica si el producto existe en la base de datos.
     *
     * @param productId ID del producto a verificar.
     * @return true si el producto existe, false en caso contrario.
     */
    public boolean doesProductExist(Long productId) {
        return productRepository.existsById(productId);
    }

    /**
     * Añade un ítem al carrito. Si el carrito no existe, se crea uno nuevo.
     *
     * @param productId ID del producto a añadir.
     * @param quantity  Cantidad del producto.
     * @param user_id   ID del usuario.
     * @return El carrito actualizado.
     */
    public Cart addItemToCart(Long productId, int quantity, Long user_id) {
        if (!doesProductExist(productId)) {
            throw new IllegalArgumentException("Product does not exist");
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Cart cart = cartRepository.findByUserId(user_id).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUserId(user_id);
            newCart.setStatus(Status.STATUS1);
            newCart.setTotal(0.0); 
            return cartRepository.save(newCart);
        });
        Item item = new Item();
        item.setProductId(productId);
        item.setQuantity(quantity);
        item.setPrice(product.getPrice());
        itemRepository.save(item);

        updateCartTotal(cart, item, true);

        return cart;
    }

    /**
     * Elimina un ítem del carrito y actualiza el total del carrito.
     *
     * @param cartId ID del carrito.
     * @param itemId ID del ítem a eliminar.
     * @return El carrito actualizado.
     */
    public Cart removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart does not exist"));
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item does not exist"));
        itemRepository.deleteById(itemId);
        updateCartTotal(cart, item, false);

        return cart;
    }

    /**
     * Actualiza el total del carrito basado en el ítem añadido o eliminado.
     *
     * @param cart El carrito a actualizar.
     * @param item El ítem que se ha añadido o eliminado.
     */
    private void updateCartTotal(Cart cart, Item item, boolean adding) {
        double total = (cart.getTotal() != null) ? cart.getTotal() : 0.0;
        if (adding) {
            total += item.getTotal();
        } else {
            total -= item.getTotal();
        }
        cart.setTotal(total);
        cartRepository.save(cart);
    }

    public void deleteCart(Long cartId) {
        if (cartRepository.existsById(cartId)) {
            cartRepository.deleteById(cartId);
        } else {
            throw new IllegalArgumentException("Cart does not exist");
        }
    }
}
