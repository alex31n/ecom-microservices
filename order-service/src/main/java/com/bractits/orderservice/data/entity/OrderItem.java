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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "OrderItem")
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_id")
    private Long orderId;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;


    @PrePersist
    public void onPrePersist() {
        this.setId(null);
        this.setCreatedDate(LocalDateTime.now());
        this.setUpdatedDate(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        this.setUpdatedDate(LocalDateTime.now());
    }
}
