package jordancode.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jordancode.project.DTO.AddItemRequest;
import jordancode.project.Model.Cart;
import jordancode.project.Service.Buy;

@RestController
@RequestMapping("/cart")
public class BuyController {

    @Autowired
    private Buy buyService;

    /**
     * Añade un ítem al carrito. Si el carrito no existe, se crea uno nuevo.
     *
     * @param productId ID del producto a añadir.
     * @param quantity  Cantidad del producto.
     * @param userId    ID del usuario.
     * @return El carrito actualizado.
     */
    @PostMapping("/add")
    public ResponseEntity<Cart> addItemToCart(@RequestBody AddItemRequest request) {
        try {
            Cart updatedCart = buyService.addItemToCart(request.getProductId(), request.getQuantity(),
                    request.getUserId());
            return ResponseEntity.ok(updatedCart);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Elimina un ítem del carrito y actualiza el total del carrito.
     *
     * @param cartId ID del carrito.
     * @param itemId ID del ítem a eliminar.
     * @return El carrito actualizado.
     */
    @DeleteMapping("/remove")
    public ResponseEntity<Cart> removeItemFromCart(
            @RequestParam Long cartId,
            @RequestParam Long itemId) {

        try {
            Cart updatedCart = buyService.removeItemFromCart(cartId, itemId);
            return ResponseEntity.ok(updatedCart);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Elimina el carrito.
     *
     * @param cartId ID del carrito a eliminar.
     * @return ResponseEntity vacío con código de estado 204 No Content.
     */
    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        try {
            buyService.deleteCart(cartId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
