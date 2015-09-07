package com.rizki.mufrizal.belajarSpringDataJPA.service.impl;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Barang;
import com.rizki.mufrizal.belajarSpringDataJPA.domain.Customer;
import com.rizki.mufrizal.belajarSpringDataJPA.domain.Pembelian;
import com.rizki.mufrizal.belajarSpringDataJPA.repository.BarangRepository;
import com.rizki.mufrizal.belajarSpringDataJPA.repository.CustomerRepository;
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
public class PembelianServiceImpl implements PembelianService {

    @Autowired
    private PembelianRepository pembelianRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BarangRepository barangRepository;

    @Transactional
    @Override
    public void savePembelian(Pembelian pembelian, String idCustomer, String idBarang) {

        Customer customer = customerRepository.findOne(idCustomer);
        Barang barang = barangRepository.findOne(idBarang);

        pembelian.setCustomer(customer);
        pembelian.setBarang(barang);

        pembelianRepository.save(pembelian);
    }

    @Transactional
    @Override
    public void deletePembelian(String idPembelian) {
        //pembelianRepository.delete(idPembelian);
        pembelianRepository.deletePembelian(idPembelian);
    }

    @Override
    public Pembelian getPembelian(String idPembelian) {
        return pembelianRepository.findOne(idPembelian);
    }

    @Override
    public Page<Pembelian> findAllPembelian(Integer page, Integer jumlah) {
        return pembelianRepository.findAll(new PageRequest(page - 1, jumlah));
    }
}
