document.getElementById("btn_back").addEventListener("click", function() {
    window.location.href = "landing-page.html";
  });
  
  document.getElementById("btn_register").addEventListener("click", async function(event) {
    event.preventDefault();
  
    const nombreUsuario = document.getElementById("inp_nombre").value;
    const login = document.getElementById("inp_correo").value;
    const clave = document.getElementById("inp_contraseña").value;
    const confirmaClave = document.getElementById("inp_repeat_contraseña").value;
    const terminos = document.getElementById("check_terminos").checked;
  
    if (!nombreUsuario) {
      Swal.fire("Datos incompletos", "El campo <b>Nombre</b> no puede estar vacio", "info");
      document.getElementById("inp_nombre").focus();
      return;
    }
    if (!login) {
      Swal.fire("Datos incompletos", "El campo <b>Correo</b> no puede estar vacio", "info");
      document.getElementById("inp_correo").focus();
      return;
    }
    if (!clave) {
      Swal.fire("Datos incompletos", "El campo <b>Contraseña</b> no puede estar vacio", "info");
      document.getElementById("inp_contraseña").focus();
      return;
    }
    if (!confirmaClave) {
      Swal.fire("Datos incompletos", "El campo <b>Repetir contraseña</b> no puede estar vacio", "info");
      document.getElementById("inp_repeat_contraseña").focus();
      return;
    }
    if (!terminos) {
      Swal.fire("Datos incompletos", "Se deben aceptar los términos y condiciones", "info");
      return;
    }
    if (clave !== confirmaClave) {
      Swal.fire("Contraseña no coinciden", "Las contraseñas deben coincidir", "info");
      return;
    }
  
    try {
      const response = await fetch("http://localhost:8080/signup", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ nombreUsuario, login, clave, confirmaClave })
      });
  
      if (response.ok) {
        const data = await response.json();
        Swal.fire("Registro exitoso", "¡Te has registrado exitosamente!", "success").then(() => {
          window.location.href = "inicio-de-sesion.html";
        });
      } else {
        const errorData = await response.json();
        Swal.fire("Error en el registro", errorData.message || "Hubo un problema al registrarte", "error");
      }
    } catch (error) {
      Swal.fire("Error", "No se pudo conectar con el servidor", "error");
    }
  });
  