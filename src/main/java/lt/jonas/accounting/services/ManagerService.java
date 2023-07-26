package lt.jonas.accounting.services;

import lombok.RequiredArgsConstructor;
import lt.jonas.accounting.converters.ManagerConverter;
import lt.jonas.accounting.dto.ManagerDTO;
import lt.jonas.accounting.entities.Manager;
import lt.jonas.accounting.repositories.ManagerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerDTO createManager(Manager manager) {
        managerRepository.save(manager);
        return ManagerConverter.convertManagerToManagerDTO(manager);
    }

    public ManagerDTO getManagerById(Long id) {
        return ManagerConverter.convertManagerToManagerDTO(managerRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public List<ManagerDTO> getManagers(Pageable pageable) {
        if (pageable != null) {
            return ManagerConverter.convertManagerPageToManagerDTOList(managerRepository.findAll(pageable));
        }
        return ManagerConverter.convertManagerListToManagerDTOList(managerRepository.findAll());
    }


    public ManagerDTO updateManager(Manager manager) {
        Manager managerToUpdate = managerRepository.findById(manager.getId()).orElseThrow(NoSuchElementException::new);
        managerToUpdate.setName(manager.getName());
        managerToUpdate.setLastName(manager.getLastName());
        managerToUpdate.setManagerRole(manager.getManagerRole());
        managerRepository.save(managerToUpdate);
        return ManagerConverter.convertManagerToManagerDTO(managerToUpdate);
    }

    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }
}
