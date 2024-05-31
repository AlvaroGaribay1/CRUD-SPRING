$(document).ready(function() {
    // Any initialization code can go here
});

async function registrarUsuario() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('apellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    datos.phone = document.getElementById('txtPhone').value;

    let RPassword = document.getElementById('txtRepeatPassword').value;

    if (datos.password !== RPassword) {
        alert('Passwords do not match');
        return;
    }

    try {
        const request = await fetch('api/usuarios', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        if (request.ok) {
            Swal.fire({
                title: 'Success!',
                text: 'Your form has been submitted.',
                icon: 'success',
                confirmButtonText: 'OK'
            }).then(() => {
                window.location.href = 'login.html';
            });
        } else {
            Swal.fire({
                title: 'Error!',
                text: 'There was a problem submitting your form.',
                icon: 'error',
                confirmButtonText: 'OK'
            });
        }
    } catch (error) {
        Swal.fire({
            title: 'Error!',
            text: 'There was a problem submitting your form.',
            icon: 'error',
            confirmButtonText: 'OK'
        });
    }
}
