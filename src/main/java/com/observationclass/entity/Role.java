package com.observationclass.entity;


import com.observationclass.model.ERole;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    private Set<Account> accounts =new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name="role_name")
    private ERole roleName;

}

