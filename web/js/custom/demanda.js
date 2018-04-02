// Al cargar documento
        var id_demanda;

$(document).ready(function () {

    // Detectar id de la demanda enviado de listar
    if (localStorage.getItem("id_demanda") == null) {
        document.location.href = 'dashboard.jsp';
    } else {
        id_demanda = localStorage.getItem("id_demanda");
        //localStorage.removeItem("id_demanda");        
        //alert(localStorage.getItem("id_demanda"));
    }

    // Multi page form
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
        onInit: function (event, currentIndex) {
            $.AdminBSB.input.activate();

            //Set tab width
            var $tab = $(event.currentTarget).find('ul[role="tablist"] li');
            var tabCount = $tab.length;
            $tab.css('width', (100 / tabCount) + '%');

            //set button waves effect
            setButtonWavesEffect(event);

            $('#demanda_wizard :input').on('change', function () {
                $('#btnSave').show();
            });

            preLoadDemanda(id_demanda);
        },
        onStepChanged: function (event, currentIndex, priorIndex) {
            setButtonWavesEffect(event);
        }
    });

    // Agregar botón de guardar
    form.find('a').last().parent().parent()
            .prepend("<li><a style='display:none' href='#save' id='btnSave' name='btnSave' onclick='saveChanges()'>Guardar cambios</a></li>");

    // Area de grupos condicionales

    // Representante legal
    var dte_rep_tiene = $("#dte_rep_tiene"); // elemento checkbox
    var dte_rep_tiene_val; // valor del checkbox
    var dte_rep_tiene_section = $("#dte_rep_tiene_section"); // seccion que controla el checkbox

    dte_rep_tiene_val = dte_rep_tiene.prop("checked") ? true : false; // tomar valor
    //
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

// Apoderado
    var dte_apo_tiene = $("#dte_apo_tiene"); // elemento checkbox
    var dte_apo_tiene_val; // valor del checkbox
    var dte_apo_tiene_section = $("#dte_apo_tiene_section"); // seccion que controla el checkbox

    dte_apo_tiene_val = dte_apo_tiene.prop("checked") ? true : false; // tomar valor
    //
    // primera reaccion
    if (!dte_apo_tiene_val) {
        dte_apo_tiene_section.addClass("hidden");
    }
    //reaccion en el cambio del elemento
    dte_apo_tiene.on('change', function () {

        dte_apo_tiene_val = dte_apo_tiene.prop("checked") ? true : false;
        if (!dte_apo_tiene_val) {
            dte_apo_tiene_section.addClass("hidden");
        } else {
            dte_apo_tiene_section.removeClass("hidden");
        }
    });




    var foreignTableID = $('#live_form #div_foreignKey');
    var carInt = $('#live_form #div_carInt');
    var carSup = $('#live_form #div_carSup');
    var all = foreignTableID.add(carInt).add(carSup);

});
;
function setButtonWavesEffect(event) {
    $(event.currentTarget).find('[role="menu"] li a').removeClass('waves-effect');
    $(event.currentTarget).find('[role="menu"] li:not(.disabled) a').addClass('waves-effect');
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

            if (json.dte_rep_tiene) {
                $('#dte_rep_tiene').prop('checked', true);
            }

            $('#dte_rep_nom').val(json.dte_rep_nom);
            $('input:radio[name=dte_rep_id_tipo]').val([json.dte_rep_id_tipo]);
            $('#dte_rep_id').val(json.dte_rep_id);

            if (json.dte_apo_tiene) {
                $('#dte_apo_tiene').prop('checked', true);
            }

            $('#dte_apo_nom').val(json.dte_apo_nom);
            $('input:radio[name=dte_apo_id_tipo]').val([json.dte_apo_id_tipo]);
            $('#dte_apo_id').val(json.dte_apo_id);
            $('#dte_apo_tar_pro').val(json.dte_apo_tar_pro);
            $('#dte_dir_not').val(json.dte_dir_not);
            $('#dte_email').val(json.dte_email);



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
            'dte_rep_tiene': $("#dte_rep_tiene").is(":checked"),
            'dte_rep_nom': $('#dte_rep_nom').val(),
            'dte_rep_id_tipo': $('input:radio[name=dte_rep_id_tipo]:checked').val(),
            'dte_rep_id': $('#dte_rep_id').val(),
            'dte_apo_tiene': $("#dte_apo_tiene").is(":checked"),
            'dte_apo_nom': $('#dte_apo_nom').val(),
            'dte_apo_id_tipo': $('input:radio[name=dte_apo_id_tipo]:checked').val(),
            'dte_apo_id': $('#dte_apo_id').val(),
            'dte_apo_tar_pro': $('#dte_apo_tar_pro').val(),
            'dte_dir_not': $('#dte_dir_not').val(),
            'dte_email': $('#dte_email').val()
        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            if (json == true) {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('si se encontro el usuario');
                document.location.href = 'signin.html';
            } else {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('no se encontro el usuario');
                alert('Error desconocido');
            }
        },
        async: false
    });
}

