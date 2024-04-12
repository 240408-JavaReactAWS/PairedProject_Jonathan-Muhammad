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

    public Optional<Item> getItemById(int id){
        return itemDAO.findById(id);
    }

    public List<Item> getAllItems(){
        return itemDAO.findAll();
    }

    public Item addItem(Item item){
        return (Item)itemDAO.save(item);
    }

    public Item updateItem(Item item){
        if(itemDAO.findById(item.getItemId())!=null){
            return (Item)itemDAO.save(item);
        }
        return null;
    }

    public int deleteItemById(int id){
        if(itemDAO.findById(id)!=null){
            itemDAO.deleteById(id);
            return -1;
        }
        return 0;
    }
}
