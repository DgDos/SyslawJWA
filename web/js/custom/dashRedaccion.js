// Al cargar documento

        var table;
var walkEnable = false;

$(document).ready(function () {

    // cuadrar altura de paneles laterales derechos
    //setSugeridosHeightAndScroll(true);
    //setAgendadosHeightAndScroll(true);

    console.log("hasta aqui");

    // Para marcar la pagina activa
    $('#menu_default').removeClass("active");
    $('#menu_redaccion').addClass("active");

    //$('#demandas_tabla').DataTable();

    walkEnable = false;
    if (walkEnable) {
        $.walk([
            {
                target: '#tour_redaccion',
                content: 'La primera etapa de tu demanda es redacción.',
                color: '#0755a5',
                acceptText: 'Siguiente'
            },
            {
                target: '#titulo_tour',
                content: 'Encuentra en esta tabla las demandas que están en redacción',
                color: '#0755a5',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_edit',
                content: 'Utiliza este botón para editar tu demanda.',
                color: '#0755a5',
                acceptText: 'Entendido'
            }
        ]);
    }


    table = $('#liststate1').DataTable({
        ajax: {
            url: "DemandaS",
            dataSrc: '',
            data: {
                'opcion': "state",
                'state': "1",
            }
        },
        columns: [
            {data: 'titulo'},
            {data: 'fecha_modificacion'},
            {data: 'fecha_creacion'},
            {data: 'porcentaje',
                render: function (data, type, row, meta) {
                    return '<div class="progress"><div class="progress-bar progress-bar-striped bg-syslaw" role="progressbar" aria-valuenow="' + data + '" aria-valuemin="0" aria-valuemax="100" style="width: ' + data + '%;">' + data + '%</div></div>';
                }},
            {data: null}
        ],
        columnDefs: [
            {
                targets: -1,
                data: null,
                defaultContent: '<a style="cursor: pointer; " id="tour_edit"><i class="material-icons" style="font-size:21px">mode_edit</i></a>'
            }
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[1, "desc"]]
    });

    $('#liststate1 tbody').on('click', 'a', function () {
        var data = table.row($(this).parents('tr')).data();
        abrir(data.id_demanda);
    });

});

$('#nueva_demanda_form').on('submit', function () {


    console.log("creando nueva demanda");

    $.ajax({
        type: 'POST',
        url: "DemandaS",
        //force to handle it as text
        data: {
            'opcion': "create",
            'titulo': $('#nuevotitulo').val()
        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            if (json == true) {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('demanda agregada');
            } else {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('no se encontro el usuario');
                alert('Error desconocido');
            }
        },
        async: false
    });

    $('#nuevaDemanda').modal('hide');

    table.ajax.reload();

    return false;
});

function abrir(id_demanda) {
    localStorage.setItem("id_demanda", id_demanda);
    document.location.href = 'redaccion_editar';
}