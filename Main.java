import java.util.*;
import java.text.SimpleDateFormat;
//
//
class Main {
    static Scanner input = new Scanner(System.in);
    static Date date = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    static boolean chooseSit(Fly flight , Passenger passenger){

        System.out.println("\nDeseja fazer a viagem em qual classe?\n1 - Primeira Classe.\n2 - Classe Econômica.");
        int opt = input.nextInt();
        int x , y;
        String sit;
        FirstClass fClass;
        EconomyClass eClass;
        boolean flag;

        if(opt==1){

            fClass = flight.getFirstClass();

            do{

                System.out.println("Onde gostaria de sentar?\n");
                fClass.print();

                sit = input.next();
                x = fClass.getX(sit);
                y = fClass.getY(sit);

                /* verify if "sit" is a valid sit and if it's empty */
                flag = fClass.sitIsEmpty(x, y);

                if(flag) break;

                System.out.println("Assento ocupado ou inexistente.");

            }while(true);

            passenger.setSit(sit);
            passenger.setClasse(fClass);
            fClass.addPassenger(passenger);
            System.out.println("Passageiro adicionado com sucesso!");
            return true;

        }else if(opt == 2){

            eClass = flight.getEconomyClass();

            do{

                System.out.println("Em qual poltrona deseja sentar?\n");
                eClass.print();

                System.out.println();
                sit = input.next();
                x = eClass.getX(sit);
                y = eClass.getY(sit);

                /* verify if "sit" is a valid sit and if it's empty */
                flag = eClass.sitIsEmpty(x, y);

                if (flag == true) break;

                System.out.println("Assento ocupado ou inexistente.");

            }while(flag!=true);

            eClass.sitMap[x][y] = 1;
            passenger.setSit(sit);
            eClass.addPassenger(passenger);
            System.out.println("Passageiro adicionado com sucesso!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int opt;
        Scanner input = new Scanner(System.in);
        Date date = new Date();
        Passenger passenger;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Fly teresina = new Fly("GOL", formatter.format(date), "14:45", "1", "A", "São Luís", "Teresina", 450.00);
        Fly saopaulo = new Fly("LATAM", formatter.format(date), "17:30", "2", "E", "São Luís", "São Paulo" , 450.00);
        Fly londres = new Fly("AZUL", formatter.format(date), "04:30", "3", "D", "São Luís", "Londres", 450.00);

        ArrayList<Fly> flights = new ArrayList<Fly>();
        flights.add(teresina);
        flights.add(saopaulo);
        flights.add(londres);

        do {

            System.out.println("Escolha um dos voos para cadastrar um passageiro: (Insira 0 para sair)");
            System.out.println("Voos disponíveis hoje:");
            System.out.println("Fly\t|Company\t|Date\t\t|Hour\t|Gate\t|To");
            System.out.println("1\t|GOL\t\t|" + formatter.format(date) + "\t|14:45\t|A\t|Teresina");
            System.out.println("2\t|LATAM\t\t|" + formatter.format(date) + "\t|17:30\t|E\t|São Paulo");
            System.out.println("3\t|AZUL\t\t|" + formatter.format(date) + "\t|04:30\t|D\t|Londres");

            opt = input.nextInt();

            if(opt == 0){
                break;
            }
            else if(opt>0 && opt<=flights.size()){
                opt--;
                Fly flight = flights.get(opt);

                System.out.print("Identifique-se para continuar\n\tnome: ");
                String name = input.next();
                passenger = flight.getFirstClass().getPassenger(name ,"name");
                if(passenger==null){ passenger = flight.getEconomyClass().getPassenger(name , "name");}

                if(passenger != null){ // Se já existe um passageiro cadastrado com este nome
                    do{
                        System.out.println(passenger.toString());
                        System.out.println("| 1-Confirmar compra\t| 2-Mudar Assento\t| 3-Cancelar Voo\t| 0 - SAIR");
                        opt = input.nextInt();
                        if(opt == 0){
                            break;
                        }else if(opt == 1){
                            System.out.println("========================================================================\n\t\t\tCARTÃO DE EMBARQUE\n========================================================================");
                            System.out.println();
                            System.out.println(flight.toString());
                            System.out.println();
                            System.out.println(passenger.toString());
                            System.out.println();
                            System.out.println("========================================================================\n\t\t\tBOA VIAGEM\n========================================================================");
                            break;
                        }else if(opt == 2){
                            //modificar assento do passageiro
                            String sit = passenger.getSit();
                            Class classe = passenger.getClasse();
                            classe.removePassenger(sit);
                            boolean flag;

                            do{
                                flag = chooseSit(flight , passenger);
                            }while(flag!=true);

                        }else if(opt == 3){

                            String sit = passenger.getSit();
                            Class classe = passenger.getClasse();
                            classe.removePassenger(sit);

                            System.out.println("Voo Cancelado");

                            break;

                        }else{
                            System.out.println("Entrada inválida");
                        }
                    }while(true);
                }else{// Se não existe um passageiro cadastrado com esse nome (criar novo cadastro)
                    opt = 0;
                    do{
                        if(opt == 2){
                            name = input.next();
                        }

                        System.out.print("\n\tID: ");
                        int id = input.nextInt();
                        System.out.print("\n\tNúmero do cartão de crédito: ");
                        int credit = input.nextInt();
                        passenger = new Passenger(name, id, credit);

                        chooseSit(flight , passenger);

                        System.out.println("| 1 - Confirmar compra\t| 2 - Adicionar outro passageiro\t| 0 - sair");
                        opt = input.nextInt();
                        if(opt == 1){
                            System.out.println("========================================================================\n\t\t\tCARTÃO DE EMBARQUE\n========================================================================");
                            System.out.println();
                            System.out.println(flight.toString());
                            System.out.println();
                            System.out.println(passenger.toString());
                            System.out.println();
                            System.out.println("========================================================================\n\t\t\tBOA VIAGEM\n========================================================================");
                            break;
                        }
                        else if(opt == 0){
                            break;
                        }

                    }while(true);
                }
            }
            else{
                System.out.println("Entrada Inválida");
            }
        }while(true);
    }
}
