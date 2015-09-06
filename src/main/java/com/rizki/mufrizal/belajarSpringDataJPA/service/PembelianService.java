package com.rizki.mufrizal.belajarSpringDataJPA.service;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Pembelian;
import org.springframework.data.domain.Page;

/**
 * Created by rizki on 06/09/15.
 */
public interface PembelianService {
    void savePembelian(Pembelian pembelian, String idCustomer, String idBarang);
    void deletePembelian(String idPembelian);
    Pembelian getPembelian(String idPembelian);
    Page<Pembelian> findAllPembelian(Integer page, Integer jumlah);
}
