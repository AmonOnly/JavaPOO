package apresentacao;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dados.Diciplina;
import dados.Professor;
import javax.swing.table.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import negocio.Sistema;
import dados.*;


public class AreaProfessor extends JFrame{
    //-------------------------------------------Painel-------------------------------------------
    private Sistema sistema = new Sistema();
    private Professor profLogado;
    private JTabbedPane areaProfessor = new JTabbedPane();

    private JPanel menu = new JPanel();
    private JPanel materias = new JPanel();
    private JPanel infoMateriasPanel = new JPanel();
    private JPanel infoAlunoPanel = new JPanel();
    private JPanel todosAluno = new JPanel();

    //-------------------------------------------Button-------------------------------------------
    private JButton areaMaterias = new JButton("Minhas Materias");
    private JButton adicionarMateria = new JButton("Adicionar nova Materia");
    private JButton atualizar = new JButton("Atualizar");
    private JButton atualizarAluno = new JButton("Atualizar");
    private JButton atualizarNota = new JButton("Atualizar");
    private JButton adicionarAluno = new JButton("Adicionar novo Aluno");
    private JButton exibirInfo = new JButton("Exibir mais info");
    private JButton excluirMateria = new JButton("Excluir materia");
    private JButton excluirAluno = new JButton("Excluir aluno");
    private JButton exibirInfoAluno = new JButton("Exibir mais info");
    private JButton settarmodificações = new JButton("Salvar modificações");
    private JButton atualizarInfoAluno = new JButton("Atualizar informações");
    private JButton adicionarNota = new JButton("Adicionar nova Nota");
    private JButton adicionarMateriaNova = new JButton("Matricular em Materias");
    private JButton pdfButton = new JButton("Gerar PDF");
    private JButton atualizarTodosAluno = new JButton("Atualizar");
    private JButton TodosAlunosButton = new JButton("Todos os Alunos");

    //-------------------------------------------Label-------------------------------------------
    private JLabel idTexto = new JLabel("Digite o ID da Materia para:");
    private JLabel idTextoAluno = new JLabel("Digite o ID do aluno para:");
    private JLabel nomeProfessor = new JLabel("Professor logado: ");
    private JLabel nomeMateria = new JLabel("Nome da Materia");
    private JLabel profLabel = new JLabel("Professor");
    private JLabel nomeLabel = new JLabel("Nome:");
    private JLabel cpfLabel = new JLabel("CPF:");
    private JLabel emailLabel = new JLabel("E-mail:");
    private JLabel cursoLabel = new JLabel("Curso:");
    private JLabel statusLabel = new JLabel("Status:");

    //-------------------------------------------TextField-------------------------------------------
    private JTextField idTextField = new JTextField();
    private JTextField idAlunoTextField = new JTextField();
    private JTextField nomeMaTextField = new JTextField();
    private JTextField nomeField = new JTextField(20);
    private JTextField cpfField = new JTextField(20);
    private JTextField emailField = new JTextField(20);
    private JTextField cursoField = new JTextField(20);
    private JTextField idAlunoTextTodosField = new JTextField();

    //-------------------------------------------Table-------------------------------------------
    private DefaultTableModel model;
    private JTable materiaTable = new JTable();
    private DefaultTableModel model2;
    private JTable alunosTable = new JTable();
    private DefaultTableModel model3;
    private JTable notasTable = new JTable();
    private DefaultTableModel model4;
    private JTable todosalunosTable = new JTable();

    //-------------------------------------------Scroll-------------------------------------------
    private JScrollPane Scrollalunos = new JScrollPane();
    private JScrollPane ScrollMateria = new JScrollPane();
    private JScrollPane ScrollNotas = new JScrollPane();
    private JScrollPane ScrollTodosAlunos = new JScrollPane();
    
     //-------------------------------------------Aleatorio-------------------------------------------
    private int idDiciplina;
    private int idAluno;
    private JComboBox<String> professorComboBox;
    private JComboBox<String> statusComboBox;
    List<Avaliacao> notas;


