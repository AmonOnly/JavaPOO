package negocio;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.util.*;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import dados.*;

public class Sistema {
    private List<Professor> professores = new LinkedList<Professor>();
    private List<Diciplina> diciplinas = new LinkedList<Diciplina>();
    private List<Estudante> estudantes = new LinkedList<Estudante>();
    public int loginProfessor(String login){
        int k = -1;
        for(int i = 0;i < professores.size();i++){
            if(professores.get(i).getLogin().equals(login)){
                k = i;
                return k;
            }
        }
        return k;
    }
    public boolean senhaProfessor(String login, String senha){
        int k = loginProfessor(login);
        if(professores.get(k).getSenha().equals(senha)){
            return true;
        }
        return false;
    }

    public Professor retornoprof(String login, String senha){
        int k = loginProfessor(login);
        if(professores.get(k).getSenha().equals(senha)){
            return professores.get(k);
        }
        return null;
    }

    public List<Professor> getProfessores() {
        return this.professores;
    }
    public void setProfessores(Professor professores) {
        this.professores.add(professores);
    }
    public List<Diciplina> getDiciplinas() {
        return diciplinas;
    }
    public void setDiciplinas(Diciplina diciplinas) {
        this.diciplinas.add(diciplinas);
    }
    public List<Estudante> getEstudantes() {
        return estudantes;
    }
    public void setEstudantes(Estudante estudantes) {
        this.estudantes.add(estudantes);
    }

    public void matricularEstudante(Estudante estudante, Diciplina diciplina){
        estudante.matriculas(diciplina);
        diciplina.adicionarAluno(estudante);
    }
    public void adicionarNotas(Estudante estudante, Diciplina diciplina, Avaliacao avaliacao){
        estudante.adicionarNotas(diciplina, avaliacao);
    }

    public void adicionarAluno(Estudante estudante){
        estudantes.add(estudante);
    }
    public void adicionarDiciplina(Diciplina diciplina){
        diciplinas.add(diciplina);
    }
    public void adicionarProfessor(Professor professor){
        professores.add(professor);
    }
    public void removerDiciplina(Diciplina diciplina){
        for(int i = 0; i < diciplina.getAlunos().size();i++){
            diciplina.getAlunos().get(i).getMatriculadas().remove(diciplina);
            diciplina.getAlunos().get(i).getNotaDiciplina().remove(diciplina);
        }
        diciplina.getProfessor().getDiciplinas().remove(diciplina);
        diciplinas.remove(diciplina);
    }
    public void removerAlunotodas(Estudante aluno){
        for(int i = 0; i < aluno.getMatriculadas().size();i++){
            aluno.getMatriculadas().get(i).getAlunos().remove(aluno);
        }
        estudantes.remove(aluno);
    }
    public void removerAlunoUmm(Estudante aluno, Diciplina diciplina){
        aluno.getMatriculadas().remove(diciplina);
        aluno.getNotaDiciplina().remove(diciplina);
        diciplina.getAlunos().remove(aluno);
    }
    public void mediaMateria(Estudante aluno, Diciplina diciplina){
        double mediaF = aluno.mediaNota(diciplina);
        if(aluno.getMediaDiciplina().containsKey(diciplina)){
            aluno.getNotaDiciplina().remove(diciplina);
        }
        aluno.setMediaDiciplina(diciplina, mediaF);
    }
    public double exameNota(Estudante aluno, Diciplina diciplina){
        double mediaExame = 0;
        if(aluno.getMediaDiciplina().get(diciplina) >= 1.7 && aluno.getMediaDiciplina().get(diciplina) < 7 ){
            mediaExame = -1.5 * aluno.getMediaDiciplina().get(diciplina) + 12.5;
            return mediaExame;
        }
        else if(aluno.getMediaDiciplina().get(diciplina) < 1.7){
            mediaExame = -1;
            return mediaExame;
        }
        return mediaExame;
    }

    public void gerarPDFMedia(Estudante aluno){
        try {
            String dest = "Notas" + aluno.getCpf() + ".pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf);
            
            doc.add(new Paragraph("Nome do Aluno: " + aluno.getNome()));
            doc.add(new Paragraph("-\tCPF: " + aluno.getCpf()));
            doc.add(new Paragraph("-\tCurso: " + aluno.getCurso()));
            for (int i = 0; i < aluno.getMatriculadas().size(); i += 1) {
                doc.add(new Paragraph("-\tDisciplina: "
                        + aluno.getMatriculadas().get(i).getNome()));
                        doc.add(new Paragraph("-\t\tMédia Final: " + aluno.mediaNota(aluno.getMatriculadas().get(i)) ));
                        doc.add(new Paragraph("-\t\tNota para Exame: " + this.exameNota(aluno, aluno.getMatriculadas().get(i))));
            }
            doc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void exibirProfessor(){
        for(int i = 0; i < professores.size();i++){
            System.out.println("ID: "+ i + " "+ professores.get(i).toString()+"\n");
        }
    }
    public void exibirAlunos(){
        if(estudantes.size() == 0){
            System.out.println("Não há estudantes");
            return;
        }
        for(int i = 0; i < estudantes.size();i++){
            System.out.println("ID: "+ i + " "+ estudantes.get(i).toString()+"\n");
        }
    }
    public void exibirDiciplina(){
        if(diciplinas.size() == 0){
            System.out.println("Não há diciplinas");
            return;
        }
        for(int i = 0; i < diciplinas.size();i++){
            System.out.println("ID: "+ i + " "+ diciplinas.get(i).toString()+"\n");
        }
    }
    public void exibirDiciplinasProfessor(Professor professor){
        for(int i = 0; i < professor.getDiciplinas().size();i++){
            System.out.println("ID: "+ i + " "+ professor.getDiciplinas().get(i).getNome() + "\n");
        }
    }
    public void exibirDiciplinasAlunos(Estudante alunos){
        for(int i = 0; i < alunos.getMatriculadas().size();i++){
            System.out.println("ID: "+ i + " "+ alunos.getMatriculadas().get(i).getNome() + "\n");
        }
    }
    public void exibirAlunosDiciplinas(Diciplina diciplina){
        for(int i = 0; i < diciplina.getAlunos().size();i++){
            System.out.println("ID: "+ i + " "+ diciplina.getAlunos().get(i).getNome() + "\n");
        }
    }

    public void registroProfessor(String nome, String cpf, String login, String senha, String telefone){
        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setLogin(login);
        professor.setSenha(senha);
        professor.setTelefone(Integer.valueOf(telefone));
        setProfessores(professor);
    }
}
