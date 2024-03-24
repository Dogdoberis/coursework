package lt.jonas.accounting.converters;

import lt.jonas.accounting.dto.ItemDTO;
import lt.jonas.accounting.entities.Item;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ItemConverter {
    /**
     * Converts an Item object to an ItemDTO object.
     * @param item The Item object to convert.
     * @return An ItemDTO object.
     */
    public static ItemDTO convertItemToItemDTO(Item item) {
        ItemDTO itemDTO = null; // Initialize a new ItemDTO object
        // Check if the item is not null
        if (item != null) {
            itemDTO = new ItemDTO(); // Instantiate a new ItemDTO object
            // Set properties of the ItemDTO object based on Item
            itemDTO.setId(item.getId());
            itemDTO.setCode(item.getCode());
            itemDTO.setTitle(item.getTitle());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setDescription(item.getDescription());
            itemDTO.setItemType(item.getItemType());
        }
        return itemDTO; // Return the ItemDTO object
    }

    /**
     * Converts an ItemDTO object to an Item object.
     * @param itemDTO The ItemDTO object to convert.
     * @return An Item object.
     */
    public static Item convertItemDTOToItem(ItemDTO itemDTO) {
        Item item = null; // Initialize a new Item object
        // Check if the itemDTO is not null
        if (itemDTO != null) {
            item = new Item(); // Instantiate a new Item object
            // Set properties of the Item object based on ItemDTO
            item.setId(itemDTO.getId());
            item.setCode(itemDTO.getCode());
            item.setTitle(itemDTO.getTitle());
            item.setPrice(itemDTO.getPrice());
            item.setDescription(itemDTO.getDescription());
            item.setItemType(itemDTO.getItemType());
        }
        return item; // Return the Item object
    }


    /**
     * Converts a list of Item objects to a list of ItemDTO objects.
     * @param itemList The list of Item objects to convert.
     * @return A list of ItemDTO objects.
     */
    public static List<ItemDTO> convertItemListToItemDTOList(List<Item> itemList) {
        List<ItemDTO> itemDTOList = null; // Initialize a new list of ItemDTO objects
        // Check if the itemList is not null and not empty
        if (itemList != null && !itemList.isEmpty()) {
            itemDTOList = new ArrayList<>(); // Initialize a new ArrayList for ItemDTO objects
            // Iterate through each Item in the itemList
            for (Item item : itemList) {
                // Convert each Item to an ItemDTO and add it to the itemDTOList
                itemDTOList.add(convertItemToItemDTO(item));
            }
        }
        return itemDTOList; // Return the list of ItemDTO objects
    }



    /**
     * Converts a list of ItemDTO ojects to a list of Item objects.
     * @param itemDTOList The List io ItemDTO objects to convert.
     * @return A list of Item objects.
     */
        public static List<Item> convertItemDTOListToItemList(List<ItemDTO> itemDTOList) {
            List<Item> itemList = null; // Initialize a new list of Item objects
            // Check if the itemDTOList is not null and not empty
            if (itemDTOList != null && !itemDTOList.isEmpty()) {
                itemList = new ArrayList<>(); // Initialize a new ArrayList for Item objects
                // Iterate through each ItemDTO in the itemDTOList
                for (ItemDTO i : itemDTOList) {
                    // Convert each ItemDTO to an Item and add it to the itemList
                    itemList.add(convertItemDTOToItem(i));
                }
            }
            return itemList;

    }
    /**
     * Converts a Page<Item> object to a list of ItemDTO objects.
     * @param itemPage The Page<Item> object to convert.
     * @return A list of ItemDTO objects.
     */
    public static List<ItemDTO> convertItemPageToItemDTOList(Page<Item> itemPage){
        List<ItemDTO> itemDTOList = null; // Initialize a new list of ItemDTO objects
        // Check if the itemPage is not null and not empty
        if (itemPage != null && !itemPage.isEmpty()){
            itemDTOList = new ArrayList<>(); // Initialize a new ArrayList for ItemDTO objects
            for (Item i : itemPage) {
                // Convert each Item to an ItemDTO and add it to the itemDTOList
               itemDTOList.add(convertItemToItemDTO(i));
            }
        }return itemDTOList; // Return the list of ItemDTO objects
    }

}

