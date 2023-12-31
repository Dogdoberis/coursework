package lt.jonas.accounting.dto;


import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lt.jonas.accounting.enumerators.ConsumerType;
import java.math.BigInteger;


@RequiredArgsConstructor
@Setter
@Getter
public class ConsumerDTO {

    private Long id;
    private String title;
    private String name;
    private Long code;
    private String vatCode;
    private String city;
    private String street;
    private String houseNumber;
    private Integer postCode;
    private String email;
    private BigInteger phoneNumber;
    private ConsumerType consumerType;
//    private List<InvoiceDTO> invoicesDTO;

}
