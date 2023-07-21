package lt.jonas.accounting.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvoiceDTO {

    private Long id;

    private String invoiceNr;

    private LocalDate invoiceDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
