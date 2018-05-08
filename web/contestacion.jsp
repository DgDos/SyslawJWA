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

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />

        <!--WaitMe Css-->
        <link href="plugins/waitme/waitMe.css" rel="stylesheet" />

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
        <div class="page-loader-wrapper">
            <div class="loader">
                <div class="preloader">
                    <div class="spinner-layer pl-blue">
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
                        <img class="d-block mx-auto mb-4" src="images/logo.svg" alt="" width="136" height="58" style="margin-top: 10px">
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
                                response.sendRedirect("signin.html");
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
                <%@include file="menu.jsp" %>
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
                            <h2 style="color: #138fc3;">Título de la demanda</h2>
                            <input type="text" id="id_contestacion" class="form-control" value="id_demanda" disabled>
                            <input type="text" id="titulo" class="form-control" value="titulo" disabled>

                            <div class="card">
                                <div class="body">

                                    <form id="contestacion_wizard" autocomplete="off">


                                        <h2>Demandado</h2>
                                        <section>
                                            <div class="row clearfix">                                               
                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Juez</h3>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="juez_nombre">Señor, juez municipal de</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" id="juez_nombre" class="form-control" placeholder="Ingrese la ciudad del juez...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="monitorio">Ref: Proceso monitorio de</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" id="proceso" class="form-control" placeholder="Ingrese el numero del proceso...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="contra">Contra:</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" readonly id="contra" class="form-control" placeholder="Ingrese el contra...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Demandado</h3>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="ddo_nom">Nombre del demandado</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" readonly id="nombre_demandado" class="form-control" placeholder="Ingrese el nombre...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="ddo_ciudad">Ciudad del demandado</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" readonly id="ciudad_demandado" class="form-control" placeholder="Ingrese la ciudad...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="tipo_documento_demandado">Tipo de id del demandado</label>
                                                    <div readonly class="id-type-radio">
                                                        <input name="tipo_documento_demandado" type="radio" id="radio_tipo_documento_demandado_1" value="0"  class="with-gap radio-col-blue" checked="">
                                                        <label for="radio_tipo_documento_demandado_1">C.C</label>
                                                        <input name="tipo_documento_demandado" type="radio" id="radio_tipo_documento_demandado_2" value="1" class="with-gap radio-col-blue">
                                                        <label for="radio_dte_id_tipo_2">NIT</label>
                                                        <input name="tipo_documento_demandado" type="radio" id="radio_tipo_documento_demandado_3" value="2" class="with-gap radio-col-blue">
                                                        <label for="radio_tipo_documento_demandado_3">TI</label>
                                                        <input name="tipo_documento_demandado" type="radio" id="radio_tipo_documento_demandado_4" value="3" class="with-gap radio-col-blue">
                                                        <label for="radio_tipo_documento_demandado_4">PASAPORTE</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="documento_demandado">Numero del demandado</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" readonly id="documento_demandado" class="form-control" placeholder="Número de identificación...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="direccion_notificaciones">Dirección donde recibe notificaciones:</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" readonly id="direccion_notificaciones" class="form-control" placeholder="Dirección de notificaciones...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="email">Dirección de correo electrónico</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="email" readonly id="email" class="form-control" placeholder="Correo electrónico...">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Apoderado del demandado</h3>
                                                </div>
                                                <div class="col-md-6">    
                                                    <label class="checkbox-label">Apoderado</label><br>
                                                    <input type="checkbox" id="ddo_apo_tiene" class="filled-in chk-col-blue">
                                                    <label for="ddo_apo_tiene">Demandado tiene apoderado</label>
                                                </div>
                                                <div id="ddo_apo_tiene_section" class="animated fadeIn">

                                                    <div class="col-md-6">
                                                        <label for="ddo_apo_nom">Nombre del apoderado</label>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="ddo_apo_nom" class="form-control" placeholder="Ingrese el nombre...">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label for="ddo_apo_id_tipo">Tipo de identificación</label>
                                                        <div class="id-type-radio">
                                                            <input name="ddo_apo_id_tipo" type="radio" id="radio_ddo_apo_id_tipo_1" value="0"  class="with-gap radio-col-blue" checked="">
                                                            <label for="radio_ddo_apo_id_tipo_1">C.C</label>
                                                            <input name="ddo_apo_id_tipo" type="radio" id="radio_ddo_apo_id_tipo_2" value="1" class="with-gap radio-col-blue">
                                                            <label for="radio_ddo_apo_id_tipo_2">NIT</label>
                                                            <input name="ddo_apo_id_tipo" type="radio" id="radio_ddo_apo_id_tipo_3" value="2" class="with-gap radio-col-blue">
                                                            <label for="radio_ddo_apo_id_tipo_3">TI</label>
                                                            <input name="ddo_apo_id_tipo" type="radio" id="radio_ddo_apo_id_tipo_4" value="3" class="with-gap radio-col-blue">
                                                            <label for="radio_ddo_apo_id_tipo_4">PASAPORTE</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label for="ddo_apo_id">Documento de identificación</label>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="ddo_apo_id" class="form-control" placeholder="Número de identificación...">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label for="ddo_apo_dir">Domicilio del demandado</label>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="ddo_apo_dir" class="form-control" placeholder="Dirección ...">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label for="ddo_apo_tar_pro">Tarjeta profesional No.</label>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="ddo_apo_tar_pro" class="form-control" placeholder="Número de tarjeta profesional...">
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </section>

                                        <h2>Pretensiones</h2>
                                        <section>
                                            <label for="pretenciones">(Recuerte que si usted se opene sin fundamento y es condenado, se le impondrá una multa equivalente al 10% del valor de la deuda a favor de su acreedor y, además, pagará las costas del proceso)</label>
                                            <div class="col-md-6">    
                                                <label class="checkbox-label">Si</label>
                                                <input type="checkbox" id="pretenciones" class="filled-in chk-col-blue">
                                                <label for="pretenciones">me opongo a las pretensiones.</label>
                                            </div>
                                        </section>
                                        <h2>Hechos</h2>
                                        <section>
                                            <div class="row clearfix">
                                                <div class="col-md-12">
                                                    <label for="hechos_admitidos">ADMITO los siquientes hechos</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea rows="1" class="form-control no-resize auto-growth" id="hechos_admitidos" placeholder="Refiera en forma concreta los hechos que fundamentan su solicitud..." style="overflow: hidden; word-wrap: break-word; height: 132px;">1.&#13;&#10;2.&#13;&#10;3.&#13;&#10;4.&#13;&#10;5.&#13;&#10;6.</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="hechos_negados">NIEGO los siguientes hechos, y en general niego total ( ) o parcialmente ( ) la deuda reclamada</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea rows="1" class="form-control no-resize auto-growth" id="hechos_negados" placeholder="Refiera en forma concreta los hechos que fundamentan su solicitud..." style="overflow: hidden; word-wrap: break-word; height: 132px;">1.&#13;&#10;2.&#13;&#10;3.&#13;&#10;4.&#13;&#10;5.&#13;&#10;6.</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="explicacion_negados">Explique por qué niega estos hechos, o niega total o parcialmente la deuda reclamada en la demanda:</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea rows="1" class="form-control no-resize auto-growth" id="explicacion_negados" placeholder="Explique detalladamente..." style="overflow: hidden; word-wrap: break-word; height: 132px;"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="hechos_no_constan">NO ME CONSTAN LOS SIGUIENTES HECHOS</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea rows="1" class="form-control no-resize auto-growth" id="hechos_no_constan" placeholder="Refiera en forma concreta los hechos que fundamentan su solicitud..." style="overflow: hidden; word-wrap: break-word; height: 132px;">1.&#13;&#10;2.&#13;&#10;3.&#13;&#10;4.&#13;&#10;5.&#13;&#10;6.</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="explicacion_no_constan">Explique por qué no le constan estos hechos:</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea rows="1" class="form-control no-resize auto-growth" id="explicacion_no_constan" placeholder="Explique detalladamente..." style="overflow: hidden; word-wrap: break-word; height: 132px;"></textarea>
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>
                                        </section>

                                        <h2>Excepciones</h2>
                                        <section>
                                            <div class="row clearfix">
                                                &nbsp;
                                                &nbsp;
                                                <label for="excepciones1">(Si quiere plantear excepciones, indíquelas a continuación y precise en forma contreta los hechos que las fundamentan)</label><br><br>

                                                <div class="col-md-12">
                                                    <label for="nom_excep1">Excepciones:</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" id="excepciones" class="form-control" placeholder="Ingrese el nombre de la excepción...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="reconocimiento">Si Usted pide el reconocimiento de alguna suma de dinero vinculada a la reclamanción de su demandnte (por ejemplo mejoras), debe estimarla bajo juramento y justificar cada uno de los conceptos.</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea rows="1" class="form-control no-resize auto-growth" id="reconocimiento" placeholder="Explique detalladamente..." style="overflow: hidden; word-wrap: break-word; height: 132px;"></textarea>
                                                        </div>
                                                    </div>
                                                </div>

                                                &nbsp;
                                                &nbsp;
                                                <label for="excepciones1">(Recuerde que si usted se excede en el 50% de la cantidad probada, se le condenará a pagarle a su contraparte, una suma equivalente al 10% de la diferencia.)</label><br>
                                                <div class="col-md-6">    
                                                    <label class="checkbox-label">En los casos en que procede, invoca usted el derecho de retención </label>
                                                    <input type="checkbox" id="retencion" class="filled-in chk-col-blue">
                                                    <label for="depende_cumplimiento">:</label>
                                                </div>



                                            </div>
                                        </section>

                                        <h2>Pruebas</h2>
                                        <section>
                                            <div class="row clearfix">
                                                <div class="col-md-12">
                                                    <label for="pruebas">Pruebas</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea rows="1" class="form-control no-resize auto-growth" id="pruebas" placeholder="Refiera las pruebas que usted aporta..." style="overflow: hidden; word-wrap: break-word; height: 32px;"></textarea>
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
                                                    <label for="anexos ">Anexos</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <textarea rows="1" class="form-control no-resize auto-growth" id="anexos " placeholder="Adjunte los anexos..." style="overflow: hidden; word-wrap: break-word; height: 32px;"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12" id='anexosfile'></div>
                                            </div>
                                        </section>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </section>

        <!-- Jquery Core Js -->
        <script src="plugins/jquery/jquery.min.js"></script>

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

        <!-- Custom Js -->
        <script src="js/custom/contestacion.js"></script>
        <script src="js/pages/index.js"></script>


    </body>

</html>
