document.addEventListener("DOMContentLoaded", function() {
    $('#fecha_hora').datetimepicker({
        format:'Y-m-d H:i',
        step: 30
    });

    document.getElementById('btn_agendar').addEventListener('click', function() {
        const usuarioId = localStorage.getItem('usuarioId');
        const especialidad = document.getElementById('slc_turnos').value;
        const fechaHora = document.getElementById('fecha_hora').value;

        console.log(fechaHora);
        
        if (!especialidad || !fechaHora) {
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'Todos los campos son obligatorios',
            });
            return;
        }

        console.log(usuarioId);

        const turnoData = {
            usuarioId: usuarioId,
            especialidad: especialidad,
            fechaHora: fechaHora
        };

        console.log(especialidad);

        fetch('http://localhost:8080/api/citas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            },
            body: JSON.stringify(turnoData)
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                Swal.fire({
                    icon: 'success',
                    title: 'Turno reservado',
                    text: 'Tu turno ha sido reservado exitosamente'
                });
               } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: data.message || 'Hubo un problema al reservar el turno'
                });
            }
        })
        .catch((error) => {
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'Hubo un problema al conectar con el servidor'
            });
        });
    });
});
