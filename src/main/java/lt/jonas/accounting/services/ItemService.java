package lt.jonas.accounting.services;

import lombok.AllArgsConstructor;
import lt.jonas.accounting.converters.ItemConverter;
import lt.jonas.accounting.dto.ItemDTO;
import lt.jonas.accounting.entities.Item;
import lt.jonas.accounting.repositories.ItemRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemDTO createItem(Item item) {
        itemRepository.save(item);
        return ItemConverter.convertItemToItemDTO(item);
    }
    public ItemDTO getItemById(Long id) {
        return ItemConverter.convertItemToItemDTO(itemRepository.getReferenceById(id));
    }
    public ItemDTO updateItem(Item item) {
        Item itemToUpdate = itemRepository.findById(item.getId()).orElseThrow(NoSuchElementException::new);
        itemToUpdate.setId(item.getId());
        itemToUpdate.setTitle(item.getTitle());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setDescription(item.getDescription());
        return ItemConverter.convertItemToItemDTO(itemToUpdate);
    }
    public List<ItemDTO> getItems(Pageable pageable) {
        if (pageable != null) {
            return ItemConverter
                    .convertItemPageToItemDTOList(itemRepository.findAll(pageable));

        }
        return ItemConverter.convertItemListToItemDTOList(itemRepository.findAll());
    }
    public void deleteItemById(Long id){
        itemRepository.deleteById(id);
    }

}
