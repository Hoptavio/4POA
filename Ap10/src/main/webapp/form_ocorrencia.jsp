<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>FAETERJ Alerta - Reportar Ocorrência</title>
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

    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card p-4 shadow-sm">
                    <h3 class="mb-4">Reportar Nova Ocorrência</h3>
                    <p class="text-muted">Descreva a situação que está acontecendo na faculdade ou região para informar a direção.</p>
                    
                    <form action="OcorrenciaServlet" method="post">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Tipo de Problema</label>
                            <select name="tipo" class="form-select" required>
                                <option value="">Selecione a situação...</option>
                                <option value="Falta de luz">Falta de luz</option>
                                <option value="Falta de água">Falta de água</option>
                                <option value="Temporal forte">Temporal forte</option>
                                <option value="Risco de enchente">Risco de enchente</option>
                                <option value="Tiroteio ou violência">Tiroteio ou violência</option>
                                <option value="Problemas técnicos">Problemas técnicos na faculdade</option>
                                <option value="Transporte">Problemas no transporte público</option>
                                <option value="Outros">Outras situações</option>
                            </select>
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label fw-bold">Localização</label>
                            <input type="text" name="localizacao" class="form-control" placeholder="Ex: Campus Principal, Rua da faculdade, Estação de trem..." required>
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label fw-bold">Descrição da Situação</label>
                            <textarea name="descricao" class="form-control" rows="4" placeholder="Detalhe o que está acontecendo..." required></textarea>
                        </div>
                        
                        <button type="submit" class="btn btn-primary w-100 mt-2">Enviar Aviso de Ocorrência</button>
                    </form>
                    <div class="mt-3 text-center">
                        <a href="index.jsp" class="text-decoration-none">← Voltar à Tela Inicial</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
