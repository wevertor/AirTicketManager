public class Passenger{
    private long id, credit;
    private String name, sit;

    Passenger(String name, long id, long credit){
        this.id = id;
        this.credit = credit;
        this.name = name;
    }

    long getId(){
        return this.id;
    }

    long getCredit(){
        return this.credit;
    }

    String getName(){
        return this.name;
    }

    String getSit(){
        return this.sit;
    }

    void setSit(String sit){
        this.sit = sit;
    }
}
