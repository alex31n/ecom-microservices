package com.bractits.orderservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Order")
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_no", nullable = false, unique = true, length = 15)
    private String orderNo;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "amount",precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @Column(name = "order_date", updatable = false)
    private LocalDateTime orderDate;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;
}
