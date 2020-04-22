package test.tcp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import test.tcp.entity.Item;
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
}