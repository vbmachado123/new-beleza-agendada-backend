package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mail;

}
