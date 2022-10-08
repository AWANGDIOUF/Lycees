package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Apprenant;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Apprenant}.
 */
public interface ApprenantService {
    /**
     * Save a apprenant.
     *
     * @param apprenant the entity to save.
     * @return the persisted entity.
     */
    Apprenant save(Apprenant apprenant);

    /**
     * Updates a apprenant.
     *
     * @param apprenant the entity to update.
     * @return the persisted entity.
     */
    Apprenant update(Apprenant apprenant);

    /**
     * Partially updates a apprenant.
     *
     * @param apprenant the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Apprenant> partialUpdate(Apprenant apprenant);

    /**
     * Get all the apprenants.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Apprenant> findAll(Pageable pageable);

    Page<Apprenant> findByUserIsCurrentUser(Pageable pageable);
    /**
     * Get all the apprenants with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Apprenant> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" apprenant.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Apprenant> findOne(Long id);

    /**
     * Delete the "id" apprenant.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
