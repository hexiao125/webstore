package se.kth.id1212.restful.webstore.integration;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless

public class CredentialDAO {
    @PersistenceContext(unitName = "credentialPU")
    private EntityManager em;
    
    public CredentialDAO(){
    }
    
    public boolean checkCredt(Credential credt){
        String username = credt.getUsername();
        String password = credt.getPassword();
        if(userExist(username)){
            return em.find(Credential.class, username).getPassword().equals(password);
        }
        return false;       
    }    
    
    public boolean addUser(Credential credt){
        String username = credt.getUsername();
        String password = credt.getPassword();
        if(!userExist(username)){
            Credential newCredt= new Credential(username, password);
            em.persist(newCredt);
            return true;
        }
        return false;       
    }
    
    public boolean userExist(String username){
        return (em.find(Credential.class, username) != null);
    }
    
}
