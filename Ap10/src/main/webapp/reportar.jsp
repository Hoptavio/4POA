<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Ocorrencia" %>
<%@ page import="dao.OcorrenciaDAO" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FAETERJ Alerta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f4f6f9; font-family: Arial, sans-serif; }
        .navbar-custom { background-color: #0d3b66; }
        .card-custom { border-radius: 12px; border: none; box-shadow: 0px 4px 10px rgba(0,0,0,0.1); }
        .status-card { background-color: #1d6fa5; color: white; }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark navbar-custom mb-4">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">FAETERJ Alerta</a>
        </div>
    </nav>
    <div class="container">
        <h2 class="mb-4">Ocorrências Reportadas</h2>
        <div class="row">
        <%
            OcorrenciaDAO dao = new OcorrenciaDAO();
            List<Ocorrencia> ocorrencias = dao.listar();
            if (ocorrencias != null && !ocorrencias.isEmpty()) {
                for (Ocorrencia o : ocorrencias) {
        %>
            <div class="col-md-4 mb-4">
                <div class="card card-custom h-100">
                    <div class="card-header status-card">
                        <strong><%= o.getTipo() %></strong>
                    </div>
                    <div class="card-body">
                        <p class="card-text"><strong>Descrição:</strong> <%= o.getDescricao() %></p>
                        <p class="card-text"><strong>Local:</strong> <%= o.getLocalizacao() %></p>
                        <p class="card-text"><small class="text-muted"><%= o.getDataHora() %></small></p>
                    </div>
                </div>
            </div>
        <%
                }
            } else {
        %>
            <div class="col-12">
                <div class="alert alert-info">Nenhuma ocorrência reportada até o momento.</div>
            </div>
        <%
            }
        %>
        </div>
        <a href="index.jsp" class="btn btn-primary mt-3">Nova Ocorrência</a>
    </div>
</body>
</html>
