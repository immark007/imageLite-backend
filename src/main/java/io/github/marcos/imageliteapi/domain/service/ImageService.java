package io.github.marcos.imageliteapi.domain.service;

import io.github.marcos.imageliteapi.domain.entity.Image;

import java.util.Optional;

public interface ImageService {
    Image save(Image image);

    Optional<Image> findById(String id);
}
