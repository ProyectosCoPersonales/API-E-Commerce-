package jordancode.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jordancode.project.Model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}

