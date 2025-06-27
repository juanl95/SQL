package com.example.sql;

public class Persona {
    private int id;
    private String nombres;
    private String apellidos;
    private int edad;
    private String correo;
    private String direccion;

    // Constructor
    public Persona(String nombres, String apellidos, int edad, String correo, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
}

