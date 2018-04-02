// Al cargar documento
var id_demanda;

$(document).ready(function () {

    if (localStorage.getItem("id_demanda") == null) {
        document.location.href = 'dashboard.jsp';
    } else {
        id_demanda = localStorage.getItem("id_demanda");
        //localStorage.removeItem("id_demanda");        
        //alert(localStorage.getItem("id_demanda"));
    }
    /*
     $("dte_ciudad").onchange(function () {
     alert("The text has been changed.");
     });
     */



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
        },
        onStepChanged: function (event, currentIndex, priorIndex) {
            setButtonWavesEffect(event);
        }
    }).find('a').last().parent().parent().prepend("<li><a style='display:none' href='#save' id='btnSave' name='btnSave' onclick='saveMe()'>Save</a></li>");
    ;


    /*
     var lastStep = 2;
     $("#demanda_wizard").steps({
     headerTag: "h2",
     bodyTag: "section",
     transitionEffect: "slideLeft",
     onStepChanged: function (event, currentIndex, priorIndex) {
     //console.log(currentIndex);
     if (true)
     $('#btnSave').show();
     else
     $('#btnSave').hide();
     },
     autoFocus: true,
     onFinishing: function () {
     alert("Hello");
     },
     }).find('a').last().parent().parent().prepend("<li><a style='display:none' href='#save' id='btnSave' name='btnSave' onclick='saveMe()'>Save</a></li>");
     */
});
;
function setButtonWavesEffect(event) {
    $(event.currentTarget).find('[role="menu"] li a').removeClass('waves-effect');
    $(event.currentTarget).find('[role="menu"] li:not(.disabled) a').addClass('waves-effect');
}

function saveMe() {
    alert('Saving');
}

