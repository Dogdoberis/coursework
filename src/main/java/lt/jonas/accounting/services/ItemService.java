package lt.jonas.accounting.services;

import lombok.RequiredArgsConstructor;
import lt.jonas.accounting.converters.ItemConverter;
import lt.jonas.accounting.dto.ItemDTO;
import lt.jonas.accounting.entities.Invoice;
import lt.jonas.accounting.entities.Item;
import lt.jonas.accounting.repositories.InvoiceRepository;
import lt.jonas.accounting.repositories.ItemRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public final InvoiceRepository invoiceRepository;

    public ItemDTO createItem(Item item) throws IllegalArgumentException {
        itemRepository.save(item);
        return ItemConverter.convertItemToItemDTO(item);
    }

    public ItemDTO getItemById(Long id) {
        return ItemConverter
                .convertItemToItemDTO(itemRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public ItemDTO updateItem(Item item) {
        Item itemToUpdate = itemRepository.findById(item.getId()).orElseThrow(NoSuchElementException::new);
        itemToUpdate.setId(item.getId());
        itemToUpdate.setCode(item.getCode());
        itemToUpdate.setTitle(item.getTitle());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setItemType(item.getItemType());
        return ItemConverter.convertItemToItemDTO(itemToUpdate);
    }

    public List<ItemDTO> getItems(Pageable pageable) {
            return ItemConverter.convertItemPageToItemDTOList(itemRepository.findAll(pageable));
    }
    public List<ItemDTO> getItemsByIds(List<Long> id) {
        List<Item> items = itemRepository.findAllById(id);
        return ItemConverter.convertItemListToItemDTOList(items);
    }
    public List<ItemDTO> searchItems(String code, String title, String description) {
        List<Item> items = null;
        if (code != null) {
            code = code.replaceAll("[\\d?.,-/d]+", "");
            items = itemRepository.findItemByCodeIgnoreCaseContaining(code);
        } else if (code == null || code.isEmpty()) {
            items = itemRepository.findAll();
        }
        if (title != null) {
            title = title.replaceAll("[\\d?.,-/d]+", "");
            items = (itemRepository.findItemByTitleIgnoreCaseContaining(title));
        } else if (description != null) {
            description = description.replaceAll("[\\d?.,-/d]+", "");
            items = (itemRepository.findItemByDescriptionIgnoreCaseContaining(description));
        }
        return ItemConverter.convertItemListToItemDTOList(items);

    }
    public void deleteItemById(Long id) {
        List<Invoice> invoices = invoiceRepository.findInvoiceByItemsId(id);
        if (!invoices.isEmpty()) {
            throw new IllegalStateException("Item with ID " + id + " cannot be deleted as it has associated invoices.");
        }
        itemRepository.deleteById(id);
    }

}
