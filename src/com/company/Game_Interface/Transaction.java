package com.company.Game_Interface;

public class Transaction {

    public String gamerName;
    public String carName;
    public Double cash;
    public Integer typeTransaction;
    //public Integer nrRound;

    public Transaction(String gamerName, String carName, Double cash, Integer typeTransaction) {
        this.gamerName = gamerName;
        this.carName = carName;
        this.cash = cash;
        this.typeTransaction = typeTransaction;
    }
    @Override
    public String toString() {
        if(typeTransaction==0) {
            return "Gracz: " + gamerName +
                    " Kupił: " + carName  +
                    " Za: " + cash;
        }
        else{
            return "Gracz: " + gamerName +
                    " Sprzedał: " + carName +
                    " Za: " + cash;
        }
    }
}
