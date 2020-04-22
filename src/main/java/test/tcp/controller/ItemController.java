package test.tcp.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.tcp.entity.Item;
import test.tcp.service.ItemService;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> list() {
        return itemService.getItems();
    }

    @GetMapping("/mock")
    public Item mock() {
        Item item = new Item();
        item.setTitle("Item "+ new Random().nextInt());
        item.setDescribe("Describe of "+ item.getTitle());
        item.setTimestamp(new Date());

        return itemService.add(item);
    }
}