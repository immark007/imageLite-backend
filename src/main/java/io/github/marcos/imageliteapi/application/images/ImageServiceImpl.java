package io.github.marcos.imageliteapi.application.images;

import io.github.marcos.imageliteapi.domain.entity.Image;
import io.github.marcos.imageliteapi.domain.service.ImageService;
import io.github.marcos.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    @Override
    @Transactional
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> findById(String id) {
        return imageRepository.findById(id);
    }
}
