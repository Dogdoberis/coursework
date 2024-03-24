package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.ConsumerDTO;
import lt.jonas.accounting.entities.Consumer;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;


public class ConsumerConverter {

    /**
     * Converts a ConsumerDTO object to a Consumer object.
     * @param consumerDTO The ConsumerDTO object to convert.
     * @return A Consumer object.
     */
    public static Consumer convertConsumerDtoToConsumer(ConsumerDTO consumerDTO) {
        Consumer consumer = null; // Initialize a new Consumer object
        // Check if the consumerDTO is not null
        if (consumerDTO != null) {
            consumer = new Consumer(); // Instantiate a new Consumer object
            // Set properties of the Consumer object based on ConsumerDTO
            consumer.setId(consumerDTO.getId());
            consumer.setTitle(consumerDTO.getTitle());
            consumer.setName(consumerDTO.getName());
            consumer.setCode(consumerDTO.getCode());
            consumer.setVatCode(consumerDTO.getVatCode());
            consumer.setCity(consumerDTO.getCity());
            consumer.setStreet(consumerDTO.getStreet());
            consumer.setHouseNumber(consumerDTO.getHouseNumber());
            consumer.setPostCode(consumerDTO.getPostCode());
            consumer.setEmail(consumerDTO.getEmail());
            consumer.setPhoneNumber(consumerDTO.getPhoneNumber());
            consumer.setConsumerType(consumerDTO.getConsumerType());
        }
        return consumer; // Return the Consumer object
    }


    /**
     * Converts a Consumer object to a ConsumerDTO object.
     * @param consumer The Consumer object to convert.
     * @return A ConsumerDTO object.
     */
    public static ConsumerDTO convertConsumerToConsumerDTO(Consumer consumer) {
        ConsumerDTO consumerDTO = null; // Initialize a new ConsumerDTO object
        // Check if the consumer is not null
        if (consumer != null) {
            consumerDTO = new ConsumerDTO(); // Instantiate a new ConsumerDTO object
            // Set properties of the ConsumerDTO object based on Consumer
            consumerDTO.setId(consumer.getId());
            consumerDTO.setTitle(consumer.getTitle());
            consumerDTO.setName(consumer.getName());
            consumerDTO.setCode(consumer.getCode());
            consumerDTO.setVatCode(consumer.getVatCode());
            consumerDTO.setCity(consumer.getCity());
            consumerDTO.setStreet(consumer.getStreet());
            consumerDTO.setHouseNumber(consumer.getHouseNumber());
            consumerDTO.setPostCode(consumer.getPostCode());
            consumerDTO.setEmail(consumer.getEmail());
            consumerDTO.setPhoneNumber(consumer.getPhoneNumber());
            consumerDTO.setConsumerType(consumer.getConsumerType());
        }
        return consumerDTO; // Return the ConsumerDTO object
    }


    /**
     * Converts a list of Consumer objects to a list of ConsumerDTO objects.
     * @param consumersList The list of Consumer objects to convert.
     * @return A list of ConsumerDTO objects.
     */
    public static List<ConsumerDTO> convertConsumerListToConsumerDTOList(List<Consumer> consumersList) {
        List<ConsumerDTO> consumerDTOList = null; // Initialize a new list of ConsumerDTO objects
        // Check if the consumersList is not null and not empty
        if (consumersList != null && !consumersList.isEmpty()) {
            consumerDTOList = new ArrayList<>(); // Initialize a new ArrayList for ConsumerDTO objects
            // Iterate through each Consumer in the consumersList
            for (Consumer consumer : consumersList) {
                // Convert each Consumer to a ConsumerDTO and add it to the consumerDTOList
                consumerDTOList.add(convertConsumerToConsumerDTO(consumer));
            }
        }
        return consumerDTOList; // Return the list of ConsumerDTO objects
    }



    /**
     * Converts a Page<Consumer> object to a list of ConsumerDTO objects.
     * @param consumerPage The Page<Consumer> object to convert.
     * @return A list of ConsumerDTO objects.
     */
    public static List<ConsumerDTO> convertConsumerPageToConsumerDTOList(Page<Consumer> consumerPage) {
        List<ConsumerDTO> consumerDTOList = null; // Initialize a new list of ConsumerDTO objects
        // Check if the consumerPage is not null and not empty
        if (consumerPage != null && !consumerPage.isEmpty()) {
            consumerDTOList = new ArrayList<>(); // Initialize a new ArrayList for ConsumerDTO objects
            // Iterate through each Consumer in the consumerPage
            for (Consumer consumer : consumerPage) {
                // Convert each Consumer to a ConsumerDTO and add it to the consumerDTOList
                consumerDTOList.add(convertConsumerToConsumerDTO(consumer));
            }
        }
        return consumerDTOList; // Return the list of ConsumerDTO objects
    }


}
