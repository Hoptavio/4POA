package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Comunicado;
import util.Conexao;

public class ComunicadoDAO {

    public void salvar(Comunicado comunicado) {
        String sql = "INSERT INTO comunicado (mensagem, status, data_hora) VALUES (?, ?, NOW())";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, comunicado.getMensagem());
            stmt.setString(2, comunicado.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comunicado> listar() {
        List<Comunicado> comunicados = new ArrayList<>();
        String sql = "SELECT * FROM comunicado ORDER BY data_hora DESC";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Comunicado c = new Comunicado();
                c.setId(rs.getInt("id"));
                c.setMensagem(rs.getString("mensagem"));
                c.setStatus(rs.getString("status"));
                c.setDataHora(rs.getString("data_hora"));
                comunicados.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comunicados;
    }
    
    public Comunicado obterUltimoComunicado() {
        Comunicado c = null;
        String sql = "SELECT * FROM comunicado ORDER BY data_hora DESC LIMIT 1";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                c = new Comunicado();
                c.setId(rs.getInt("id"));
                c.setMensagem(rs.getString("mensagem"));
                c.setStatus(rs.getString("status"));
                c.setDataHora(rs.getString("data_hora"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
