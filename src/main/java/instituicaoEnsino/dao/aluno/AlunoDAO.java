package instituicaoEnsino.dao.aluno;

import instituicaoEnsino.config.DatabaseConnection;
import instituicaoEnsino.dominio.aluno.Aluno;
import instituicaoEnsino.exception.SistemaAcademicoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void salvar(Aluno aluno) {

        String sql = "INSERT INTO aluno (nome) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SistemaAcademicoException("Erro ao salvar aluno");
        }
    }

    public List<Aluno> listar() {

        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT id, nome FROM aluno";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                alunos.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SistemaAcademicoException("Erro ao listar alunos");
        }

        return alunos;
    }

    public Aluno buscarPorId(int id) {

        String sql = "SELECT id, nome FROM aluno WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new SistemaAcademicoException("Aluno não encontrado");
    }
}
