package co.usa.ciclo3.ciclo3.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.report.ContReservationStatus;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation a){
        if (a.getIdReservation()==null){
            return reservationRepository.save(a);
        }else{
            Optional<Reservation> aaux=reservationRepository.getReservation(a.getIdReservation());
            if(aaux.isEmpty()){
                return reservationRepository.save(a);
            }else{
                return a;
            }
        }
    }

    public Reservation update(Reservation a){
        if(a.getIdReservation()!=null){
            Optional<Reservation>g=reservationRepository.getReservation(a.getIdReservation());
            if(!g.isEmpty()){
                if(a.getStartDate()!=null){
                    g.get().setStartDate(a.getStartDate());
                }
                if(a.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(a.getDevolutionDate());
                }
                return reservationRepository.save(g.get());
            }
        }
            return a;
    }

    public boolean deleteReservation(int id){
        Optional<Reservation>a=getReservation(id);
        if(!a.isEmpty()){
            reservationRepository.delete(a.get());
            return true;
        }
        return false;
    }

    public List<Reservation> getReservationByDate(Date startDate, Date endDate){
        return reservationRepository.getReservationByDate(startDate, endDate);
    }

    public ContReservationStatus getReportStatus(){
        int completed = reservationRepository.getCountByStatus("completed");
        int cancelled = reservationRepository.getCountByStatus("cancelled");
        return new ContReservationStatus(completed, cancelled);
    }
}