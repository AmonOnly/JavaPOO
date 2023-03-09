import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanTeclado = new Scanner(System.in);
    String[] str = new String[5];
    int[] idade = new int[5];
    for (int i = 0; i < 5; i++) {
      System.out.println("Digite o Nome do aluno " + (i + 1));
      str[i] = scanTeclado.nextLine();
      System.out.println("Digite a Idade do Aluno " + (i + 1));
      idade[i] = Integer.parseInt(scanTeclado.nextLine());
    }
    int aux;
    String cop;
    for (int in = 0; in < 5; in++) {
      for (int i = in; i < 5; i++) {
        if (idade[in] < idade[i]) {
          cop = str[in];
          aux = idade[in];
          str[in] = str[i];
          idade[in] = idade[i];
          str[i] = cop;
          idade[i] = aux;
        }
      }
    }
    for (int i = 0; i < 5; i++) {
      System.out.println("Nome do aluno " + "" + str[i] + " e a Idade" + " " + idade[i]);
    }
  }
}