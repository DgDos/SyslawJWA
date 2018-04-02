// Variables globales
        var datepicked;
var today;
var ePrivados;
var ePubAgendados;
var ePubSugerencias;

// Al cargar documento
$(document).ready(function () {

    // cuadrar altura de paneles laterales derechos
    setSugeridosHeightAndScroll(true);
    setAgendadosHeightAndScroll(true);

    // inicializar fecha en hoy
    today = new Date();
    today.setDate(today.getDate() - 7);

    datepicked = new Date(today);

    // generar dashboard
    generateDashboard();


});

// al redimensionar página
$(window).resize(function () {
    setSugeridosHeightAndScroll(false);
    setAgendadosHeightAndScroll(false);
});

function wipeDashboard() {
    var casillas = $('#horario td:not(#hora)')
    casillas.empty();
    casillas.removeClass();
    casillas.removeAttr('rowspan');
    casillas.unbind();
}

function generateDashboard() {

    // inicializar animacion de espera
    $('#dashboard-container').waitMe({
        effect: 'bounce',
        bg: 'rgba(255, 255, 255, 0.85)',
        color: '#f44336',
        maxSize: '',
        waitTime: -1,
        textPos: 'vertical',
        fontSize: '',
        source: '',
    });

    $('#date-loader').waitMe({
        effect: 'pulse',
        bg: 'rgba(255, 255, 255, 0.85)',
        color: '#f44336',
        maxSize: '',
        waitTime: -1,
        textPos: 'vertical',
        fontSize: '',
        source: '',
    });

    //obtener fecha guardada en string
    var dateS = datepicked.toISOString();

    console.log("actualizando horario");
    $.ajax({
        url: "StudentDash",
        type: 'GET',
        dataType: "text",
        data: {
            'date': dateS
        },
        success: function (data) {

            var json = $.parseJSON(data);

            // extraer arreglos
            ePrivados = json.ePrivados;
            ePubAgendados = json.ePubAgendados;
            ePubSugerencias = json.ePubSugerencias;

            startDate = new Date(json.startDate);
            endDate = new Date(json.endDate);
            $('#date-loader').empty().append(pickerDateRangeFormat(startDate, endDate))

            // para pruebas
            console.log(ePrivados);
            console.log(ePubAgendados);
            console.log(ePubSugerencias);

            // limpiar horario
            wipeDashboard();

            // ubicar eventos privados
            drawPrivateEvents();

            // ubicar eventos publicos agendados
            for (var i = 0; i < ePubAgendados.length; ++i) {
                drawScheduledEvent(i);
            }

            // ubicar sugerencias y tarjetas correspondientes
            for (var i = 0; i < ePubSugerencias.length; ++i)
            {
                drawSuggestion(i);
            }


            $('#dashboard-container').waitMe("hide");
            $('#date-loader').waitMe("hide");

        }
    });
}

function drawSuggestion(pos) {

    // obtener variables
    var sug = ePubSugerencias[pos];
    var ini = sug.hora_ini;
    var fin = sug.hora_fin;
    var day = sug.day;
    var eventos = sug.e;

    for (var a = parseInt(ini); a < parseInt(fin); a++) {
        var checkCas = $('#' + day + a);
        if (checkCas.hasClass("event-private") || checkCas.hasClass("event-private-disabled") || checkCas.hasClass("event-public") || checkCas.hasClass("hidden")) {
            $.notify({
                message: 'Error. Este horario no está disponible.',
                icon: 'fa fa-exclamation-triangle alert-span-icon'
            });
            return false;
        }
    }

    // dibujar casilla
    var casilla = $('#' + day + ini);
    casilla.addClass('event-suggest');
    casilla.addClass('event-relative');
    casilla.addClass('hor-whiteborder');
    casilla.attr('rowspan', fin - ini);
    casilla.css('cursor', 'pointer');

    // si ya paso el evento
    var dayNames = ["dom", "lun", "mar", "mie", "jue", "vie", "sab"];
    var dia_semana = today.getDay();
    var hora_hoy = today.getHours();
    var dia_evento = dayNames.indexOf(day);
    if (datepicked.getTime() < today.getTime() || datepicked.getTime() == today.getTime() && dia_evento <= dia_semana && fin <= hora_hoy) {
        casilla.addClass('past');
    }

    for (var i = 1; i < fin - ini; i++) {
        var casillaRedundante = $('#' + day + (parseInt(ini) + i));
        casillaRedundante.addClass('hidden');
    }

    casilla.append(eventos.length + " sugerencia" + ((eventos.length > 1) ? "s" : ""));

    casilla.click(function () {
        showSuggestionList(pos);
    });

    // dibujar tarjetas lado derecho
    var cardcontainer = $('#sugeridos-lista');
    var exists_interested = false;
    for (var i = 0; i < eventos.length; ++i)
    {
        var id = eventos[i].id_eventoP;
        var name = eventos[i].nombre_eveP;
        var day = eventos[i].dia;
        var desc = eventos[i].descripcion;

        var card = '<div class="card waves-effect waves-light" onclick="showSuggestedEvent(' + pos + ', ' + i + ');" style="cursor: pointer;">' +
                '<div class="header bg-orange">' +
                '<h2>' +
                name +
                '<small>' + day + '</small>' +
                '<small>' + desc + '</small>' +
                '</h2>';

        if (eventos[i].estado == 'int') {
            card += '<div class="event-star">'
                    + '    <i style="font-size: 30px;" class="material-icons">star_border</i>'
                    + '       </div>';
            exists_interested = true;
        }
        card += '</div>' +
                '</div>';

        cardcontainer.append(card);
    }

    if (exists_interested) {
        casilla.append('<div class="event-star">'
                + '    <i style="font-size: 30px;" class="material-icons">star_border</i>'
                + '       </div>');
    }
}

