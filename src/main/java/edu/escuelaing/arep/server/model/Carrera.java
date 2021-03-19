package edu.escuelaing.arep.server.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private List<Participante> participantes;
    public Carrera(){
        participantes = new ArrayList<Participante>();
        participantes.add(new Participante(1,23,"david herrera","off road"));
        participantes.add(new Participante(2,23,"juan herrera","Street"));
        participantes.add(new Participante(3,25,"cesar villamil","Enduro"));
        participantes.add(new Participante(4,21,"Andres rocha","Street"));
        participantes.add(new Participante(5,22,"Santiago Lopez","Multiproposito"));
    }
    public List<Participante> getParticipantes(){
        return participantes;
    }
    public void addParticipantes(Participante corredor){
        participantes.add(corredor);
    }
}
