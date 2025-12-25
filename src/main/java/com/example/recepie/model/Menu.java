package com.example.recepie.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    @Column(nullable = false)
    private String name;
    public Long getMenuId() {
        return menuId;
    }
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}

