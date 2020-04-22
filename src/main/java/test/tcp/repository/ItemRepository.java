package test.tcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.tcp.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}