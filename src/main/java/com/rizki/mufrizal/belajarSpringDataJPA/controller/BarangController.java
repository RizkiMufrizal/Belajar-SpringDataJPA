package com.rizki.mufrizal.belajarSpringDataJPA.controller;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Barang;
import com.rizki.mufrizal.belajarSpringDataJPA.service.BarangService;
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
public class BarangController {

    @Autowired
    private BarangService barangService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/barang", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Page<Barang> getBarangs(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "jumlah") Integer jumlah) {
        return barangService.findAllBarang(page, jumlah);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/barang/{idBarang}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Barang getBarang(@PathVariable("idBarang") String idBarang) {
        return barangService.getBarang(idBarang);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/barang", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public HashMap<String, Object> saveBarang(@RequestBody Barang barang) {

        HashMap<String, Object> objectHashMap = new HashMap<>();

        if (barang == null) {
            objectHashMap.put("Success", Boolean.FALSE);
            objectHashMap.put("Info", "Data tidak ada yang terkirim");
            return objectHashMap;
        } else {
            barangService.saveBarang(barang);
        }

        objectHashMap.put("Success", Boolean.TRUE);
        objectHashMap.put("Info", "Data berhasil disimpan");
        return objectHashMap;

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/barang", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public HashMap<String, Object> updateBarang(@RequestBody Barang barang) {

        HashMap<String, Object> objectHashMap = new HashMap<>();

        if (barang == null) {
            objectHashMap.put("Success", Boolean.FALSE);
            objectHashMap.put("Info", "Data tidak ada yang terkirim");
            return objectHashMap;
        } else {
            barangService.updateBarang(barang);
        }

        objectHashMap.put("Success", Boolean.TRUE);
        objectHashMap.put("Info", "Data berhasil diedit");
        return objectHashMap;

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/barang/{idBarang}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HashMap<String, Object> deleteBarang(@PathVariable("idBarang") String idBarang) {

        HashMap<String, Object> objectHashMap = new HashMap<>();

        if (barangService.getBarang(idBarang) == null) {
            objectHashMap.put("Success", Boolean.FALSE);
            objectHashMap.put("Info", "Data tidak ada yang terkirim");
            return objectHashMap;
        } else {
            barangService.deleteBarang(idBarang);
        }

        objectHashMap.put("Success", Boolean.TRUE);
        objectHashMap.put("Info", "Data berhasil diedit");
        return objectHashMap;
    }

}
