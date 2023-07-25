package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.ManagerDTO;
import lt.jonas.accounting.entities.Manager;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;


public class ManagerConverter {

    public static Manager convertManagerDTOToManager(ManagerDTO managerDTO) {
        Manager manager = null;
        if (managerDTO != null) {
            manager = new Manager();
            manager.setId(managerDTO.getId());
            manager.setName(managerDTO.getName());
            manager.setLastName(manager.getLastName());
            manager.setManagerType(managerDTO.getManagerType());

        }
        return manager;
    }

    public static ManagerDTO convertManagerToManagerDTO(Manager manager) {
        ManagerDTO managerDTO = null;
        if (manager != null) {
            managerDTO = new ManagerDTO();
            managerDTO.setId(manager.getId());
            managerDTO.setName(manager.getName());
            managerDTO.setLastName(manager.getLastName());
            managerDTO.setManagerType(manager.getManagerType());

        }
        return managerDTO;
    }

    public static List<ManagerDTO> convertManagerListToManagerDTOList(List<Manager> managerList) {
        List<ManagerDTO> managerDTOList = null;
        if (managerList != null && !managerList.isEmpty()) {
            managerDTOList = new ArrayList<>();
            for (Manager a : managerList) {
                managerDTOList.add(convertManagerToManagerDTO(a));
            }
        }
        return managerDTOList;
    }

    public static List<ManagerDTO> convertManagerPageToManagerDTOList(Page<Manager> accountPage) {
        List<ManagerDTO> managerDTOList = null;
        if (accountPage != null && !accountPage.isEmpty()) {
            managerDTOList = new ArrayList<>();
            for (Manager a : accountPage) {
                managerDTOList.add(convertManagerToManagerDTO(a));
            }
        }
        return managerDTOList;
    }

}