package se.kth.id1212.restful.webstore.model;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import se.kth.id1212.restful.webstore.integration.Credential;
import se.kth.id1212.restful.webstore.integration.CredentialDAO;

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CredentialHandler {
    @EJB 
    private CredentialDAO credtDB;
     
    public CredentialHandler() {
    }
    
    public Credential createUser(Credential credt){
        Credential regStatus = credt;
        if (credt.getUsername().isEmpty() || credt.getPassword().isEmpty()) {
            regStatus.setCredtPass(false);
        } else {
            boolean credtPass = credtDB.addUser(credt);
            regStatus.setCredtPass(credtPass);
            regStatus.setPassword(null);
        }
        return regStatus;
    }
        
    public Credential checkCredt(Credential credt){
        Credential logStatus = credt;
        logStatus.setCredtPass(credtDB.checkCredt(credt));
        logStatus.setPassword(null);
        return logStatus;
    }
}
