package com.shopette.backend.Controller;

import com.shopette.backend.Model.Item;
import com.shopette.backend.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dami Olawoyin-Yussuf
 * @project backend
 * @created 08/01/2025
 * @description
 */

@RestController
@RequestMapping("/items")
public class ItemController
{
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService)
    {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item)
    {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.CREATED);
    }


    //GetAll Rest Api
    @GetMapping
    public List<Item> getAllEmployee(){
        return itemService.getAllItem();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    public ResponseEntity<Item> getEmployeeById(@PathVariable("id") String itemID){
        return new ResponseEntity<>(itemService.getItemById(itemID), HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Item> updateEmployee(@PathVariable("id") String id,
                                                   @RequestBody Item item){
        return new ResponseEntity<>(itemService.updateItem(item, id), HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id){
        //delete employee from db
        itemService.deleteItem(id);
        return new ResponseEntity<>("Item deleted Successfully.", HttpStatus.OK);
    }

    @GetMapping("/create")
    public String createSampleItem()
    {
        itemService.createSampleItem();
        return "Sample item created successfully";
    }
}
