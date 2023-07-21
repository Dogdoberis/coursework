package lt.jonas.accounting.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.ConsumerRole;

import java.math.BigInteger;
import java.time.LocalDateTime;
@RequiredArgsConstructor
@Setter
@Getter
public class ConsumerDTO {

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
    private ConsumerRole consumerRole;

    private LocalDateTime updatedAt;
}