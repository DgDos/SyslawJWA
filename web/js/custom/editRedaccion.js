var id_demanda;
var changesdone = false;
var walkEnable = false;
var tituloInicial = "";

$(document).ready(function () {



    // Para marcar la pagina activa
    $('#menu_default').removeClass("active");
    $('#menu_redaccion').addClass("active");



    // Detectar id de la demanda enviado de listar y redireccionar
    if (localStorage.getItem("id_demanda") == null) {
        document.location.href = 'redaccion';
    } else {
        id_demanda = localStorage.getItem("id_demanda");
    }

    // Steps configuration
    var form = $('#demanda_wizard').show();

    form.steps({
        headerTag: 'h2',
        bodyTag: 'section',
        transitionEffect: 'fade',
        enableAllSteps: true,
        enableFinishButton: false,
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
            preLoadDemanda(id_demanda);

            tituloInicial = $('#titulo').val();

            // set changes save button show
            $('#demanda_wizard :input').on('keyup change', function () {
                changesdone = true;
                $('#btnSave').show();
            });






        },
        onStepChanged: function (event) {
            setButtonWavesEffect(event);
            $("[data-toggle=tooltip]").tooltip();
        }
    });

    // Agregar botón de guardar
    form.find('a').last().parent().parent()
            .prepend("<li><a style='display:none' href='#save' id='btnSave' name='btnSave' onclick='saveChanges()'>Guardar cambios</a></li>");

    // configurar autosize
    autosize($('textarea.auto-growth'));


    if (walkEnable) {
        $.walk([
            {
                target: '#demanda_wizard-t-0',
                content: 'Tu demanda se divide en 6 secciones. La primera es la del demandante.',
                color: '#404fcd',
                acceptText: 'Siguiente'
            },
            {
                target: '#demanda_wizard-t-1',
                content: 'Puedes cambiar entre secciones haciendo click en los selectores de sección.',
                color: '#565656',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_botones',
                content: 'Usa la barra de herramientas superior para realizar acciones como renombrar, guardar, analizar, descargar, enviar a SYSLAW Connect y terminar tu demanda.',
                color: '#1e85e9',
                acceptText: 'Siguiente'
            },
            {
                target: '#tour_guardar',
                content: 'No olvides guardar tus cambios, pues estos no se guardarán automáticamente. Sin embargo, la página no te dejará salir sin avisarte de guardar.',
                color: '#5230bd',
                acceptText: '¡Redactar mi demanda!'
            }
        ]);
    }

    $('[data-toggle="popover"]').popover();

    // Area de grupos condicionales



    // dte_apo_tiene conditional
    var dte_apo_tiene = $('#dte_apo_tiene'); // elemento checkbox
    var dte_apo_tiene_val; // valor del checkbox
    var dte_apo_tiene_section = $('#dte_apo_tiene_section'); // seccion que controla el checkbox
    var dte_apo_tiene_not = $('#alert_poder'); // seccion que controla el checkbox

    dte_apo_tiene_val = dte_apo_tiene.prop('checked') ? true : false; // tomar valor
    //
    // primera reaccion
    if (!dte_apo_tiene_val) {
        dte_apo_tiene_section.addClass('hidden');
        dte_apo_tiene_not.addClass('hidden');
    }
    //reaccion en el cambio del elemento
    dte_apo_tiene.on('change', function () {

        dte_apo_tiene_val = dte_apo_tiene.prop('checked') ? true : false;
        if (!dte_apo_tiene_val) {
            dte_apo_tiene_section.addClass('hidden');
            dte_apo_tiene_not.addClass('hidden');
        } else {
            dte_apo_tiene_section.removeClass('hidden');
            dte_apo_tiene_not.removeClass('hidden');
        }
    });



// solicito_cautelares conditional
    var solicito_cautelares = $('#solicito_cautelares'); // elemento checkbox
    var solicito_cautelares_val; // valor del checkbox
    var solicito_cautelares_section = $('#solicito_cautelares_section'); // seccion que controla el checkbox

    solicito_cautelares_val = solicito_cautelares.prop('checked') ? true : false; // tomar valor
    //
    // primera reaccion
    if (!solicito_cautelares_val) {
        solicito_cautelares_section.addClass('hidden');
    }
    //reaccion en el cambio del elemento
    solicito_cautelares.on('change', function () {

        solicito_cautelares_val = solicito_cautelares.prop('checked') ? true : false;
        if (!solicito_cautelares_val) {
            solicito_cautelares_section.addClass('hidden');
        } else {
            solicito_cautelares_section.removeClass('hidden');
        }
    });




    // conditionals end

    //$('#pruebasfile').append(generateDropzone("Arrastre aquí los archivos de pruebas", "Los archivos serán guardados en su cuenta"));
    //$('#anexosfile').append(generateDropzone("Arrastre aquí los archivos anexos", "Los archivos serán guardados en su cuenta"));



//Dropzone
    Dropzone.options.frmFileUpload = {
        paramName: "file",
        maxFilesize: 2
    };
    //verifica si un demandado se encuentra en la app
    $("#botonVerificacion").on('click', function () {
        $.ajax({
            type: 'GET',
            url: "UsuarioS",
            data: {
                'opcion': "existUser",
                'documento': $("#dem_id").val()
            },
            dataType: "text",
            success: function (data) {
                var json = $.parseJSON(data);
                $('#dem_nom').val(json.nombre);
                $('#dem_id').val(json.documento);
                $('input:radio[name=dem_id_tipo]').val([json.tipo_id]);
                $('#dem_ciu').val(json.ciudad);
                $('#dem_dir_not').val(json.direccion);
                $('#dem_email').val(json.correo);
            },
            async: false
        });
    });
    //al finalizar una demanda
    $("#finalizar").on('click', function () {
        saveChanges();
        $.ajax({
            type: 'POST',
            url: "DemandaS",
            data: {
                'opcion': "endDone",
                'id_demanda': $('#id_demanda').val()
            },
            dataType: "text",
            success: function (data) {
                window.location.replace("/SyslawJWA/dashboard.jsp");
            },
            async: false
        });
    });
});

