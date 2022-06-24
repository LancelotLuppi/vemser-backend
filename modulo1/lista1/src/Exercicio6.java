import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palavra para traduzir:");
        String str = scanner.nextLine();
        boolean temNoTradutor = false;
        String strLower = str.toLowerCase();

        if(strLower.equals("cachorro")){
            System.out.println("Traducao pt-br=>en: Dog");
            temNoTradutor = true;
        }
        if(strLower.equals("tempo")){
            System.out.println("Traducao pt-br=>en: Time");
            temNoTradutor = true;
        }
        if(strLower.equals("amor")){
            System.out.println("Traducao pt-br=>en: Love");
            temNoTradutor = true;
        }
        if(strLower.equals("cidade")){
            System.out.println("Traducao pt-br=>en: City");
            temNoTradutor = true;
        }
        if(strLower.equals("feliz")){
            System.out.println("Traducao pt-br=>en: Happy");
            temNoTradutor = true;
        }
        if(strLower.equals("triste")){
            System.out.println("Traducao pt-br=>en: Sad");
            temNoTradutor = true;
        }
        if(strLower.equals("Deveria")){
            System.out.println("Traducao pt-br=>en: Shoud");
            temNoTradutor = true;
        }
        if(strLower.equals("Poderia")){
            System.out.println("Traducao pt-br=>en: Could");
            temNoTradutor = true;
        }
        if(strLower.equals("dog")){
            System.out.println("Traducao en=>pt-br: Cachorro");
            temNoTradutor = true;
        }
        if(strLower.equals("time")){
            System.out.println("Traducao en=>pt-br: Tempo");
            temNoTradutor = true;
        }
        if(strLower.equals("love")){
            System.out.println("Traducao en=>pt-br: Amor");
            temNoTradutor = true;
        }
        if(strLower.equals("city")){
            System.out.println("Traducao en=>pt-br: Cidade");
            temNoTradutor = true;
        }
        if(strLower.equals("happy")){
            System.out.println("Traducao en=>pt-br: Feliz");
            temNoTradutor = true;
        }
        if(strLower.equals("sad")){
            System.out.println("Traducao en=>pt-br: Triste");
            temNoTradutor = true;
        }
        if(strLower.equals("shoud")){
            System.out.println("Traducao en=>pt-br: Deveria");
            temNoTradutor = true;
        }
        if(strLower.equals("could")){
            System.out.println("Traducao en=>pt-br: Poderia");
            temNoTradutor = true;
        }
        if(temNoTradutor == false){
            System.out.println("Essa palavra nao eh valida");
        }
    }
}