    public void setProfessorLogado(Professor professor){
        this.profLogado = professor;
        nomeProfessor.setText("");
        nomeProfessor.setText("Professor logado: " + profLogado.getNome());
        nomeProfessor.setBounds(20,10,200,60);
        menu.add(nomeProfessor);
        sistema.adicionarProfessor(profLogado);
    }
    
    public JPanel getMenu(){
        return this.menu;
    }
    
    private void model(int idDiciplina){

        for (int i = 0; i < profLogado.getDiciplinas().get(idDiciplina).getAlunos().size();i++) {
            model2.addRow(new Object[]{i,profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(i).getNome(),
                profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(i).getCpf(),
                profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(i).getCurso(),
                profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(i).getStatus()});
        }

        nomeMaTextField.setText(profLogado.getDiciplinas().get(idDiciplina).getNome());
    
    }
    
    private void model4(){

        for (int i = 0; i < sistema.getEstudantes().size();i++) {
            model4.addRow(new Object[]{i,sistema.getEstudantes().get(i).getNome(),
                sistema.getEstudantes().get(i).getCpf(),
                sistema.getEstudantes().get(i).getCurso(),
                sistema.getEstudantes().get(i).getStatus()});
        }

    
    }
    
    public AreaProfessor(){
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leodu\\Downloads\\GerenciadorDeNotasVisual\\GerenciadorDeNotasV2\\FV6bxcMagAArxPI.jpg");
        this.setIconImage(icon);
        setTitle("Gerenciador de Notas");
        setBounds(100,100, 700, 700);
        this.add(areaProfessor);
        areaProfessor.setBounds(100,100, 700, 700);
        areaProfessor.add("Menu Principal",menu);
        this.setVisible(true);
        //-------------------------------------------Menu-------------------------------------------
        menu();
        TodosAlunosButton.setBounds(100,120, 175, 20);
        menu.add(TodosAlunosButton);
        TodosAlunosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaProfessor.add("Todos os Alunos",todosAluno);
                model4();
                sistema.exibirAlunos();
            }
        });
        //-------------------------------------MinhasMaterias------------------------------------------
        MinhasMaterias();
        //-------------------------------------MateriaPage------------------------------------------
        materiaPage();
        //-------------------------------------AlunoPanel------------------------------------------
        AlunoPanel();
        //-------------------------------------TodosAlunos------------------------------------------
        todososAlunos();



    }


    private void menu(){
        menu.setLayout(null);
        areaMaterias.setBounds(100,90, 150, 20);
        menu.add(areaMaterias);
        areaMaterias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaProfessor.add("Materias",materias);
                JLabel ordemLabelMaterias = new JLabel(profLogado.getNome() + " -> " + "Minhas Materias");
                ordemLabelMaterias.setBounds(10,-15,200,60);
                materias.add(ordemLabelMaterias);
                refreshTableAlunos();
                refreshTableNotas();
                refreshTableMaterias();
            }
        });

        
        adicionarAluno.setBounds(100,150, 175, 20);
        menu.add(adicionarAluno);
        adicionarAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdicionarAlunoDialog(null);
                refreshTableAlunos();
                refreshTableNotas();
                refreshTableMaterias();
            }
        });
    }

    private void MinhasMaterias(){
        materias.setLayout(null);
        String[] materiasColunas = {"ID","Materia","Quantidade Alunos", "Professor"};
        Object[][] data = {
        };

        model = new DefaultTableModel(data,materiasColunas);
        materiaTable.setModel(model);
        ScrollMateria.add(materiaTable);
        ScrollMateria.setBounds(30,30, 400,500);
        ScrollMateria.setViewportView(materiaTable);
        materias.add(ScrollMateria);

        atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTableMaterias();
            }
        });

        adicionarMateria.setBounds(30,550, 175, 20);
        materias.add(adicionarMateria);
        adicionarMateria.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent arg0){
                String nome = JOptionPane.showInputDialog("Digite o nome da Materia");
                Diciplina auxiliar = new Diciplina();
                auxiliar.setNome(nome);
                auxiliar.setProfessor(profLogado);
                sistema.setDiciplinas(auxiliar);
                sistema.exibirDiciplinasProfessor(profLogado);
                model.addRow(new Object[]{profLogado.getDiciplinas().size(),nome,auxiliar.getAlunos().size(),auxiliar.getProfessor().getNome()});
                profLogado.setDiciplinas(auxiliar);
                refreshTableMaterias();
            }
        });
        atualizar.setBounds(30,590, 175, 20);
        atualizar.addActionListener(e -> refreshTableMaterias());
        materias.add(atualizar);

        idTexto.setBounds(450,30, 175, 20);
        materias.add(idTexto);

        idTextField.setBounds(450,50, 75, 20);
        materias.add(idTextField);

        exibirInfo.setBounds(450,80, 175, 20);
        materias.add(exibirInfo);
        exibirInfo.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent arg0){
                idDiciplina = Integer.valueOf(idTextField.getText());
                areaProfessor.remove(infoMateriasPanel);
                areaProfessor.add(profLogado.getDiciplinas().get(idDiciplina).getNome(),infoMateriasPanel);
                JLabel ordemLabelMaterias = new JLabel(profLogado.getNome() + " -> " + "Minhas Materias" +" -> " + profLogado.getDiciplinas().get(idDiciplina).getNome());
                ordemLabelMaterias.setBounds(10,-15,200,60);
                infoMateriasPanel.add(ordemLabelMaterias);
                model(idDiciplina);
                sistema.exibirProfessor();
                refreshTableAlunos();
                refreshTableNotas();
                refreshTableMaterias();
            }
        });

        excluirMateria.setBounds(450,110, 175, 20);
        materias.add(excluirMateria);
        excluirMateria.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent arg0){
                idDiciplina = Integer.valueOf(idTextField.getText());
                sistema.removerDiciplina(profLogado.getDiciplinas().get(idDiciplina));
                refreshTableMaterias();
            }
        });

    }
    
    private void materiaPage(){
        infoMateriasPanel.setLayout(null);

        String[] alunosColunas = {"ID","Nome","CPF", "Curso","Status"};
        Object[][] dataAlunos = {
        };

        model2 = new DefaultTableModel(dataAlunos,alunosColunas);
        alunosTable.setModel(model2);
        Scrollalunos.add(alunosTable);
        Scrollalunos.setBounds(30,65, 400,500);
        Scrollalunos.setViewportView(alunosTable);
        infoMateriasPanel.add(Scrollalunos);

        idAlunoTextField.setBounds(450,80, 75, 20);
        infoMateriasPanel.add(idAlunoTextField);

        atualizarAluno.setBounds(30,580, 175, 20);
        atualizarAluno.addActionListener(e -> refreshTableAlunos());
        infoMateriasPanel.add(atualizarAluno);

        nomeMateria.setBounds(30,-5,300,60);
        infoMateriasPanel.add(nomeMateria);

        nomeMaTextField.setBounds(30,35, 75, 20);
        infoMateriasPanel.add(nomeMaTextField);

        String[] arrayprof = {"Prof1","prof2"};
        professorComboBox = new JComboBox<>(arrayprof);
        professorComboBox.setBounds(190,35,150,18);
        infoMateriasPanel.add(professorComboBox);

        profLabel.setBounds(190,-5,300,60);
        infoMateriasPanel.add(profLabel);

        idTextoAluno.setBounds(450,60, 200, 20);
        infoMateriasPanel.add(idTextoAluno);

        excluirAluno.setBounds(450,140, 175, 20);
        infoMateriasPanel.add(excluirAluno);
        excluirAluno.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent arg0){
                idAluno = Integer.valueOf(idAlunoTextField.getText());
                sistema.removerAlunoUmm(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno),
                profLogado.getDiciplinas().get(idDiciplina));
                refreshTableAlunos();
                refreshTableNotas();
                refreshTableMaterias();
            }
        });

        exibirInfoAluno.setBounds(450,110, 175, 20);
        infoMateriasPanel.add(exibirInfoAluno);
        exibirInfoAluno.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent arg0){
                idAluno = Integer.valueOf(idAlunoTextField.getText());
                areaProfessor.remove(infoAlunoPanel);
                areaProfessor.add(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getNome(),infoAlunoPanel);
                JLabel ordemLabelMaterias = new JLabel(profLogado.getNome() + " -> " + "Minhas Materias" +" -> " + profLogado.getDiciplinas().get(idDiciplina).getNome() + " -> "
                + profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getNome());
                ordemLabelMaterias.setBounds(10,-15,300,60);
                infoAlunoPanel.add(ordemLabelMaterias);
                notas = profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getNotaDiciplina().get(profLogado.getDiciplinas().get(idDiciplina));
                for(int i = 0; i < notas.size();i++){
                    model3.addRow(new Object[]{notas.get(i).getNome(),notas.get(i).getNota(),notas.get(i).getData()});
                }
                nomeField.setText(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getNome());
                cpfField.setText(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getCpf());
                emailField.setText(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getEmail());
                cursoField.setText(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getCurso());
                statusComboBox.setSelectedItem(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getStatus());

                refreshTableAlunos();
                refreshTableNotas();
                refreshTableMaterias();
            }
        });

        settarmodificações.setBounds(250,580, 175, 20);
        infoMateriasPanel.add(settarmodificações);
        settarmodificações.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent arg0){
                profLogado.getDiciplinas().get(idDiciplina).setNome(nomeMaTextField.getText());
                refreshTableAlunos();
                refreshTableNotas();
                refreshTableMaterias();
            }
        });
    }

