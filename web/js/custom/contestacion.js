var id_contestacion;
var changesdone = false;

$(document).ready(function () {

    // Detectar id de la demanda enviado de listar y redireccionar
    if (localStorage.getItem("id_contestacion") == null) {
        document.location.href = 'dashboardContestaciones.jsp';
    } else {
        id_contestacion = localStorage.getItem("id_contestacion");
    }

    // Steps configuration
    var form = $('#contestacion_wizard').show();

    form.steps({
        headerTag: 'h2',
        bodyTag: 'section',
        transitionEffect: 'fade',
        enableAllSteps: true,
        labels:
                {
                    current: "Página actual:",
                    pagination: "Paginación",
                    finish: "Terminar",
                    next: "Siguiente",
                    previous: "Anterior",
                    loading: "Cargando ..."
                },
        onInit: function (event) {
            $.AdminBSB.input.activate();

            //Set tab width
            var $tab = $(event.currentTarget).find('ul[role="tablist"] li');
            var tabCount = $tab.length;
            $tab.css('width', (100 / tabCount) + '%');

            //set button waves effect
            setButtonWavesEffect(event);


// preload form with data from controller
            preLoadContestacion(id_contestacion);

            // set changes save button show
            $('#contestacion_wizard :input').on('change', function () {
                changesdone = true;
                $('#btnSave').show();
            });

        },
        onStepChanged: function (event) {
            setButtonWavesEffect(event);
        }
    });

    // Agregar botón de guardar
    form.find('a').last().parent().parent()
            .prepend("<li><a style='display:none' href='#save' id='btnSave' name='btnSave' onclick='saveChanges()'>Guardar cambios</a></li>");

    // configurar autosize
    autosize($('textarea.auto-growth'));



    // Area de grupos condicionales
// dem_apo_tiene conditional
    var ddo_apo_tiene = $('#ddo_apo_tiene '); // elemento checkbox
    var ddo_apo_tiene_val; // valor del checkbox
    var ddo_apo_tiene_section = $('#ddo_apo_tiene_section'); // seccion que controla el checkbox

    ddo_apo_tiene_val = ddo_apo_tiene.prop('checked') ? true : false; // tomar valor
    //
    // primera reaccion
    if (!ddo_apo_tiene_val) {
        ddo_apo_tiene_section.addClass('hidden');
    }
    //reaccion en el cambio del elemento
    ddo_apo_tiene.on('change', function () {

        ddo_apo_tiene_val = ddo_apo_tiene.prop('checked') ? true : false;
        if (!ddo_apo_tiene_val) {
            ddo_apo_tiene_section.addClass('hidden');
        } else {
            ddo_apo_tiene_section.removeClass('hidden');
        }
    });

    // conditionals end

    $('#pruebasfile').append(generateDropzone("Arrastre aquí los archivos de pruebas", "Los archivos serán guardados en su cuenta"));
    $('#anexosfile').append(generateDropzone("Arrastre aquí los archivos anexos", "Los archivos serán guardados en su cuenta"));

//Dropzone
    Dropzone.options.frmFileUpload = {
        paramName: "file",
        maxFilesize: 2
    };
});


function generateDropzone(title, subtitle) {

    return '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">'
            + '      <form action="/" id="frmFileUpload" class="dropzone" method="post" enctype="multipart/form-data">'
            + '              <div class="dz-message">'
            + '                 <div class="drag-icon-cph">'
            + '                     <i class="material-icons">touch_app</i>'
            + '                 </div>'
            + '                 <h3>' + title + '</h3>'
            + '                 <em>' + subtitle + '</em>'
            + '              </div>'
            + '              <div class="fallback">'
            + '                   <input name="file" type="file" multiple />'
            + '              </div>'
            + '          </form>'
            + '     </div>';

}

