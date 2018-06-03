public class Passenger{
    private long id, credit;
    private String name, sit;
    private Class classe;
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

    Class getClasse(){
        return this.classe;
    }

    void setClasse( Class classe ){
        this.classe = classe;
    }
    
    public String toString(){
        String class_str;

        if(classe instanceof FirstClass){
            class_str = " primeira classe";
        }else{
            class_str = " classe economica";
        }

        return id + " - " + name + " "+ sit + class_str;

    }
    void setSit(String sit){
        this.sit = sit;
    }
}
