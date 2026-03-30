package instituicaoEnsino.dao.aluno;

import instituicaoEnsino.config.DatabaseConnection;
import instituicaoEnsino.dominio.aluno.Nota;
import instituicaoEnsino.exception.SistemaAcademicoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotaDAO {

    public void salvar(int matriculaId, Nota nota) {

        String sql = "INSERT INTO nota (matricula_id, tipo, valor, peso) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, matriculaId);
            stmt.setString(2, nota.getTipo());
            stmt.setDouble(3, nota.getValor());
            stmt.setDouble(4, nota.getPeso());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SistemaAcademicoException("Erro ao salvar nota");
        }
    }

    public List<Nota> listarPorMatricula(int matriculaId) {

        List<Nota> notas = new ArrayList<>();

        String sql = "SELECT tipo, valor, peso FROM nota WHERE matricula_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, matriculaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Nota nota = new Nota(
                        rs.getString("tipo"),
                        rs.getDouble("valor"),
                        rs.getDouble("peso")
                );

                notas.add(nota);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notas;
    }
}