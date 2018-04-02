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
                            <div class="card">
                                <div class="body">
                                    <form id="demanda_wizard" autocomplete="off">


                                        <h2>Demandante</h2>
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


                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Demandante</h3>
                                                </div>


                                                <div class="col-md-6">
                                                    <label for="dte_nom">Nombre del demandante</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" id="dte_nom" class="form-control" placeholder="Ingrese el nombre...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dte_ciudad">Ciudad del demandante</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" id="dte_ciudad" class="form-control" placeholder="Ingrese la ciudad...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <label for="juez_nombre">Señor, juez municipal de</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="" id="juez_nombre" class="form-control" placeholder="Ingrese la ciudad del juez...">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="dte_id_tipo">Tipo de id del demandante</label>
                                                    <div class="id-type-radio">
                                                        <input name="dte_id_tipo" type="radio" id="radio1" value="0" class="with-gap radio-col-blue" checked="">
                                                        <label for="radio1">C.C</label>
                                                        <input name="dte_id_tipo" type="radio" id="radio2" value="1" class="with-gap radio-col-blue">
                                                        <label for="radio2">NIT</label>
                                                        <input name="dte_id_tipo" type="radio" id="radio3" value="2" class="with-gap radio-col-blue">
                                                        <label for="radio3">TI</label>
                                                        <input name="dte_id_tipo" type="radio" id="radio4" value="3" class="with-gap radio-col-blue">
                                                        <label for="radio4">PASAPORTE</label>
                                                    </div>
                                                </div>


                                                <div class="col-md-6">
                                                    <label for="dte_id">Numero del demandante</label>
                                                    <div class="form-group">
                                                        <div class="form-line">
                                                            <input type="text" id="dte_id" class="form-control" placeholder="Número de identificación...">
                                                        </div>
                                                    </div>
                                                </div>



                                                <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                    <h3 class="form-section-title">Representante legal</h3>
                                                </div>
                                                <div class="col-md-6">    
                                                    <label class="checkbox-label">Representante legal</label><br>
                                                    <input type="checkbox" id="dte_rep_tiene" class="filled-in chk-col-blue">
                                                    <label for="dte_rep_tiene">Demandante tiene representante legal</label>
                                                </div>
                                                <div class="hidden" id="dte_rep_tiene_section">
                                                    <div class="col-md-6">
                                                        <label for="dte_rep_nom">Nombre del representante</label>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="dte_rep_nom" class="form-control" placeholder="Ingrese el nombre...">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label for="dte_rep_id_tipo">Tipo de id del representante</label>
                                                        <div class="id-type-radio">
                                                            <input name="dte_rep_id_tipo" type="radio" id="radio1" value="0" class="with-gap radio-col-blue" checked="">
                                                            <label for="radio1">C.C</label>
                                                            <input name="dte_rep_id_tipo" type="radio" id="radio2" value="1" class="with-gap radio-col-blue">
                                                            <label for="radio2">NIT</label>
                                                            <input name="dte_rep_id_tipo" type="radio" id="radio3" value="2" class="with-gap radio-col-blue">
                                                            <label for="radio3">TI</label>
                                                            <input name="dte_rep_id_tipo" type="radio" id="radio4" value="3" class="with-gap radio-col-blue">
                                                            <label for="radio4">PASAPORTE</label>
                                                        </div>
                                                    </div>


                                                    <div class="col-md-6">
                                                        <label for="dte_rep_id">Numero del representante</label>
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="dte_rep_id" class="form-control" placeholder="Número de identificación...">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>



                                        </section>

                                        <h2>Demandado</h2>
                                        <section>

                                            <div class="col-md-12">                                               
                                                <input type="checkbox" id="dte_rep_tiene" class="filled-in chk-col-blue">
                                                <label for="dte_rep_tiene">Demandante tiene representante legal</label>
                                            </div>

                                            <div class="col-md-12" style="padding: 0px; margin: 0px;">
                                                <h3 class="form-section-title">Apoderado</h3>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="dte_rep_nom">Nombre del representante</label>
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input type="text" id="dte_rep_nom" class="form-control" placeholder="Ingrese el nombre...">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="dte_rep_id_tipo">Tipo de id del representante</label>
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input type="text" id="dte_rep_id_tipo" class="form-control" placeholder="Tipo de identificacion...">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="dte_rep_id">Numero del representante</label>
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input type="text" id="dte_rep_id" class="form-control" placeholder="Número de identificación...">
                                                    </div>
                                                </div>
                                            </div>




                                        </section>

                                        <h2>Pretensiones</h2>
                                        <section>
                                            <input id="acceptTerms-2" name="acceptTerms" type="checkbox" required>
                                            <label for="acceptTerms-2">I agree with the Terms and Conditions.</label>
                                        </section>

                                        <h2>Hechos</h2>
                                        <section>
                                            <input id="acceptTerms-2" name="acceptTerms" type="checkbox" required>
                                            <label for="acceptTerms-2">I agree with the Terms and Conditions.</label>
                                        </section>

                                        <h2>Pruebas</h2>
                                        <section>
                                            <input id="acceptTerms-2" name="acceptTerms" type="checkbox" required>
                                            <label for="acceptTerms-2">I agree with the Terms and Conditions.</label>
                                        </section>

                                        <h2>Manifestaciones</h2>
                                        <section>
                                            <input id="acceptTerms-2" name="acceptTerms" type="checkbox" required>
                                            <label for="acceptTerms-2">I agree with the Terms and Conditions.</label>
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

        <!-- Theme Js -->
        <script src="js/admin.js"></script>

        <!-- Custom Js -->
        <script src="js/custom/demanda.js"></script>
        <script src="js/pages/index.js"></script>


    </body>

</html>