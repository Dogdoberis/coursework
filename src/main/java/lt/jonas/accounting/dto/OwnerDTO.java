package lt.jonas.accounting.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.math.BigInteger;

@RequiredArgsConstructor
@Setter
@Getter
public class OwnerDTO {
    private Long id;
    private String title;
    private String name;
    private BigInteger code;
    private String vatCode;
    private String city;
    private String street;
    private String houseNumber;
    private Integer postCode;
    private String email;
    private BigInteger phoneNumber;

}
