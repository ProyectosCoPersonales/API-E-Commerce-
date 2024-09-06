package jordancode.project.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jordancode.project.Model.Cart;
import jordancode.project.Model.Invoice;
import jordancode.project.Model.InvoiceDetailDTO;


import jordancode.project.Repository.CartRepository;
import jordancode.project.Repository.InvoiceRepository;
import jordancode.project.Repository.UserRepository;
import jordancode.project.User.User;

import java.time.LocalDateTime;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Genera una factura para el usuario especificado.
     *
     * @param userId ID del usuario.
     * @return El DTO con los detalles de la factura.
     */
    public InvoiceDetailDTO createInvoice(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found for user"));
        Invoice invoice = Invoice.builder()
                .user(userId)
                .dateIssued(LocalDateTime.now())
                .build();

        Invoice savedInvoice = invoiceRepository.save(invoice);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return InvoiceDetailDTO.builder()
                .invoiceId(savedInvoice.getId())
                .user(user)
                .dateIssued(savedInvoice.getDateIssued())
                .cart(cart)
                .total(cart.getTotal())
                .build();
    }
}

