package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.ItemDTO;
import lt.jonas.accounting.entities.Item;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ItemConverter {
    public static ItemDTO convertItemToItemDTO(Item item) {
        ItemDTO itemDTO = null;
        if (item != null) {
            itemDTO = new ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setCode(item.getCode());
            itemDTO.setTitle(item.getTitle());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setDescription(item.getDescription());
            itemDTO.setItemType(item.getItemType());
        }
        return itemDTO;
    }

    public static Item convertItemDTOToItem(ItemDTO itemDTO) {
        Item item = null;
        if (itemDTO != null) {
            item = new Item();
            item.setId(itemDTO.getId());
            item.setCode(itemDTO.getCode());
            item.setTitle(itemDTO.getTitle());
            item.setPrice(itemDTO.getPrice());
            item.setDescription(itemDTO.getDescription());
            item.setItemType(itemDTO.getItemType());
        }
        return item;
    }

    public static List<ItemDTO> convertItemListToItemDTOList(List<Item> itemList) {
        List<ItemDTO> itemDTOList = null;
        if (itemList != null && !itemList.isEmpty()) {
            itemDTOList = new ArrayList<>();
            for (Item i : itemList) {
                itemDTOList.add(convertItemToItemDTO(i));
            }
        }
        return itemDTOList;
    }
        public static List<Item> convertItemDTOListToItemList(List<ItemDTO> itemDTOList) {
            List<Item> itemList = null;
            if (itemDTOList != null && !itemDTOList.isEmpty()) {
                itemList = new ArrayList<>();
                for (ItemDTO i : itemDTOList) {
                    itemList.add(convertItemDTOToItem(i));
                }
            }
            return itemList;

    }
    public static List<ItemDTO> convertItemPageToItemDTOList(Page<Item> itemPage){
        List<ItemDTO> itemDTOList = null;
        if (itemPage != null && !itemPage.isEmpty()){
            itemDTOList = new ArrayList<>();
            for (Item i : itemPage) {
               itemDTOList.add(convertItemToItemDTO(i));
            }
        }return itemDTOList;
    }

}

