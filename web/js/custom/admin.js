// Al cargar documento

 var table;

$(document).ready(function () {

    table = $('#estadisticas').DataTable({
        ajax: "AdministradorS",
        columns: [
            {data: 'id_usuario'},
            {data: 'veces'}
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });
    
});