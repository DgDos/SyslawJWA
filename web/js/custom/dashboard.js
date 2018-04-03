// Al cargar documento

 var table;

$(document).ready(function () {

    // cuadrar altura de paneles laterales derechos
    //setSugeridosHeightAndScroll(true);
    //setAgendadosHeightAndScroll(true);


    //$('#demandas_tabla').DataTable();


    table = $('#demandas').DataTable({
        ajax: {
            url: "DemandaS",
            dataSrc: '',
            data: {
                'opcion': "allMe"
            }
        },
        columns: [
            {data: 'titulo'},
            {data: 'fecha_modificacion'},
            {data: 'fecha_creacion'},
            {data: null},
            {data: 'porcentaje'},
            {data: null},
        ],
        columnDefs: [
            {
                targets: -1,
                data: null,
                defaultContent: '<button type="button" class="btn btn-primary waves-effect">Abrir</button>'
            }
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });

    $('#demandas tbody').on('click', 'button', function () {
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
    localStorage.setItem("id_demanda",id_demanda);
    document.location.href='demanda.jsp';
}