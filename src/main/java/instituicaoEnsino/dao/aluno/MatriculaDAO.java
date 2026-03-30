package instituicaoEnsino.dao.aluno;

import instituicaoEnsino.config.DatabaseConnection;
import instituicaoEnsino.dominio.Disciplinas;
import instituicaoEnsino.dominio.aluno.Matricula;
import instituicaoEnsino.exception.SistemaAcademicoException;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatriculaDAO {

    public void salvar(Matricula matricula) {

        String sql = "INSERT INTO matricula (aluno_id, disciplina) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, matricula.getAluno().getId());
            stmt.setString(2, matricula.getDisciplina().name());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SistemaAcademicoException("Erro ao salvar matrícula");
        }
    }

    public int buscarIdMatricula(int alunoId, Disciplinas disciplina) {

        String sql = "SELECT id FROM matricula WHERE aluno_id = ? AND disciplina = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alunoId);
            stmt.setString(2, disciplina.name());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new SistemaAcademicoException("Matrícula não encontrada");
    }
}
