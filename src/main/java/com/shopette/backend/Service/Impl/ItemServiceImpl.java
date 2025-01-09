package com.shopette.backend.Service.Impl;

import com.shopette.backend.Model.Item;
import com.shopette.backend.Repository.ItemRepository;
import com.shopette.backend.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Dami Olawoyin-Yussuf
 * @project backend
 * @created 08/01/2025
 * @description
 */

@Service
public class ItemServiceImpl implements ItemService
{

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item saveItem(Item item)
    {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItem()
    {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(String id)
    {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent())
        {
            return item.get();
        }else
        {
            throw new RuntimeException();
        }
    }

    @Override
    public Item updateItem(Item item, String id)
    {
        Item existingItem = itemRepository.findById(id).orElseThrow(RuntimeException::new);
        existingItem.setTitle(item.getTitle());
        existingItem.setDescription(item.getDescription());
        existingItem.setImageUrl(item.getImageUrl());
        existingItem.setPrice(item.getPrice());

        itemRepository.save(existingItem);
        return existingItem;
    }

    @Override
    public void deleteItem(String id)
    {
        itemRepository.findById(id).orElseThrow(RuntimeException::new);
        itemRepository.deleteById(id);
    }
}
