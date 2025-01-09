package com.shopette.backend.Service;

import com.shopette.backend.Model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dami Olawoyin-Yussuf
 * @project backend
 * @created 08/01/2025
 * @description
 */

public interface ItemService
{
    Item saveItem(Item item);
    List<Item> getAllItem();
    Item getItemById(String id);
    Item updateItem(Item item, String id);
    void deleteItem(String id);
    void createSampleItem();

}
