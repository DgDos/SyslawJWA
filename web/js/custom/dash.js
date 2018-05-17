// Al cargar documento

        var table;
var walkEnable = false;

$(document).ready(function () {

    // cuadrar altura de paneles laterales derechos
    //setSugeridosHeightAndScroll(true);
    //setAgendadosHeightAndScroll(true);

    //Widgets count
    //$('.count-to').countTo();

    // Para marcar la pagina activa
    $('#menu_default').removeClass("active");
    $('#menu_dash').addClass("active");
     walkEnable = true;
    if (walkEnable) {
        $.walk([
            {
                target: '#tour_misdemandas',
                content: 'Bienvenido/a a tu Dashboard de SYSLAW! Continúa para hacer el recorrido por la aplicación.',
                color: '#0b57a7',
                acceptText: 'Siguiente'
            },
            {
                target: '#menu_dash',
                content: 'En el dashboard principal encontrarás un resumen de tus demandas.',
                color: '#0780d6',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_redaccion',
                content: 'El primer estado de tu demanda es el de <b>redacción</b>. En esta etapa tu escribes la demanda y la puedes editar en cualquier momento.',
                color: '#0b57a7',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_enviadas',
                content: 'Una vez redactada tu demanda, podrás <b>enviarla</b>. En esta etapa, ya no podrás editar el contenido de la misma, pero podrás descargar el PDF para imprimirla.',
                color: '#d07c00',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_revision',
                content: 'Si antes de enviar tu demanda, quieres ayuda profesional, podrás obtenerla a través de nuestro fácil servicio SYSLAW Connect.',
                color: '#017c8c',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_revision2',
                content: 'Aquí verás las demandas SYSLAW Connect que ya han sido revisadas por tu abogado asignado. El uso de SYSLAW Connect es totalmente opcional.    ',
                color: '#4d7d14',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_addbutton',
                content: 'Para crear tu <b>primera demanda</b>, usa el botón de "agregar demanda" en la esquina superior derecha.',
                color: '#0b57a7',
                acceptText: 'Siguiente'
            },
            {
                target: '#menu_faq',
                content: '<b>Esperamos disfrutes tu experiencia con SYSLAW.</b><br><br> Si necesitas ayuda, puedes encontrarla en nuestra sección de ayuda en el menú lateral.',
                color: '#4c319e',
                acceptText: '¡Comenzar Experiencia!'
            }
        ]);
    }

    //$('#demandas_tabla').DataTable();




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
    document.location.href = 'demanda.jsp';
}

function wait(ms) {
    var start = new Date().getTime();
    var end = start;
    while (end < start + ms) {
        end = new Date().getTime();
    }
}