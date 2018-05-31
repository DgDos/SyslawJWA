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
    walkEnable = false;
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
                content: 'Al usar el servicio SYSLAW Connect, se asignará un abogado quien revisará tu demanda y te ayudará a corregirla y mejorarla. Este paso es totalmente opcional.',
                color: '#4d7d14',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_addbutton',
                content: 'Para crear tu <b>primera demanda</b>, usa el botón "+" de la esquina superior derecha.',
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

    getEstadisticas();

});

function tour() {
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
                content: 'Al usar el servicio SYSLAW Connect, se asignará un abogado quien revisará tu demanda y te ayudará a corregirla y mejorarla. Este paso es totalmente opcional.',
                color: '#4d7d14',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_addbutton',
                content: 'Para crear tu <b>primera demanda</b>, usa el botón "+" de la esquina superior derecha.',
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

function getEstadisticas() {
    $.ajax({
        type: 'GET',
        url: "DemandaS",
        //force to handle it as text
        data: {
            'opcion': "veces"
        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            var e1 = 0, e2 = 0, e3 = 0, e4 = 0;

            for (var i = 0; i < json.length; i++) {
                var item = json[i];

                var estado = item.estado;

                switch (estado) {
                    case "1":
                        e1 += item.cuenta;
                        break;
                    case "2":
                        e2 += item.cuenta;
                        break;
                    case "3":
                        e2 += item.cuenta;
                        break;
                    case "4":
                        e3 += item.cuenta;
                        break;
                    case "5":
                        e4 += item.cuenta;
                        break;
                    default:
                        break;
                }
            }

            $('#redaccion_num').empty().text(e1);
            $('#espera_num').empty().text(e2);
            $('#revisadas_num').empty().text(e3);
            $('#enviadas_num').empty().text(e4);

        },
        async: false
    });
}



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