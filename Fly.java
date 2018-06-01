public class Fly{
    FirstClass firstClass;
    EconomyClass economyClass;
    private String company, date, time, gate, number, from, to;

    public Fly(String company, String date, String time, String gate, String number, String from, String to){
        this.company = company;
        this.date = date;
        this.time = time;
        this.gate = gate;
        this.number = number;
        this.from = from;
        this.to = to;

        this.firstClass = new FirstClass();
        this.economyClass = new EconomyClass();
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
