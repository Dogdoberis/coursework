package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.UserDTO;
import lt.jonas.accounting.entities.User;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;


public class UserConverter {

    /**
     * Converts a UserDTO object to a User object.
     * @param userDTO The UserDTO object to convert.
     * @return A User object.
     */
    public static User convertUserDTOToUser(UserDTO userDTO) {
        User user = null; // Create a new User object
        if (userDTO != null) { // Check if the UserDTO is not null
            user = new User(); // Instantiate a new User object
            // Set properties of the User object based on UserDTO
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setUserName(userDTO.getUserNmae());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());

        }
        return user; // Return the User object
    }

    /**
     * Converts a User object to a UserDTO object.
     * @param user The User object to convert.
     * @return A UserDTO
     */
    public static UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = null; // Create a new UserDTO object
        if (user != null) { // Check if the User object is not null
            userDTO = new UserDTO();  // Instantiate a new UserDTO object
            // Set properties of the UserDTO object based on User
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setLastName(user.getLastName());
            userDTO.setUserNmae(user.getUserName());
//            userDTO.setPassword(user.getPassword());
            userDTO.setRole(user.getRole());

        }
        return userDTO; // Return the UserDTO object
    }

    /**
     * Converts a list of User objects to a list of UserDTO objects.
     * @param userList The list of User objects to convert.
     * @return A list of UserDTO objects.
     */
    public static List<UserDTO> convertUserListToUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = null; // Create a new list of UserDTOs
        if (userList != null && !userList.isEmpty()) { // Check if the received list is not null and not empty
            userDTOList = new ArrayList<>(); // Create a new ArrayList for UserDTOs
            for (User a : userList) { // Iterate through the received list of users
                userDTOList.add(convertUserToUserDTO(a)); // Convert each user to a UserDTO and add it to the new list
            }
        }
        return userDTOList; // Return the list of UserDTOs
    }

    /**
     * Converts a list of User objects to a list of UserDTO objects.
     * @param ,  userList The list of User objects to convert.
     * @return A list of UserDTO objects.
     */
    public static List<UserDTO> convertUserPageToUserDTOList(Page<User> accountPage) {
        List<UserDTO> userDTOList = null; // Create a new list of UserDTOs
        if (accountPage != null && !accountPage.isEmpty()) { // Check if the received list is not null and not empty
            userDTOList = new ArrayList<>(); // Create a new ArrayList for UserDTOs
            for (User a : accountPage) { // Iterate through the received list of users
                userDTOList.add(convertUserToUserDTO(a)); // Convert each user to DTO and add it to the new list
            }
        }
        return userDTOList; // Return the converted list of UserDTOs
    }

}