function editTitleModal() {
    $('#editTitleModal').modal('show');
}

$('#editTitleModal').on('hidden.bs.modal', function () {
    $('#titulo').val(tituloInicial);
    $('#titulo_text').text("");
    $('#titulo_text').append('<i onclick="" style="margin-right: 8px" class="material-icons">description</i>' + $('#titulo').val());
    $('#editTitleModal').modal('hide');
});

$('#modifyTitle').on('submit', function () {
    return false;
});

function editTitleModalConfirm() {
    tituloInicial = $('#titulo').val();

    // cambios realizados
    changesdone = true;
    $('#btnSave').show();

    $('#titulo_text').text("");
    $('#titulo_text').append('<i onclick="" style="margin-right: 8px" class="material-icons">description</i>' + tituloInicial);
    $('#editTitleModal').modal('hide');
}

function ayudaAnalisis() {
    $.walk([
            {
                target: '#analizarButton',
                content: 'Inicia el análisis haciendo click en el botón Analizar Demanda.',
                color: '#404fcd',
                acceptText: 'Siguiente'
            }
        ]);
}

function analizarDemanda() {
    alert('analizando demanda');
}

function analizarDemandaShow() {
    $('#analisisDemanda').modal('show');
    analizarDemanda();
}

function enviarConnect() {
    alert('enviando a abogado');
    $.ajax({
        type: 'POST',
        url: "DemandaS",
        data: {
            'opcion': "endState",
            'id_demanda': $('#id_demanda').val(),
            'state': 2
        },
        dataType: "text",
        success: function (data) {
            document.location.href = 'revision';
        },
        async: false
    });
}

function finalizarDemanda() {
    alert('finalizando demanda');
    $.ajax({
        type: 'POST',
        url: "DemandaS",
        data: {
            'opcion': "endState",
            'id_demanda': $('#id_demanda').val(),
            'state': 4
        },
        dataType: "text",
        success: function (data) {
            document.location.href = 'enviadas';
        },
        async: false
    });
}

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

