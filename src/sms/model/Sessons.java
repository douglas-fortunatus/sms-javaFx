/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.model;

import java.io.Serializable;

/**
 *
 * @author Douglas
 */
public class Sessons implements Serializable{
    
    public int sessID;
    public String sessName;

    public Sessons(int sessID, String sessName) {
        this.sessID = sessID;
        this.sessName = sessName;
    }

    public Sessons() {
    }

    public int getSessID() {
        return sessID;
    }

    public void setSessID(int sessID) {
        this.sessID = sessID;
    }

    public String getSessName() {
        return sessName;
    }

    public void setSessName(String sessName) {
        this.sessName = sessName;
    }
    
    
    
    public int addElement(int sessID){
        this.sessID = sessID;
        
        return sessID;
    }
    
}
