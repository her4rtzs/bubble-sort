/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joyce
 */
class Package {
    private int id;
    private String recipientName;
    private double weight;

    public Package(int id, String recipientName, double weight) {
        this.id = id;
        this.recipientName = recipientName;
        this.weight = weight;
    }

    public int getId() { return id; }
    public String getRecipientName() { return recipientName; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10.2f", id, recipientName, weight);
    }
    
    
}