function preLoadContestacion(id_contestacion) {
    $.ajax({
        type: 'GET',
        url: "ContestacionS",
        //force to handle it as text
        data: {
            'opcion': "one",
            'id_contestacion': id_contestacion
        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            $('#proceso').val(json.proceso);
            $('#contra').val(json.contra);
            $('#id_contestacion').val(json.id_contestacion);
            $('#titulo').val(json.titulo);

            if (json.ddo_apo_tiene) {
                $('#ddo_apo_tiene').prop('checked', true).change();
            }
            $('#ddo_apo_nom').val(json.dte_apo_nom);
            $('input:radio[name=ddo_apo_id_tipo]').val([json.dte_apo_id_tipo]);
            $('#ddo_apo_id').val(json.dte_apo_id);
            $('#ddo_apo_tar_pro').val(json.dte_apo_tar_pro);

            $('#nombre_demandado').val(json.nombre_demandado);
            $('#ciudad_demandado').val(json.ciudad_demandado);
            $('input:radio[name=tipo_documento_demandado]').val([json.tipo_documento_demandado]);
            $('#documento_demandado').val(json.documento_demandado);
            $('#direccion_notificaciones').val(json.direccion_notificaciones);
            $('#email').val(json.email);
            if (json.pretenciones) {
                $('#pretenciones').prop('checked', true).change();
            }
            $('#hechos_admitidos').html(json.hechos_admitidos);
            $('#hechos_negados').html(json.hechos_negados);
            $('#explicacion_negados').html(json.explicacion_negados);
            $('#hechos_no_constan').html(json.hechos_no_constan);
            $('#explicacion_no_constan').html(json.explicacion_no_constan);
            $('#excepciones').html(json.excepciones);
            $('#reconocimiento').html(json.reconocimiento);

            if (json.retencion) {
                $('#retencion').prop('checked', true).change();
            }
            $('#pruebas').html(json.pruebas);
            $('#anexos ').html(json.anexos);
        },
        async: false
    });
}

function saveChanges() {
    $.ajax({
        type: 'POST',
        url: "ContestacionS",
        //force to handle it as text
        data: {
            'opcion': "update",
            'proceso': $('#proceso').val(),
            'contra': $('#contra').val(),
            'id_contestacion': $('#id_contestacion').val(),
            'titulo': $('#titulo').val(),

            'ddo_apo_tiene': $('#ddo_apo_tiene').is(":checked"),

            'ddo_apo_nom': $('#ddo_apo_nom').val(),
            'ddo_apo_id_tipo': $('input:radio[name=ddo_apo_id_tipo]:checked').val(),
            'ddo_apo_id': $('#ddo_apo_id').val(),
            'ddo_apo_tar_pro': $('#ddo_apo_tar_pro').val(),

            'nombre_demandado': $('#nombre_demandado').val(),
            'ciudad_demandado': $('#ciudad_demandado').val(),
            'tipo_documento_demandado': $('input:radio[name=tipo_documento_demandado]:checked').val(),
            'documento_demandado': $('#documento_demandado').val(),
            'direccion_notificaciones': $('#direccion_notificaciones').val(),
            'email': $('#email').val(),

            'pretenciones': $('#pretenciones').is(":checked"),

            'hechos_admitidos': $('#hechos_admitidos').val(),
            'hechos_negados': $('#hechos_negados').val(),
            'explicacion_negados': $('#explicacion_negados').val(),
            'hechos_no_constan': $('#hechos_no_constan').val(),
            'explicacion_no_constan': $('#explicacion_no_constan').val(),
            'excepciones': $('#excepciones').val(),
            'reconocimiento': $('#reconocimiento').val(),

            'retencion': $('#retencion').is(":checked"),

            'pruebas': $('#pruebas').val(),

            'anexos': $('#anexos ').val(),

        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            if (json == true) {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('si se actualizo');
            } else {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('no se actualizo');
                alert('Error desconocido');
            }
        },
        async: false
    });

    changesdone = false;
    location.reload();
}

// prevenir salida sin guardar cambios
window.onbeforeunload = function () {
    if (changesdone) {
        return 'Are you sure you want to navigate away from this page?';
    }
};

// borrar variable de storage
function resetStorageRedirect(redirect) {

    localStorage.clear();
    document.location.href = redirect;
}


function setButtonWavesEffect(event) {
    $(event.currentTarget).find('[role="menu"] li a').removeClass('waves-effect');
    $(event.currentTarget).find('[role="menu"] li:not(.disabled) a').addClass('waves-effect');
}





