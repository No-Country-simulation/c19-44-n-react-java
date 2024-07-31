$(document).ready(function() {
  $('#inp_dni').on('keypress', function(event) {
      var charCode = (event.which) ? event.which : event.keyCode;
      // Permitir solo números y teclas de control
      if (charCode > 31 && (charCode < 48 || charCode > 57)) {
          event.preventDefault();
      }
  });

  $('#fecha_hora').datetimepicker({
      format: 'd/m/Y H:i', // Formato de fecha y hora
      step: 30, // Paso de minutos (opcional)
      timepickerScrollbar: true // Habilitar scrollbar en el timepicker (opcional)
  });
})

$("#btn_agendar").on("click", function(){
  if($("#fecha_hora").val() == ""){
      swal.fire("Datos incompletos", "Debe seleccion una fecha para su cita", "info");
      $("#fecha_hora").focus();
  }else{
      //window.location.href = "realizar-pago.html";
      $("#turno").append($("#slc_turnos").val());
      $("#fecha").append($("#fecha_hora").val());
  }
})

$("#btn_back").on("click", function(){
  window.location.href = "perfil-usuario.html";
});

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
