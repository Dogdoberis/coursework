package lt.jonas.accounting.services;

import lombok.RequiredArgsConstructor;
import lt.jonas.accounting.converters.OwnerConverter;
import lt.jonas.accounting.dto.OwnerDTO;
import lt.jonas.accounting.entities.Owner;
import lt.jonas.accounting.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
@RequiredArgsConstructor
public class OwnerService {
    private OwnerRepository ownerRepository;
    public OwnerDTO createOwner(Owner Owner) {
        ownerRepository.save(Owner);
        return OwnerConverter.convertOwnerToOwnerDTO(Owner);
    }
    public OwnerDTO updateOwner(Owner Owner) {
        Owner OwnerToUpdate = ownerRepository
                .findById(Owner.getId())
                .orElseThrow(NoSuchElementException::new);
        OwnerToUpdate.setTitle(Owner.getTitle());
        OwnerToUpdate.setName(Owner.getName());
        OwnerToUpdate.setCode(Owner.getCode());
        OwnerToUpdate.setVatCode(Owner.getVatCode());
        OwnerToUpdate.setCity(Owner.getCity());
        OwnerToUpdate.setStreet(Owner.getStreet());
        OwnerToUpdate.setHouseNumber(Owner.getHouseNumber());
        OwnerToUpdate.setPostCode(Owner.getPostCode());
        OwnerToUpdate.setEmail(Owner.getEmail());
        OwnerToUpdate.setPhoneNumber(Owner.getPhoneNumber());
        ownerRepository.save(OwnerToUpdate);
        return OwnerConverter.convertOwnerToOwnerDTO(OwnerToUpdate);
    }
}
