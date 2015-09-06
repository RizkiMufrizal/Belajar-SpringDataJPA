package com.rizki.mufrizal.belajarSpringDataJPA.repository;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Barang;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rizki on 06/09/15.
 */

@Repository
public interface BarangRepository extends PagingAndSortingRepository<Barang, String> {

}
