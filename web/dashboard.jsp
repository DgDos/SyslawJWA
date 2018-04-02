<%@page import="Model.Usuario"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Mis demandas | Syslaw</title>
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

        <link href="plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" rel="stylesheet">

        <!-- Custom Css -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />

        <!--WaitMe Css-->
        <link href="plugins/waitme/waitMe.css" rel="stylesheet" />

        <style>.modal-backdrop.in { opacity: .4;}</style>


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
                <div class="menu">
                    <ul class="list">
                        <li class="header">MENÚ DE NAVEGACIÓN</li>
                        <li class="active">
                            <a href="studentdash.jsp">
                                <i class="material-icons">clear_all</i>
                                <span>Mis Demandas</span>
                            </a>
                        </li>
                        <!--
                        <li>
                            <a href="studentbase.jsp">
                                <i class="material-icons">view_array</i>
                                <span>Horario Base</span>
                            </a>
                        </li>
                        
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">view_compact</i>
                                <span>Dashboard</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="pages/maps/google.html">Horario Base</a>
                                </li>
                                <li>
                                        <a href="pages/maps/yandex.html">Ver horas disponibles</a>
                                </li>
                            </ul>
                        </li>-->


                    </ul>
                </div>
                <!-- #Menu -->
                <!-- Footer -->
                <div class="legal">
                    <div class="copyright">
                        &copy; 2018 <a href="javascript:void(0);">SYSLAW</a>.
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
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding: 0px; margin-top:-20px">
                        <div class="card" style="box-shadow: none" >
                            <div class="header bg-white add-event-header" style="background-color: #f1f1f1 !important;">
                                <div class="row clearfix">
                                    <div class="col-xs-12 col-sm-12" style="margin-top: 5px">
                                        <h2 style="color: #1981ad;">Mis demandas</h2>
                                    </div>
                                </div>

                            </div>

                            <div class="body" id="dashboard-container" style="background-color: #f1f1f1;">  

                                <div class="card">
                                    <div class="body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-striped table-hover js-basic-example dataTable" id="demandas">
                                                <thead>
                                                    <tr>
                                                        <th>Título</th>
                                                        <th>Modificado</th>
                                                        <th>Creado</th>
                                                        <th>Ayudante</th>
                                                        <th>Porcentaje</th>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                                <tfoot>
                                                    <tr>
                                                        <th>Título</th>
                                                        <th>Modificado</th>
                                                        <th>Creado</th>
                                                        <th>Ayudante</th>
                                                        <th>Porcentaje</th>
                                                        <th></th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <!-- Evento publico modal -->
                <div class="modal fade-scale fade" id="modalEventoPublico" tabindex="-1" role="dialog" style="display: none;">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">

                            <div class="modal-header detail-header bg-red" id="modEvePubHeader">
                                <div class="pull-left">
                                    <h4 class="modal-title" style="font-size:18px" id="modEvePubTitulo">Clase de técnica vocal</h4>
                                    <small id="modEvePubSub">Decanatura de Estudiantes</small>
                                </div>

                                <button data-dismiss="modal" type="button" class="pull-right btn btn-info btn-sm btn-transparent">
                                    <i id="toogle-add-event-icon" class="material-icons">close</i>
                                </button>
                            </div>
                            <div class="modal-body">
                                <ul class="list-group">
                                    <li class="list-group-item detail-item">
                                        <span data-original-title="Organizador" data-toggle="tooltip" data-placement="right" class="detail-icon"><i class="material-icons">mood</i></span>
                                        <span id="modEvePubOrg">Decanatura de estudiantes</span>
                                        <span class="badge bg-grey">Organizador</span></li>
                                    <li class="list-group-item detail-item"><span class="detail-icon"><i class="material-icons">event</i></span>
                                        <span id="modEvePubFecha">Miércoles, 3 de Enero, 4:00 p.m.</span>
                                        <span class="badge bg-grey">Fecha y hora</span></li>
                                    <li class="list-group-item detail-item"><span class="detail-icon"><i class="material-icons">location_on</i></span>
                                        <span id="modEvePubLoc">B203</span>
                                        <span class="badge bg-grey">Ubicación</span></li>

                                    <div class="btn-group btn-group-justified btn-group-lg" style="margin-top: 10px" role="group" aria-label="Justified button group">
                                        <a href="javascript:void(0);" id="modevepub-btn-asist-no" class="btn btn-default waves-effect" role="button">
                                            <i style="font-size: 21px;margin-top: -10px; top: 6px; margin-right: 5px; margin-left: -5px;" class="material-icons">close</i>
                                            No registrado</a>
                                        <a href="javascript:void(0);" id="modevepub-btn-asist-int" class="btn btn-default waves-effect" role="button">
                                            <i style="font-size: 21px;margin-top: -10px; top: 5px; margin-right: 5px; margin-left: -5px" class="material-icons">star_border</i>
                                            Me interesa</a>
                                        <a href="javascript:void(0);" id="modevepub-btn-asist-con" class="btn btn-danger waves-effect" role="button">
                                            <i style="font-size: 21px;margin-top: -10px; top: 6px; margin-right: 5px; margin-left: -5px" class="material-icons">check</i>
                                            Asistiré</a>
                                    </div>
                                    <!--
                                    <li class="list-group-item detail-item"><span class="detail-icon"><i class="material-icons">event_note</i></span>
                                        <span class="list-group-item-heading">List group item heading</span>
                                    <p class="list-group-item-text">
                                            Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius.
                                            Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid
                                            pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren
                                            sadipscing mel.
                                        </p></li> -->
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>

                <!-- Lista de sugerencias modal -->
                <div class="modal fade-scale fade" id="modalListaSugerencias" tabindex="-1" role="dialog" style="display: none;">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">

                            <div class="modal-header detail-header bg-orange">
                                <div class="pull-left">
                                    <h4 class="modal-title" style="font-size:18px" id="modEveSugTitulo">5 sugerencias encontradas</h4>
                                </div>

                                <button data-dismiss="modal" type="button" class="pull-right btn btn-info btn-sm btn-transparent btn-short">
                                    <i id="toogle-add-event-icon" class="material-icons">close</i>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="row" id="modal-sugerencias-container">
                                    <div class="col-xs-12 col-md-6 card-section-waves">
                                        <div class="card waves-effect waves-light" onclick="verSugerenciaLista(0);" style="cursor: pointer;"><div class="header bg-orange"><h2>EventoSugerido1<small>dom</small><small>Descripcion para sugerido 1</small></h2></div></div>
                                    </div>
                                    <div class="col-xs-12 col-md-6 card-section-waves">
                                        <div class="card waves-effect waves-light" onclick="verSugerenciaLista(0);" style="cursor: pointer;"><div class="header bg-orange"><h2>EventoSugerido1<small>dom</small><small>Descripcion para sugerido 1</small></h2></div></div>
                                    </div>
                                    <div class="col-xs-12 col-md-6 card-section-waves">
                                        <div class="card waves-effect waves-light" onclick="verSugerenciaLista(0);" style="cursor: pointer;"><div class="header bg-orange"><h2>EventoSugerido1<small>dom</small><small>Descripcion para sugerido 1</small></h2></div></div>
                                    </div>
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
        <script src="plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
        <script src="plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
        <script src="plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
        <script src="plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
        <script src="plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
        <script src="plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>

        <!-- Theme Js -->
        <script src="js/admin.js"></script>
        <script src="js/pages/ui/tooltips-popovers.js"></script>

        <!-- Custom Js -->
        <script src="js/custom/dashboard.js"></script>
        <script src="js/pages/index.js"></script>


    </body>

</html>