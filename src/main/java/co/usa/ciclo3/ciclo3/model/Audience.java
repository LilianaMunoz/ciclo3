package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="audience")
/**
* Esta clase define el modelo del objeto Auditorio
* @author Liliana Muñoz
*/ 
public class Audience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      /**
    * Identificador del auditorio
    * @author Liliana Muñoz
    */ 
    private Integer id;
      /**
    * Nombre del auditorio
    * @author Liliana Muñoz
    */ 
    private String name;
      /**
    * Propietario del auditorio
    * @author Liliana Muñoz
    */ 
    private String owner;
      /**
    * Capacidad del auditorio
    * @author Liliana Muñoz
    */ 
    private Integer capacity;
      /**
    * Descripción del auditorio
    * @author Liliana Muñoz
    */ 
    private String description;

    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnoreProperties("audiences")
     /**
    * Llave foránea
    * @author Liliana Muñoz
    */ 
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    /**
    * Genera la lista de mensajes
    * @author Liliana Muñoz
    */ 
    private List<Message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties("audience")
    /**
    * Genera la lista de reservas
    * @author Liliana Muñoz
    */ 
    private List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}