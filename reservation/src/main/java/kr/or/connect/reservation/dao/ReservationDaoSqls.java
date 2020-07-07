package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_CATEGORIES = "select c.id as id, c.name as name, count(p.id) as count from category as c left join product as p on c.id = p.category_id group by c.id";
	
	/*
	 select p.id, p.category_id, di.id as display_info_id,p.description, p.content, p.event,
		(select name from category as c where p.category_id = c.id) as name,
		di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, p.create_date, p.modify_date, 
        (select file_id from product_image as pi where p.id = pi.product_id and type ="ma") as file_id
	from product as p left join display_info as di on p.id = di.product_id;
	  */
}
