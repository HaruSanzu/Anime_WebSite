package com.example.anime_website.repo;

import com.example.anime_website.models.Reviews;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Review_Repository extends JpaRepository<Reviews, Long> {
}
