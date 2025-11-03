/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestion_incidencias_ra3_prueba;

import HibernateConnection.hibernate_connection;

/**
 *
 * @author cmdia
 */

public class Incidents_management {
	
    public static void main(String[] args) {
    	 System.out.println("Aplicación de gestión de incidencias iniciada correctamente.");
         // Opcional: probar conexión a Hibernate
         try {
             hibernate_connection.getSessionFactory();
             System.out.println("Conexión Hibernate establecida correctamente.");
         } catch (Exception e) {
             System.err.println(" Error al conectar con Hibernate: " + e.getMessage());
         }
     }
 }
