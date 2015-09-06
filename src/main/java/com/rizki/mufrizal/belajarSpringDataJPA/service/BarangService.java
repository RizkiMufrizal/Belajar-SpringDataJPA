package com.rizki.mufrizal.belajarSpringDataJPA.service;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Barang;
import org.springframework.data.domain.Page;

/**
 * Created by rizki on 06/09/15.
 */
public interface BarangService {
    void saveBarang(Barang barang);
    void updateBarang(Barang barang);
    void updateJumlahBarang(String idBarang, Integer jumlahBarang);
    void deleteBarang(String idBarang);
    Barang getBarang(String idBarang);
    Page<Barang> findAllBarang(Integer page, Integer jumlah);
}
