package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
	public List<ItemEntity> findByNameContaining(String name);
}

//package com.example.repository;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.stereotype.Repository;
//
//import com.example.domain.Item;
//
///**
// * 
// * itemsテーブルを操作するレポジトリ.
// * 
// * @author 萩田 yamaokahayato
// * 
// */
//@Repository
//public class ItemRepository {
//
//	private static final RowMapper<Item> ITEM_ROW_MAPPER = new BeanPropertyRowMapper<>(Item.class);
//
//	@Autowired
//	private NamedParameterJdbcTemplate template;
//
//	/**
//	 * 
//	 * 商品情報を取得する.
//	 * 
//	 * @param id 商品ID
//	 * @return 商品情報
//	 */
//	public Item load(Integer id) {
//		String sql = "SELECT id, name, image_path, price_m, price_l, description FROM items WHERE id = :id";
//		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
//		Item item = template.queryForObject(sql, param, ITEM_ROW_MAPPER);
//		return item;
//	}
//
//	/**
//	 * 商品情報を全件検索する.
//	 * 
//	 * @return 商品一覧
//	 */
//	public List<Item> findAll() {
//		String sql = "SELECT id, name, description, price_m, price_l, image_path FROM items ORDER BY price_m";
//		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
//		return itemList;
//	}
//
//	/**
//	 * 検索欄から商品名の曖昧検索をする.
//	 * 
//	 * @param name 商品名
//	 * @return 商品一覧
//	 */
//	public List<Item> findByName(String name) {
//		String sql = "SELECT id, name, description, price_m, price_l, image_path FROM items WHERE name LIKE :name ORDER BY price_m;";
//		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");
//		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
//		return itemList;
//	}
//
//	/**
//	 * 商品一覧の並び順を検索する.
//	 * 
//	 * @param order
//	 * @return 商品一覧
//	 */
//	public List<Item> findAll(String sort) {
//		String sql = "SELECT id, name, description, price_m, price_l, image_path FROM items ORDER BY price_m";
//
//		if (sort.equals("high")) {
//			sql = sql + " DESC";
//		}
//		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
//		return itemList;
//
//	}
//
//}
