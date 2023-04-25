import java.time.LocalDate;

import desafio.dominio.Bootcamp;
import desafio.dominio.Curso;
import desafio.dominio.Dev;
import desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descricao curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev1 = new Dev();
        dev1.setNome("fulano");

        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteudo inscritos:" + dev1.getNome() + " " + " " + dev1.getConteudosInscritos());
        System.out.println("------------------------------");

        dev1.progredir();
        dev1.progredir();
        System.out.println("Conteudo inscritos:" + dev1.getNome() + " " + " " + dev1.getConteudosInscritos());
        System.out.println("Conteudo concluidos:" + dev1.getNome() + " " + " " + dev1.getConteudosConcluidos());
        System.out.println("------------------------------");
        System.out.println("Total XP: " + dev1.getNome() + " " + dev1.calcularTotalXp());
        System.out.println("------------------------------");
        System.out.println("Data de inscrição: " + dev1.getDataInscricao() + " Data limite para conclusão: "
                + bootcamp.getDataFinal());
        System.out.println(dev1.prazo(bootcamp));

        System.out.println("============================");

        Dev dev2 = new Dev();
        dev2.setNome("ciclano");

        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteudo inscritos:" + dev2.getNome() + " " + " " + dev2.getConteudosInscritos());
        System.out.println("------------------------------");

        dev2.progredir();
        System.out.println("Conteudo inscritos:" + dev2.getNome() + " " + " " + dev2.getConteudosInscritos());
        System.out.println("Conteudo concluidos:" + dev2.getNome() + " " + " " + dev2.getConteudosConcluidos());
        System.out.println("------------------------------");
        System.out.println("Total XP: " + dev2.getNome() + " " + dev2.calcularTotalXp());
        System.out.println("------------------------------");
        System.out.println("Data de inscrição: " + dev2.getDataInscricao() + " Data limite para conclusão: "
                + bootcamp.getDataFinal());
        System.out.println(dev2.prazo(bootcamp));
        System.out.println("============================");
    }
}
