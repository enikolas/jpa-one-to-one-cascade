package com.enikolas.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "body_part_hit")
@XmlRootElement(name = "bodyPartHit")
@Data
@EqualsAndHashCode(exclude = "bodyPart")
@ToString(exclude = "bodyPart")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyPartHit {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "perc_damage_hit")
    private BigDecimal percentDamageHit;

    @OneToOne
    @JoinColumn(name = "id_body_part", unique = true, nullable = false, updatable = false)
    private BodyPart bodyPart;

    @Column(name = "id_body_part", insertable = false, updatable = false, nullable = false)
    private Integer idBodyPart;
}
