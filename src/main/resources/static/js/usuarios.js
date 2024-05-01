// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios() {
       const request = await fetch("api/usuarios", {
       method: 'GET',
       headers: {
        "Accept" : "application/json",
        'Content-Type': 'application/json'
       }
       });

       const usuarios = await request.json();

       console.log(usuarios);


       let listadoHTML = '';
       for(usuario of usuarios) {

          let deleteButton = '<a onclick="eliminarUsuario('+ usuario.id +')" href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'


          let usuarioHTML = '<tr><td>' + usuario.id + '</td><td>'+ usuario.nombre +' '+ usuario.apellido +'</td><td>'
          + usuario.email +'</td><td>'+ usuario.phone
          +'</td><td>' + deleteButton+ '</td></tr>';
          listadoHTML += usuarioHTML;
       }


       document.querySelector('#usuarios tbody').outerHTML = listadoHTML;
}


async function eliminarUsuario(id) {

if (!confirm('¿Eliminar usuario?')) {
    return;
}
         const request = await fetch("api/usuario/" + id, {
           method: 'DELETE',
           headers: {
            "Accept" : "application/json",
            'Content-Type': 'application/json'
           }
         });

alert("usuario eliminado")
  location.reload();

}
