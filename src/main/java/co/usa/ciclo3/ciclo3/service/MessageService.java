package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message a){
        if (a.getIdMessage()==null){
            return messageRepository.save(a);
        }else{
            Optional<Message> aaux=messageRepository.getMessage(a.getIdMessage());
            if(aaux.isEmpty()){
                return messageRepository.save(a);
            }else{
                return a;
            }
        }
    }
}