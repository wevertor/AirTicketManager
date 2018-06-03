public class Fly{
    private FirstClass firstClass ;
    private EconomyClass economyClass;
    private String company, date, time, gate, number, from, to;
    private Double price;

    public Fly(String company, String date, String time, String number, String gate, String from, String to, Double price){
        this.company = company;
        this.date = date;
        this.time = time;
        this.gate = gate;
        this.number = number;
        this.from = from;
        this.to = to;
        this.price = price;
        this.firstClass =  new FirstClass();
        this.economyClass = new EconomyClass();
    }

    void print(){
        System.out.println("================ Primeira Classe ================");
        firstClass.print();
        System.out.println("================ Classe Econômica ================");
        economyClass.print();
    }

    FirstClass getFirstClass(){
        return this.firstClass;
    }

    EconomyClass getEconomyClass(){
        return this.economyClass;
    }

    String getCompany(){
        return this.company;
    }

    String getDate(){
        return this.date;
    }

    String getTime(){
        return this.time;
    }

    String getGate(){
        return this.gate;
    }

    String getNumber(){
        return this.number;
    }

    String getFrom(){
        return this.from;
    }

    public String toString(){
        return date + " "+ time + "\t\tGATE :" +gate + "\t\tFlight nº: " + number + "\n\nFrom\t: "+from +"\t\t\t\t\t$"+price + "\n\nTo\t: " +to;
    }

    String getTo(){
        return this.to;
    }
}
