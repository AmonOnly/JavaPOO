package apresentacao;
import dados.*;
import negocio.*;
import java.util.*;

public class Apresentacao {
    static Sistema sistema = new Sistema();
    static Scanner scan = new Scanner(System.in);
    public static void cadastroAluno(){
        Estudante aluno = new Estudante();

        System.out.println("Digite o nome do aluno:");
        String nome = scan.nextLine();
        aluno.setNome(nome);

        System.out.println("Digite o cpf do aluno:");
        String cpf = scan.nextLine();
        aluno.setCpf(cpf);

        System.out.println("Digite o email do aluno:");
        String email = scan.nextLine();
        aluno.setEmail(email);

        System.out.println("Digite o curso do estudante:");
        String curso = scan.nextLine();
        aluno.setCurso(curso);

        System.out.println("Digite o estado do estudante:");
        String status = scan.nextLine();
        aluno.setStatus(status);

        aluno.setIdAluno(sistema.getEstudantes().size());
        sistema.adicionarAluno(aluno);
    }

    public static void cadastroDiciplina(){
        Diciplina diciplina = new Diciplina();
        if(sistema.getProfessores().size() == 0){
            System.out.println("Não há professores para darem aula");
            return;
        }

        System.out.println("Digite o nome da diciplina:");
        String nome = scan.nextLine();
        diciplina.setNome(nome);

        System.out.println("Escolha o id do professor:");
        sistema.exibirProfessor();
        int idProfessor = Integer.parseInt(scan.nextLine());
        diciplina.setProfessor(sistema.getProfessores().get(idProfessor));
        sistema.getProfessores().get(idProfessor).setDiciplinas(diciplina);

        diciplina.setIdDiciplina(sistema.getDiciplinas().size());
        sistema.setDiciplinas(diciplina);
    }

    public static void cadastroProfessor(){
        Professor professor = new Professor();

        System.out.println("Digite o nome do professor:");
        String nome = scan.nextLine();
        professor.setNome(nome);

        System.out.println("Digite o cpf do professor:");
        String cpf = scan.nextLine();
        professor.setCpf(cpf);

        System.out.println("Digite o login do professor:");
        String login = scan.nextLine();
        professor.setLogin(login);

        System.out.println("Digite a senha do professor:");
        String senha = scan.nextLine();
        professor.setSenha(senha);

        System.out.println("Digite o telefone do professor:");
        int telefone = Integer.parseInt(scan.nextLine());
        professor.setTelefone(telefone);

        sistema.adicionarProfessor(professor);
    }

    public static Avaliacao novaAvaliacao(){
        Avaliacao avaliacao = new Avaliacao();

        System.out.println("Digite o nome para a avaliação:");
        String nome = scan.nextLine();
        avaliacao.setNome(nome);

        System.out.println("Digite a data da avaliação:");
        String data = scan.nextLine();
        avaliacao.setData(data);

        System.out.println("Digite a nota da avaliação:");
        double nota = Double.parseDouble(scan.nextLine());
        avaliacao.setNota(nota);

        System.out.println("Digite o peso da avaliação:");
        int peso = Integer.parseInt(scan.nextLine());
        avaliacao.setPeso(peso);

        return avaliacao;

    }

    public static void adicionarAlunoDiciplina(){

        if(sistema.getDiciplinas().size() == 0){
            System.out.println("Não há diciplinas");
            return;
        }
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Escolha a diciplina:");
        sistema.exibirDiciplina();
        int idDiciplina = Integer.parseInt(scan.nextLine());
        if(idDiciplina > sistema.getDiciplinas().size()){
            System.out.println("Não há está diciplinas");
            return;
        }

        System.out.println("Escolha o aluno para matricular na diciplina:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        if(idAluno > sistema.getEstudantes().size()){
            System.out.println("Não há este Estudante");
            return;
        }
        sistema.matricularEstudante(sistema.getEstudantes().get(idAluno),sistema.getDiciplinas().get(idDiciplina));

        System.out.println("Matriculas feitas\n");

    }

