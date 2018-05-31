  <%@page import="Model.Usuario"%>
<%
                            if (request.getSession().getAttribute("usuario") != null) {
                                Usuario u = (Usuario) request.getSession().getAttribute("usuario");
                                if(u.getTipo_usuario()==0){
                                    response.sendRedirect("dash0.jsp");
                                }if(u.getTipo_usuario()==1){
                                    response.sendRedirect("dash1.jsp");
                                }if(u.getTipo_usuario()==2){
                                }
                            }
                            else{
                                response.sendRedirect("signin.html");
                            }
                        %>