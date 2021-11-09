package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Audience;
import co.usa.ciclo3.ciclo3.repository.AudienceRepository;

@Service
public class AudienceService {
    
    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }

    public Optional<Audience> getAudience(int id){
        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience a){
        if (a.getId()==null){
            return audienceRepository.save(a);
        }else{
            Optional<Audience> aaux=audienceRepository.getAudience(a.getId());
            if(aaux.isEmpty()){
                return audienceRepository.save(a);
            }else{
                return a;
            }
        }
    }

    public Audience update(Audience a){
        if(a.getId()!=null){
            Optional<Audience>g=audienceRepository.getAudience(a.getId());
            if(!g.isEmpty()){
                if(a.getName()!=null){
                    g.get().setName(a.getName());
                }
                if(a.getOwner()!=null){
                    g.get().setOwner(a.getOwner());
                }
                if(a.getCapacity()!=null){
                    g.get().setCapacity(a.getCapacity());
                } 
                if(a.getDescription()!=null){
                    g.get().setDescription(a.getDescription());
                } 
                return audienceRepository.save(g.get());
            }
        }
            return a;
    }
    
    public boolean deleteAudience(int id){
        Optional<Audience>a=getAudience(id);
        if(!a.isEmpty()){
            audienceRepository.delete(a.get());
            return true;
        }
        return false;
    }
}