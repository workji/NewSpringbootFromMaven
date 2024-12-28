package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Order;
import org.example.entity.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface OrderMapper {

    // 注文情報をスーパーマーケットIDで取得
    @Select("SELECT * FROM Orders WHERE supermarket_id = #{supermarketId}")
    List<Order> findOrdersBySupermarketId(@Param("supermarketId") Integer supermarketId);

    // 注文詳細情報を注文IDで取得
    @Select("SELECT * FROM OrderDetails WHERE order_id = #{orderId}")
    List<OrderDetail> findOrderDetailsByOrderId(@Param("orderId") Integer orderId);

    // 注文の挿入
    @Insert("INSERT INTO Orders (supermarket_id, order_date, delivery_date, year, month, request) " +
            "VALUES (#{supermarketId}, #{orderDate}, #{deliveryDate}, #{year}, #{month}, #{request})")
    void insertOrder(Order order);

    // 注文詳細の挿入
    @Insert("INSERT INTO OrderDetails (order_id, vegetable_id, quantity) " +
            "VALUES (#{orderId}, #{vegetableId}, #{quantity})")
    void insertOrderDetail(OrderDetail orderDetail);
}
