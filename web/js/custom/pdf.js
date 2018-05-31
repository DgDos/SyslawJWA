$(document).ready(function () {
    $('#botonPDF').on('click',function() {
        $.ajax({
            type: 'POST',
            url: "PdfS",
            //force to handle it as text
            data: {
                'id_demanda': "8"
            },
            dataType: "text",
            success: function (data) {
                var json = $.parseJSON(data);
                window.location.href = json;
            },
            async: false
        });   
    });
});