package com.example.donationapp;

public class recversItem {

    private String recvID , shortBio ;
    private int itemRequest,amount;

    recversItem(String recvID , String shortBio , int itemRequest  ){

        this.recvID = recvID;
        this.shortBio = shortBio;
        this.itemRequest = itemRequest;
        this.amount = 0;
    }

    public String getRecvID() {
        return recvID;
    }

    public void setRecvID(String recvID) {
        this.recvID = recvID;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }


    public int getItemRequest() {
        return itemRequest;
    }

    public void setItemRequest(int itemRequest) {
        this.itemRequest = itemRequest;
    }

    public void incAmount() {
        amount++;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void decAmount() {
        if(amount > 0)  amount--;
    }
}
