var id_demanda;
var changesdone = false;

$(document).ready(function () {

    // Detectar id de la demanda enviado de listar y redireccionar
    if (localStorage.getItem("id_demanda") == null) {
        document.location.href = 'dashboard.jsp';
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

            // set changes save button show
            $('#demanda_wizard :input').on('change', function () {
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

    // Representante legal
    var dte_rep_tiene = $("#dte_rep_tiene"); // elemento checkbox
    var dte_rep_tiene_val; // valor del checkbox
    var dte_rep_tiene_section = $("#dte_rep_tiene_section"); // seccion que controla el checkbox

    dte_rep_tiene_val = dte_rep_tiene.prop("checked") ? true : false; // tomar valor

    // primera reaccion
    if (!dte_rep_tiene_val) {
        dte_rep_tiene_section.addClass("hidden");
    }
    //reaccion en el cambio del elemento
    dte_rep_tiene.on('change', function () {

        dte_rep_tiene_val = dte_rep_tiene.prop("checked") ? true : false;
        if (!dte_rep_tiene_val) {
            dte_rep_tiene_section.addClass("hidden");
        } else {
            dte_rep_tiene_section.removeClass("hidden");
        }
    });


    // conditionals start


    // dte_apo_tiene conditional
    var dte_apo_tiene = $('#dte_apo_tiene'); // elemento checkbox
    var dte_apo_tiene_val; // valor del checkbox
    var dte_apo_tiene_section = $('#dte_apo_tiene_section'); // seccion que controla el checkbox

    dte_apo_tiene_val = dte_apo_tiene.prop('checked') ? true : false; // tomar valor
    //
    // primera reaccion
    if (!dte_apo_tiene_val) {
        dte_apo_tiene_section.addClass('hidden');
    }
    //reaccion en el cambio del elemento
    dte_apo_tiene.on('change', function () {

        dte_apo_tiene_val = dte_apo_tiene.prop('checked') ? true : false;
        if (!dte_apo_tiene_val) {
            dte_apo_tiene_section.addClass('hidden');
        } else {
            dte_apo_tiene_section.removeClass('hidden');
        }
    });



// dem_apo_tiene conditional
    var dem_apo_tiene = $('#dem_apo_tiene'); // elemento checkbox
    var dem_apo_tiene_val; // valor del checkbox
    var dem_apo_tiene_section = $('#dem_apo_tiene_section'); // seccion que controla el checkbox

    dem_apo_tiene_val = dem_apo_tiene.prop('checked') ? true : false; // tomar valor
    //
    // primera reaccion
    if (!dem_apo_tiene_val) {
        dem_apo_tiene_section.addClass('hidden');
    }
    //reaccion en el cambio del elemento
    dem_apo_tiene.on('change', function () {

        dem_apo_tiene_val = dem_apo_tiene.prop('checked') ? true : false;
        if (!dem_apo_tiene_val) {
            dem_apo_tiene_section.addClass('hidden');
        } else {
            dem_apo_tiene_section.removeClass('hidden');
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


