// Al cargar documento

$(document).ready(function () {

    // cuadrar altura de paneles laterales derechos
    //setSugeridosHeightAndScroll(true);
    //setAgendadosHeightAndScroll(true);


    //$('#demandas_tabla').DataTable();


    var table = $('#demandas').DataTable({
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
            {data: 'id_ayudante'},
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

function abrir(id_demanda) {
    localStorage.setItem("id_demanda",id_demanda);
    document.location.href='demanda.jsp';
}