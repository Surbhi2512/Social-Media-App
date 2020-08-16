/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmedia;

/**
 *
 * @author DELL
 */
public class User {
    String name;
    String edu;
    Duration dur;
    String hobby;
    
    public User(String name, String edu, Duration dur,String hobby)
    {
        this.name=name;
        this.edu=edu;
        this.dur=dur;
        this.hobby=hobby;
    }
    
    @Override
    public String toString(){
        return  this.name+ ","+ this.edu + "," + dur.toString() + "," + this.hobby;
    }
}
