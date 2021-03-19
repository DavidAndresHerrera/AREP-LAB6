package edu.escuelaing.arep.server;
import edu.escuelaing.arep.server.model.Carrera;
import edu.escuelaing.arep.server.model.Participante;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import static  spark.Spark.*;

public class HelloSecureService {
    public static void  main(String... args){

        secure("keystores/areplabkey.p12","123456",null,null);
        port(getPort());
        get("/", (req,res) -> "Hola este es mi servicio inicial");
        get("/Datos",(req,res) -> getDatos());

    }

    private static JSONObject getDatos() throws JSONException {
        JSONObject res = new JSONObject();
        Carrera carrera = new Carrera();
        List<Participante> participantes = carrera.getParticipantes();
        List<JSONObject> datos = new LinkedList<>();

        for (Participante i: participantes){
            JSONObject temp = new JSONObject();
            temp.put("id",i.getId());
            temp.put("edad", i.getEdad());
            temp.put("name", i.getName());
            temp.put("categoria", i.getCategoria());
            datos.add(temp);
        }
        res.put("Participantes",datos);
        return res;

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
