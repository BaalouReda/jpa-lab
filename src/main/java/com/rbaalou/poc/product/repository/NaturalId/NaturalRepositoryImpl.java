package com.rbaalou.poc.product.repository.NaturalId;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Transactional(readOnly = true)
public class NaturalRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements NaturalRepository<T, ID> {

    private final EntityManager entityManager;

    public NaturalRepositoryImpl(JpaEntityInformation entityInformation,
                                 EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findBySimpleNaturalId(ID naturalId) {

        Optional<T> entity = entityManager.unwrap(Session.class)
                .bySimpleNaturalId(this.getDomainClass())
                .loadOptional(naturalId);

        return entity;
    }

    @Override
    public void deleteBySimpleNaturalId(ID naturalId) {
        Optional<T> entity = findBySimpleNaturalId(naturalId);
        entity.ifPresent(this::delete);
    }


}
