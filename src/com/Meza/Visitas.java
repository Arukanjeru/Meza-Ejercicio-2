package com.Meza;
import com.Meza.Condiciones.ErrorValidacion;

public class Visitas {
    public String nombreCompleto;
    public String telefono;
    public int contador;


    public Visitas() {
        this.nombreCompleto = nombreCompleto;
    }


    public String setNombre(String nombre) throws ErrorValidacion{
        if(nombre.length() > 50){
            throw new ErrorValidacion("Ese nombre excede la capacidad maxima");
        }
        return nombre;
    }

    public void setTelefono(String telefono) throws ErrorValidacion {
        if (!telefono.matches("[0-9]{4}\\-[0-9]{4}")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;

    }





}


