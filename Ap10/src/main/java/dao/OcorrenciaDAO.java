package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ocorrencia;
import util.Conexao;

public class OcorrenciaDAO {

    public void salvar(Ocorrencia ocorrencia) {
        String sql = "INSERT INTO ocorrencia (tipo, descricao, localizacao, data_hora) VALUES (?, ?, ?, NOW())";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ocorrencia.getTipo());
            stmt.setString(2, ocorrencia.getDescricao());
            stmt.setString(3, ocorrencia.getLocalizacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ocorrencia> listar() {
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        String sql = "SELECT * FROM ocorrencia ORDER BY data_hora DESC";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setId(rs.getInt("id"));
                o.setTipo(rs.getString("tipo"));
                o.setDescricao(rs.getString("descricao"));
                o.setLocalizacao(rs.getString("localizacao"));
                o.setDataHora(rs.getString("data_hora"));
                ocorrencias.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ocorrencias;
    }
}
