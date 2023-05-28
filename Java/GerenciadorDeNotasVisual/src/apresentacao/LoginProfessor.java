package apresentacao;
import javax.swing.*;

import dados.Professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocio.Sistema;

public class LoginProfessor extends JFrame {
    public static void main(String[] args) {
        LoginProfessor frame = new LoginProfessor();
        frame.setVisible(false);
    }
    AreaProfessor areaProfessor = new AreaProfessor();
    private JTabbedPane tabbedPane = new JTabbedPane();

    private JPanel painel = new JPanel();
    private JPanel painelRegistro = new JPanel();
    private JLabel infologin = new JLabel("Usuario:");
    private JTextField usuarioField = new JTextField();
    private JLabel infoSenha = new JLabel("Senha:");
    private JTextField senhaField = new JPasswordField();
    private JButton login = new JButton("Login");
    private JButton primeira = new JButton("Primeiro acesso?");
    private Sistema sistema = new Sistema();
    private JLabel nome = new JLabel("Nome:");
    private JLabel cpf = new JLabel("CPF:");
    private JLabel loginR = new JLabel("Login:");
    private JLabel senhaR = new JLabel("Senha:");
    private JLabel telefone = new JLabel("Telefone: ZAP BB");
    private JTextField nomeT = new JTextField();
    private JTextField cpfT = new JTextField();
    private JTextField loginT = new JTextField();
    private JTextField SenhaT = new JTextField();
    private JTextField telefoneT = new JTextField(); 
    private JButton registro = new JButton("Registrar :)");
    private JButton logout = new JButton("Logout");
    public Professor professor = new Professor();



    public LoginProfessor(){
        logout.setBounds(570,600,100, 18);
        areaProfessor.getMenu().add(logout);
        logout.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent arg0){
                areaProfessor.setVisible(false);
                setVisible(true);
            }
        });

        setTitle("Gerenciador de Notas");
        setBounds(100,100, 300, 500);
        this.add(tabbedPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabbedPane.setBounds(100,100, 300, 500);
        tabbedPane.add("Login",painel);
        painel.setLayout(null);
        painelRegistro.setLayout(null);

        infologin.setBounds(125, 125, 200, 15);
        painel.add(infologin);

        usuarioField.setBounds(65,145, 175, 20);
        painel.add(usuarioField);

        infoSenha.setBounds(130, 185, 200, 15);
        painel.add(infoSenha);

        senhaField.setBounds(65,205, 175, 20);
        painel.add(senhaField);

        login.setBounds(100, 240, 100, 18);
        painel.add(login);
        login.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent arg0){
                if(sistema.senhaProfessor(usuarioField.getText(),senhaField.getText())){
                    setVisible(false);
                    areaProfessor.setProfessorLogado(sistema.retornoprof(usuarioField.getText(),senhaField.getText()));
                    usuarioField.setText("");
                    senhaField.setText("");
                    areaProfessor.setVisible(true);
                }else{
                    System.out.println("Não deu bom");
                }
            }
        });

        primeira.setBounds(75, 270, 150, 18);
        painel.add(primeira);
        primeira.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent arg0){
                tabbedPane.add("Registro",painelRegistro);
                tabbedPane.setSelectedIndex(1);
            }
        });

        nome.setBounds(130, 75, 75, 15);
        painelRegistro.add(nome);

        nomeT.setBounds(75,95, 150, 20);
        painelRegistro.add(nomeT);

        cpf.setBounds(130, 115, 75, 15);
        painelRegistro.add(cpf);

        cpfT.setBounds(75,135, 150, 20);
        painelRegistro.add(cpfT);

        loginR.setBounds(130, 155, 75, 15);
        painelRegistro.add(loginR);

        loginT.setBounds(75,175, 150, 20);
        painelRegistro.add(loginT);

        senhaR.setBounds(130, 195, 75, 15);
        painelRegistro.add(senhaR);

        SenhaT.setBounds(75,215, 150, 20);
        painelRegistro.add(SenhaT);

        telefone.setBounds(130, 235, 75, 15);
        painelRegistro.add(telefone);

        telefoneT.setBounds(75,255, 150, 20);
        painelRegistro.add(telefoneT);

        registro.setBounds(75,295,150, 20);
        painelRegistro.add(registro);

        registro.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent arg0){
                sistema.registroProfessor(nomeT.getText(),cpfT.getText(),loginT.getText(),SenhaT.getText(),telefoneT.getText());
                professor.setCpf(cpfT.getText());
                professor.setNome(nomeT.getText());
                professor.setLogin(loginT.getText());
                professor.setSenha(SenhaT.getText());
                professor.setTelefone(Integer.valueOf(telefoneT.getText()));
                nomeT.setText("");
                cpfT.setText("");
                loginT.setText("");
                SenhaT.setText("");
                telefoneT.setText("");
                tabbedPane.setSelectedIndex(0);
                tabbedPane.remove(1);
                sistema.exibirProfessor();

            }
        });
    }

}