private void AlunoPanel(){
    infoAlunoPanel.setLayout(null);

    String[] notasColunas = {"Nome","Nota","Data"};
    Object[][] datanotas = {
    };

    model3 = new DefaultTableModel(datanotas,notasColunas);
    notasTable.setModel(model3);
    ScrollNotas.add(notasTable);
    ScrollNotas.setBounds(30,250, 450,300);
    ScrollNotas.setViewportView(notasTable);
    infoAlunoPanel.add(ScrollNotas);

    atualizarInfoAluno.setBounds(30,220, 175, 20);
    infoAlunoPanel.add(atualizarInfoAluno);
    atualizarInfoAluno.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            String email = emailField.getText();
            String curso = cursoField.getText();
            String status = (String) statusComboBox.getSelectedItem();
            Estudante aluno = profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno);
            aluno.setCpf(cpf);
            aluno.setCurso(curso);
            aluno.setEmail(email);
            aluno.setNome(nome);
            aluno.setStatus(status);
            refreshTableAlunos();
            refreshTableNotas();
            refreshTableMaterias();
        }
    });

    adicionarNota.setBounds(495,250, 175, 20);
    infoAlunoPanel.add(adicionarNota);
    adicionarNota.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new AdicionarNotaDialog(null);
            refreshTableAlunos();
            refreshTableNotas();
            refreshTableMaterias();
        }
    });

    String[] statusOptions = {"Ativo", "Inativo"};
    statusComboBox = new JComboBox<>(statusOptions);

    nomeLabel.setBounds(30,30, 175, 20);
    infoAlunoPanel.add(nomeLabel);
    nomeField.setBounds(30,50, 175, 20);
    infoAlunoPanel.add(nomeField);

    cpfLabel.setBounds(30,70, 175, 20);
    infoAlunoPanel.add(cpfLabel);
    cpfField.setBounds(30,90, 175, 20);
    infoAlunoPanel.add(cpfField);

    emailLabel.setBounds(30,110, 175, 20);
    infoAlunoPanel.add(emailLabel);
    emailField.setBounds(30,130, 175, 20);
    infoAlunoPanel.add(emailField);

    cursoLabel.setBounds(245,30, 175, 20);
    infoAlunoPanel.add(cursoLabel);
    cursoField.setBounds(245,50, 175, 20);
    infoAlunoPanel.add(cursoField);

    statusLabel.setBounds(245,70, 175, 20);
    infoAlunoPanel.add(statusLabel);
    statusComboBox.setBounds(245,90, 175, 20);
    infoAlunoPanel.add(statusComboBox);
    
    atualizarNota.setBounds(30,580, 175, 20);
    atualizarAluno.addActionListener(e -> refreshTableNotas());
    infoAlunoPanel.add(atualizarNota);

    adicionarMateriaNova.setBounds(245,580, 175, 20);
    adicionarMateriaNova.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new MatricularAlunoDialog(null);
            refreshTableAlunos();
            refreshTableNotas();
            refreshTableMaterias();
        }
    });
    infoAlunoPanel.add(adicionarMateriaNova);

}

