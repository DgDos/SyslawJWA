$(document).ready(function () {
});

$('#sign_in').on('submit', function () {

    var correo = $('#correo').val();
    var pass = $('#pass').val();

    verificarPersona(correo, pass);
    return false;
});

function verificarPersona(correo, pass) {
    quitarErrorIniciar();
    $.ajax({
        type: 'POST',
        url: "Login",
        //force to handle it as text
        data: {
            'correo': correo,
            'pass': pass
        },
        dataType: "text",
        success: function (data) {

            var encontro = data;
            if (encontro == 'si') {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('si se encontro el usuario');
                document.location.href = 'dashboard.jsp';
            } else if (encontro == 'no') {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('no se encontro el usuario');
                errorIniciar();
            }
        },

    });
}

function errorIniciar() {
    $('#correo').parents('.form-line').addClass('error');
    $('#correo').focus();
    $('#correo').val('');
    $('#pass').parents('.form-line').addClass('error');
    var mess = '<label id="labelIncorrecto" class="error" for="usuario">Usuario o contraseña incorrecto/a</label>';
    $('#pass').parents('.input-group').append(mess);
    $('#pass').val('');
}
function quitarErrorIniciar() {
    $('#correo').parents('.form-line').removeClass('error');
    $('#pass').parents('.form-line').removeClass('error');
    $('#labelIncorrecto').remove();
}
$(function () {
    $('#sign_in').validate({

        highlight: function (input) {
            console.log(input);
            $(input).parents('.form-line').addClass('error');
        },
        unhighlight: function (input) {
            $(input).parents('.form-line').removeClass('error');
        },
        errorPlacement: function (error, element) {
            $(element).parents('.input-group').append(error);
            $(element).parents('.form-group').append(error);
        }
    });

    $.extend($.validator, {
        messages: {
            required: "Este es un campo requerido",
            remote: "Please fix this field.",
            email: "Ingrese un correo válido.",
            url: "Please enter a valid URL.",
            date: "Please enter a valid date.",
            dateISO: "Please enter a valid date (ISO).",
            number: "Please enter a valid number.",
            digits: "Please enter only digits.",
            equalTo: "Las contraseñas no coinciden.",
            maxlength: $.validator.format("Please enter no more than {0} characters."),
            minlength: $.validator.format("Please enter at least {0} characters."),
            rangelength: $.validator.format("Please enter a value between {0} and {1} characters long."),
            range: $.validator.format("Please enter a value between {0} and {1}."),
            max: $.validator.format("Please enter a value less than or equal to {0}."),
            min: $.validator.format("Please enter a value greater than or equal to {0}."),
            step: $.validator.format("Please enter a multiple of {0}.")
        },
    });
});

