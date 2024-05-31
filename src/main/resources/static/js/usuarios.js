// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
  actualizarEmailUsuario();
});

function actualizarEmailUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

function getHeaders() {
    return {
        'Accept' : "application/json",
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    }
}

async function cargarUsuarios() {
       const request = await fetch("api/usuarios", {
       method: 'GET',
       headers: getHeaders()
       });

       const usuarios = await request.json();

       console.log(usuarios);


       let listadoHTML = '';
       for(usuario of usuarios) {

          let deleteButton = '<a onclick="confirmation('+ usuario.id +')" href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'


          let usuarioHTML = '<tr><td>' + usuario.id + '</td><td>'+ usuario.nombre +' '+ usuario.apellido +'</td><td>'
          + usuario.email +'</td><td>'+ usuario.phone
          +'</td><td>' + deleteButton+ '</td></tr>';
          listadoHTML += usuarioHTML;
       }


       document.querySelector('#usuarios tbody').outerHTML = listadoHTML;
}

function confirmation (id) {
    Swal.fire({
      title: "¿Quieres eliminar el usuario?",
      showCancelButton: true,
      confirmButtonText: "Sí",
    }).then((result) => {
      if (result.isConfirmed) {
            eliminarUsuario(id);
      } else {
        return;
      }
    });
}


async function eliminarUsuario(id) {
     const request = await fetch("api/usuario/" + id, {
     method: 'DELETE',
     headers: getHeaders()
     });
    location.reload();
}