private void todososAlunos(){
    todosAluno.setLayout(null);

    String[] alunosColunas = {"ID","Nome","CPF", "Curso","Status"};
    Object[][] dataAlunos = {
    };

    model4 = new DefaultTableModel(dataAlunos,alunosColunas);
    todosalunosTable.setModel(model4);
    ScrollTodosAlunos.add(todosalunosTable);
    ScrollTodosAlunos.setBounds(30,65, 400,500);
    ScrollTodosAlunos.setViewportView(todosalunosTable);
    todosAluno.add(ScrollTodosAlunos);

    idAlunoTextTodosField.setBounds(450,80, 75, 20);
    todosAluno.add(idAlunoTextTodosField);

    pdfButton.setBounds(230,580, 175, 20);
    todosAluno.add(pdfButton);
    pdfButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println(sistema.getEstudantes().get(Integer.valueOf(idAlunoTextTodosField.getText())).toStringComNotas());
            sistema.mediaMateria(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno), profLogado.getDiciplinas().get(idDiciplina));
            sistema.gerarPDFMedia(sistema.getEstudantes().get(0));
        }
    });

    atualizarTodosAluno.setBounds(30,580, 175, 20);
    atualizarTodosAluno.addActionListener(e -> refreshTableAlunos());
    todosAluno.add(atualizarTodosAluno);
}

