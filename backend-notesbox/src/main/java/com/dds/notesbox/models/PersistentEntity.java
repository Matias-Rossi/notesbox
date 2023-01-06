package com.dds.notesbox.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class PersistentEntity {
  @Column @Getter
  @GeneratedValue @Id
  public Long id;

  @Column @Getter @Setter
  public boolean disabled;

}
