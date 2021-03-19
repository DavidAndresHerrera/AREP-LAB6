package edu.escuelaing.arep.client;

import org.json.JSONException;
import org.json.JSONObject;
import static spark.Spark.*;
import org.apache.commons.codec.digest.DigestUtils;


public class SecureServices {

    private static final String usuarioB = "david@gmail.com";
    private static final String pass = "7c4a8d09ca3762af61e59520943dc26494f8941b";

    public static void main(String... args){
        port(getPort());
        staticFileLocation("/static");
        secure("keystores/areplabkey.p12", "123456", null, null);
        get("/helloservice", (req, res) -> "Hello web Services");
        get("/", (req,res) -> { res.redirect("index.html");
            return null;
        });
        post("/login",(req, res) -> autenticacion(new JSONObject(req.body())));
        get("/getData",(req,res) -> getData());
    }

    private static Object getData() throws JSONException {
        String res = "";
        JSONObject data = null;
        System.out.println("entreeeeeeeeeeeeeeee");
        try{
            res = SecureURLReader.readURL("https://ec2-54-157-181-250.compute-1.amazonaws.com:42000/Datos");
            System.out.println(res);
            data = new JSONObject(res);
        }catch (Exception e){
            data = new JSONObject("Error en la conexión con el Servidor");
        }

        return data;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5002;
    }

    private static JSONObject autenticacion(JSONObject datos) throws JSONException {
        System.out.println("holaaaaaaaaaaaaaaaa");
        JSONObject res = new JSONObject();
        String usuario = datos.get("usuario").toString();
        String contra = datos.get("contra").toString();
        String hash = DigestUtils.sha1Hex(contra);
        System.out.println(hash);
        if(usuario.equals(usuarioB) && hash.equals(pass)){
            res.put("response","true");
            return res;
        }
        return res.put("response","false");
    }
}
