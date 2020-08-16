/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmedia;

import java.util.HashMap;

/**
 *
 * @author DELL
 */
public class Duration {
    int smonth;
    int syear;
    int emonth;
    int eyear;
    HashMap<Integer,String> hm= new HashMap<>();
    
    public Duration(int smonth, int syear,int emonth, int eyear)
    {
        this.smonth=smonth;
        this.syear=syear;
        this.emonth=emonth;
        this.eyear=eyear;
    }
    
    public String month(int x)
    {
        hm.put(1,"January");
        hm.put(2,"February");
        hm.put(3,"March");
        hm.put(4,"April");
        hm.put(5,"May");
        hm.put(6,"June");
        hm.put(7,"July");
        hm.put(8,"August");
        hm.put(9,"September");
        hm.put(10,"October");
        hm.put(11,"November");
        hm.put(12,"December");
        
        return hm.get(x);
    }
    
    @Override
    public String toString() {
        return month(this.smonth) + "/" + this.syear + " - " + month(this.emonth) + "/" + this.eyear;
    }
}
