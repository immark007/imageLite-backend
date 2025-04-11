package io.github.marcos.imageliteapi.infra.repository;

import io.github.marcos.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
