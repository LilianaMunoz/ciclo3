package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a){
        if (a.getId()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> aaux=adminRepository.getAdmin(a.getId());
            if(aaux.isEmpty()){
                return adminRepository.save(a);
            }else{
                return a;
            }
        }
    }

    public Admin update(Admin a){
        if(a.getId()!=null){
            Optional<Admin>g=adminRepository.getAdmin(a.getId());
            if(!g.isEmpty()){
                if(a.getName()!=null){
                    g.get().setName(a.getName());
                }
                if(a.getPassword()!=null){
                    g.get().setPassword(a.getPassword());
                } 
                return adminRepository.save(g.get());
            }
        }
            return a;
    }

    public boolean deleteAdmin(int id){
        Optional<Admin>a=getAdmin(id);
        if(!a.isEmpty()){
            adminRepository.delete(a.get());
            return true;
        }
        return false;
    }
}