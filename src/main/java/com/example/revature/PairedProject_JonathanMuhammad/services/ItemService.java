package com.example.revature.PairedProject_JonathanMuhammad.services;

import com.example.revature.PairedProject_JonathanMuhammad.models.Item;
import com.example.revature.PairedProject_JonathanMuhammad.repos.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemDAO itemDAO;

    public ItemService() {
    }

    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    // Get item by ID
    public Optional<Item> getItemById(int id){
        return itemDAO.findById(id);
    }

    // Get all items
    public List<Item> getAllItems(){
        return itemDAO.findAll();
    }

    // Add a new item
    public Item addItem(Item item){
        return (Item)itemDAO.save(item);
    }

    // Update an existing item
    public Item updateItem(Item item){
        // Check if the item exists by ID
        if(itemDAO.findById(item.getItemId())!=null){
            return (Item)itemDAO.save(item);
        }
        return null; // Item does not exist
    }

    // Delete an item by ID
    public int deleteItemById(int id){
        // Check if the item exists by ID
        if(itemDAO.findById(id)!=null){
            itemDAO.deleteById(id);
            return -1; // Item deleted successfully
        }
        return 0; // Item does not exist
    }
}
