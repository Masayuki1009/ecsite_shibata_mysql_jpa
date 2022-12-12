package com.example.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.ItemEntity;
import com.example.Entity.ToppingEntity;
import com.example.domain.Item;
import com.example.repository.ItemRepository;
import com.example.repository.ToppingRepository;



@Service
@Transactional
public class ShowItemDetailService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ToppingRepository toppingRepository;
	
	public Item detailByItem(Integer id) {
		ItemEntity itemEntity = itemRepository.getReferenceById(id);
		
		List<ToppingEntity> toppingListEntity = toppingRepository.findAll();
		
		Item itemDomain = new Item();
		ToppingEntity toppingDomain = new ToppingEntity();
		BeanUtils.copyProperties(itemEntity, itemDomain);
//		BeanUtils.copyProperties(toppingListEntity, toppingDomain);
		
		
		itemDomain.setToppingList(toppingListEntity);
		
		return itemDomain;
	}

}


//package com.example.service;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.domain.Item;
//import com.example.domain.Topping;
//import com.example.repository.ItemRepository;
//import com.example.repository.ToppingRepository;
//
///**
// * 商品詳細情報を操作するサービス.
// * 
// * @author yamaokahayato
// *
// */
//@Service
//@Transactional
//public class ShowItemDetailService {
//	
//	@Autowired
//	private ItemRepository itemRepository;
//	
//	@Autowired
//	private ToppingRepository toppingRepository;
//	
//	public Item detailByItem(Integer id) {
//		Item item = itemRepository.load(id);
//		List<Topping> toppingList = toppingRepository.findAll();
//		item.setToppingList(toppingList);
//		return item;
//	}
//
//}
