package co.usa.ciclo3.ciclo3.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save (Reservation a){
        return reservationCrudRepository.save(a);
    }

    public void delete (Reservation a){
        reservationCrudRepository.delete(a);
    }

    public List<Reservation> getReservationByDate(Date startDate, Date endDate){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(startDate, endDate);
    }

    public int getCountByStatus (String status){
        return reservationCrudRepository.findAllByStatus(status).size();
    }
}