function preLoadDemanda(id_demanda) {
    $.ajax({
        type: 'GET',
        url: "DemandaS",
        //force to handle it as text
        data: {
            'opcion': "one",
            'id_demanda': id_demanda,
        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            $('#id_demanda').val(json.id_demanda);
            $('#titulo').val(json.titulo);
            tituloInicial = json.titulo;
            $('#titulo_text').text("");
            $('#titulo_text').append('<i onclick="" style="margin-right: 8px" class="material-icons">description</i>' + tituloInicial);


            $('#juez_nombre').val(json.juez_nombre);

            $('#dte_nom').val(json.dte_nom);
            $('#dte_ciudad').val(json.dte_ciudad);
            $('input:radio[name=dte_id_tipo]').val([json.dte_id_tipo]);
            $('#dte_id').val(json.dte_id);
            $('#dte_dir_not').val(json.dte_dir_not);
            $('#dte_email').val(json.dte_email);

            if (json.dte_apo_tiene) {
                $('#dte_apo_tiene').prop('checked', true).change();
            }
            $('#dte_apo_nom').val(json.dte_apo_nom);
            $('input:radio[name=dte_apo_id_tipo]').val([json.dte_apo_id_tipo]);
            $('#dte_apo_id').val(json.dte_apo_id);
            $('#dte_apo_tar_pro').val(json.dte_apo_tar_pro);

            $('#dem_nom').val(json.dem_nom);
            $('#dem_id').val(json.dem_id);
            $('input:radio[name=dem_id_tipo]').val([json.dem_id_tipo]);
            $('#dem_ciu').val(json.dem_ciu);
            $('#dem_dir_not').val(json.dem_dir_not);
            $('#dem_email').val(json.dem_email);

            if (json.dem_apo_tiene) {
                $('#dem_apo_tiene').prop('checked', true).change();
            }
            $('#dem_apo_nom').val(json.dem_apo_nom);
            $('#pretensiones').html(json.pretensiones);
            $('#hechos').html(json.hechos);
            if (json.depende_cumplimiento) {
                $('#depende_cumplimiento').prop('checked', true).change();
            }
            if (json.tengo_pruebas) {
                $('#tengo_pruebas').prop('checked', true).change();
            }
            $('#pruebas').html(json.pruebas);
            if (json.estaba_obligado) {
                $('#estaba_obligado ').prop('checked', true).change();
            }
            $('#fundamentos').html(json.fundamentos);
            $('#anexos ').html(json.anexos);
            if (json.solicito_cautelares) {
                $('#solicito_cautelares').prop('checked', true).change();
            }
            $('#cautelares_que_solicita').html(json.cautelares_que_solicita);
        },
        async: false
    });
}

function saveChanges() {
    $.ajax({
        type: 'POST',
        url: "DemandaS",
        //force to handle it as text
        data: {
            'opcion': "update",
            'id_demanda': $('#id_demanda').val(),
            'titulo': $('#titulo').val(),

            'juez_nombre': $('#juez_nombre').val(),

            'dte_nom': $('#dte_nom').val(),
            'dte_ciudad': $('#dte_ciudad').val(),
            'dte_id_tipo': $('input:radio[name=dte_id_tipo]:checked').val(),
            'dte_id': $('#dte_id').val(),
            'dte_dir_not': $('#dte_dir_not').val(),
            'dte_email': $('#dte_email').val(),

            'dte_apo_tiene': $("#dte_apo_tiene").is(":checked"),
            'dte_apo_nom': $('#dte_apo_nom').val(),
            'dte_apo_id_tipo': $('input:radio[name=dte_apo_id_tipo]:checked').val(),
            'dte_apo_id': $('#dte_apo_id').val(),
            'dte_apo_tar_pro': $('#dte_apo_tar_pro').val(),

            'dem_nom': $('#dem_nom').val(),
            'dem_ciu': $('#dem_ciu').val(),
            'dem_id_tipo': $('input:radio[name=dem_id_tipo]:checked').val(),
            'dem_id': $('#dem_id').val(),
            'dem_dir_not': $('#dem_dir_not').val(),
            'dem_email': $('#dem_email').val(),

            'dem_apo_tiene': $("#dem_apo_tiene").is(":checked"),
            'dem_apo_nom': $('#dem_apo_nom').val(),
            'pretensiones': $('#pretensiones').val(),
            'hechos': $('#hechos').val(),
            'depende_cumplimiento': $("#depende_cumplimiento").is(":checked"),
            'tengo_pruebas': $("#tengo_pruebas").is(":checked"),
            'pruebas': $('#pruebas').val(),
            'estaba_obligado ': $("#estaba_obligado ").is(":checked"),
            'fundamentos': $('#fundamentos').val(),
            'anexos ': $('#anexos ').val(),
            'solicito_cautelares': $("#solicito_cautelares").is(":checked"),
            'cautelares_que_solicita': $('#cautelares_que_solicita').val()

        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            if (json == true) {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('si se actualizo');
                swal("¡Cambios guardados!", "Todos los cambios fueron guardados con éxito", "success");
                changesdone = false;
                location.reload();
            } else {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('no se actualizo');
                swal("¡No se guardaron los cambios!", "Se produjo un error desconocido", "error");
            }
        },
        async: false
    });


}

/* Tooltip solo aparece on hover */
$('[data-toggle="tooltip"]').tooltip({
    trigger: 'hover'
})

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





