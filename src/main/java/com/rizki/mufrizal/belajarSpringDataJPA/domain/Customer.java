package com.rizki.mufrizal.belajarSpringDataJPA.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rizki on 06/09/15.
 */

@Entity
@Table(name = "tb_customer",
    indexes = {
        @Index(columnList = "idCustomer", name = "idCustomer")
    }
)
public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idCustomer", length = 150)
    private String idCustomer;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Column(name = "noTelpon", length = 15, nullable = false, unique = true)
    private String noTelpon;

    @Enumerated(EnumType.STRING)
    @Column(name = "jenisKelamin", length = 6)
    private JenisKelamin jenisKelamin;

    @Column(name = "email", length = 45)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "customer")
    private List<Pembelian> pembelians = new ArrayList<>();

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNoTelpon() {
        return noTelpon;
    }

    public void setNoTelpon(String noTelpon) {
        this.noTelpon = noTelpon;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pembelian> getPembelians() {
        return pembelians;
    }

    public void setPembelians(List<Pembelian> pembelians) {
        this.pembelians = pembelians;
    }
}
