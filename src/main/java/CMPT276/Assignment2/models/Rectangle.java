package CMPT276.Assignment2.models;

import jakarta.persistence.*;

@Entity
@Table(name="rectangle")
public class Rectangle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String name;
    private int width;
    private int height;
    private String color;
    
    public Rectangle(){
    }

    public Rectangle(String n, int w, int h, String c) {
        this.name = n;
        this.width = w;
        this.height = h;
        this.color = c;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public String getColor(){
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String n){
        this.name = n;
    }

    public void setWidth(int w){
        this.width = w;
    }

    public void setHeight(int h){
        this.height = h;
    }

    public void setColor(String c){
        this.color = c;
    }
}
