package com.refactorizando.example.postgresql.entity;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity {

  @CreatedDate
  @Column(name = "CREATED_DATE", updatable = false)
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(name = "MODIFIED_DATE")
  private LocalDateTime modifiedDate;

}
