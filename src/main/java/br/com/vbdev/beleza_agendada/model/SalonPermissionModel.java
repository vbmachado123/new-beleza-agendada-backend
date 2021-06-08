package br.com.vbdev.beleza_agendada.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "salon_permission")
public class SalonPermissionModel implements GrantedAuthority, Serializable {


    private static final long serialVersionUID = 1L;

    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "salon_permissions")
//    @LazyCollection(LazyCollectionOption.FALSE)
    List<BeautySalonModel> salons;

    @Override
    public String getAuthority() {
        return this.description;
    }
}
