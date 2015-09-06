package com.rizki.mufrizal.belajarSpringDataJPA.service.impl;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Barang;
import com.rizki.mufrizal.belajarSpringDataJPA.repository.BarangRepository;
import com.rizki.mufrizal.belajarSpringDataJPA.service.BarangService;
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
public class BarangServiceImpl implements BarangService{

    @Autowired
    private BarangRepository barangRepository;

    @Transactional
    @Override
    public void saveBarang(Barang barang) {
        barangRepository.save(barang);
    }

    @Transactional
    @Override
    public void updateBarang(Barang barang) {
        barangRepository.save(barang);
    }

    @Transactional
    @Override
    public void deleteBarang(String idBarang) {
        barangRepository.delete(idBarang);
    }

    @Override
    public Barang getBarang(String idBarang) {
        return barangRepository.findOne(idBarang);
    }

    @Override
    public Page<Barang> findAllBarang(Integer page, Integer jumlah) {
        return barangRepository.findAll(new PageRequest(page, jumlah));
    }
}
