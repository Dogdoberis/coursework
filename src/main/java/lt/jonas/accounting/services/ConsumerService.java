package lt.jonas.accounting.services;


import lombok.RequiredArgsConstructor;
import lt.jonas.accounting.converters.ConsumerConverter;
import lt.jonas.accounting.dto.ConsumerDTO;
import lt.jonas.accounting.entities.Consumer;
import lt.jonas.accounting.repositories.ConsumerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final ConsumerRepository consumerRepository;

    public ConsumerDTO createConsumer(Consumer consumer) {
        consumerRepository.save(consumer);
        return ConsumerConverter.convertConsumerToConsumerDTO(consumer);
    }

    public List<ConsumerDTO> getConsumers(Pageable pageable) {
        if (pageable != null) {
            return ConsumerConverter.convertConsumerPageToConsumerDTOList(consumerRepository.findAll(pageable));

        }
        return ConsumerConverter.convertConsumerListToConsumerDTOList(consumerRepository.findAll());
    }

    public ConsumerDTO getConsumerById(Long id) {
        return ConsumerConverter
                .convertConsumerToConsumerDTO(consumerRepository
                        .findById(id)
                        .orElseThrow(NoSuchElementException::new));
    }


    public ConsumerDTO updateConsumer(Consumer consumer) {
        Consumer consumerToUpdate = consumerRepository
                .findById(consumer.getId())
                .orElseThrow(NoSuchElementException::new);
        consumerToUpdate.setTitle(consumer.getTitle());
        consumerToUpdate.setName(consumer.getName());
        consumerToUpdate.setCode(consumer.getCode());
        consumerToUpdate.setVatCode(consumer.getVatCode());
        consumerToUpdate.setCity(consumer.getCity());
        consumerToUpdate.setStreet(consumer.getStreet());
        consumerToUpdate.setHouseNumber(consumer.getHouseNumber());
        consumerToUpdate.setPostCode(consumer.getPostCode());
        consumerToUpdate.setEmail(consumer.getEmail());
        consumerToUpdate.setPhoneNumber(consumer.getPhoneNumber());
        consumerToUpdate.setConsumerType(consumer.getConsumerType());
        consumerRepository.save(consumerToUpdate);
        return ConsumerConverter.convertConsumerToConsumerDTO(consumerToUpdate);
    }

    public List<ConsumerDTO> searchConsumers(String name, Long code, String vatCode) {
        List<Consumer> consumers = null;
        if (name != null) {
            name = name.replaceAll("[\\d?.,-/d]+", "");
            consumers = consumerRepository.findByNameIgnoreCaseContaining(name);
        } else if (name == null || name.isEmpty()) {
            consumers = consumerRepository.findAll();
        }
        if (code != null) {
            consumers = (consumerRepository.findByCode(code.toString()));
        } else if (vatCode != null) {
            consumers = (consumerRepository.findByVatCodeContaining(vatCode));
        }
        return ConsumerConverter.convertConsumerListToConsumerDTOList(consumers);


    }


}

