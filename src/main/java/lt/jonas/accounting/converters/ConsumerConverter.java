package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.ConsumerDTO;
import lt.jonas.accounting.entities.Consumer;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ConsumerConverter {

    public static Consumer convertConsumerDtoToConsumer(ConsumerDTO consumerDTO) {
        Consumer consumer = null;
        if (consumerDTO != null) {
            consumer = new Consumer();
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
            consumer.setConsumerRole(consumerDTO.getConsumerRole());

        }
        return consumer;
    }

    public static ConsumerDTO convertConsumerToConsumerDto(Consumer consumer) {
        ConsumerDTO consumerDTO = null;
        if (consumer != null) {
            consumerDTO = new ConsumerDTO();
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
            consumerDTO.setConsumerRole(consumer.getConsumerRole());


        }
        return consumerDTO;
    }

    public static List<ConsumerDTO> convertConsumerListToConsumerDTOList(List<Consumer> consumersList) {
        List<ConsumerDTO> consumerDTOList = null;
        if (consumersList != null && consumersList.isEmpty()) {
            consumerDTOList = new ArrayList<>();
            for (Consumer c : consumersList) {
                consumerDTOList.add(convertConsumerToConsumerDto(c));

            }
        }
        return consumerDTOList;
    }


    public static List<ConsumerDTO> convertConsumerPageToConsumerDTOList(Page<Consumer> consumerPage) {
        List<ConsumerDTO> consumerDTOList = null;
        if (consumerPage != null && !consumerPage.isEmpty()) {
            consumerDTOList = new ArrayList<>();
            for (Consumer c : consumerPage) {
                consumerDTOList.add(convertConsumerToConsumerDto(c));
            }
        }
        return consumerDTOList;
    }

}
