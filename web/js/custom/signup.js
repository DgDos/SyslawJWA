
$('#agregarPersona').on('submit', function () {
    if ($('#agregarPersona').valid()) {
        var nombre = $('#nombre').val();
        var tipo_documento = $('input[name=tipo_documento]:checked').val();
        var documento = $('#documento').val();
        var ciudad = $('#ciudad').val();
        var direccion = $('#direccion').val();
        var correo = $('#correo').val();
        var contrasena = $('#password').val();

        addPersona(nombre, tipo_documento, documento, ciudad, direccion, correo, contrasena);

        return false;
    }
});

$('#agregarAbogado').on('submit', function () {
    if ($('#agregarAbogado').valid()) {

        $.ajax({
            type: 'POST',
            url: "Register",
            //force to handle it as text
            data: {
                'tipo_usuario': 2,
                'nombre': $('#nombre').val(),
                'tipo_documento': $('input[name=tipo_documento]:checked').val(),
                'documento': $('#documento').val(),
                'tarjeta': $('#tarjeta').val(),
                'ciudad': $('#ciudad').val(),
                'direccion': $('#direccion').val(),
                'correo': $('#correo').val(),
                'pass': $('#password').val()

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


        return false;
    }
});

function addPersona(name, tipo_documento, documento, ciudad, direccion, correo, password) {

    $.ajax({
        type: 'POST',
        url: "Register",
        //force to handle it as text
        data: {
            'tipo_usuario': 1,
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
                
                $("#message").empty().append('<a href="login"><span style="width: 100%; font-size: 14px" class="badge bg-green">Usuario agregado con éxito! Ingresar ahora</span></a>');
                $("#message").removeClass("hidden");
            } else {
                // Aqui debe modificar la pagina de alguna forma con jQuery para mostrar el mensaje
                console.log('no se encontro el usuario');
                $("#message").empty().append('<a href="#"><span style="width: 100%; font-size: 14px" class="badge bg-red">Error desconocido. No se agregó el usuario.</span></a>');
                $("#message").removeClass("hidden");
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
            'documento': {
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
    
    $('#agregarAbogado').validate({
        rules: {
            'terms': {
                required: true
            },
            'correo': {
                remote: 'Register'
            },
            'documento': {
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
            remote: "Ya registrado. Intente con otro valor.",
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
        }
    });
});