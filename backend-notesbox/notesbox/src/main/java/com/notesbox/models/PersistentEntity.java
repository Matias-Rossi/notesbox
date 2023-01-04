package com.notesbox.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class PersistentEntity {
  @Column @Getter
  @GeneratedValue @Id
  public long id;

  @Column @Getter @Setter
  public boolean disabled;

}
