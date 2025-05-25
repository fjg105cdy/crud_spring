package com.yian.crud_spring.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @CreatedDate
    @Column()
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column()
    private LocalDateTime updatedAt;

}
