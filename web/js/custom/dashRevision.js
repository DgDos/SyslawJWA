// Al cargar documento

 var table1;

$(document).ready(function () {

    // cuadrar altura de paneles laterales derechos
    //setSugeridosHeightAndScroll(true);
    //setAgendadosHeightAndScroll(true);
    
    console.log("hasta aqui");
    
    // Para marcar la pagina activa
    $('#menu_default').removeClass("active");
    $('#menu_revision').addClass("active");

    //$('#demandas_tabla').DataTable();


    table1 = $('#liststate2').DataTable({
        ajax: {
            url: "DemandaS",
            dataSrc: '',
            data: {
                'opcion': "state",
                'state': "2",
            }
        },
        columns: [
            {data: 'titulo'},
            {data: 'fecha_modificacion'},
            {data: 'fecha_creacion'},
            {data: 'id_ayudante'},
            {data: 'porcentaje',
                render: function (data, type, row, meta ) {
                    return '<div class="progress"><div class="progress-bar progress-bar-striped bg-syslaw" role="progressbar" aria-valuenow="'+data+'" aria-valuemin="0" aria-valuemax="100" style="width: '+data+'%;">' + data +'%</div></div>';
                }}
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });
    
    table3 = $('#liststate3').DataTable({
        ajax: {
            url: "DemandaS",
            dataSrc: '',
            data: {
                'opcion': "state",
                'state': "3",
            }
        },
        columns: [
            {data: 'titulo'},
            {data: 'fecha_modificacion'},
            {data: 'fecha_creacion'},
            {data: 'id_ayudante'},
            {data: 'porcentaje',
                render: function (data, type, row, meta ) {
                    return '<div class="progress"><div class="progress-bar progress-bar-striped bg-syslaw" role="progressbar" aria-valuenow="'+data+'" aria-valuemin="0" aria-valuemax="100" style="width: '+data+'%;">' + data +'%</div></div>';
                }}
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });
    
    
    
    table2 = $('#liststate4').DataTable({
        ajax: {
            url: "DemandaS",
            dataSrc: '',
            data: {
                'opcion': "state",
                'state': "4",
            }
        },
        columns: [
            {data: 'titulo'},
            {data: 'fecha_modificacion'},
            {data: 'fecha_creacion'},
            {data: 'id_ayudante'},
            {data: 'porcentaje',
                render: function (data, type, row, meta ) {
                    return '<div class="progress"><div class="progress-bar progress-bar-striped bg-syslaw" role="progressbar" aria-valuenow="'+data+'" aria-valuemin="0" aria-valuemax="100" style="width: '+data+'%;">' + data +'%</div></div>';
                }},
            {data: null}
        ],
        columnDefs: [
            {
                targets: -1,
                data: null,
                defaultContent: '<a style="cursor: pointer; "><i class="material-icons" style="font-size:21px">mode_edit</i></a>'
            }
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });

    $('#liststate4 tbody').on('click', 'a', function () {
        var data = table2.row($(this).parents('tr')).data();
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

    table1.ajax.reload();

    return false;
});

function abrir(id_demanda) {
    localStorage.setItem("id_demanda",id_demanda);
    document.location.href='revision_editar';
}