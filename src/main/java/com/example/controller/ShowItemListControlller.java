package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entity.ItemEntity;
import com.example.service.ShowItemListService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class ShowItemListControlller {
	
	@Autowired 
	ShowItemListService service;

	@Autowired
	private HttpSession session;

	@GetMapping("")
	public String index(Model model) {
		List<ItemEntity> itemList = (List<ItemEntity>) service.searchByName(null);
		model.addAttribute("itemList", itemList);
		List<List<ItemEntity>> itemListList = createItemListList(itemList);
		model.addAttribute("itemListList", itemListList);
		
		
		return "item_list_curry";
	}
	
	@RequestMapping("/showList")
	public String showList(String itemName, Model model) {
		List<ItemEntity> itemList = service.searchByName(itemName);
		model.addAttribute("itemList", itemList);
		List<List<ItemEntity>> itemListList = createItemListList(itemList);
		model.addAttribute("itemListList", itemListList);
		return "item_list_curry";
	}
	
	@PostMapping("/itemSort")
	public String itemSort(String sort, Model model) {
		List<ItemEntity> itemList = service.itemSort(sort);
		model.addAttribute("itemList", itemList);
		List<List<ItemEntity>> itemListList = createItemListList(itemList);
		model.addAttribute("itemListList", itemListList);
		return "item_list_curry";
	}
	
	
	private List<List<ItemEntity>> createItemListList(List<ItemEntity> itemList) {
		List<List<ItemEntity>> itemListList = new ArrayList<>();
		List<ItemEntity> threeItemList = new ArrayList<>();
		for (int i = 0; i < itemList.size(); i++) {
			if (i % 3 == 0) {
				threeItemList = new ArrayList<>();
				itemListList.add(threeItemList);
			}
			threeItemList.add(itemList.get(i));
		}
		
		return itemListList;
	}

}

//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.domain.Item;
//import com.example.service.ShowItemListService;
//
//import jakarta.servlet.http.HttpSession;
//
///**
// * 商品情報を操作するコントローラー.
// * 
// * @author yamaokahayato
// *
// */
//@Controller
//@RequestMapping("/")
//public class ShowItemListControlller {
//
//	@Autowired
//	private ShowItemListService showItemListService;
//
//	@Autowired
//	private HttpSession session;
//
//	@GetMapping("")
//	public String index(Model model) {
//		List<Item> itemList = showItemListService.searchByName(null);
//		model.addAttribute("itemList", itemList);
//		List<List<Item>> itemListList = createItemListList(itemList);
//		model.addAttribute("itemListList", itemListList);
//		System.out.println("session結果" + session.getId());
//		return "item_list_curry";
//	}
//
//	/**
//	 * 商品一覧表示と検索欄からの曖昧検索.
//	 * 
//	 * @param itemName 商品名
//	 * @param model    モデル
//	 * @return 商品一覧画面
//	 */
//	@RequestMapping("/showList")
//	public String showList(String itemName, Model model) {
//		List<Item> itemList = showItemListService.searchByName(itemName);
//		model.addAttribute("itemList", itemList);
//		List<List<Item>> itemListList = createItemListList(itemList);
//		model.addAttribute("itemListList", itemListList);
//		return "item_list_curry";
//	}
//
//	/**
//	 * 商品の並び替え欄から送られた内容で商品の並び替えを表示する
//	 * 
//	 * @param sort
//	 * @param model モデル
//	 * @return 商品一覧画面
//	 */
//	@PostMapping("/itemSort")
//	public String itemSort(String sort, Model model) {
//		List<Item> itemList = showItemListService.itemSort(sort);
//		model.addAttribute("itemList", itemList);
//		List<List<Item>> itemListList = createItemListList(itemList);
//		model.addAttribute("itemListList", itemListList);
//		return "item_list_curry";
//	}
//
//	
//
//}
