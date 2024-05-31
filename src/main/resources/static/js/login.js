// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function iniciarSesion() {
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

       const request = await fetch("api/login", {
       method: 'POST',
       headers: {
        "Accept" : "application/json",
        'Content-Type': 'application/json'
       },
       body: JSON.stringify(datos)
       });


       const response = await request.text();


    if (response != "fail") {
        localStorage.token = response;
        localStorage.email = datos.email;
        window.location.href = 'usuarios.html';
        Swal.fire ({
            title: "Good job!",
            text: "You clicked the button!",
            icon: "success"
        })
    } else {
        Swal.fire ({
            icon: "error",
            title: "Oops...",
            text: "Hay un problema con las credenciales"
        })
    }

}
