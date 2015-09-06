package com.rizki.mufrizal.belajarSpringDataJPA.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rizki on 06/09/15.
 */

@Entity
@Table(name = "tb_barang",
    indexes = {
        @Index(columnList = "idBarang", name = "idBarang")
    }
)
public class Barang implements Serializable{

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idBarang", length = 150)
    private String idBarang;

    @Column(name = "namaBarang", length = 45)
    private String namaBarang;

    @Enumerated(EnumType.STRING)
    @Column(name = "jenisBarang", length = 5)
    private JenisBarang jenisBarang;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "tanggalKadaluarsa")
    private Date tanggalKadaluarsa;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "barang")
    private List<Pembelian> pembelians = new ArrayList<>();

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public JenisBarang getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(JenisBarang jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public Date getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(Date tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public List<Pembelian> getPembelians() {
        return pembelians;
    }

    public void setPembelians(List<Pembelian> pembelians) {
        this.pembelians = pembelians;
    }
}
