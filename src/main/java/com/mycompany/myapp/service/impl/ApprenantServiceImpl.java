package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Apprenant;
import com.mycompany.myapp.repository.ApprenantRepository;
import com.mycompany.myapp.service.ApprenantService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Apprenant}.
 */
@Service
@Transactional
public class ApprenantServiceImpl implements ApprenantService {

    private final Logger log = LoggerFactory.getLogger(ApprenantServiceImpl.class);

    private final ApprenantRepository apprenantRepository;

    public ApprenantServiceImpl(ApprenantRepository apprenantRepository) {
        this.apprenantRepository = apprenantRepository;
    }

    @Override
    public Apprenant save(Apprenant apprenant) {
        log.debug("Request to save Apprenant : {}", apprenant);
        return apprenantRepository.save(apprenant);
    }

    @Override
    public Apprenant update(Apprenant apprenant) {
        log.debug("Request to save Apprenant : {}", apprenant);
        return apprenantRepository.save(apprenant);
    }

    @Override
    public Optional<Apprenant> partialUpdate(Apprenant apprenant) {
        log.debug("Request to partially update Apprenant : {}", apprenant);

        return apprenantRepository
            .findById(apprenant.getId())
            .map(existingApprenant -> {
                if (apprenant.getNomPrenom() != null) {
                    existingApprenant.setNomPrenom(apprenant.getNomPrenom());
                }
                if (apprenant.getDateNaissance() != null) {
                    existingApprenant.setDateNaissance(apprenant.getDateNaissance());
                }
                if (apprenant.getLieuNaissance() != null) {
                    existingApprenant.setLieuNaissance(apprenant.getLieuNaissance());
                }
                if (apprenant.getTelephone() != null) {
                    existingApprenant.setTelephone(apprenant.getTelephone());
                }
                if (apprenant.getAdresse() != null) {
                    existingApprenant.setAdresse(apprenant.getAdresse());
                }
                if (apprenant.getSexe() != null) {
                    existingApprenant.setSexe(apprenant.getSexe());
                }
                if (apprenant.getAnneeScolaire() != null) {
                    existingApprenant.setAnneeScolaire(apprenant.getAnneeScolaire());
                }
                if (apprenant.getOption() != null) {
                    existingApprenant.setOption(apprenant.getOption());
                }
                if (apprenant.getSituationMatrimoniale() != null) {
                    existingApprenant.setSituationMatrimoniale(apprenant.getSituationMatrimoniale());
                }
                if (apprenant.getTuteur() != null) {
                    existingApprenant.setTuteur(apprenant.getTuteur());
                }
                if (apprenant.getContactTuteur() != null) {
                    existingApprenant.setContactTuteur(apprenant.getContactTuteur());
                }

                return existingApprenant;
            })
            .map(apprenantRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Apprenant> findAll(Pageable pageable) {
        log.debug("Request to get all Apprenants");
        return apprenantRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Apprenant> findByUserIsCurrentUser(Pageable pageable) {
        log.debug("Request to get all Apprenants");
        return apprenantRepository.findByUserIsCurrentUser(pageable);
    }
    
    public Page<Apprenant> findAllWithEagerRelationships(Pageable pageable) {
        return apprenantRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Apprenant> findOne(Long id) {
        log.debug("Request to get Apprenant : {}", id);
        return apprenantRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Apprenant : {}", id);
        apprenantRepository.deleteById(id);
    }
}