function drawScheduledEvent(pos) {

    // obtener variables
    var evento = ePubAgendados[pos];
    var name = evento.nombre_eveP;
    var org = evento.organizador_id;
    var desc = evento.descripcion;
    var day = evento.dia;
    var ini = evento.hora_ini;
    var fin = evento.hora_fin;

    // comprobar conflictos
    for (var a = parseInt(ini); a < parseInt(fin); a++) {
        var checkCas = $('#' + day + a);
        if (checkCas.hasClass("event-private") || checkCas.hasClass("hidden")) {
            $.notify({
                message: 'Error. Este horario no está disponible.',
                icon: 'fa fa-exclamation-triangle alert-span-icon'
            });
            return false;
        }
    }

    // dibujar la casilla
    var casilla = $('#' + day + ini);
    casilla.addClass('event-public');
    casilla.addClass('event-relative');
    casilla.addClass('hor-whiteborder');
    casilla.attr('rowspan', fin - ini);
    casilla.css('cursor', 'pointer');

    // si ya paso el evento
    var fecha_fin = new Date(evento.fecha_fin);

    if (fecha_fin < today || today.getTime() > datepicked.getTime()) {
        casilla.addClass('past');
    }

    for (var i = 1; i < fin - ini; i++) {
        var casillaRedundante = $('#' + day + (parseInt(ini) + i));
        casillaRedundante.addClass('hidden');
    }

    casilla.append(name);

    casilla.click(function () {
        showScheduledEvent(pos);
    });

    var cardcontainer = $('#agendados-lista');

    var card = '<div class="card waves-effect waves-light" onclick="showScheduledEvent(' + pos + ');" style="cursor: pointer;">' +
            '<div class="header bg-red">' +
            '<h2>' +
            name +
            '<small>' + day + '</small>' +
            '<small>' + desc + '</small>' +
            '</h2>' +
            '</div>' +
            '</div>';
    cardcontainer.append(card);
}

function drawPrivateEvents() {

    for (var pos = 0; pos < ePrivados.length; pos++)
    {
        var e = ePrivados[pos];
        var eventName = e.nombre;
        var day = e.dia;
        var startTime = e.horaInicio;
        var endTime = e.horaFinal;
        var id = e.eventoID;

        var casilla = $('#' + day + startTime);
        casilla.addClass('event-private-disabled');
        casilla.addClass('event-relative');
        casilla.addClass('hor-whiteborder');
        casilla.attr('rowspan', endTime - startTime);

        // si ya paso el evento
        var dayNames = ["dom", "lun", "mar", "mie", "jue", "vie", "sab"];
        var dia_semana = today.getDay();
        var hora_hoy = today.getHours();
        var dia_evento = dayNames.indexOf(day);

        var test1 = datepicked.getTime() < today.getTime();
        var test12 = datepicked.getTime() == today.getTime();
        var test2 = dia_evento < dia_semana;
        var test3 = endTime < hora_hoy

        if (datepicked.getTime() < today.getTime() || datepicked.getTime() == today.getTime() && dia_evento <= dia_semana && endTime <= hora_hoy) {
            casilla.addClass('past');
        }

        for (var i = 1; i < endTime - startTime; i++) {
            var casillaRedundante = $('#' + day + (parseInt(startTime) + i));
            casillaRedundante.addClass('hidden');
        }

        casilla.append(eventName);
    }



}

