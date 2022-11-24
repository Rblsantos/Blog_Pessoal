package com.generation.blog_pessoal.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity /* Converte a classe em uma tabela */
@Table(name = "tb_postagens")
public class Postagem {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
@Id // configurando chave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
@NotBlank(message = " O título é obrigatório e não pode  ser vazio!") // Indica que nao pode ser nulo ou em branco
@Size(min = 5, max = 100, message = "O título deve ser de no mínimo 5 caracteres e no máximo 100!")
private String titulo;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
@NotNull (message = "O atributo texto é obrigatório") // NotNull aceita espaço em branco
@Size(min = 10, max =1000, message = "O texto deve conter no mínimo 10 e no máximo 1000 caracteres!")
    private String texto;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
@UpdateTimestamp
    private LocalDateTime data;


}

