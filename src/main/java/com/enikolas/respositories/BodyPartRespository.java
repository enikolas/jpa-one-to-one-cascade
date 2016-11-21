package com.enikolas.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enikolas.models.BodyPart;

@Repository
public interface BodyPartRespository extends JpaRepository<BodyPart, Integer> {

}
