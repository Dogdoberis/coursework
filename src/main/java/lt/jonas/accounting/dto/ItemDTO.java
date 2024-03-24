package lt.jonas.accounting.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.ItemType;



@RequiredArgsConstructor
@Setter
@Getter
public class ItemDTO {
    private Long id;
    private String code;
    private String title;
    private Double price;
    private String description;
    private ItemType itemType;
//    private List<InvoiceDTO> invoicesDTO;
}
