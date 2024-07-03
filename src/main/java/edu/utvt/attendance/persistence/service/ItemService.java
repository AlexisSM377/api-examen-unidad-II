package edu.utvt.attendance.persistence.service;

import edu.utvt.attendance.persistence.entities.Item;

import java.util.List;

public interface ItemService {

    List<Item> gellAllItems();
    Item getItemById(Long id);
    List<Item> getItemsByNombre(String nombre);
    Item saveItem(Item item);
    void deleteItem(Long id);
}