function showSuggestionList(pos) {

    var $sidebar = $('#rightsidebar');
    var $overlay = $('.overlay');
    $sidebar.removeClass('open');
    $overlay.fadeOut();


    var sug = ePubSugerencias[pos];

    var sug_container = $('#modal-sugerencias-container');
    sug_container.empty();

    var eventos = sug.e;

    $('#modEveSugTitulo').empty().append(eventos.length + ' sugerencia' + (((eventos.length > 1) ? "s" : "") + ' encontrada' + ((eventos.length > 1) ? "s" : "")));

    for (var i = 0; i < eventos.length; i++) {

        var name = eventos[i].nombre_eveP;
        var day = eventos[i].dia;
        var desc = eventos[i].descripcion;
        var card = '<div class="col-xs-12 col-md-6 card-section-waves">' +
                '<div class="card waves-effect waves-light" onclick="showSuggestedEvent(' + pos + ', ' + i + ');" style="cursor: pointer;">' +
                '<div class="header bg-orange">' +
                '<h2>' +
                name +
                '<small>' + day + '</small>' +
                '<small>' + desc + '</small>' +
                '</h2>';

        if (eventos[i].estado == 'int') {
            card += '<div class="event-star">'
                    + '    <i style="font-size: 30px;" class="material-icons">star_border</i>'
                    + '       </div>';
        }
        card += '</div>' +
                '</div>' +
                '   </div>';

        sug_container.append(card);
    }

    $('#modalListaSugerencias').modal('show');
}

function showScheduledEvent(pos1) {
    showPublicEvent('age', pos1, -1);
}

function showSuggestedEvent(pos1, pos2) {
    showPublicEvent('sug', pos1, pos2);
}

function showPublicEvent(type, pos1, pos2) {

    var $sidebar = $('#rightsidebar');
    var $overlay = $('.overlay');
    $sidebar.removeClass('open');
    $overlay.fadeOut();

    var evento;

    if (type == 'age') {
        evento = ePubAgendados[pos1];
    } else if (type == 'sug') {
        evento = ePubSugerencias[pos1].e[pos2];
    } else {
        alert("error");
    }

    $('#modEvePubTitulo').empty().append(evento.nombre_eveP);
    $('#modEvePubSub').empty().append(evento.cupo_actual + ' de ' + evento.cupo_inicial + ' cupos disponibles');
    $('#modEvePubOrg').empty().append(evento.organizador_name);
    $('#modEvePubFecha').empty().append(eventDateRangeFormat(new Date(evento.fecha_ini), new Date(evento.fecha_fin)));
    $('#modEvePubLoc').empty().append("Ubicación no implementada...");

    $('#modEvePubHeader').removeClass('bg-red');
    $('#modEvePubHeader').removeClass('bg-orange');

    var no = $('#modevepub-btn-asist-no').removeClass().unbind();
    var int = $('#modevepub-btn-asist-int').removeClass().unbind();
    var con = $('#modevepub-btn-asist-con').removeClass().unbind();

    if (type == 'age') {
        $('#modEvePubHeader').addClass('bg-red');

        no.addClass("btn btn-default waves-effect");
        int.addClass("btn btn-default waves-effect");
        con.addClass("btn btn-danger waves-effect");

        int.click(function () {
            changeEventStatus(evento.id_eventoP, 'int');
        });

        no.click(function () {
            changeEventStatus(evento.id_eventoP, 'no');
        });

    } else if (type == 'sug') {
        $('#modEvePubHeader').addClass('bg-orange');

        var estado = evento.estado;
        if (estado == 'int') {
            no.addClass("btn btn-default waves-effect");
            int.addClass("btn btn-warning waves-effect");
            con.addClass("btn btn-default waves-effect");

            no.click(function () {
                changeEventStatus(evento.id_eventoP, 'no');
            });

            con.click(function () {
                changeEventStatus(evento.id_eventoP, 'con');
            });
        } else {
            no.addClass("btn btn-warning waves-effect");
            int.addClass("btn btn-default waves-effect");
            con.addClass("btn btn-default waves-effect");

            int.click(function () {
                changeEventStatus(evento.id_eventoP, 'int');
            });

            con.click(function () {
                changeEventStatus(evento.id_eventoP, 'con');
            });

        }
    }

    $('#modalEventoPublico').modal('show');
    $('#modalListaSugerencias').modal('hide');
}

function changeEventStatus(evento_id, estado_nuevo) {
    //console.log(sugerencia);
    $.ajax({
        url: "StudentDash",
        dataType: "text",
        type: 'post',
        data: {
            'evento_id': evento_id,
            'estado_nuevo': estado_nuevo
        },
        async: false
    });

    $('#modalEventoPublico').modal('hide');
    generateDashboard();

}

