public class Fly{
    private FirstClass firstClass = new FirstClass();
    private EconomyClass economyClass = new EconomyClass();
    private String company, date, time, gate, number, from, to;
    private Double price;

    public Fly(String company, String date, String time, String gate, String number, String from, String to, Double price){
        this.company = company;
        this.date = date;
        this.time = time;
        this.gate = gate;
        this.number = number;
        this.from = from;
        this.to = to;
        this.price = price;
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

    String getTo(){
        return this.to;
    }
}
