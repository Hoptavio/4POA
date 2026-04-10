<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="dao.ComunicadoDAO" %>
<%@ page import="model.Comunicado" %>

<%
    ComunicadoDAO dao = new ComunicadoDAO();
    Comunicado statusAtual = dao.obterUltimoComunicado();
    
    String corBadge = "bg-success";
    String alertClass = "alert-success";
    String tituloStatus = "Funcionamento Normal";
    String msgStatus = "A faculdade está funcionando normalmente.";
    String dataStatus = "";
    
    if (statusAtual != null) {
        msgStatus = statusAtual.getMensagem();
        tituloStatus = statusAtual.getStatus();
        dataStatus = statusAtual.getDataHora();
        
        if (tituloStatus.equalsIgnoreCase("Alerta")) {
            corBadge = "bg-warning text-dark";
            alertClass = "alert-warning";
        } else if (tituloStatus.equalsIgnoreCase("Faculdade fechada")) {
            corBadge = "bg-danger";
            alertClass = "alert-danger";
        }
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FAETERJ Alerta - Início</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f4f6f9; font-family: Arial, sans-serif; }
        .navbar-custom { background-color: #0d3b66; }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark navbar-custom mb-4">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">FAETERJ Alerta</a>
        </div>
    </nav>

    <div class="container">
        <div class="row mb-5">
            <div class="col-md-12 text-center">
                <h2>Status da Faculdade: <span class="badge <%= corBadge %>"><%= tituloStatus %></span></h2>
            </div>
        </div>

        <div class="row justify-content-center mb-5">
            <div class="col-md-8">
                <div class="alert <%= alertClass %> text-center" role="alert">
                    <h4 class="alert-heading">Comunicado Oficial</h4>
                    <p><%= msgStatus %></p>
                    <hr>
                    <p class="mb-0"><small>Atualizado em: <%= dataStatus %></small></p>
                </div>
            </div>
        </div>
        
        <div class="row text-center mb-5 mt-5">
            <div class="col-md-6 mb-3">
                <div class="card p-4 shadow-sm h-100">
                    <h4>Área do Aluno</h4>
                    <p class="text-muted">Presenciou algum problema (falta de luz, temporal, tiroteio)? Reporte aqui para avisar a direção.</p>
                    <a href="form_ocorrencia.jsp" class="btn btn-primary mt-auto">Reportar Ocorrência</a>
                </div>
            </div>
            
            <div class="col-md-6 mb-3">
                <div class="card p-4 shadow-sm h-100">
                    <h4>Administração</h4>
                    <p class="text-muted">Acesso restrito para direção avaliar ocorrências e emitir comunicados oficiais.</p>
                    <a href="painel_admin.jsp" class="btn btn-secondary mt-auto">Acesso Admin</a>
                </div>
            </div>
        </div>

    </div>
</body>
</html>
