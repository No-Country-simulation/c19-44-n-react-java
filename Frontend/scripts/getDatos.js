const baseURL = 'http://127.0.0.1:5500';

export default function getDatos(endpoint) {
    return fetch(`${baseURL}${endpoint}`)
        .then(response => response.json())
        .catch(error => {
            console.error('Error al acceder al endpoint', error);
        });
}