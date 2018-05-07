package se.kth.id1212.restful.webstore.integration;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credential implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private String username;
    private String password;
    private boolean credtPass;
    
    public Credential(){
    }
    
    public Credential(String username, String password){
        this.username = username;
        this.password = password;
        this.credtPass = false;
    }
    
    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getCredtPass() {
        return credtPass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredtPass(boolean credtPass) {
        this.credtPass = credtPass;
    }
   
}
