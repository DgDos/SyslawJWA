var changesMade = false;

$(document).ready(function () {
    updateView();
    changesMade = false;
    $('#add-event-toogle').css('margin-bottom', '-=' + $('#add-event-toogle').outerHeight() + '');

});

$(window).unload(function () {
    cancelarCambios();
    return null;
});

window.onbeforeunload = function () {
    if (changesMade) {
        return 'Are you sure you want to navigate away from this page?';
    }
};

/* Al enviar formulario de agregar evento */
$('#agregarEvento').on('submit', function () {

    var evento_nombre = $('#eventoNombre').val();
    var evento_dia = $('#eventoDia').val();
    var evento_inicio = $('#eventoInicio').val();
    var evento_fin = $('#eventoFin').val();

    if (parseInt(evento_inicio) >= parseInt(evento_fin)) {
        $.notify({
            message: 'La hora de fin del evento debe ser mayor a la hora de inicio.',
            icon: 'fa fa-exclamation-triangle alert-span-icon'
        });
        return false;
    }

    /* revisar conflictos del horario */

    for (var a = parseInt(evento_inicio); a < parseInt(evento_fin); a++) {
        var checkCas = $('#' + evento_dia + a);
        if (checkCas.hasClass("event-private") || checkCas.hasClass("hidden")) {
            $.notify({
                message: 'Error. Este horario no está disponible.',
                icon: 'fa fa-exclamation-triangle alert-span-icon'
            });
            return false;
        }
    }

    addEvent(evento_nombre, evento_dia, evento_inicio, evento_fin);
    updateView();

    return false;
});

/* Al enviar formulario de agregar evento */
$('#modificarEventoForm').on('submit', function () {

    var evento_id = $('#eventoModID').val();
    var evento_nombre = $('#eventoModName').val();
    var evento_dia = $('#eventoModDay').val();
    var evento_inicio = $('#eventoModStart').val();
    var evento_fin = $('#eventoModEnd').val();

    if (parseInt(evento_inicio) >= parseInt(evento_fin)) {
        $.notify({
            message: 'La hora de fin del evento debe ser mayor a la hora de inicio.',
            icon: 'fa fa-exclamation-triangle alert-span-icon'
        });
        return false;
    }

    /* revisar conflictos del horario */

    for (var a = parseInt(evento_inicio); a < parseInt(evento_fin); a++) {
        var checkCas = $('#' + evento_dia + a);
        if (!checkCas.hasClass('eveid' + evento_id)) {
            if ((checkCas.hasClass("event-private") || checkCas.hasClass("hidden"))) {
                $.notify({
                    message: 'Error. Este horario no está disponible.',
                    icon: 'fa fa-exclamation-triangle alert-span-icon'
                });
                return false;
            }
        }
    }

    modificarEvento(evento_id, evento_nombre, evento_dia, evento_inicio, evento_fin);
    updateView();

    return false;
});

function addEvent(eventName, day, startTime, endTime) {

    $.ajax({
        url: "StudentBase",
        dataType: "text",
        type: 'post',
        data: {
            'action': "add",
            'nombre': eventName,
            'dia': day,
            'inicio': startTime,
            'fin': endTime
        },
        async: false
    });
}

function cancelarCambios() {

    $.ajax({
        url: "StudentBase",
        dataType: "text",
        type: 'post',
        data: {
            'action': "cancel"
        },
        async: false
    });

    updateView();
    changesMade = false;
}

function confirmarCambios() {

    $.ajax({
        url: "StudentBase",
        dataType: "text",
        type: 'post',
        data: {
            'action': "confirm"
        },
        async: false
    });

    updateView();
    $.notify({
        message: 'Eventos actalizados satisfactoriamente',
        icon: 'fa fa-check alert-span-icon'
    });
    changesMade = false;
}

