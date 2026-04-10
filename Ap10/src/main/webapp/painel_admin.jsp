<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Ocorrencia" %>
<%@ page import="dao.OcorrenciaDAO" %>
<%@ page import="model.Comunicado" %>
<%@ page import="dao.ComunicadoDAO" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FAETERJ Alerta - Painel Administrativo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f4f6f9; font-family: Arial, sans-serif; }
        .navbar-custom { background-color: #0d3b66; }
        .status-card { background-color: #1d6fa5; color: white; }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark navbar-custom mb-4">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">FAETERJ Alerta - Administração</a>
            <div class="ms-auto text-white">
                <a href="index.jsp" class="btn btn-outline-light btn-sm">Sair do Painel</a>
            </div>
        </div>
    </nav>

    <div class="container">
        
        <!-- Bloco para lançar Comunicado -->
        <div class="row mb-5">
            <div class="col-12">
                <div class="card p-4 border-primary shadow-sm">
                    <h3 class="text-primary mb-3">Emitir Comunicado Oficial</h3>
                    <form action="ComunicadoServlet" method="post">
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label class="fw-bold">Status da Faculdade</label>
                                <select name="status" class="form-select" required>
                                    <option value="Funcionamento normal">Funcionamento normal</option>
                                    <option value="Alerta">Em Alerta</option>
                                    <option value="Faculdade fechada">Faculdade fechada</option>
                                </select>
                            </div>
                            <div class="col-md-8 mb-3">
                                <label class="fw-bold">Mensagem aos Alunos e Funcionários</label>
                                <input type="text" name="mensagem" class="form-control" placeholder="Descreva a decisão (ex: Aulas remotas devido à falta de luz)" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary d-block w-100">Atualizar Status e Emitir Comunicado</button>
                    </form>
                </div>
            </div>
        </div>

        <h2 class="mb-4 mt-5">Histórico de Ocorrências Reportadas</h2>
        <div class="row">
        <%
            OcorrenciaDAO dao = new OcorrenciaDAO();
            List<Ocorrencia> ocorrencias = dao.listar();
            if (ocorrencias != null && !ocorrencias.isEmpty()) {
                for (Ocorrencia o : ocorrencias) {
        %>
            <div class="col-md-4 mb-4">
                <div class="card h-100 shadow-sm border-0">
                    <div class="card-header status-card">
                        <strong><%= o.getTipo() %></strong>
                    </div>
                    <div class="card-body">
                        <p class="card-text mb-1"><strong>Local:</strong> <%= o.getLocalizacao() %></p>
                        <p class="card-text mb-1"><strong>Descrição:</strong> <%= o.getDescricao() %></p>
                        <hr class="my-2">
                        <p class="card-text"><small class="text-muted">Enviado em: <%= o.getDataHora() %></small></p>
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

    </div>
</body>
</html>
