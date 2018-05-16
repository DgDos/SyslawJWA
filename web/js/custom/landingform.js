
$('#landingform').on('submit', function () {
    var nombre = $('#nombre').val();
    var correo = $('#correo').val();
    var beta = $("#beta").is(":checked");

    submitLanding(nombre, correo, beta);

    return false;

});

function successMessage() {
    swal("¡Suscripción exitosa!", "Te contactaremos tan pronto comiencen las pruebas beta!", "success")
}

function cleanForm() {
    $('#nombre').val("");
    $('#correo').val("");
    $('#beta').prop('checked', true).change();
}

function duplicateMessage() {
    swal("Ya estás suscrito", "Ya estás registrado con el correo actual. Intenta con un correo distinto.", "warning")
}

function submitLanding(name, correo, beta) {

    $.ajax({
        type: 'POST',
        url: "LandingS",
        //force to handle it as text
        data: {
            'nombre': name,
            'correo': correo,
            'beta': beta

        },
        dataType: "text",
        success: function (data) {

            var json = $.parseJSON(data);
            if (json == true) { 
                cleanForm();
                successMessage();
            } else {
                duplicateMessage();
            }
        },
        async: false
    });
}