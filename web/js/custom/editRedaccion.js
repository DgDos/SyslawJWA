var id_demanda;
var changesdone = false;
var analized = false;
var errors = 0;
var walkEnable = false;
var tituloInicial = "";



$(document).ready(function () {

    $("#titulo_text").click(function () {
        $(".target").effect("highlight", {color: "#669966"}, 3000);
    });

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
    if (changesdone) {
        swal({
            title: "¿Desea guardar sus cambios?",
            text: "Para analizar su demanda, es requerido guardar o descartar los cambios realizados. <br> Si selecciona no guardar, todos su cambios sin guardar se perderán permanentemente.",
            type: "warning",
            html: true,
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Guardar cambios y analizar",
            cancelButtonText: "Descartar cambios y analizar",
            closeOnConfirm: true,
            closeOnCancel: true
        }, function (isConfirm) {
            if (isConfirm) {
                saveChanges();
                swal.close();
                analizarDemanda();
            } else {
                changesdone = false;
                preLoadDemanda(id_demanda);
                analizarDemanda();
                swal.close();
            }
        });
    } else {

        $('#analisisDemanda').modal('show');

        $.ajax({
            type: 'GET',
            url: "PdfS",
            data: {
                'id_demanda': id_demanda
            },
            dataType: "text",
            success: function (data) {
                var json = $.parseJSON(data);
                var errores = $('#analisis_errores_area').empty();
                var advertencias = $('#analisis_advertencias_area').empty();
                var correctos = $('#analisis_correctos_area').empty();

                var erroresCount = 0;
                var advertenciasCount = 0;
                var correctosCount = 0;

                analisisMarkClean();
                analisisPopoverClean();

                for (var i = 0; i < json.length; i++) {
                    var not = json[i];
                    var append = genNotAnalisis(not.id, not.titulo, not.content, not.code);
                    analisisMarkError(not.id, not.code);
                    agregarPopoverError(not.id, not.titulo, not.content, not.code)
                    switch (not.code) {
                        case 1:
                            errores.append(append);
                            erroresCount++;
                            break;
                        case 2:
                            advertencias.append(append);
                            advertenciasCount++;
                            break;
                        case 3:
                            correctos.append(append);
                            correctosCount++;
                            break;
                        default:
                            break;
                    }
                }
                if (erroresCount > 0) {
                    errores.children("div:last").remove();
                }
                if (advertenciasCount > 0) {
                    advertencias.children("div:last").remove();
                }
                if (correctosCount > 0) {
                    correctos.children("div:last").remove();
                }

                $('#errores_count').text(erroresCount);
                $('#advertencias_count').text(advertenciasCount);
                $('#correctos_count').text(correctosCount);

                analized = true;
                errors = erroresCount;


            },
            async: false
        });
    }


}


var erroresCount = 0;
var advertenciasCount = 0;
var correctosCount = 0;
var errores = $('#analisis_errores_area').empty();
var advertencias = $('#analisis_advertencias_area').empty();
var correctos = $('#analisis_correctos_area').empty();

var campos_nombres = new Map();
campos_nombres.set('juez_nombre', 'Señor, juez municipal de');
campos_nombres.set('dte_nom', 'Nombre del demandante');
campos_nombres.set('dte_ciudad', 'Ciudad del demandante');
campos_nombres.set('dte_id_tipo', 'Tipo de id del demandante');
campos_nombres.set('dte_id', 'Identificación del demandante');
campos_nombres.set('dte_dir_not', 'Dirección donde recibe notificaciones:');
campos_nombres.set('dte_email', 'Dirección de correo electrónico');
campos_nombres.set('dte_apo_tiene', 'Apoderado');
campos_nombres.set('dte_apo_nom', 'Nombre del apoderado');
campos_nombres.set('dte_apo_id_tipo', 'Tipo de identificación');
campos_nombres.set('dte_apo_id', 'Numero de identificación');
campos_nombres.set('dte_apo_tar_pro', 'Tarjeta profesional No.');
campos_nombres.set('dem_nom', 'Nombre del demandado');
campos_nombres.set('dem_id_tipo', 'Tipo de id del demandado');
campos_nombres.set('dem_id', 'Identificación del demandado');
campos_nombres.set('dem_ciu', 'Ciudad de domicilio del demandado');
campos_nombres.set('dem_dir_not', 'Dirección donde recibe notificaciones:');
campos_nombres.set('dem_email', 'Dirección de correo electrónico');
campos_nombres.set('pretensiones', 'Pretensiones');
campos_nombres.set('depende_cumplimiento', 'Manifiesto que');
campos_nombres.set('tengo_pruebas', 'Manifiesto bajo juramento que');
campos_nombres.set('hechos', 'Hechos');
campos_nombres.set('pruebas', 'Pruebas');
campos_nombres.set('fundamentos', 'Fundamentos de derecho');
campos_nombres.set('anexos', 'Anexos');
campos_nombres.set('solicito_cautelares', 'Solicito medidas cautelares');
campos_nombres.set('cautelares_que_solicita', 'Medidas cautelares que solicita');


var campos_paginas = new Map();
campos_paginas.set('juez_nombre', 0);
campos_paginas.set('dte_nom', 0);
campos_paginas.set('dte_ciudad', 0);
campos_paginas.set('dte_id_tipo', 0);
campos_paginas.set('dte_id', 0);
campos_paginas.set('dte_dir_not', 0);
campos_paginas.set('dte_email', 0);
campos_paginas.set('dte_apo_tiene', 0);
campos_paginas.set('dte_apo_nom', 0);
campos_paginas.set('dte_apo_id_tipo', 0);
campos_paginas.set('dte_apo_id', 0);
campos_paginas.set('dte_apo_tar_pro', 0);
campos_paginas.set('dem_nom', 1);
campos_paginas.set('dem_ciu', 1);
campos_paginas.set('dem_dir_not', 1);
campos_paginas.set('dem_email', 1);
campos_paginas.set('dem_id_tipo', 1);
campos_paginas.set('dem_id', 1);
campos_paginas.set('pretensiones', 2);
campos_paginas.set('depende_cumplimiento', 2);
campos_paginas.set('tengo_pruebas', 2);
campos_paginas.set('hechos', 3);
campos_paginas.set('pruebas', 4);
campos_paginas.set('fundamentos', 5);
campos_paginas.set('anexos', 5);
campos_paginas.set('solicito_cautelares', 5);
campos_paginas.set('cautelares_que_solicita', 5);

var paginas_nombres = new Map();
paginas_nombres.set(0, 'Demandante');
paginas_nombres.set(1, 'Demandado');
paginas_nombres.set(2, 'Pretensiones');
paginas_nombres.set(3, 'Hechos');
paginas_nombres.set(4, 'Pruebas');
paginas_nombres.set(5, 'Otros');


function genNotAnalisis(campo, titulo, texto, tipo) {

    var buttonClass = "";

    switch (tipo) {
        case 1:
            buttonClass = "ab-red";
            break;
        case 2:
            buttonClass = "ab-orange";
            break;
        case 3:
            buttonClass = "ab-green";
            titulo = "Campo lleno";
            texto = "No encontramos problemas en este campo";

            break;
        default:
            break;
    }

    return '<div class="col-lg-1">'
            + '                          <button type="button" onClick = "analisisGoTo(\'' + campo + '\')" class="btn btn-circle-lg waves-effect waves-circle waves-float analisis-button ' + buttonClass + '">'
            + '                              <i class="material-icons">search</i>'
            + '                          </button>                                                               '
            + '                      </div>'
            + '                      <div class="col-lg-4">'
            + '                          <h4>' + campos_nombres.get(campo) + '<small><br>' + paginas_nombres.get(campos_paginas.get(campo)) + '</small></h4>'
            + '                      </div>'
            + '                      <div class="col-lg-7">'
            + '                          <p style="margin-top: 8px"><b>' + titulo + '</b><br>' + texto + '</p>'
            + '                      </div>'
            + '                      <div class="col-lg-12">'
            + '                          <hr>'
            + '                      </div>'
}
function analisisMarkError(campo, tipo) {

    var myClassField = "";
    var myClassLabel = "";
    if (tipo == 1) {
        myClassField = "error";
        myClassLabel = "col-red";
    } else if (tipo == 2) {
        myClassField = "warning";
        myClassLabel = "col-orange";
    } else if (tipo == 3) {
        myClassField = "success";
        myClassLabel = "col-green";
    }

    $("#" + campo).parent().addClass(myClassField);
    $("label[for='" + campo + "']").addClass(myClassLabel);

}

function analisisMarkClean() {
    $('form#demanda_wizard label').removeClass();
    $("form#demanda_wizard :input").parent('.form-line').removeClass().addClass("form-line");
}


function analisisGoTo(campo) {

    $('#analisisDemanda').modal('hide');

    var bool = false;

    bool = $('#demanda_wizard').steps("setStep", campos_paginas.get(campo));
    setTimeout(function () {

        $("#" + campo).focus();
        $("#" + campo).focus();
        goToByScroll(campo);

    }, 400);

}

function goToByScroll(id) {

    $('html,body').animate({
        scrollTop: $("#" + id).offset().top - 150},
            'slow');
}

function analisisPopoverClean() {
    $(":button.analisis-tooltip-mark").remove();
}

function agregarPopoverError(campo_id, titulo, mensaje, tipoError) {

    var myClass = "";
    var myIcon = "";
    if (tipoError == 1) {
        myClass = "ft-error";
        myIcon = "cancel";
    } else if (tipoError == 2) {
        myClass = "ft-warning";
        myIcon = "warning";
    } else if (tipoError == 3) {
        myClass = "ft-success";
        myIcon = "check_circle";
    } else {
        return;
    }

    var popover = '<button type="button" class="btn btn-sm btn-transparent analisis-tooltip-mark form-tooltip ' + myClass + '" data-trigger="hover focus" data-container="body" data-toggle="popover"'
            + '    data-placement="right" '
            + '    data-html="true" '
            + '    title="' + titulo + '" '
            + '   data-content="' + mensaje + '">'
            + '<i class="material-icons">' + myIcon + '</i>'
            + '</button>';

    $("#" + campo_id + "_popover_area").empty().append(popover);

    $("[data-toggle=popover]").popover();


}

function generatePDF() {
    if (changesdone) {
        swal({
            title: "¿Desea guardar sus cambios?",
            text: "Para previsualizar su demanda, es requerido guardar o descartar los cambios realizados. <br> Si selecciona no guardar, todos su cambios sin guardar se perderán permanentemente.",
            type: "warning",
            html: true,
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Guardar cambios y exportar",
            cancelButtonText: "Descartar cambios y exportar",
            closeOnConfirm: true,
            closeOnCancel: true
        }, function (isConfirm) {
            if (isConfirm) {
                saveChanges();
                generatePDF();
            } else {
                changesdone = false;
                preLoadDemanda(id_demanda);
                generatePDF();
            }
        });
    } else {
        $.ajax({
            type: 'POST',
            url: "PdfS",
            //force to handle it as text
            data: {
                'id_demanda': id_demanda
            },
            dataType: "text",
            success: function (data) {
                var json = $.parseJSON(data);
                var win = window.open(json, '_blank');
                if (win) {
                    //Browser has allowed it to be opened
                    win.focus();
                } else {
                    //Browser has blocked it
                    alert('Please allow popups for this website');
                }
            },
            async: false
        });
    }
}




function enviarConnectShow() {
    if (changesdone) {
        swal({
            title: "¿Desea guardar sus cambios?",
            text: "Para previsualizar su demanda, es requerido guardar o descartar los cambios realizados. <br> Si selecciona no guardar, todos su cambios sin guardar se perderán permanentemente.",
            type: "warning",
            html: true,
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Guardar cambios y enviar",
            cancelButtonText: "Descartar cambios y enviar",
            closeOnConfirm: false,
            closeOnCancel: false
        }, function (isConfirm) {
            if (isConfirm) {
                saveChanges(false);
                preLoadDemanda(id_demanda);
                enviarConnectShow();
            } else {
                changesdone = false;
                preLoadDemanda(id_demanda);
                enviarConnectShow();
            }
        });
    } else {
        if (!analized) {
            swal({
                title: "¿Desea analizar su demanda?",
                text: "Para enviar su demanda a un abogado le recomendamos que analice su demanda con nuestro sistema",
                type: "warning",
                html: true,
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Analizar",
                cancelButtonText: "No analizar y enviar",
                closeOnConfirm: false,
                closeOnCancel: false
            }, function (isConfirm) {
                if (isConfirm) {
                    analizarDemanda();
                    swal.close();
                } else {
                    analized = true;
                    enviarConnectShow();
                }
            });
        } else {
            if (errors > 0) {
                swal({
                    title: "Advertencias graves",
                    text: "El último análisis realizado encontró " + errors + " advertencias importantes en tu demanda. Te recomendamos realizar un nuevo análisis hasta que no tengas más advertencias, antes de enviar tu demanda a un abogado.",
                    type: "warning",
                    html: true,
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "Analizar de nuevo",
                    cancelButtonText: "Ignorar errores y enviar",
                    closeOnConfirm: false,
                    closeOnCancel: false
                }, function (isConfirm) {
                    if (isConfirm) {
                        analizarDemanda();
                        swal.close();
                    } else {
                        errors = 0;
                        enviarConnectShow();
                    }
                });
            } else {
                swal.close();
                $('#toConnectModal').modal('show');
            }
        }
    }
}

function enviarConnect() {
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
            var json = $.parseJSON(data);
            if (json == true) {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('enviado a revision');
                document.location.href = 'revision';
            } else {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('no se pudo');
                swal("¡No se puedo hacer el pago!", "Revisa tu saldo", "error");
            }
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
            'state': 5
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

            $('#pretensiones').html(json.pretensiones);
            $('#hechos').html(json.hechos);
            if (json.depende_cumplimiento) {
                $('#depende_cumplimiento').prop('checked', true).change();
            }
            if (json.tengo_pruebas) {
                $('#tengo_pruebas').prop('checked', true).change();
            }
            $('#pruebas').html(json.pruebas);
            $('#fundamentos').html(json.fundamentos);
            $('#anexos').html(json.anexos);
            if (json.solicito_cautelares) {
                $('#solicito_cautelares').prop('checked', true).change();
            }
            $('#cautelares_que_solicita').html(json.cautelares_que_solicita);

            changesdone = false;

            analized = false;
            errors = 0;
            analisisMarkClean();
            analisisPopoverClean();

        },
        async: false
    });
}

function saveChanges() {
    saveChanges(true);
}

function saveChanges(showNot) {
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

            'pretensiones': $('#pretensiones').val(),
            'hechos': $('#hechos').val(),
            'depende_cumplimiento': $("#depende_cumplimiento").is(":checked"),
            'tengo_pruebas': $("#tengo_pruebas").is(":checked"),
            'pruebas': $('#pruebas').val(),
            'fundamentos': $('#fundamentos').val(),
            'anexos': $('#anexos').val(),
            'solicito_cautelares': $("#solicito_cautelares").is(":checked"),
            'cautelares_que_solicita': $('#cautelares_que_solicita').val()

        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            if (json == true) {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('si se actualizo');
                if (showNot) {
                    swal("¡Cambios guardados!", "Todos los cambios fueron guardados con éxito", "success");

                    analized = false;
                    errors = 0;
                }

                preLoadDemanda(id_demanda);
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





