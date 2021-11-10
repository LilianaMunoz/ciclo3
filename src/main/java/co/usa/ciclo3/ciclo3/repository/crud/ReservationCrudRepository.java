package co.usa.ciclo3.ciclo3.repository.crud;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import co.usa.ciclo3.ciclo3.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer>{
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date endDate);

    public List<Reservation> findAllByStatus (String status);
}