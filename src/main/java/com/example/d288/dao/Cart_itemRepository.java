package com.example.d288.dao;

import com.example.d288.entities.Cart_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface Cart_itemRepository extends JpaRepository<Cart_item, Long> {
}
