package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ocorrencia;
import dao.OcorrenciaDAO;

@WebServlet("/OcorrenciaServlet")
public class OcorrenciaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");
        String localizacao = request.getParameter("localizacao");
        
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setTipo(tipo);
        ocorrencia.setDescricao(descricao);
        ocorrencia.setLocalizacao(localizacao);
        
        OcorrenciaDAO dao = new OcorrenciaDAO();
        dao.salvar(ocorrencia);
        // Redireciona de volta para a tela inicial
        response.sendRedirect("index.jsp");
    }
}