function updateView() {

    $.ajax({
        url: "StudentBase",
        type: 'GET',
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            console.log(json);

            var casillas = $('#horario td:not(#hora)')
            casillas.empty();
            casillas.removeClass();
            casillas.removeAttr('rowspan');

            for (var i = 0; i < json.length; ++i)
            {
                renderEvent(json[i].nombre, json[i].dia, json[i].horaInicio, json[i].horaFinal, json[i].eventoID);
            }
        }
    });

    changesMade = true;
}

function renderEvent(eventName, day, startTime, endTime, eventID) {

    var casilla = $('#' + day + startTime);
    casilla.addClass('event-private');
    casilla.addClass('event-relative');
    casilla.addClass('hor-whiteborder');
    casilla.addClass('eveid' + eventID);
    casilla.attr('rowspan', endTime - startTime);

    for (var i = 1; i < endTime - startTime; i++) {
        var casillaRedundante = $('#' + day + (parseInt(startTime) + i));
        casillaRedundante.addClass('hidden');
        casillaRedundante.addClass('eveid' + eventID);
    }

    casilla.append(eventName);
    var buttons = '<div class="event-bottom">' +
            '<span style="cursor: pointer;" onClick="verEvento(' + eventID + ');"><i class="material-icons">zoom_in</i></span>&nbsp;' +
            '<span style="cursor: pointer;" onClick="modificarEventoGenerateModal(' + eventID + ',\'' + eventName + '\',\'' + day + '\',' + startTime + ',' + endTime + ');"><i class="material-icons">mode_edit</i></span>&nbsp;' +
            '<span style="cursor: pointer;" onClick="eliminarEvento(' + eventID + ');"><i class="material-icons">delete</i></div></span>';
    casilla.append(buttons);


}

function verEvento(eventID) {
    //alert('ver' + eventID);
}

function modificarEventoGenerateModal(evento_id, eventName, day, startTime, endTime) {
    $('#eventoModID').val(evento_id);
    $('#eventoModName').val(eventName);
    $('#eventoModDay').val(day).change();
    ;
    $('#eventoModStart').val(startTime).change();
    ;
    $('#eventoModEnd').val(endTime).change();
    ;
    $('#modificarEvento').modal('show');

}
function modificarEvento(eventID, eventName, day, startTime, endTime) {
    $.ajax({
        url: "StudentBase",
        dataType: "text",
        type: 'post',
        data: {
            'action': 'update',
            'evento_id': eventID,
            'nombre': eventName,
            'dia': day,
            'inicio': startTime,
            'fin': endTime
        },
        async: false
    });
    $('#modificarEvento').modal('hide');
}
function eliminarEvento(eventID) {
    $.ajax({
        url: "StudentBase",
        dataType: "text",
        type: 'post',
        data: {
            'custom_method': 'DELETE',
            'action': 'deleteone',
            'evento_id': eventID
        },
        async: false
    });
    updateView();
}

function eliminarTodosEventos() {
    $.ajax({
        url: "StudentBase",
        dataType: "text",
        type: 'post',
        data: {
            'custom_method': 'DELETE',
            'action': 'deleteall',
            'usuario_id': 0
        },
        async: false
    });
    updateView();
}

function toogleAddEvent() {

    if ($('#toogle-add-event-icon').text() == 'add') {
        $('#toogle-add-event-icon').empty();
        $('#toogle-add-event-icon').append('keyboard_arrow_up');
        $('#add-event-toogle').addClass('header-toogle-show');
        $('#add-event-toogle').css('margin-bottom', '0px');
    } else {
        $('#toogle-add-event-icon').empty();
        $('#toogle-add-event-icon').append('add');
        $('#add-event-toogle').removeClass('header-toogle-show');
        $('#add-event-toogle').css('margin-bottom', '-=' + $('#add-event-toogle').outerHeight() + '');
    }
}

/* Tooltip solo aparece on hover */
$('[data-toggle="tooltip"]').tooltip({
    trigger: 'hover'
}) 