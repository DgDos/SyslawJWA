<%@page import="Model.Usuario"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Dashboard | Syslaw</title>
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

        <link href="plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" rel="stylesheet">

        <!-- Custom Css -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />

        <!--WaitMe Css-->
        <link href="plugins/waitme/waitMe.css" rel="stylesheet" />
        
        <!-- material walkthrough -->
        <link href="plugins/material-walkthrough/material-walkthrough.css" rel="stylesheet" />

        <style>.modal-backdrop.in { opacity: .4;}</style>


    </head>

    <body class="theme-blue" style="background-color: #f1f1f1;">

        <!-- Page Loader -->
        <div class="page-loader-wrapper p-l-w-dark">
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
                    <a class="navbar-brand" href=".">SysLaw</a>
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
                    <div class="py-5 text-center" id="logo">
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
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding: 0px; margin-top:-10px">
                        <div class="card" style="box-shadow: none" >
                            <div class="header bg-white add-event-header" style="background-color: #f1f1f1 !important;">
                                <div class="row clearfix">
                                    <div class="col-xs-6 col-sm-6" style="margin-top: 5px">
                                        <h2><span id="tour_misdemandas">Mi Dashboard</span></h2>
                                    </div>
                                    <div class="col-xs-12 col-sm-6 align-right">
                                        <button id="tour_addbutton" type="button" data-toggle="modal" data-target="#nuevaDemanda" class="btn bg-syslaw waves-effect btn-no-shadow">
                                            <i id="toogle-add-event-icon" class="material-icons">add</i>
                                        </button>

                                    </div>
                                </div>

                            </div>

                            <div class="body" id="dashboard-container" style="background-color: #f1f1f1;">  

                                <div class="card">
                                    <div class="body">
                                        <div class="row clearfix">
                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" id="tour_redaccion">
                                                <div class="info-box bg-blue hover-expand-effect">
                                                    <div class="icon">
                                                        <i class="material-icons">mode_edit</i>
                                                    </div>
                                                    <div class="content">
                                                        <div class="text">DEM. EN REDACCION</div>
                                                        <div class="number count-to">3</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" id="tour_revision">
                                                <div class="info-box bg-cyan hover-expand-effect">
                                                    <div class="icon">
                                                        <i class="material-icons">access_time</i>
                                                    </div>
                                                    <div class="content">
                                                        <div class="text">CONNECT EN ESPERA</div>
                                                        <div class="number count-to">3</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" id="tour_revision2">
                                                <div class="info-box bg-light-green hover-expand-effect">
                                                    <div class="icon">
                                                        <i class="material-icons">rate_review</i>
                                                    </div>
                                                    <div class="content">
                                                        <div class="text">CONNECT REVISADOS</div>
                                                        <div class="number count-to">2</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" id="tour_enviadas">
                                                <div class="info-box bg-orange hover-expand-effect">
                                                    <div class="icon">
                                                        <i class="material-icons">playlist_add_check</i>
                                                    </div>
                                                    <div class="content">
                                                        <div class="text">DEM. ENVIADAS</div>
                                                        <div class="number count-to">3</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="row clearfix">
                                            <!-- Visitors -->
                                            
                                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                                <div class="card">
                                                    <div class="body bg-cyan">
                                                        <div class="m-b--35 font-bold">LATEST SOCIAL TRENDS</div>
                                                        <ul class="dashboard-stat-list">
                                                            <li>
                                                                #socialtrends
                                                                <span class="pull-right">
                                                                    <i class="material-icons">trending_up</i>
                                                                </span>
                                                            </li>
                                                            <li>
                                                                #materialdesign
                                                                <span class="pull-right">
                                                                    <i class="material-icons">trending_up</i>
                                                                </span>
                                                            </li>
                                                            <li>#adminbsb</li>
                                                            <li>#freeadmintemplate</li>
                                                            <li>#bootstraptemplate</li>
                                                            <li>
                                                                #freehtmltemplate
                                                                <span class="pull-right">
                                                                    <i class="material-icons">trending_up</i>
                                                                </span>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- #END# Latest Social Trends -->
                                            <!-- Answered Tickets -->
                                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                                <div class="card">
                                                    <div class="body bg-teal">
                                                        <div class="font-bold m-b--35">ANSWERED TICKETS</div>
                                                        <ul class="dashboard-stat-list">
                                                            <li>
                                                                TODAY
                                                                <span class="pull-right"><b>12</b> <small>TICKETS</small></span>
                                                            </li>
                                                            <li>
                                                                YESTERDAY
                                                                <span class="pull-right"><b>15</b> <small>TICKETS</small></span>
                                                            </li>
                                                            <li>
                                                                LAST WEEK
                                                                <span class="pull-right"><b>90</b> <small>TICKETS</small></span>
                                                            </li>
                                                            <li>
                                                                LAST MONTH
                                                                <span class="pull-right"><b>342</b> <small>TICKETS</small></span>
                                                            </li>
                                                            <li>
                                                                LAST YEAR
                                                                <span class="pull-right"><b>4 225</b> <small>TICKETS</small></span>
                                                            </li>
                                                            <li>
                                                                ALL
                                                                <span class="pull-right"><b>8 752</b> <small>TICKETS</small></span>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- #END# Answered Tickets -->
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


                <!-- Evento publico modal -->
                <div class="modal fade-scale fade" id="nuevaDemanda" tabindex="-1" role="dialog" style="display: none;">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">

                            <div class="modal-header detail-header bg-blue" id="modEvePubHeader">
                                <div class="pull-left">
                                    <h4 style="font-size:18px" id="modEvePubTitulo">Nueva demanda</h4>

                                </div>

                                <button data-dismiss="modal" type="button" class="pull-right btn btn-info btn-sm btn-transparent">
                                    <i id="toogle-add-event-icon" class="material-icons">close</i>
                                </button>
                            </div>
                            <form id="nueva_demanda_form" autocomplete="off">
                                <div class="modal-body">

                                    <div class="row">
                                        <div class="col-md-12">
                                            <label for="nuevotitulo">Titulo de la nueva demanda</label>
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input autofocus maxlength="50" type="text" id="nuevotitulo" class="form-control" placeholder="Ingresa un título...">
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-lg btn-default waves-effect" data-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-lg btn-primary waves-effect">Crear demanda</button>
                                </div>
                            </form>
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

        <!-- Jquery CountTo Plugin Js -->
        <script src="plugins/jquery-countto/jquery.countTo.js"></script>

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
        
        <!-- Material Walkthrough -->
        <script src="plugins/material-walkthrough/material-walkthrough.js"></script>

        <!-- Theme Js -->
        <script src="js/admin.js"></script>
        <script src="js/pages/ui/tooltips-popovers.js"></script>

        <!-- Custom Js -->
        <script src="js/custom/dash.js"></script>



    </body>

</html>