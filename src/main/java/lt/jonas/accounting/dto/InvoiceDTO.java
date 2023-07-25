package lt.jonas.accounting.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.entities.Manager;
import lt.jonas.accounting.entities.Consumer;

import java.time.LocalDate;

@RequiredArgsConstructor
@Setter
@Getter
public class InvoiceDTO {

    private Long id;
    private String invoiceNr;

    private LocalDate invoiceDate;
    private Manager manager;

}
