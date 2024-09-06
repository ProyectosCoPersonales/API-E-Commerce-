package jordancode.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jordancode.project.Model.InvoiceDetailDTO;
import jordancode.project.Service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    /**
     * Crea una factura para el usuario especificado.
     *
     * @param userId ID del usuario.
     * @return El DTO con los detalles de la factura.
     */
    
     @PostMapping("/create/{userId}")
     public ResponseEntity<InvoiceDetailDTO> createInvoice(@PathVariable Long userId) {
         try {
             InvoiceDetailDTO invoiceDetailDTO = invoiceService.createInvoice(userId);
             return ResponseEntity.ok(invoiceDetailDTO);
         } catch (IllegalArgumentException e) {
             return ResponseEntity.badRequest().body(null);
         }
     }
}

