<%@page import="Model.Usuario"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Redactar | Syslaw</title>
        <!-- Favicon-->
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:200,400,700&amp;subset=cyrillic" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500" rel="stylesheet">

        <!-- Bootstrap Core Css -->
        <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Waves Effect Css -->
        <link href="plugins/node-waves/waves.css" rel="stylesheet" />

        <!-- JQuery DataTable Css -->
        <link href="plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">

        <!-- Animation Css -->
        <link href="plugins/animate-css/animate.css" rel="stylesheet" />

        <!-- FontAwesome Css -->
        <link href="plugins/font-awesome/css/font-awesome.css" rel="stylesheet" />

        <!-- Bootstrap Select Css -->
        <link href="plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />

        <link href="plugins/jquery-spinner/css/bootstrap-spinner.css" rel="stylesheet">

        <!-- Dropzone Css -->
        <link href="plugins/dropzone/dropzone.css" rel="stylesheet">

        <!-- Custom Css -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />

        <!-- Sweetalert Css -->
        <link href="plugins/sweetalert/sweetalert.css" rel="stylesheet" />

        <!--WaitMe Css-->
        <link href="plugins/waitme/waitMe.css" rel="stylesheet" />

        <!-- material walkthrough -->
        <link href="plugins/material-walkthrough/material-walkthrough.css" rel="stylesheet" />

        <style>
            .fadeIn {
                -webkit-animation: fadeIn 0.5s; /* Safari 4+ */
                -moz-animation:    fadeIn 0.5s; /* Fx 5+ */
                -o-animation:      fadeIn 0.5s; /* Opera 12+ */
                animation:         fadeIn 0.5s; /* IE 10+, Fx 29+ */
            }
        </style>


    </head>

    <body class="theme-blue" style="background-color: #f1f1f1;">

        <!-- Page Loader -->
        <div class="page-loader-wrapper p-l-w-dark">
            <div class="loader">
                <div class="preloader">
                    <div class="spinner-layer pl-white">
                        <div class="circle-clipper left">
                            <div class="circle"></div>
                        </div>
                        <div class="circle-clipper right">
                            <div class="circle"></div>
                        </div>
                    </div>
                </div>
                <p>Por favor espere...</p>
            </div>
        </div>
        <!-- #END# Page Loader -->
        <!-- Overlay For Sidebars -->
        <div class="overlay"></div>
        <!-- #END# Overlay For Sidebars -->
        <!-- Search Bar -->
        <div class="search-bar">
            <div class="search-icon">
                <i class="material-icons">search</i>
            </div>
            <input type="text" placeholder="START TYPING...">
            <div class="close-search">
                <i class="material-icons">close</i>
            </div>
        </div>
        <!-- #END# Search Bar -->
        <!-- Top Bar -->
        <nav class="navbar">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                    <a href="javascript:void(0);" class="bars"></a>
                    <a class="navbar-brand" href="index.html">SysLaw</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse">

                    <ul class="nav navbar-nav navbar-right">
                        <!-- Call Search 
                        <li><a href="javascript:void(0);" class="js-search" data-close="true"><i class="material-icons">search</i></a></li>
                        #END# Call Search 
                        <li class="pull-right"><a href="javascript:void(0);" class="js-right-sidebar" data-close="true"><i class="material-icons">more_vert</i></a></li>-->

                    </ul>
                </div>
            </div>
        </nav>
        <!-- #Top Bar -->
        <section>
            <!-- Left Sidebar -->
            <aside id="leftsidebar" class="sidebar">
                <!-- User Info -->
                <div class="user-info">
                    <div class="py-5 text-center">
                        <img class="d-block mx-auto mb-4" src="images/syslaw_dash_info_2.svg" alt="" width="230" style="margin-top: 25px; margin-bottom: 10px;">
                    </div>
                    <div class="info-container">
                        <%
                            if (request.getSession().getAttribute("usuario") != null) {
                                Usuario u = (Usuario) request.getSession().getAttribute("usuario");
                        %>
                        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="usuarioNombre"><%=u.getNombre()%></div>
                        <div class="email"><%=u.getCorreo()%></div>
                        <%
                            } else {
                                response.sendRedirect("login");
                            }
                        %>

                        <div class="btn-group user-helper-dropdown">
                            <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                            <ul class="dropdown-menu pull-right">
                                <li><a href="javascript:void(0);"><i class="material-icons">person</i>Perfil</a></li>
                                <li role="seperator" class="divider"></li>
                                <li><a onClick="logout();"><i class="material-icons">input</i>Cerrar Sesión</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- #User Info -->
                <!-- Menu -->
                <%@include file="util/menu.jsp" %>
                <!-- #Menu -->
                <!-- Footer -->
                <div class="legal">
                    <div class="copyright">
                        &copy; 2018 <a href="javascript:void(0);">SysLaw</a>.
                    </div>
                    <div class="version">
                        <b>Version: </b> 0.0.1
                    </div>
                </div>
                <!-- #Footer -->
            </aside>

        </section>

        <section class="content">
            <div class="container-fluid">
                <div class="row clearfix">

                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">


                        <div class="body" id="dashboard-container" style="background-color: #f1f1f1;"> 
                            <div class="row clearfix">
                                <div class="col-xs-6 col-sm-6" style="margin-top: 5px">
                                    <h2 style="margin-bottom: 15px;text-transform: none;" id="titulo_text">Título de la demanda</h2>
                                </div>
                                <div class="col-xs-12 col-sm-6 align-right" style="margin-top: 15px">
                                    <span  id="tour_botones" >
                                        <button style="background-color: #601ab1 !important;" type="button" onclick="editTitleModal();" data-original-title="Editar título" data-toggle="tooltip" data-placement="bottom" class="btn bg-syslaw waves-effect btn-no-shadow">
                                            <i class="material-icons">mode_edit</i>
                                        </button>
                                        <!--                                        
                                        </button>
                                        <button style="background-color: #e4e4e4 !important;" type="button" onclick="deleteDemanda();" data-original-title="Eliminar demanda" data-toggle="tooltip" data-placement="bottom" class="btn btn-transparent waves-effect btn-no-shadow">
                                            <i class="material-icons">delete</i>
                                        </button>
                                        -->
                                        <button style="background-color: #5230bd !important;" id="tour_guardar" type="button" data-original-title="Guardar cambios" onclick='saveChanges()' data-toggle="tooltip" data-placement="bottom" class="btn bg-syslaw waves-effect btn-no-shadow">
                                            <i class="material-icons">save</i>
                                        </button>
                                        <button style="background-color: #4543c6 !important;"  type="button" data-original-title="Análisis automático de la demanda" onclick='analizarDemanda()' data-toggle="tooltip" data-placement="bottom" class="btn bg-syslaw waves-effect btn-no-shadow">
                                            <i class="material-icons">spellcheck</i>
                                        </button>
                                        <button style="background-color: #365ed4 !important;"  type="button" data-original-title="Enviar para revisión de abogado en SYSLAW Connect"  onclick='enviarConnectShow()' data-toggle="tooltip" data-placement="bottom" class="btn bg-syslaw waves-effect btn-no-shadow">
                                            <i class="material-icons">people</i>
                                        </button>
                                        <button style="background-color: #1e85e9 !important;"  type="button" data-original-title="Previsualizar PDF"  onclick='generatePDF()' data-toggle="tooltip" data-placement="bottom" class="btn bg-syslaw waves-effect btn-no-shadow">
                                            <i class="material-icons">file_download</i>
                                        </button>
                                        <button style="background-color: #119af5 !important;" type="button" data-original-title="Marcar demanda como terminada" data-toggle="tooltip"  onclick='finalizarDemanda()'data-placement="bottom" class="btn bg-syslaw waves-effect btn-no-shadow">
                                            <i class="material-icons">check</i>
                                        </button>
                                    </span>
                                </div>
                            </div>


                            <div class="card">
                                <div class="body">

                                    <form id="demanda_wizard" autocomplete="off">


                                        <h2>Demandante</h2>
                                        <section>
                                            <div class="row clearfix">   
                                                <div class="col-md-12 hidden">
                                                    <label for="id_demanda">ID</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" id="id_demanda" class="form-control" placeholder="Ingrese el ID...">
                                                        </div>
                                                    </div>
                                                </div>  
                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Juez</h3>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="juez_nombre">Señor, juez municipal de</label>
                                                    <span id='juez_nombre_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="50" type="text" id="juez_nombre" class="form-control" placeholder="Ingrese la ciudad del juez...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Demandante</h3>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dte_nom">Nombre del demandante</label>
                                                    <span id='dte_nom_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="50" type="text" id="dte_nom" class="form-control" placeholder="Ingrese el nombre...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dte_ciudad">Ciudad del demandante</label>
                                                    <span id='dte_ciudad_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="20" type="text" id="dte_ciudad" class="form-control" placeholder="Ingrese la ciudad...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dte_id_tipo">Tipo de ID del demandante</label>
                                                    <span id='dte_id_tipo_popover_area'></span>
                                                    <div class="id-type-radio">
                                                        <input name="dte_id_tipo" type="radio" id="radio_dte_id_tipo_1" value="0"  class="with-gap radio-col-blue" checked="">
                                                        <label for="radio_dte_id_tipo_1">C.C</label>
                                                        <!--
                                                        <input name="dte_id_tipo" type="radio" id="radio_dte_id_tipo_2" value="1" class="with-gap radio-col-blue">
                                                        <label for="radio_dte_id_tipo_2">NIT</label>
                                                        -->
                                                        <input name="dte_id_tipo" type="radio" id="radio_dte_id_tipo_3" value="2" class="with-gap radio-col-blue">
                                                        <label for="radio_dte_id_tipo_3">TI</label>
                                                        <input name="dte_id_tipo" type="radio" id="radio_dte_id_tipo_4" value="3" class="with-gap radio-col-blue">
                                                        <label for="radio_dte_id_tipo_4">PASAPORTE</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dte_id">ID del demandante</label>
                                                    <span id='dte_id_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="20" type="text" id="dte_id" class="form-control" placeholder="Número de identificación...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dte_dir_not">Dirección donde recibe notificaciones:</label>
                                                    <span id='dte_dir_not_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="100" type="text" id="dte_dir_not"  class="form-control" placeholder="Dirección de notificaciones...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dte_email">Dirección de correo electrónico</label>
                                                    <span id='dte_email_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="50" type="email" id="dte_email"  class="form-control" placeholder="Correo electrónico...">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Apoderado del demandante</h3>
                                                </div>
                                                <div class="col-md-12">    
                                                    <label class="checkbox-label">Apoderado</label>
                                                    <button type="button" class="btn btn-sm btn-transparent form-tooltip" data-trigger="hover focus" data-container="body" data-toggle="popover" 
                                                            data-placement="right" 
                                                            data-html="true" 
                                                            title="¿Qué es un apoderado?" 
                                                            data-content="Es la persona o abogado que tiene la facultad de representar al demandante y que actúa en su nombre. Esta facultad es otorgada por medio de un poder por parte del demandante.">
                                                        <i class="material-icons">help</i>
                                                    </button>
                                                    <span id='dte_apo_tiene_popover_area'></span>
                                                    <br>

                                                    <input type="checkbox" id="dte_apo_tiene" class="filled-in chk-col-blue">
                                                    <label for="dte_apo_tiene">Demandante tiene apoderado</label>
                                                </div>
                                                <div id="dte_apo_tiene_section" class="animated fadeIn">

                                                    <div class="col-md-6">
                                                        <label for="dte_apo_nom">Nombre del apoderado</label>
                                                        <span id='dte_apo_nom_popover_area'></span>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input maxlength="50" type="text" id="dte_apo_nom" class="form-control" placeholder="Ingrese el nombre...">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label for="dte_apo_tar_pro">Tarjeta profesional No.</label>
                                                        <button type="button" class="btn btn-sm btn-transparent form-tooltip" data-trigger="hover focus" data-container="body" data-toggle="popover" 
                                                                data-placement="right" 
                                                                data-html="true" 
                                                                title="Información sobre este campo" 
                                                                data-content="Descubre más sobre este campo">
                                                            <i class="material-icons">help</i>
                                                        </button>
                                                        <span id='dte_apo_tar_pro_popover_area'></span>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input maxlength="20" type="text" id="dte_apo_tar_pro" class="form-control" placeholder="Número de tarjeta profesional...">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label for="dte_apo_id_tipo">Tipo de identificación</label>
                                                        <span id='dte_apo_id_tipo_popover_area'></span>
                                                        <div class="id-type-radio">
                                                            <input name="dte_apo_id_tipo" type="radio" id="radio_dte_apo_id_tipo_1" value="0"  class="with-gap radio-col-blue" checked="">
                                                            <label for="radio_dte_apo_id_tipo_1">C.C</label>
                                                            <!--
                                                            <input name="dte_apo_id_tipo" type="radio" id="radio_dte_apo_id_tipo_2" value="1" class="with-gap radio-col-blue">
                                                            <label for="radio_dte_apo_id_tipo_2">NIT</label>
                                                            -->
                                                            <input name="dte_apo_id_tipo" type="radio" id="radio_dte_apo_id_tipo_3" value="2" class="with-gap radio-col-blue">
                                                            <label for="radio_dte_apo_id_tipo_3">TI</label>
                                                            <input name="dte_apo_id_tipo" type="radio" id="radio_dte_apo_id_tipo_4" value="3" class="with-gap radio-col-blue">
                                                            <label for="radio_dte_apo_id_tipo_4">PASAPORTE</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label for="dte_apo_id">Numero de identificación</label>
                                                        <span id='dte_apo_id_popover_area'></span>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input maxlength="20" type="text" id="dte_apo_id" class="form-control" placeholder="Número de identificación...">
                                                            </div>
                                                        </div>
                                                    </div>


                                                </div>
                                            </div>
                                        </section>

                                        <h2>Demandado</h2>
                                        <section>
                                            <div class="row clearfix">
                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Demandado</h3>
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="" for="dem_nom">Nombre del demandado</label>
                                                    <span id='dem_nom_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="50" type="text" id="dem_nom" class="form-control" placeholder="Nombre...">
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="col-md-6">
                                                    <label for="dem_ciu">Ciudad de domicilio del demandado</label>
                                                    <span id='dem_ciu_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="20" type="text" id="dem_ciu" class="form-control" placeholder="Ingrese la ciudad...">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="dem_id_tipo">Tipo de identificación</label>
                                                    <span id='dem_id_tipo_popover_area'></span>
                                                    <div class="id-type-radio">
                                                        <input name="dem_id_tipo" type="radio" id="dem_id_tipo_1" value="0"  class="with-gap radio-col-blue" checked="">
                                                        <label for="dem_id_tipo_1">C.C</label>
                                                        <!--
                                                        <input name="dem_id_tipo" type="radio" id="dem_id_tipo_2" value="1" class="with-gap radio-col-blue">
                                                        <label for="dem_id_tipo_2">NIT</label>
                                                        -->
                                                        <input name="dem_id_tipo" type="radio" id="dem_id_tipo_3" value="2" class="with-gap radio-col-blue">
                                                        <label for="dem_id_tipo_3">TI</label>
                                                        <input name="dem_id_tipo" type="radio" id="dem_id_tipo_4" value="3" class="with-gap radio-col-blue">
                                                        <label for="dem_id_tipo_4">PASAPORTE</label>
                                                    </div>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="dem_id">Documento del demandado</label>
                                                    <span id='dem_id_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="30" type="text" id="dem_id" class="form-control" placeholder="Ingrese el no. de identificación...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--
                                                <div class="col-md-3">
                                                    <label for="dem_id">Verificar documento</label>
                                                    <div class="form-group">

                                                        <button type="button" id="botonVerificacion" class="btn bg-purple btn-circle waves-effect waves-circle waves-float">
                                                            <i class="material-icons">search</i>

                                                    </div>
                                                </div>
                                                -->
                                                <div class="col-md-6">
                                                    <label for="dem_dir_not">Dirección donde recibe notificaciones:</label>
                                                    <span id='dem_dir_not_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="100" type="text" id="dem_dir_not" class="form-control" placeholder="Dirección de notificaciones...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dem_email">Dirección de correo electrónico <span style="color:#3bacfa">(opcional)</span></label>
                                                    <span id='dem_email_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input maxlength="50" type="email" id="dem_email" class="form-control" placeholder="Correo electrónico...">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </section>

                                        <h2>Pretensiones</h2>
                                        <section>
                                            <div class="row clearfix">
                                                <div class="col-md-12">
                                                    <label for="pretensiones">Pretensiones</label>
                                                    <button type="button" class="btn btn-sm btn-transparent form-tooltip" data-trigger="hover focus" data-container="body" data-toggle="popover" 
                                                            data-placement="right" 
                                                            data-html="true" 
                                                            title="¿Qué son las pretensiones?" 
                                                            data-content="Las pretensiones se basan en expresarle al juez lo que quieres obtener cuando se acabe el proceso. <br><br>Es por esto que, mediante estas, puedes solicitar que se condene a tu demandado a pagarte la suma de dinero que te debe, o en general cualquier aspecto que pretendas ganar u obtener cuando dicte sentencia la autoridad del proceso. <br><br>Recuerda que las pretensiones <b>deben estar numeradas</b> y en orden.">
                                                        <i class="material-icons">help</i>
                                                    </button>
                                                    <span id='pretensiones_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea maxlength="2000" rows="1" class="form-control no-resize auto-growth" id="pretensiones" placeholder="Indique las sumas de dinero cuyo pago solicita..." style="overflow: hidden; word-wrap: break-word; height: 132px;">1.&#13;&#10;2.&#13;&#10;3.&#13;&#10;4.&#13;&#10;5.&#13;&#10;6.</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">    
                                                    <label class="checkbox-label">Manifiesto que</label>
                                                    <span id='depende_cumplimiento_popover_area'></span>
                                                    <br>
                                                    <input type="checkbox" id="depende_cumplimiento" class="filled-in chk-col-blue">
                                                    <label for="depende_cumplimiento">El pago de la suma adeudada depende del cumplimiento de una obligación a mi cargo.</label>
                                                </div>
                                                <div class="col-md-6">    
                                                    <label class="checkbox-label">Manifiesto bajo juramento que</label>
                                                    <button type="button" class="btn btn-sm btn-transparent form-tooltip" data-trigger="hover focus" data-container="body" data-toggle="popover" 
                                                            data-placement="right" 
                                                            data-html="true" 
                                                            title="¿Qué es una prueba documental?" 
                                                            data-content="Es cualquier documeto que te permite demostrarle al juez la veracidad de los hechos que relataste en tu demanda, como un contrato, un cheque, un pagaré, etc.">
                                                        <i class="material-icons">help</i>
                                                    </button>
                                                    <span id='tengo_pruebas_popover_area'></span>
                                                    <br>
                                                    <input type="checkbox" id="tengo_pruebas" class="filled-in chk-col-blue">
                                                    <label for="tengo_pruebas">Tengo en mi poder pruebas documentales sobre la existencia de la obligación cuyo pago pretendo.</label>
                                                </div>
                                            </div>
                                        </section>

                                        <h2>Hechos</h2>
                                        <section>
                                            <div class="row clearfix">
                                                <div class="col-md-12">
                                                    <label for="hechos">Hechos</label>
                                                    <button type="button" class="btn btn-sm btn-transparent form-tooltip" data-trigger="hover focus" data-container="body" data-toggle="popover" 
                                                            data-placement="right" 
                                                            data-html="true" 
                                                            title="¿Qué son los hechos?" 
                                                            data-content="Son todos los acontecimientos o antecedentes que generan consecuencias jurídicas en una relación jurídica. <br><br>Recuerda que los hechos <b>deben estar numerados</b> y en orden.">
                                                        <i class="material-icons">help</i>
                                                    </button>
                                                    <span id='hechos_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea maxlength="2000" rows="1" class="form-control no-resize auto-growth" id="hechos" placeholder="Refiera en forma concreta los hechos que fundamentan su solicitud..." style="overflow: hidden; word-wrap: break-word; height: 132px;">1.&#13;&#10;2.&#13;&#10;3.&#13;&#10;4.&#13;&#10;5.&#13;&#10;6.</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </section>

                                        <h2>Pruebas</h2>
                                        <section>
                                            <div class="row clearfix">
                                                <div class="col-md-12">
                                                    <label for="pruebas">Pruebas</label>
                                                    <button type="button" class="btn btn-sm btn-transparent form-tooltip" data-trigger="hover focus" data-container="body" data-toggle="popover" 
                                                            data-placement="right" 
                                                            data-html="true" 
                                                            title="¿Qué pruebas puedo anexar?" 
                                                            data-content="Anexa cualquier documento que te permita demostrarle al juez la veracidad de los hechos que relataste en tu demanda. <br><br> Cualquier documento que te ayude a demostrar que el demandado de debe dinero, lo puedes anexar aquí.">
                                                        <i class="material-icons">help</i>
                                                    </button>
                                                    <span id='pruebas_popover_area'></span>

                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea maxlength="2000" rows="1" class="form-control no-resize auto-growth" id="pruebas" placeholder="Refiera las pruebas que usted aporta..." style="overflow: hidden; word-wrap: break-word; height: 132px;"></textarea>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-md-12" id='pruebasfile'></div>


                                            </div>
                                        </section>

                                        <h2>Otros</h2>
                                        <section>
                                            <div class="row clearfix">
                                                <div class="col-md-12">
                                                    <label for="fundamentos">Fundamentos de derecho <span style="color:#3bacfa">(opcionales)</span></label>
                                                    <button type="button" class="btn btn-sm btn-transparent form-tooltip" data-trigger="hover focus" data-container="body" data-toggle="popover" 
                                                            data-placement="right" 
                                                            data-html="true" 
                                                            title="¿Qué son los fundamentos de derecho?" 
                                                            data-content="En este espacio, puedes indicar los artículos, leyes, resoluciones, decretos o en general cualquier norma colombiana que te permita decirle al juez que tus derechos han sido vulnerados por el demandado quien actuo de forma contraria a lo que versa la norma. <br><br>Te recomendamos citar explícitamente la ley o leyes pertinentes que se acomoden a tu problema.">
                                                        <i class="material-icons">help</i>
                                                    </button>
                                                    <span id='fundamentos_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea maxlength="2000" rows="1" class="form-control no-resize auto-growth" id="fundamentos" placeholder="Otras normas aplicables..." style="overflow: hidden; word-wrap: break-word; height: 132px;"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="anexos">Anexos</label>
                                                    <button type="button" class="btn btn-sm btn-transparent form-tooltip" data-trigger="hover focus" data-container="body" data-toggle="popover" 
                                                            data-placement="right" 
                                                            data-html="true" 
                                                            title="¿Qué son los anexos?" 
                                                            data-content="Son todos aquellos documentos que se encuentran vinculados al proceso jurídico que se está iniciando, como por ejemplo el poder o contratos cuando el proceso verse sobre ellos.">
                                                        <i class="material-icons">help</i>
                                                    </button>
                                                    <span id='anexos_popover_area'></span>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea maxlength="1000" rows="1" class="form-control no-resize auto-growth" id="anexos" placeholder="Mencione los anexos..." style="overflow: hidden; word-wrap: break-word; height: 32px;"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="alert alert-info bg-syslaw-gradient" id="alert_poder">
                                                        <strong>Importante!</strong> Usted ha marcado que cuenta con un apoderado. No olvide referenciar como anexo el poder o autorización para el apoderado.
                                                    </div>
                                                </div>
                                                <div class="col-md-12" id='anexosfile'></div>
                                                <div class="col-md-6">    
                                                    <label class="checkbox-label">Solicito medidas cautelares</label><br>
                                                    <span id='solicito_cautelares_popover_area'></span>
                                                    <input type="checkbox" id="solicito_cautelares" class="filled-in chk-col-blue">
                                                    <label for="solicito_cautelares">Solicito la práctica de medidas cautelares</label>
                                                </div>
                                                <div id="solicito_cautelares_section" class="animated fadeIn">
                                                    <div class="col-md-6">
                                                        <label for="cautelares_que_solicita">Medidas cautelares que solicita</label>
                                                        <span id='cautelares_que_solicita_popover_area'></span>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <textarea maxlength="500" rows="1" class="form-control no-resize auto-growth" id="cautelares_que_solicita" placeholder="Precise a continuación las que solicita..." style="overflow: hidden; word-wrap: break-word; height: 32px;"></textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </section>
                                    </form>                                    
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="analisisDemanda" tabindex="-1" role="dialog" style="display: none;">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <form id="modifyTitle" method="post">
                            <div class="modal-header detail-header bg-syslaw-gradient">
                                <div class="pull-left" style="margin-top: 8px;">
                                    <h4 class="modal-title" style="font-size:18px" id="modEvePubTitulo">Análisis automático</h4>
                                </div>



                                <button data-dismiss="modal" type="button" class="pull-right btn btn-info btn-sm btn-transparent">
                                    <i class="material-icons">close</i>
                                </button>
                                <!--
                                <button type="button" class="pull-right btn btn-info btn-sm btn-transparent">
                                    <i onclick="ayudaAnalisis()" class="material-icons">help</i><span style="margin-bottom: 7px; margin-left: 5px">Ayuda</span>
                                </button>
                                -->
                                <button onclick="analizarDemanda()" id="analizarButton" type="button" class="pull-right btn btn-info btn-sm btn-transparent">
                                    <i class="material-icons">spellcheck</i><span style="margin-bottom: 7px; margin-left: 5px">Analizar demanda</span>
                                </button>

                            </div>
                            <div class="modal-body">

                                <div class="row" id="collapseAnalisis">

                                    <div class="col-xs-12 ol-sm-12 col-md-12 col-lg-12">
                                        <div class="panel-group" id="accordion_19" role="tablist" aria-multiselectable="true">
                                            <div class="panel panel-col-red">
                                                <div class="panel-heading" role="tab" id="headingOne_19">
                                                    <h4 class="panel-title">
                                                        <a role="button" data-toggle="collapse" href="#collapseOne_19" aria-expanded="true" aria-controls="collapseOne_19">
                                                            <i class="material-icons">cancel</i> Advertencias (<span id="errores_count">test</span>)
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="collapseOne_19" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne_19">
                                                    <div class="panel-body p-l-20 p-r-20">
                                                        <div class="row clearfix" id="analisis_errores_area">
                                                            <div class="col-lg-1">
                                                                <button type="button" onClick = "analisisPoint(1, 'dem_nom')" class="btn btn-circle-lg waves-effect waves-circle waves-float analisis-button ab-red">
                                                                    <i class="material-icons">search</i>
                                                                </button>                                                               
                                                            </div>
                                                            <div class="col-lg-4">
                                                                <h4>Número de documento<small><br>Demandante</small></h4>
                                                            </div>
                                                            <div class="col-lg-7">
                                                                <p style="margin-top: 8px"><b>El campo está vacío</b><br>Por favor llene el campo</p>
                                                            </div>
                                                            <div class="col-lg-12">
                                                                <hr>
                                                            </div>


                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="panel panel-col-orange">
                                                <div class="panel-heading" role="tab" id="headingTwo_19">
                                                    <h4 class="panel-title">
                                                        <a role="button" data-toggle="collapse" href="#collapseTwo_19" aria-expanded="false" aria-controls="collapseTwo_19">
                                                            <i class="material-icons">warning</i> Sugerencias (<span id="advertencias_count">test</span>)
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="collapseTwo_19" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo_19">
                                                    <div class="panel-body">
                                                        <div class="row clearfix" id="analisis_advertencias_area">

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="panel panel-col-green">
                                                <div class="panel-heading" role="tab" id="headingThree_19">
                                                    <h4 class="panel-title">
                                                        <a class="collapsed" role="button" data-toggle="collapse" href="#collapseThree_19" aria-expanded="false" aria-controls="collapseThree_19">
                                                            <i class="material-icons">spellcheck</i> Correctos (<span id="correctos_count">test</span>)
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="collapseThree_19" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree_19">
                                                    <div class="panel-body">
                                                        <div class="row clearfix" id="analisis_correctos_area">



                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-lg btn-default waves-effect" data-dismiss="modal">SALIR</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="toConnectModal" tabindex="-1" role="dialog" style="display: none;">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <form id="modifyTitle" method="post">
                            <div class="modal-header detail-header bg-syslaw-gradient">
                                <div class="pull-left" style="margin-top: 8px;">
                                    <h4 class="modal-title" style="font-size:18px" id="modEvePubTitulo">Revisión SYSLAW Connect</h4>
                                </div>



                                <button data-dismiss="modal" type="button" class="pull-right btn btn-info btn-sm btn-transparent">
                                    <i class="material-icons">close</i>
                                </button>
                                <!--
                                <button type="button" class="pull-right btn btn-info btn-sm btn-transparent">
                                    <i onclick="ayudaAnalisis()" class="material-icons">help</i><span style="margin-bottom: 7px; margin-left: 5px">Ayuda</span>
                                </button>
                                -->
                                <button onclick="analizarDemanda()" id="analizarButton" type="button" class="pull-right btn btn-info btn-sm btn-transparent">
                                    <i class="material-icons">money</i><span style="margin-bottom: 7px; margin-left: 5px">$<span id="plata_num">15.000</span></span>
                                </button>

                            </div>
                            <div class="modal-body">

                                <div class="row" id="collapseAnalisis">

                                    <div class="col-xs-4">

                                        <img src="landing/images/graphic2.png" alt="graphic" class="img-fluid rounded align-self-start mr-lg-5 mb-5 mb-lg-0">

                                    </div>

                                    <div class="col-xs-8">
                                        <h2>Ayuda profesional para tu demanda</h2>
                                        <p class="lead">Syslaw Connect te conecta con la ayuda que necesitas</p>
                                        <p>Aunque el servicio gratuito te ayuda a redactar tu demanda, es posible que quieras contar con la guía personalizada de un abogado. Con Syslaw Connect, un abogado estara ahí, a muy bajo costo, para resolver tus dudas y corregir tu demanda. 
                                        </p>
                                        <h4>El servicio de 1 revisión te cuesta: $10.000</h4>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" onclick="enviarConnect()" class="btn btn-lg btn-primary waves-effect">PAGAR Y ENVIAR A ABOGADO</button>
                                <button type="button" class="btn btn-lg btn-default waves-effect" data-dismiss="modal">SALIR</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>



            <div class="modal fade" id="editTitleModal" tabindex="-1" role="dialog" style="display: none;">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form id="modifyTitle" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title" id="defaultModalLabel">Modificar Título de la Demanda</h4>
                            </div>
                            <div class="modal-body">

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group" style="margin-bottom: 0px">
                                            <div class="form-line">
                                                <input type="text" id="titulo" class="form-control" placeholder="Titulo">
                                            </div>
                                        </div>
                                    </div>                                                                        
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" onclick="editTitleModalConfirm();" class="btn btn-lg btn-primary waves-effect">MODIFICAR TITULO</button>
                                <button type="button" class="btn btn-lg btn-default waves-effect" data-dismiss="modal">CANCELAR CAMBIOS</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>



        </section>

        <!-- Jquery Core Js -->
        <script src="plugins/jquery/jquery.min.js"></script>


        <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <!-- Bootstrap Core Js -->
        <script src="plugins/bootstrap/js/bootstrap.js"></script>

        <!-- Select Plugin Js -->
        <script src="plugins/bootstrap-select/js/bootstrap-select.js"></script>

        <script src="plugins/jquery-spinner/js/jquery.spinner.js"></script>

        <!-- Slimscroll Plugin Js -->
        <script src="plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

        <!-- Waves Effect Plugin Js -->
        <script src="plugins/node-waves/waves.js"></script>

        <!-- JQuery Steps Plugin Js -->
        <script src="plugins/jquery-steps/jquery.steps.js"></script>

        <!-- Autosize Plugin Js -->
        <script src="plugins/autosize/autosize.js"></script>

        <script src="plugins/momentjs/moment.js"></script>
        <script src="plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>

        <!-- Wait Me Plugin Js -->
        <script src="plugins/waitme/waitMe.js"></script>

        <script src="plugins/bootstrap-notify/bootstrap-notify.js"></script>

        <!-- Jquery DataTable Plugin Js -->
        <script src="plugins/jquery-datatable/jquery.dataTables.js"></script>
        <script src="plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
        <script src="plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>

        <!-- Dropzone Plugin Js -->
        <script src="plugins/dropzone/dropzone.js"></script>

        <!-- Theme Js -->
        <script src="js/admin.js"></script>
        <script src="js/pages/ui/tooltips-popovers.js"></script>

        <!-- SweetAlert Plugin Js -->
        <script src="plugins/sweetalert/sweetalert.min.js"></script> 

        <!-- Material Walkthrough -->
        <script src="plugins/material-walkthrough/material-walkthrough.js"></script>

        <!-- Custom Js -->
        <script src="js/custom/editRedaccion.js"></script>


    </body>

</html>
