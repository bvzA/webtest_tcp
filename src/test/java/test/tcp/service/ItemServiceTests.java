package test.tcp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import test.tcp.entity.Item;
import test.tcp.repository.ItemRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ItemServiceTests {

    @MockBean
    private ItemRepository itemRepository;

    private ItemService itemService;

    @BeforeEach
    public void before() {
        doReturn(Lists.list(new Item(), new Item())).when(itemRepository).findAll();

        this.itemService = new ItemService(itemRepository);
    }

    @Test
    public void testGetItems() {
        assertNotNull(itemService);
        
        List<Item> lst = itemService.getItems();

        assertNotNull(lst);
        assertEquals(2, lst.size(), "Result is not equals to 2");
    }
}