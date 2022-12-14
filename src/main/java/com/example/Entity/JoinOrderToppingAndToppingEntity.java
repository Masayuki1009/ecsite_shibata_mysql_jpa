package com.example.Entity;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "joinOrderToppingAndTopping", entities = {
		@EntityResult(entityClass = JoinOrderToppingAndToppingEntity.class, fields = {
				@FieldResult(name="", column=""),
				@FieldResult(name="", column=""),
				@FieldResult(name="", column=""),
				@FieldResult(name="", column="")
		}) }

)
@NamedNativeQuery(
		  name = "SiteInfo.getSiteInfo",
			// SqlResultSetMappingで定義した名前
		  resultSetMapping = "siteInfoMap",
		  query = "select u.url_id, u.url, u.domain_id, d.domain from urls u inner join domains d on d.id = u.domain_id"
		)
public class JoinOrderToppingAndToppingEntity {

}
