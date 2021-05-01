package com.feldmann.cursodespring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.feldmann.cursodespring.domain.Categoria;

import org.hibernate.validator.constraints.Length;

public class CategoriaDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5,max = 80, message = "O Tamanho tem que ser entre 5 ~ 80 caracteres")
    private String nome;

    public CategoriaDTO(){
    }

    public CategoriaDTO(Categoria obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
