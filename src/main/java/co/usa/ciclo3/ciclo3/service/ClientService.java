package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client a){
        if (a.getIdClient()==null){
            return clientRepository.save(a);
        }else{
            Optional<Client> aaux=clientRepository.getClient(a.getIdClient());
            if(aaux.isEmpty()){
                return clientRepository.save(a);
            }else{
                return a;
            }
        }
    }
}