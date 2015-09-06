package com.rizki.mufrizal.belajarSpringDataJPA.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rizki on 06/09/15.
 */

@Entity
@Table(name = "tb_pembelian",
    indexes = {
        @Index(columnList = "idPembelian", name = "idPembelian")
    }
)
public class Pembelian implements Serializable{

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idPembelian", length = 150)
    private String idPembelian;

    @Column(name = "namaBarang", length = 50)
    private String namaBarang;

    @Column(name = "jumlahBarang")
    private Integer jumlahBarang;

    @Column(name = "hargaBarang")
    private BigDecimal hargaBarang;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "tanggalPembelian")
    private Date tanggalPembelian;

    @Column(name = "totalHarga")
    private BigDecimal totalHarga;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "idBarang")
    private Barang barang;

    public String getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(String idPembelian) {
        this.idPembelian = idPembelian;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Integer getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(Integer jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public BigDecimal getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(BigDecimal hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public Date getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setTanggalPembelian(Date tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }

    public BigDecimal getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(BigDecimal totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }
}
