package Metodos;

import POJOS.Incident;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateConnection.hibernate_connection;

/**
 * Incident methods for CRUD operations using Hibernate
 */
public class IncidentMethods {

    public static Session session = hibernate_connection.getSessionFactory().openSession();

    public static void addIncident(Incident incident) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(incident);
            tx.commit();
            System.out.println("Incident added successfully");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error adding incident: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void findById(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Incident existingIncident = session.get(Incident.class, id);
            if (existingIncident != null) {
                System.out.println("--Incident Details--");
                System.out.println(existingIncident);
            } else {
                System.out.println("Incident not found");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error finding incident: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Incident> listIncidents() {
        List<Incident> incidentList = new ArrayList<>();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            incidentList = session.createQuery("FROM Incident", Incident.class).getResultList();
            if (incidentList != null) {
                System.out.println("--Incident List--");
                for (Incident incident : incidentList) {
                    System.out.println(incident);
                }
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error listing incidents: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return incidentList;
    }

    public static List<Incident> incidentsByEmployee(int employeeId) {
        List<Incident> byEmployee = new ArrayList<>();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            byEmployee = session.createQuery(
                    "FROM Incident i WHERE i.originEmployee.id = :employeeId", Incident.class)
                    .setParameter("employeeId", employeeId)
                    .getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error fetching incidents by employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return byEmployee;
    }
}

