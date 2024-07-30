document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const login = document.getElementById('email').value;
    const clave = document.getElementById('password').value;

    try {
        const response = await fetch('http://localhost:8080/auth', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ login, clave })
        }
    );

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem('token', data.token); // Guardar el token en el almacenamiento local
            console.log('Token guardado en localStorage:', data.token);
            window.location.href = 'perfil-usuario.html'; // Redirigir al perfil de usuario
        } else {
            alert('Inicio de sesión fallido');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('Ocurrió un error al iniciar sesión');
    }
});
