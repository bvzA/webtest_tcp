package test.tcp.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import test.tcp.entity.Item;
import test.tcp.model.ItemListResponse;
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

    @GetMapping("/add")
    @ResponseBody
    public Item adddata(@RequestParam String title,@RequestParam String data){
        Item item = new Item();
        item.setTitle(title);
        item.setDescribe(data);
        item.setTimestamp(new Date());

        itemService.AutoDeletedata();
        return itemService.add(item);

    }
    @GetMapping("/list")
    public ItemListResponse Showlistdata(@RequestParam String title) {
        return itemService.listAll(title);
    }

    // @GetMapping("/dle")
    // public long Deletedata(@RequestParam Integer id) {
    //     return itemService.AutoDeletedata();
    // }

}