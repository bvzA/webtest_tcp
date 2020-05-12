package test.tcp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.tcp.entity.Item;
import test.tcp.model.ItemListResponse;
import test.tcp.model.ItemResponse;
import test.tcp.repository.ItemRepository;

@Service
public class ItemService {
    
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.itemRepository = repository;
    }

    public List<Item> getItems() {
        // process ...
        return itemRepository.findAll();
    }

	public Item add(Item item) {
        return itemRepository.save(item);
    }
    
    public ItemListResponse listAll(String title) {
        List<Item> list = itemRepository.findAll();
        ItemListResponse liseres = new ItemListResponse();
        liseres.setItems(new ArrayList<>());
        for (Item item : list) {
   
            if(item.getTitle().equals(title))
            {
                ItemResponse itemRes = new ItemResponse();
                itemRes.setTitle(item.getTitle());
                itemRes.setId(item.getId());
                itemRes.setDescription(item.getDescribe());
                itemRes.setTimestamp(item.getTimestamp());

                liseres.getItems().add(itemRes);
            }

        }
        return liseres;
        
    }
    public void AutoDeletedata() {
        // Item item = itemRepository.getOne(id);
        // Date time1 = new Date();
        // Date time2 = new Date();
        // time2 = item.getTimestamp();
        // long diff = time1.getTime() - time2.getTime();
        // if((diff / (1000*60*60*24)) > 1)
        // {
        //     itemRepository.deleteAll();
        // }
       // return (diff / (1000*60*60*24));
       if(itemRepository.count() == 5000)
       {
         itemRepository.deleteAll();
       }

    }
}