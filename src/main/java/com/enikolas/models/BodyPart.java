package com.enikolas.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "body_part")
@XmlRootElement(name = "bodyPart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyPart {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bodyPart")
    private BodyPartHit bodyPartHit;

    private String description;

    @PrePersist
    public void prePersist() {
        if (bodyPartHit != null) {
            bodyPartHit.setBodyPart(this);
        }
    }
}
