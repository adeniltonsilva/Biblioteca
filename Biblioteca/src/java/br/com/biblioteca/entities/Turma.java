/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Régis
 */
@Entity
@Table(name="Turma")
public class Turma implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTurma", nullable = false)
    private Integer idTurma;
    
    @Column(name = "nome", unique = true, nullable = false, length = 45)
    private String nome;
    
    @OneToMany(mappedBy = "Turma", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_idTurma")
    private List<Aluno> alunos;

    public Turma() {
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.idTurma != null ? this.idTurma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.idTurma != other.idTurma && (this.idTurma == null || !this.idTurma.equals(other.idTurma))) {
            return false;
        }
        return true;
    }
    
}
