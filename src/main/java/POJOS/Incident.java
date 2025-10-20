/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOS;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Incident entity mapped to "incidents" table
 */
@Entity
@Table(name="incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "origin_employee_id") // foreign key in incidents table
    private Employee originEmployee;

    @ManyToOne
    @JoinColumn(name = "destination_employee_id") // foreign key in incidents table
    private Employee destinationEmployee;

    private String details;
    private char type;

    public Incident(){}

    public Incident(String dateTime, Employee originEmployee, Employee destinationEmployee, String details, char type) {
        this.dateTime = dateTime;
        this.originEmployee = originEmployee;
        this.destinationEmployee = destinationEmployee;
        this.details = details;
        this.type = type;
    }


    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Employee getOriginEmployee() {
		return originEmployee;
	}

	public void setOriginEmployee(Employee originEmployee) {
		this.originEmployee = originEmployee;
	}

	public Employee getDestinationEmployee() {
		return destinationEmployee;
	}

	public void setDestinationEmployee(Employee destinationEmployee) {
		this.destinationEmployee = destinationEmployee;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	@Override
    public String toString() {
        return "Incident{" +
                "dateTime='" + dateTime + '\'' +
                ", originEmployee=" + originEmployee +
                ", destinationEmployee=" + destinationEmployee +
                ", details='" + details + '\'' +
                ", type=" + type +
                '}';
    }
}



