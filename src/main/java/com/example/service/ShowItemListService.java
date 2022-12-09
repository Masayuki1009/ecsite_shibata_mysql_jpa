package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.Item;
import com.example.repository.ItemRepository;

@Service
@Transactional
public class ShowItemListService{

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * item情報を全件検索する業務処理と商品名を曖昧検索する業務処理.
	 * 
	 * @param name 商品名
	 * @return 商品リスト
	 */
	public List<Item> searchByName(String name) {
		System.out.println("nameの値" + name);
		if (name == null) {
			List<Item> itemList = (List<Item>) itemRepository.findAll();
			return itemList;
		}
		
		List<Item> itemList = itemRepository.findByNameContaining(name);
		return itemList;
	}

	/**
	 * 商品の並び順を価格の高い順、低い順で並び替える.
	 * 
	 * @param order
	 * @return 商品一覧
	 */
	public List<Item> itemSort(String sort) {
		if ("high".equals(sort)) {
			return itemRepository.findAll(Sort.by(Sort.Direction.DESC, "priceM"));
		}

		return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "priceM"));
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
//import com.example.repository.ItemRepository;
//
///**
// * 商品一覧情報を操作するサービス.
// * 
// * @author yamaokahayato
// *
// */
//@Service
//@Transactional
//public class ShowItemListService {
//
//	@Autowired
//	private ItemRepository itemRepository;
//
//	/**
//	 * item情報を全件検索する業務処理と商品名を曖昧検索する業務処理.
//	 * 
//	 * @param name 商品名
//	 * @return 商品リスト
//	 */
//	public List<Item> searchByName(String name) {
//		System.out.println("name" + name);
//		if (name == null) {
//			List<Item> itemList = itemRepository.findAll();
//			return itemList;
//		}
//		List<Item> itemList = itemRepository.findByName(name);
//		return itemList;
//	}
//
//	/**
//	 * 商品の並び順を価格の高い順、低い順で並び替える.
//	 * 
//	 * @param order
//	 * @return 商品一覧
//	 */
//	public List<Item> itemSort(String sort) {
//		List<Item> itemList = itemRepository.findAll(sort);
//		return itemList;
//	}
//}
