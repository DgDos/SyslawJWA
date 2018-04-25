$(document).ready(function () {
});

$('#agregarPersona').on('submit', function () {

    var nombre = $('#nombre').val(); 
    var tipo_documento = $('input[name=tipo_documento]:checked').val();
    var documento = $('#documento').val();
    var ciudad = $('#ciudad').val();
    var direccion = $('#direccion').val();
    var correo = $('#correo').val();
    var contrasena = $('#password').val();

    addPersona(nombre, tipo_documento, documento, ciudad, direccion, correo, contrasena );

    return false;
});

function addPersona(name, tipo_documento, documento, ciudad, direccion, correo, password ) {

    $.ajax({
        type: 'POST',
        url: "Register",
        //force to handle it as text
        data: {
            'nombre': name,
            'tipo_documento': tipo_documento, 
            'documento': documento,
            'ciudad': ciudad,
            'direccion': direccion,
            'correo': correo,
            'pass': password
            
        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            if (json == true) {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('si se encontro el usuario');
                document.location.href='signin.html';
            } else {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('no se encontro el usuario');    
                alert('Error desconocido'); 
            }
        },
        async: false
    });
}


$(function () {
    $('#agregarPersona').validate({
        rules: {
            'terms': {
                required: true
            },
            'correo': {
                remote: 'Register'
            },
            'confirm': {
                equalTo: '[name="password"]'
            }
        },

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
            remote: "Este correo ya está registrado",
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