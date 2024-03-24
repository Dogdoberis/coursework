package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.OwnerDTO;
import lt.jonas.accounting.entities.Owner;

public class OwnerConverter {
    /**
     * Convert an OvnerDTO object to an Owner ogject.
     * @param OwnerDTO The OwnerDTO object to convert.
     * @return An Owner object.
     */
    public static Owner convertOwnerDtoToOwner(OwnerDTO OwnerDTO) {
        Owner Owner = null; //Create a new Owner object
        if (OwnerDTO != null) { // Check if the OwnerDTO object is not null
            Owner = new Owner(); // Instantiate a new Owner object
            // Set properties of the Owner object based on OwnerDTO
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
        return Owner; // Return the Owner object
    }

    /**
     * Converts an Owner object to an OwnerDTO object.
     * @param Owner The Owner object to convert.
     * @return An OwnerDTO object.
     */
    public static OwnerDTO convertOwnerToOwnerDTO(Owner Owner) {
        OwnerDTO OwnerDTO = null; // Create a new OwnerDTO object
        if (Owner != null) { // Check if the Owner object is not null
            OwnerDTO = new OwnerDTO(); // Instantiate a new OwnerDTO object
            // Set properties of the OwnerDTO object based on Owner
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
        return OwnerDTO; // Return the OwnerDTO object
    }
}
