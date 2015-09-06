package com.rizki.mufrizal.belajarSpringDataJPA.service.impl;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Pembelian;
import com.rizki.mufrizal.belajarSpringDataJPA.repository.PembelianRepository;
import com.rizki.mufrizal.belajarSpringDataJPA.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rizki on 06/09/15.
 */

@Service
@Transactional(readOnly = true)
public class PembelianServiceImpl implements PembelianService{

    @Autowired
    private PembelianRepository pembelianRepository;

    @Transactional
    @Override
    public void savePembelian(Pembelian pembelian) {
        pembelianRepository.save(pembelian);
    }

    @Transactional
    @Override
    public void deletePembelian(String idPembelian) {
        pembelianRepository.delete(idPembelian);
    }

    @Override
    public Pembelian getPembelian(String idPembelian) {
        return pembelianRepository.findOne(idPembelian);
    }

    @Override
    public Page<Pembelian> findAllPembelian(Integer page, Integer jumlah) {
        return pembelianRepository.findAll(new PageRequest(page, jumlah));
    }
}
