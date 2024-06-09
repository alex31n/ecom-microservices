package com.bractits.orderservice.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "amount", precision = 8, scale = 2)
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


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderItem> items;


    @PrePersist
    public void onPrePersist() {
        this.setId(null);
        this.setCreatedDate(LocalDateTime.now());
        this.setUpdatedDate(LocalDateTime.now());

        updateAmount();

    }

    @PreUpdate
    public void onPreUpdate() {
        this.setUpdatedDate(LocalDateTime.now());
        updateAmount();
    }


    private void updateAmount(){
        this.amount = this.items.stream()
                .map(item -> {
                    BigDecimal quantity = item.getQuantity() == null ? BigDecimal.ZERO : BigDecimal.valueOf(item.getQuantity());
                    BigDecimal price = item.getPrice() == null ? BigDecimal.ZERO : item.getPrice();
                    return price.multiply(quantity);

                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