function increaseWeek() {
    datepicked.setDate(datepicked.getDate() + 7);
    generateDashboard();
}

function decreaseWeek() {
    datepicked.setDate(datepicked.getDate() - 7);
    generateDashboard();
}

function resetWeek() {
    datepicked.setDate(today.getDate());
    generateDashboard();
}

function eventDateRangeFormat(date1, date2) {
    var monthNames = [
        "Enero", "Febrero", "Marzo",
        "Abril", "Mayo", "Junio", "Julio",
        "Agosto", "Septiembre", "Octubre",
        "Noviembre", "Diciembre"
    ];

    var day1 = date1.getDate();
    var monthIndex1 = date1.getMonth();
    var year1 = date1.getFullYear();
    var hours1 = date1.getHours();
    var minutes1 = date1.getMinutes();
    var ampm1 = hours1 >= 12 ? 'pm' : 'am';
    hours1 = hours1 % 12;
    hours1 = hours1 ? hours1 : 12; // the hour '0' should be '12'
    minutes1 = minutes1 < 10 ? '0' + minutes1 : minutes1;

    var day2 = date2.getDate();
    var monthIndex2 = date2.getMonth();
    var year2 = date2.getFullYear();
    var hours2 = date2.getHours();
    var minutes2 = date2.getMinutes();
    var ampm2 = hours2 >= 12 ? 'pm' : 'am';
    hours2 = hours2 % 12;
    hours2 = hours2 ? hours2 : 12; // the hour '0' should be '12'
    minutes2 = minutes2 < 10 ? '0' + minutes2 : minutes2;


    if (year2 == year1 && monthIndex2 == monthIndex1 && day2 == day1) {
        return day1 + ' de ' + monthNames[monthIndex1] + ' de ' + year1 + ', ' + hours1 + ':' + minutes1 + ' ' + ampm1 + ' - ' + hours2 + ':' + minutes2 + ' ' + ampm2;
    }

    return day1 + ' de ' + monthNames[monthIndex1] + ' de ' + year1 + ', ' + hours1 + ':' + minutes1 + ' ' + ampm1 + ' - ' + day1 + ' de ' + monthNames[monthIndex1] + ' de ' + year1 + ', ' + hours2 + ':' + minutes2 + ' ' + ampm2;
}

function pickerDateRangeFormat(date1, date2) {
    var monthNames = [
        "Ene", "Feb", "Mar",
        "Abr", "May", "Jun", "Jul",
        "Ago", "Sep", "Oct",
        "Nov", "Dic"
    ];

    var day1 = date1.getDate();
    var monthIndex1 = date1.getMonth();
    var year1 = date1.getFullYear();

    var day2 = date2.getDate();
    var monthIndex2 = date2.getMonth();
    var year2 = date2.getFullYear();

    if (year2 == year1 && monthIndex2 == monthIndex1) {
        return monthNames[monthIndex1] + ' ' + day1 + ' - ' + day2;
    }

    return monthNames[monthIndex1] + ' ' + day1 + ' - ' + monthNames[monthIndex2] + ' ' + day2;
}

/* Tooltip solo aparece on hover */
$('[data-toggle="tooltip"]').tooltip({
    trigger: 'hover'
})




function setSugeridosHeightAndScroll(isFirstTime) {
    var height = $(window).height() - ($('.navbar').innerHeight() + $('.right-sidebar .nav-tabs').outerHeight());
    var $el = $('.sugeridos-lista');

    if (!isFirstTime) {
        $el.slimScroll({destroy: true}).height('auto');
        $el.parent().find('.slimScrollBar, .slimScrollRail').remove();
    }

    $el.slimscroll({
        height: height + 'px',
        color: 'rgba(0,0,0,0.5)',
        size: '6px',
        alwaysVisible: false,
        borderRadius: '0',
        railBorderRadius: '0'
    });
}

//Setting tab content set height and show scroll
function setAgendadosHeightAndScroll(isFirstTime) {
    var height = $(window).height() - ($('.navbar').innerHeight() + $('.right-sidebar .nav-tabs').outerHeight());
    var $el = $('.right-sidebar .agendados-lista');

    if (!isFirstTime) {
        $el.slimScroll({destroy: true}).height('auto');
        $el.parent().find('.slimScrollBar, .slimScrollRail').remove();
    }

    $el.slimscroll({
        height: height + 'px',
        color: 'rgba(0,0,0,0.5)',
        size: '6px',
        alwaysVisible: false,
        borderRadius: '0',
        railBorderRadius: '0'
    });
}
