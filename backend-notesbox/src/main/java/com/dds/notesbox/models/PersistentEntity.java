package com.dds.notesbox.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@jsonId")
public abstract class PersistentEntity {
  @Column @Getter
  @Id @GeneratedValue
  public Long id;

  @Column @Getter @Setter
  public boolean disabled;

}