    public static void cadastrarAvaliacaoAluno(){
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        if(sistema.getDiciplinas().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Digite o Id do aluno:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        if(idAluno > sistema.getEstudantes().size()){
            System.out.println("Não há este Estudante");
            return;
        }
        System.out.println("Digite o Id da materia matriculada:");
        sistema.exibirDiciplinasAlunos(sistema.getEstudantes().get(idAluno));
        int idDiciplina = Integer.parseInt(scan.nextLine());
        if(idDiciplina > sistema.getEstudantes().get(idAluno).getMatriculadas().size()){
            System.out.println("Não há está diciplinas");
            return;
        }
        Avaliacao avaliacao = novaAvaliacao();

        sistema.adicionarNotas(sistema.getEstudantes().get(idAluno),sistema.getEstudantes().get(idAluno).getMatriculadas().get(idDiciplina), avaliacao);
        sistema.mediaMateria(sistema.getEstudantes().get(idAluno), sistema.getEstudantes().get(idAluno).getMatriculadas().get(idAluno));
        System.out.println("Nota Registrada");
    }

    public static void mostrarNotasAluno(){
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Digite o Id do aluno:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        if(idAluno > sistema.getEstudantes().size()){
            System.out.println("Não há este Estudante");
            return;
        }
        for(int i = 0; i < sistema.getEstudantes().get(idAluno).getMatriculadas().size();i++){
            System.out.println("ID: "+ i + " nome da diciplina: " + sistema.getEstudantes().get(idAluno).getMatriculadas().get(i).getNome() + 
            " Media: "+ sistema.getEstudantes().get(idAluno).mediaNota(sistema.getEstudantes().get(idAluno).getMatriculadas().get(i)) + "\n");
        }

    }

    public static void removerAlunoDoSistema(){
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Digite o Id do aluno:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        if(idAluno > sistema.getEstudantes().size()){
            System.out.println("Não há este Estudante");
            return;
        }
        sistema.removerAlunotodas(sistema.getEstudantes().get(idAluno));
        System.out.println("Remoção completa");
    }

    public static void removerAlunoDamateria(){
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        if(sistema.getDiciplinas().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Digite o Id do aluno:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        if(idAluno > sistema.getEstudantes().size()){
            System.out.println("Não há este Estudante");
            return;
        }
        System.out.println("Digite o Id da materia matriculada:");
        sistema.exibirDiciplinasAlunos(sistema.getEstudantes().get(idAluno));
        int idDiciplina = Integer.parseInt(scan.nextLine());
        if(idDiciplina > sistema.getEstudantes().get(idAluno).getMatriculadas().size()){
            System.out.println("Não há está diciplinas");
            return;
        }
        sistema.removerAlunoUmm(sistema.getEstudantes().get(idAluno), sistema.getEstudantes().get(idAluno).getMatriculadas().get(idDiciplina));
    }

    public static void removerDiciplina(){
        if(sistema.getDiciplinas().size() == 0){
            System.out.println("Não há diciplinas");
            return;
        }
        System.out.println("Escolha a diciplina:");
        sistema.exibirDiciplina();
        int idDiciplina = Integer.parseInt(scan.nextLine());
        if(idDiciplina > sistema.getDiciplinas().size()){
            System.out.println("Não há está diciplinas");
            return;
        }
        sistema.removerDiciplina(sistema.getDiciplinas().get(idDiciplina));
    }

    public static void gerarPDF(){
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Digite o Id do aluno:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        sistema.gerarPDFMedia(sistema.getEstudantes().get(idAluno));
    }

    public static void mostrarMediaExame(){
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        if(sistema.getDiciplinas().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Digite o Id do aluno:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        if(idAluno > sistema.getEstudantes().size()){
            System.out.println("Não há este Estudante");
            return;
        }
        System.out.println("Digite o Id da materia matriculada:");
        sistema.exibirDiciplinasAlunos(sistema.getEstudantes().get(idAluno));
        int idDiciplina = Integer.parseInt(scan.nextLine());
        if(idDiciplina > sistema.getEstudantes().get(idAluno).getMatriculadas().size()){
            System.out.println("Não há está diciplinas");
            return;
        }
        System.out.println(" Media: "+ sistema.exameNota(sistema.getEstudantes().get(idAluno),sistema.getEstudantes().get(idAluno).getMatriculadas().get(idDiciplina)));

    }
    
    public static void mostrarTudoAluno(){
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Digite o Id do aluno:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        if(idAluno > sistema.getEstudantes().size()){
            System.out.println("Não há este Estudante");
            return;
        }
        System.out.println(sistema.getEstudantes().get(idAluno).toStringComNotas());
    }

    public static void editarAluno(){
        if(sistema.getEstudantes().size() == 0){
            System.out.println("Não há alunos");
            return;
        }
        System.out.println("Digite o Id do aluno:");
        sistema.exibirAlunos();
        int idAluno = Integer.parseInt(scan.nextLine());
        if(idAluno > sistema.getEstudantes().size()){
            System.out.println("Não há este Estudante");
            return;
        }

        System.out.println("Escolha o que deseja editar:");
        menuEdicaoAluno();
        int idEdicao = -1;
        idEdicao = Integer.parseInt(scan.nextLine());
        switch(idEdicao){
            case 1:
                System.out.println("Digite o novo nome:");
                String nome = scan.nextLine();
                sistema.getEstudantes().get(idAluno).setNome(nome);
                break;
            case 2:
                System.out.println("Digite o novo CPF:");
                String cpf = scan.nextLine();
                sistema.getEstudantes().get(idAluno).setCpf(cpf);;
                break;
            case 3:
                System.out.println("Digite o novo Curso:");
                String curso = scan.nextLine();
                sistema.getEstudantes().get(idAluno).setCurso(curso);;
                break;
            case 4:
                System.out.println("Digite o novo Email:");
                String email = scan.nextLine();
                sistema.getEstudantes().get(idAluno).setEmail(email);;
                break;
            case 5:
                System.out.println("Digite o novo Status:");
                String estado = scan.nextLine();
                sistema.getEstudantes().get(idAluno).setStatus(estado);;
                break;
            case 0:
                return;
            default:
                System.out.println("Não há está opção");
            
        }

    }

    public static void editarDiciplina(){
        if(sistema.getDiciplinas().size() == 0){
            System.out.println("Não há diciplinas");
            return;
        }
        System.out.println("Escolha a diciplina:");
        sistema.exibirDiciplina();
        int idDiciplina = Integer.parseInt(scan.nextLine());
        if(idDiciplina > sistema.getDiciplinas().size()){
            System.out.println("Não há está diciplinas");
            return;
        }
        System.out.println("Escolha o que deseja editar:");
        menuEdicaoDiciplina();
        int idEdicao = -1;
        idEdicao = Integer.parseInt(scan.nextLine());
        switch(idEdicao){
            case 1:
                System.out.println("Digite o novo nome da diciplina:");
                String nome = scan.nextLine();
                sistema.getDiciplinas().get(idDiciplina).setNome(nome);
                break;
            case 2:
                System.out.println("Escolha o id do novo professor:");
                sistema.exibirProfessor();
                int idProfessor = Integer.parseInt(scan.nextLine());
                sistema.getDiciplinas().get(idDiciplina).setProfessor(sistema.getProfessores().get(idProfessor));
                sistema.getProfessores().get(sistema.getProfessores().indexOf(sistema.getDiciplinas().get(idDiciplina).getProfessor())).getDiciplinas().remove(sistema.getDiciplinas().get(idDiciplina));
                sistema.getProfessores().get(idProfessor).getDiciplinas().add(sistema.getDiciplinas().get(idDiciplina));
                break;
            default:
                System.out.println("Não há está opção");
        }
    }
    public static void menuEdicaoAluno(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Digite 1 para editar o nome");
        System.out.println("Digite 2 para editar o cpf");
        System.out.println("Digite 3 para editar o curso");
        System.out.println("Digite 4 para editar o email");
        System.out.println("Digite 5 para editar o estado do aluno");
        System.out.println("Digite 0 para sair");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void menuEdicaoDiciplina(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Digite 1 para editar o nome");
        System.out.println("Digite 2 para editar professor");
        System.out.println("Digite 0 para sair");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void login(){
        System.out.println("Digite o Login:");
        String login = scan.nextLine();
        if(sistema.loginProfessor(login)>= 0){
            System.out.println("Digite a senha:");
            String senha = scan.nextLine();
            if(sistema.senhaProfessor(login, senha)){
                System.out.println("Login foi um sucesso");
            }
        }
        else{
            System.out.println("Login falhou, indo para criar professor");
            cadastroProfessor();
        }

    }

    public static void menu(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Digite 1 para Criar novo aluno");
        System.out.println("Digite 2 para Criar nova diciplina");
        System.out.println("Digite 3 para Exibir todas as Diciplinas");
        System.out.println("Digite 4 para Exibir todos os alunos");
        System.out.println("Digite 5 para Adicionar um aluno a uma diciplina");
        System.out.println("Digite 6 para adicionar uma nota a um aluno");
        System.out.println("digite 7 para Gerar PDF de um aluno");
        System.out.println("digite 8 para mostrar as medias de um aluno");
        System.out.println("digite 9 para Remover um aluno do sistema");
        System.out.println("digite 10 para Remover um aluno de uma materia");
        System.out.println("digite 11 para Remover uma materia");
        System.out.println("digite 12 para Mostrar a nota para o exame");
        System.out.println("digite 13 para Mostrar tudo sobre aluno");
        System.out.println("digite 14 para editar um aluno");
        System.out.println("Digite 15 para editar uma diciplina");
        System.out.println("Digite 0 para sair");
        System.out.println("--------------------------------------------------------------------------------");
    }
    
    public static void main(String[] args) {
        int menu = -1;
        cadastroProfessor();
        login();
        while(menu != 0){
            menu();                default:
            System.out.println("Não há está opção");
            menu = Integer.parseInt(scan.nextLine());
            switch(menu){

                case 1:
                    cadastroAluno();
                    break;
                case 2:
                    cadastroDiciplina();
                    break;
                case 3:
                    sistema.exibirDiciplina();
                    break;
                case 4:
                    sistema.exibirAlunos();
                    break;
                case 5:
                    adicionarAlunoDiciplina();
                    break;
                case 6:
                    cadastrarAvaliacaoAluno();
                    break;
                case 7:
                    gerarPDF();
                    break;
                case 8:
                    mostrarNotasAluno();
                    break;
                case 9:
                    removerAlunoDoSistema();
                    break;
                case 10:
                    removerAlunoDamateria();
                    break;
                case 11:
                    removerDiciplina();
                    break;
                case 12:
                    mostrarMediaExame();
                    break;
                case 13:
                    mostrarTudoAluno();
                    break;
                case 14:
                    editarAluno();
                    break;
                case 15:
                    editarDiciplina();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Não há está opção");
            }

        }
    }
}
