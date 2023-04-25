package desafio.dominio;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class Dev {
  private String nome;
  private LocalDate dataInscricao;

  private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
  private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

  public Dev() {
    this.dataInscricao = LocalDate.now().plusDays(new Random().nextInt(60));
  }

  public void inscreverBootcamp(Bootcamp bootcamp) {
    this.conteudosInscritos.addAll(bootcamp.getConteudos());
    bootcamp.getDevsInscritos().add(this);
  }

  // Método implementado como atividade de conclusçai do desafio proposto
  // Abstraindo um Bootcamp Usando Orientação a Objetos em Java

  public String prazo(Bootcamp bootcamp) {

    Period periodo = Period.between(dataInscricao, bootcamp.getDataFinal());
    if (periodo.getDays() > 0 && getConteudosConcluidos().size() == bootcamp.getConteudos().size()) {
      return "Parabéns, você já concluiu este bootcamp!";
    }
    if (periodo.getDays() < 0) {
      return "Prazo encerrado para a conclusão do bootcamp";
    } else if (periodo.getDays() == 0) {
      return "Hoje é o último dia para a conclusão do bootcamp";
    } else if (periodo.getDays() < 10) {
      return "Atenção, restam " + periodo.getDays() + "dia(s) para encerrar o prazo de conclusão do bootcamp";
    } else {
      return "Espero que esteja aproveitando a jornada";
    }
  };

  // ==========================================================================

  public void progredir() {
    Optional<Conteudo> conteudo = this.conteudosInscritos.stream()
        .findFirst();
    if (conteudo.isPresent()) {
      this.conteudosConcluidos.add(conteudo.get());
      this.conteudosInscritos.remove(conteudo.get());
    } else {
      System.err.println("Você não está matriculado em nenhum conteúdo");
    }

  }

  public double calcularTotalXp() {
    return this.conteudosConcluidos.stream()
        .mapToDouble(Conteudo::calcularXp)
        .sum();
  }

  public LocalDate getDataInscricao() {
    return dataInscricao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Conteudo> getConteudosInscritos() {
    return conteudosInscritos;
  }

  public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
    this.conteudosInscritos = conteudosInscritos;
  }

  public Set<Conteudo> getConteudosConcluidos() {
    return conteudosConcluidos;
  }

  public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
    this.conteudosConcluidos = conteudosConcluidos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((conteudosInscritos == null) ? 0 : conteudosInscritos.hashCode());
    result = prime * result + ((conteudosConcluidos == null) ? 0 : conteudosConcluidos.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Dev other = (Dev) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (conteudosInscritos == null) {
      if (other.conteudosInscritos != null)
        return false;
    } else if (!conteudosInscritos.equals(other.conteudosInscritos))
      return false;
    if (conteudosConcluidos == null) {
      if (other.conteudosConcluidos != null)
        return false;
    } else if (!conteudosConcluidos.equals(other.conteudosConcluidos))
      return false;
    return true;
  }

}
