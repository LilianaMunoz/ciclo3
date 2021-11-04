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
}