/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;


public class ProjectController {
    
    public void save(Project project) throws SQLException{
        String sql = "INSERT INTO PROJECTS (NAME, DESCRIPTION, CREATEDAT, UPDATEDAT) "
                + "VALUE (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            
            statement.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar inserir o projeto no banco de dados" + e.getMessage(), e);
            
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(Project project) throws SQLException{
        String sql = "UPDATE PROJECTS SET NAME = ?, DESCRIPTION = ?, CREATEDAT = ?, UPDATEDAT = ? "
                + "WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            
            statement.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar atualizar o projeto no banco de dados" + e.getMessage(), e);
            
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public void removeById(int projectId) throws SQLException{
        
        String sql = "DELETE FROM PROJECTS WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, projectId);
            
            statement.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar deletar o projeto no banco de dados" + e.getMessage(), e);
            
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public List<Project> getAll() throws SQLException{
        String sql = "SELECT * FROM PROJECTS";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList();
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                Project project = new Project();
                
                project.setId(resultSet.getInt("ID"));
                project.setName(resultSet.getString("NAME"));
                project.setDescription(resultSet.getString("DESCRIPTION"));
                project.setCreatedAt(resultSet.getDate("CREATEDAT"));
                project.setUpdatedAt(resultSet.getDate("UPDATEDAT"));
                
                projects.add(project); 
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar inserir o projeto no banco de dados" + e.getMessage(), e);
            
        } finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        return projects;
    }
    
}