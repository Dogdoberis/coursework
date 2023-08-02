package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.UserDTO;
import lt.jonas.accounting.entities.User;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;


public class UserConverter {

    public static User convertUserDTOToUser(UserDTO userDTO) {
        User user = null;
        if (userDTO != null) {
            user = new User();
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setUserName(userDTO.getUserNmae());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());

        }
        return user;
    }

    public static UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = null;
        if (user != null) {
            userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setLastName(user.getLastName());
            userDTO.setUserNmae(user.getUserName());
            userDTO.setPassword(user.getPassword());
            userDTO.setRole(user.getRole());

        }
        return userDTO;
    }

    public static List<UserDTO> convertUserListToUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = null;
        if (userList != null && !userList.isEmpty()) {
            userDTOList = new ArrayList<>();
            for (User a : userList) {
                userDTOList.add(convertUserToUserDTO(a));
            }
        }
        return userDTOList;
    }

    public static List<UserDTO> convertUserPageToUserDTOList(Page<User> accountPage) {
        List<UserDTO> userDTOList = null;
        if (accountPage != null && !accountPage.isEmpty()) {
            userDTOList = new ArrayList<>();
            for (User a : accountPage) {
                userDTOList.add(convertUserToUserDTO(a));
            }
        }
        return userDTOList;
    }

}