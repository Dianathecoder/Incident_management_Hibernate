package Metodos;


import HibernateConnection.hibernate_connection;
import POJOS.Employee;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeMethods {

    public static Session session = hibernate_connection.getSessionFactory().openSession(); // get the session

    public static void insertEmployee(Employee employee) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(employee);
            tx.commit();
            System.out.println("Employee inserted successfully");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error inserting employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void validateLogin(String username, String password, int id) {
        try {
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                    System.out.println("Employee validated successfully");
                } else {
                    System.out.println("Employee ID or credentials not found");
                }
            }
        } catch (Exception e) {
            System.err.println("Error validating employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateEmployee(Employee employee, int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee existingEmployee = session.get(Employee.class, id);
            if (existingEmployee != null) {
                employee.setId(existingEmployee.getId());
                session.merge(employee);
                tx.commit();
                System.out.println("Employee " + employee.getId() + " updated successfully");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error updating employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void changePassword(int id, String newPassword) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                employee.setPassword(newPassword);
                session.merge(employee);
                tx.commit();
                System.out.println("Employee password updated successfully");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error changing password: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteEmployee(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
                tx.commit();
                System.out.println("Employee deleted successfully");
            }
        } catch (Exception e) {
            System.err.println("Error deleting employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Employee> listEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            employeeList = session.createQuery("FROM Employee", Employee.class).getResultList();
            if (employeeList != null) {
                System.out.println("--Employee List--");
                for (Employee employee : employeeList) {
                    System.out.println(employee);
                }
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error fetching employee list: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeList;
    }
}