private void refreshTableNotas() {

    // Limpa o modelo da tabela
    model3.setRowCount(0);

    // Preenche o modelo com os novos dados
    notas = profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno).getNotaDiciplina().get(profLogado.getDiciplinas().get(idDiciplina));
    for(int i = 0; i < notas.size();i++){
        model3.addRow(new Object[]{notas.get(i).getNome(),notas.get(i).getNota(),notas.get(i).getData()});
    }
}

private void refreshTableMaterias() {


        model.setRowCount(0);


        for (int i = 0; i < profLogado.getDiciplinas().size();i++) {
            model.addRow(new Object[]{i,profLogado.getDiciplinas().get(i).getNome(),profLogado.getDiciplinas().get(i).getAlunos().size(),profLogado.getNome()});
        }
    }
    
    private void refreshTableAlunos() {


        model2.setRowCount(0);

        for (int i = 0; i < profLogado.getDiciplinas().get(idDiciplina).getAlunos().size();i++) {
            model2.addRow(new Object[]{i,profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(i).getNome(),
                profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(i).getCpf(),
                profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(i).getCurso(),
                profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(i).getStatus()});
        }
    }
    
    class MatricularAlunoDialog extends JDialog {
        private JButton adicionarButton;
        private JCheckBox[] materiasCheckBoxes;
    
        public MatricularAlunoDialog(JFrame parent) {
            super(parent, "Adicionar Aluno", true);
    

            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(400, 400);
            setLocationRelativeTo(parent);

            JLabel materiasLabel = new JLabel("Matérias:");

            materiasCheckBoxes = new JCheckBox[profLogado.getDiciplinas().size()];
            for (int i = 0; i < profLogado.getDiciplinas().size(); i++) {
                materiasCheckBoxes[i] = new JCheckBox(profLogado.getDiciplinas().get(i).getNome());    
                materiasCheckBoxes[i].setSelected(true);
            }
    
            adicionarButton = new JButton("Adicionar");
            adicionarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    adicionarAluno();
                }
            });

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);


            gbc.gridx = 0;
            gbc.gridy++;
            add(materiasLabel, gbc);
    
            gbc.gridy++;
            gbc.gridwidth = 2;
            for (int i = 0; i < materiasCheckBoxes.length; i++) {
                add(materiasCheckBoxes[i], gbc);
                gbc.gridy++;
            }
    
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            add(adicionarButton, gbc);
    
            setVisible(true);
        }
    
        private void adicionarAluno() {
            Estudante aluno = profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno);
            for (int i = 0; i < materiasCheckBoxes.length; i++) {
                if (materiasCheckBoxes[i].isSelected()) {
                    sistema.matricularEstudante(aluno,profLogado.getDiciplinas().get(i));
                }
            }

            sistema.exibirAlunos();
            sistema.exibirDiciplinasAlunos(aluno);
    
            JOptionPane.showMessageDialog(this, "Aluno matriculado com sucesso!");
    

            dispose();
        }
    }

    class AdicionarAlunoDialog extends JDialog {
        private JTextField nomeField;
        private JTextField cpfField;
        private JTextField emailField;
        private JTextField cursoField;
        private JComboBox<String> statusComboBox;
        private JButton adicionarButton;
        private JCheckBox[] materiasCheckBoxes;
    
        public AdicionarAlunoDialog(JFrame parent) {
            super(parent, "Adicionar Aluno", true);
    
            // Configurações básicas do JDialog
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(400, 400);
            setLocationRelativeTo(parent);
    
            // Criação dos componentes
            JLabel nomeLabel = new JLabel("Nome:");
            nomeField = new JTextField(20);
    
            JLabel cpfLabel = new JLabel("CPF:");
            cpfField = new JTextField(20);
    
            JLabel emailLabel = new JLabel("E-mail:");
            emailField = new JTextField(20);
    
            JLabel cursoLabel = new JLabel("Curso:");
            cursoField = new JTextField(20);
    
            JLabel statusLabel = new JLabel("Status:");
            String[] statusOptions = {"Ativo", "Inativo"};
            statusComboBox = new JComboBox<>(statusOptions);

            JLabel materiasLabel = new JLabel("Matérias:");

            materiasCheckBoxes = new JCheckBox[profLogado.getDiciplinas().size()];
            for (int i = 0; i < profLogado.getDiciplinas().size(); i++) {
                materiasCheckBoxes[i] = new JCheckBox(profLogado.getDiciplinas().get(i).getNome());
                materiasCheckBoxes[i].setSelected(true);
            }
    
            adicionarButton = new JButton("Adicionar");
            adicionarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    adicionarAluno();
                }
            });
    
            // Configuração do layout
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);
    
            // Adiciona os componentes ao JDialog
            add(nomeLabel, gbc);
            gbc.gridx++;
            add(nomeField, gbc);
    
            gbc.gridx = 0;
            gbc.gridy++;
            add(cpfLabel, gbc);
            gbc.gridx++;
            add(cpfField, gbc);
    
            gbc.gridx = 0;
            gbc.gridy++;
            add(emailLabel, gbc);
            gbc.gridx++;
            add(emailField, gbc);
    
            gbc.gridx = 0;
            gbc.gridy++;
            add(cursoLabel, gbc);
            gbc.gridx++;
            add(cursoField, gbc);
    
            gbc.gridx = 0;
            gbc.gridy++;
            add(statusLabel, gbc);
            gbc.gridx++;
            add(statusComboBox, gbc);
            
            gbc.gridx = 0;
            gbc.gridy++;
            add(materiasLabel, gbc);
    
            gbc.gridy++;
            gbc.gridwidth = 2;
            for (int i = 0; i < materiasCheckBoxes.length; i++) {
                add(materiasCheckBoxes[i], gbc);
                gbc.gridy++;
            }
    
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            add(adicionarButton, gbc);
    
            setVisible(true);
        }
    
        private void adicionarAluno() {
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            String email = emailField.getText();
            String curso = cursoField.getText();
            String status = (String) statusComboBox.getSelectedItem();
            Estudante aluno = new Estudante();
            aluno.setCpf(cpf);
            aluno.setCurso(curso);
            aluno.setEmail(email);
            aluno.setNome(nome);
            aluno.setStatus(status);
            for (int i = 0; i < materiasCheckBoxes.length; i++) {
                if (materiasCheckBoxes[i].isSelected()) {
                    sistema.matricularEstudante(aluno,profLogado.getDiciplinas().get(i));
                    // Adicione a lógica para lidar com a matéria selecionada, como associá-la ao aluno
                }
            }
    
            // Aqui você pode criar um novo objeto Aluno com as informações inseridas
            // e adicioná-lo à sua lista de alunos ou fazer qualquer outra ação necessária
            sistema.adicionarAluno(aluno);
            sistema.exibirAlunos();
            sistema.exibirDiciplinasAlunos(aluno);
    
            JOptionPane.showMessageDialog(this, "Aluno adicionado com sucesso!");
    
            // Fecha o diálogo após adicionar o aluno
            dispose();
        }
    }
    
    public class AdicionarNotaDialog extends JDialog {

        private JTextField nomeField;
        private JTextField pesoField;
        private JFormattedTextField textFieldData;
        private JTextField textFieldNota;
        private JButton adicionarButton;
    
        public AdicionarNotaDialog(JFrame parent) {
            super(parent, "Adicionar Nota", true);
    
            // Configurações básicas do JDialog
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(400, 200);
            setLocationRelativeTo(parent);
    
            // Criação dos componentes
            JLabel nomeLabel = new JLabel("Nome:");
            nomeField = new JTextField(20);

            JLabel labelNota = new JLabel("Nota:");
            textFieldNota = new JTextField(10);
    
            JLabel pesoLabel = new JLabel("Peso:");
            pesoField = new JTextField(20);
    
            JLabel labelData = new JLabel("Data (dd/MM/yyyy):");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            textFieldData = new JFormattedTextField(dateFormat);
            textFieldData.setColumns(10);
    
            adicionarButton = new JButton("Adicionar");
            adicionarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    adicionarNota();
                }
            });
    
            // Configuração do layout
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);
    
            // Adiciona os componentes ao JDialog
            add(nomeLabel, gbc);
            gbc.gridx++;
            add(nomeField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(labelNota, gbc);
            gbc.gridx++;
            add(textFieldNota, gbc);
    
            gbc.gridx = 0;
            gbc.gridy++;
            add(pesoLabel, gbc);
            gbc.gridx++;
            add(pesoField, gbc);
    
            gbc.gridx = 0;
            gbc.gridy++;
            add(labelData,gbc);
            gbc.gridx++;
            add(textFieldData, gbc);
    
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            add(adicionarButton, gbc);
    
            setVisible(true);
        }
    
        private void adicionarNota() {
            String nome = nomeField.getText();
            int peso = Integer.valueOf(pesoField.getText());
            Date data = (Date) textFieldData.getValue();;
            double nota = Double.valueOf(textFieldNota.getText());
            Avaliacao notanova = new Avaliacao();
            notanova.setData(data);
            notanova.setNome(nome);
            notanova.setNota(nota);
            notanova.setPeso(peso);
    
            // Lógica para adicionar a nota ao sistema ou fazer o que for necessário com os dados
            sistema.adicionarNotas(profLogado.getDiciplinas().get(idDiciplina).getAlunos().get(idAluno),profLogado.getDiciplinas().get(idDiciplina),notanova);
            // Fecha o diálogo após adicionar a nota
            dispose();
        }
}
}