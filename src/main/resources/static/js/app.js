var app = ( function() {

    function login(){
        var  email = document.getElementById('correo');
        var  pass = document.getElementById('contra');
        if(email !== null && pass !== null){
            enviarcredenciales(email.value,pass.value);
        }
        else
            alert("Datos incorrectos");
    };

    function enviarcredenciales(email,pass){
        axios.post("/login",
            {usuario:email,contra: pass})
            .then(res => {
                answerLogin(res);
            })
            .catch(error => console.log(error));
    };

    function answerLogin(res){
        var response = res["data"]["response"];
        console.log(response);
        if(response === "true"){
            window.location.href = "/principal.html";
        }
        else
            alert("Hubo un error con sus datos");
    };

    function getData(){
        var url = "/getData"
        axios.get(url)
            .then(res => {
                console.log(res);
                addTable(res);
            })
            .catch(error => console.log(error));
    };


    function addTable(lista){
        console.log(lista);
        var data = lista["data"]["response"];

        if(data === "Error en la conexión con el Servidor"){
            $("#table > tbody").empty();
            alert("Error en la conexión con el Servidor");
        }
        else{
            var cont = 0;
            $("#table > tbody").empty();
            for(var iterator in data){
                var inscri = data[iterator];
                if(inscri !== "Error al cargar los datos"){
                    var fila = "<tr>"+
                        "<td>"+inscri["id"]+"</td>"+
                        "<td>"+inscri["name"]+"</td>"+
                        "<td>"+inscri["categoria"]+"</td>"+
                        "<td>"+inscri["edad"]+"</td>"+
                        "</tr>";
                    $("#table > tbody").append(fila);
                    console.log(fila);
                }
            }
        }
    }

    return{
        login: login,
        getData: getData,

    };
})();

