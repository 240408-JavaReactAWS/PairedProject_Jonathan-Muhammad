package com.example.revature.PairedProject_JonathanMuhammad.controllers;

import com.example.revature.PairedProject_JonathanMuhammad.models.Item;
import com.example.revature.PairedProject_JonathanMuhammad.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    public ItemController() {
    }

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Add Item endpoint
    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        Item savedItem = itemService.addItem(item);
        if(savedItem != null){
            return new ResponseEntity<>(savedItem,OK);
        }
        return new ResponseEntity<>(NOT_ACCEPTABLE);
    }

    // Get All Items endpoint
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return new ResponseEntity<>(itemService.getAllItems(),OK);
    }

    // Get Item by ID endpoint
    @GetMapping("{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") int id) {
        Optional foundItem = itemService.getItemById(id);
        if (foundItem != null) {
            return new ResponseEntity<>((Item)foundItem.get(), OK);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }

    // Update Item endpoint
    @PutMapping
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        Optional foundItem = itemService.getItemById(item.getItemId());
        if (foundItem != null) {
            Item updatedItem = itemService.updateItem(item);
            return new ResponseEntity<>(updatedItem, OK);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }

    // Delete Item by ID endpoint
    @DeleteMapping("{id}")
    public ResponseEntity<Integer> deleteItemById(@PathVariable("id") int id) {
        Optional foundItem = itemService.getItemById(id);
        if (foundItem != null) {
            Item item=(Item)foundItem.get();
            int deletedItem = itemService.deleteItemById(item.getItemId());
            return new ResponseEntity<>(deletedItem, OK);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }
}
