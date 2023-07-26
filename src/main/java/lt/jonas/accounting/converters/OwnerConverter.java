package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.OwnerDTO;
import lt.jonas.accounting.entities.Owner;

public class OwnerConverter {
    public static Owner convertOwnerDtoToOwner(OwnerDTO OwnerDTO) {
        Owner Owner = null;
        if (OwnerDTO != null) {
            Owner = new Owner();
            Owner.setId(OwnerDTO.getId());
            Owner.setTitle(OwnerDTO.getTitle());
            Owner.setName(OwnerDTO.getName());
            Owner.setCode(OwnerDTO.getCode());
            Owner.setVatCode(OwnerDTO.getVatCode());
            Owner.setCity(OwnerDTO.getCity());
            Owner.setStreet(OwnerDTO.getStreet());
            Owner.setHouseNumber(OwnerDTO.getHouseNumber());
            Owner.setPostCode(OwnerDTO.getPostCode());
            Owner.setEmail(OwnerDTO.getEmail());
            Owner.setPhoneNumber(OwnerDTO.getPhoneNumber());


        }
        return Owner;
    }

    public static OwnerDTO convertOwnerToOwnerDTO(Owner Owner) {
        OwnerDTO OwnerDTO = null;
        if (Owner != null) {
            OwnerDTO = new OwnerDTO();
            OwnerDTO.setId(Owner.getId());
            OwnerDTO.setTitle(Owner.getTitle());
            OwnerDTO.setName(Owner.getName());
            OwnerDTO.setCode(Owner.getCode());
            OwnerDTO.setVatCode(Owner.getVatCode());
            OwnerDTO.setCity(Owner.getCity());
            OwnerDTO.setStreet(Owner.getStreet());
            OwnerDTO.setHouseNumber(Owner.getHouseNumber());
            OwnerDTO.setPostCode(Owner.getPostCode());
            OwnerDTO.setEmail(Owner.getEmail());
            OwnerDTO.setPhoneNumber(Owner.getPhoneNumber());


        }
        return OwnerDTO;
    }
}
