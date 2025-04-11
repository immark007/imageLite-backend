package io.github.marcos.imageliteapi.infra.repository;

import io.github.marcos.imageliteapi.domain.entity.Image;
import io.github.marcos.imageliteapi.domain.enums.ImageExtension;
import io.github.marcos.imageliteapi.infra.repository.specs.ImageSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {


    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {
        Specification<Image> conjunction = (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();
        Specification<Image> spec = Specification.where(conjunction);

        if(extension != null) {
            spec = spec.and(ImageSpecs.extensionEqual(extension));
        }

        if(StringUtils.hasText(query)) {
            spec = spec.and(Specification.anyOf(ImageSpecs.nameLike(query), ImageSpecs.tagsLike(query)));
        }

        return findAll(spec);
    }
}
