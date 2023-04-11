package jpabook.jpashop.repository.order.query;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

    private final EntityManager em;

    public List<OrderQueryDto> findOrderQueryDtos(){
        List<OrderQueryDto> result = findOrders();
        result.forEach(o->{
            List<OrderItemQueryDto> orderItems = findOrderItems(o.getOrderId());
            o.setOrderItems(orderItems);
        });
        return result;
    }

    private List<OrderItemQueryDto> findOrderItems(Long orderId) {
        return em.createQuery(
            "select new jpabook.jpashop.repository.order.query.OOrderItemQueryDto(o.orderId, i.name, oi.orderPrice, oi.count)"
                + "from OrderItem oi"
                + "join oi.item i"
                + "where oi.order.id = :orderId", OrderItemQueryDto.class)
            .setParameter("orderId",orderId)
            .getResultList();
    }

    public List<OrderQueryDto> findOrders() {
        List<OrderQueryDto> result = findOrders();
        List<Long> orderIds = result.stream()
            .map(o->o.getOrderId())
            .collect(Collectors.toList());

        return em.createQuery(
            "select new jpabook.jpashop.repository.order.query.OrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address)"
                + "from Order o"+
                "join o.member m"+
                "join o.delivery d", OrderQueryDto.class)
            .getResultList();
    }

/*    public List<OrderQueryDto> findAllByDto_optimization() {
        returList<OrderQueryDto> result = findOrders();
        em.createQuery(
            ""
        ,OrderItemQueryDto.class)
    }*/
}
