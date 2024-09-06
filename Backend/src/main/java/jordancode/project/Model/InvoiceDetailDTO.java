package jordancode.project.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jordancode.project.User.User;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailDTO {
    private Long invoiceId;
    private User user;
    private LocalDateTime dateIssued;
    private Cart cart;
    private Double total;
}

