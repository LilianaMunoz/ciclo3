package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category a){
        if (a.getId()==null){
            return categoryRepository.save(a);
        }else{
            Optional<Category> aaux=categoryRepository.getCategory(a.getId());
            if(aaux.isEmpty()){
                return categoryRepository.save(a);
            }else{
                return a;
            }
        }
    }

    public Category update(Category a){
        if(a.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(a.getId());
            if(!g.isEmpty()){
                if(a.getName()!=null){
                    g.get().setName(a.getName());
                }
                if(a.getDescription()!=null){
                    g.get().setDescription(a.getDescription());
                } 
                return categoryRepository.save(g.get());
            }
        }
            return a;
    }

    public boolean deleteCategory(int id){
        Optional<Category>a=getCategory(id);
        if(!a.isEmpty()){
            categoryRepository.delete(a.get());
            return true;
        }
        return false;
    }
}