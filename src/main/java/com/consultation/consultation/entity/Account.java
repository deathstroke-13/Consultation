package com.consultation.consultation.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String accountName;

    @Schema(name = "Email", example = "test@test.com")
    public String email;

    @Schema(name = "Nomor Handphone", example = "085612341234")
    public String handphone;

    @Schema(name = "Jenis Kelamin", example = "L")
    public String gender;

    public Date tglLahir;

    public Long urlPhotoId;

    @Column(unique = true)
    public String firebaseKey;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "domisili_id")
    public Domisili domisiliId;

}
