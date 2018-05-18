import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long id, credit;
        int opt, sitmap[][], x, y, parar;
        Passenger cliente;
        String nome, sit;
        boolean flag;

        FirstClass fClass = new FirstClass();
        EconomyClass eClass = new EconomyClass();

        do{
            System.out.print("Insira os dados do passageiro.\n Nome: ");
            nome = input.next();
            System.out.print(" ID: ");
            id = input.nextInt();
            System.out.print(" Número do cartão de crédito: ");
            credit = input.nextInt();
            cliente = new Passenger(nome, id, credit);
            System.out.println("\nOnde o passageiro deseja viajar?\n1 - Primeira Classe.\n2 - Classe Econômica.");
            opt = input.nextInt();

            if(opt==1){
                do{

                    System.out.println("Em qual poltrona deseja sentar?");
                    sit = input.next();
                    x = fClass.getX(sit);
                    //System.out.println(x);
                    y = fClass.getY(sit);
                    //System.out.println(y);

                    /* verify if "sit" is a valid sit and if it's empty */
                    flag = fClass.sitIsEmpty(fClass.sitMap, x, y);

                    //System.out.println(flag);
                    if(flag == false) System.out.println("Assento ocupado ou inexistente.");

                }while(flag != true);
                fClass.sitMap[x][y] = 1;
                fClass.addPassenger(sit, cliente);
                System.out.println("Passageiro adicionado com sucesso!");
            }else if(opt == 2){

                do{
                    System.out.println("Em qual poltrona deseja sentar?");
                    sit = input.next();
                    x = eClass.getX(sit);
                    y = eClass.getY(sit);
                    /* verify if "sit" is a valid sit and if it's empty */
                    flag = eClass.sitIsEmpty(eClass.sitMap, x, y);
                    if(flag == false) System.out.println("Assento ocupado ou inexistente.");
                }while(flag == true);
                eClass.sitMap[x][y] = 1;
                eClass.addPassenger(sit, cliente);
                System.out.println("Passageiro adicionado com sucesso!");
            }
            System.out.println("Deseja adicionar outro passageiro?\n 1 - Sim.\n 2 - Não.");
            parar = input.nextInt();
        }while(parar == 1);
    }
}
