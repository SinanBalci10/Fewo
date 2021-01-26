package com.example.application.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// definiert wie man id values, die primary keys und boolean generiert usw
//überschreibt hashcode und equals
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue (strategy= GenerationType.SEQUENCE)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public boolean isPersisted() {
        return id != null;
    }

    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractEntity)) {
            return false; // null or other class
        }
        AbstractEntity other = (AbstractEntity) obj;

        if (id != null) {
            return id.equals(other.id);
        }
        return super.equals(other);
    }
}