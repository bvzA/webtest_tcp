package test.tcp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import test.tcp.entity.Item;

@SpringBootTest
public class ItemRepositoryTests {

    @Autowired
    private ItemRepository repository;

    @BeforeEach
    public void before() {
        assertNotNull(repository);
        repository.deleteAll();
    }

    @Test
    public void testGetList() {
        assertNotNull(repository);
        List<Item> lst = repository.findAll();

        assertNotNull(lst);
        assertEquals(0, lst.size(), "Result is not zero.");
    }

    @Test
    public void testAddItem() {
        assertNotNull(repository);

        Item item = new Item();
        item.setTitle("Item-Zero");
        item.setDescribe("The first item");
        item.setTimestamp(new Date());

        Item result = repository.save(item);
        assertNotNull(result);
        assertNotNull(result.getId());
    }
}