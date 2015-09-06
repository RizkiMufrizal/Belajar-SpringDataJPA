package com.rizki.mufrizal.belajarSpringDataJPA.controller;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Pembelian;
import com.rizki.mufrizal.belajarSpringDataJPA.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by rizki on 06/09/15.
 */

@RestController
@RequestMapping(value = "/api")
public class PembelianController {

    @Autowired
    private PembelianService pembelianService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/pembelian", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Page<Pembelian> getPembelians(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "jumlah") Integer jumlah) {
        return pembelianService.findAllPembelian(page, jumlah);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/pembelian/{idPembelian}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Pembelian getPembelian(@PathVariable("idPembelian") String idPembelian) {
        return pembelianService.getPembelian(idPembelian);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/pembelian", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public HashMap<String, Object> savePembelian(
            @RequestBody Pembelian pembelian,
            @RequestParam(value = "idCustomer") String idCustomer,
            @RequestParam(value = "idBarang") String idBarang) {

        HashMap<String, Object> objectHashMap = new HashMap<>();

        if (pembelian == null) {
            objectHashMap.put("Success", Boolean.FALSE);
            objectHashMap.put("Info", "Data tidak ada yang terkirim");
            return objectHashMap;
        } else {
            pembelianService.savePembelian(pembelian, idCustomer, idBarang);
        }

        objectHashMap.put("Success", Boolean.TRUE);
        objectHashMap.put("Info", "Data berhasil disimpan");
        return objectHashMap;

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/pembelian/{idPembelian}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HashMap<String, Object> deletePembelian(@PathVariable("idPembelian") String idPembelian) {

        HashMap<String, Object> objectHashMap = new HashMap<>();

        if (pembelianService.getPembelian(idPembelian) == null) {
            objectHashMap.put("Success", Boolean.FALSE);
            objectHashMap.put("Info", "Data tidak ada yang terkirim");
            return objectHashMap;
        } else {
            pembelianService.deletePembelian(idPembelian);
        }

        objectHashMap.put("Success", Boolean.TRUE);
        objectHashMap.put("Info", "Data berhasil diedit");
        return objectHashMap;
    }

}
