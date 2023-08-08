package lt.jonas.accounting.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.entities.User;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class InvoiceDTO {

    private Long id;
    private String invoiceNr;
    private LocalDate invoiceDate;
    private UserDTO userDTO;
    private ConsumerDTO consumerDTO;
   private List<ItemDTO> itemDTOList;

}
