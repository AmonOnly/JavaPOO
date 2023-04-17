package dados;

import java.util.*;;

public class Turma {
    private List<Aluno> alunos = new LinkedList<>();
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        this.ordenarAlunosPorMedia();

    }


    public void organize(Equipe<Aluno> equipe) {

        for(int i = 0; i < equipe.getLista().size()-1;i++ ){
            Aluno menor = equipe.getLista().get(i);
            for(int in = i; in < equipe.getLista().size();in++){
                if(menor.calcularMedia() > equipe.getLista().get(in).calcularMedia()){
                    equipe.getLista().set(i, equipe.getLista().get(in));
                    equipe.getLista().set(in, menor);
                    menor = equipe.getLista().get(i);
                }
            }
        }
    }
    public void organizeEquipe(List<Equipe<Aluno>> Grupo) {
        for(int i = 0; i < Grupo.size();i++ ){
            organize(Grupo.get(i));
        }
    }

    public void ordenarAlunosPorMedia() {
        Comparator<Aluno> comparador = new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return Double.compare(a2.calcularMedia(), a1.calcularMedia());
            }
        };

        Collections.sort(alunos, comparador);
    }

    public List<Equipe<Aluno>> separarEmEquipes() {
        if (this.alunos.size() < 3) {
            return null;
        }
        List<Aluno> aux = new LinkedList<>();
        aux.addAll(alunos);
        Random rand = new Random();
        List<Equipe<Aluno>> equipes = new LinkedList<>();
        int tamanhoEquipe, inicio, fim;
        for(int i = 0;!aux.isEmpty();i++){
            if(aux.size()<3){
                return equipes;
            }
            if(aux.size()%3 == 0){
                tamanhoEquipe = 3;
            }else{
                tamanhoEquipe = 4;
            }
            Equipe<Aluno> p = new Equipe<>();
            if(tamanhoEquipe == 3){
                inicio = rand.ints(1, 3).findFirst().getAsInt();
                if(inicio == 1){
                    fim = 2;
                }else{fim = 1;}
            }else{
                inicio = 2;
                fim = 2;
            }
            for(int in = 0; in<inicio;in++){
                p.getLista().add(aux.get(0));
                aux.remove(0);
            }
            for(int k = 0; k<fim;k++){
                p.getLista().add(aux.get(aux.size()-1));
                for(int ik = 0;ik < p.getLista().size();ik++){
                    System.out.println(p.getLista().get(ik).toString());
                }
                aux.remove(aux.size()-1);
            }
            if(aux.isEmpty()){
                organize(p);
                equipes.add(i, p);
                return equipes;
            }
            organize(p);
            equipes.add(i, p);
        }
        organizeEquipe(equipes);
        return equipes;
    }
}
