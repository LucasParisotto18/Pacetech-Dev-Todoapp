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
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author jonathandamasiomedeiros
 */
public class TaskController {
    
    public void save(Task task) throws SQLException{
        String sql = "INSERT INTO TASKS (idProject, name, description, completed, notes, "
                + "deadline, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar inserir a tarefa no banco de dados" + e.getMessage(), e);
            
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    
    public void update(Task task) throws SQLException{
        String sql = "UPDATE TASKS SET idProject = ?, name = ?, description = ?, completed = ?, notes = ?, "
                + "deadline = ?, createdAt = ?, updatedAt = ? WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar atualizar a tarefa no banco de dados" + e.getMessage(), e);
            
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
        
    }
    
    public void removeById(int taskId) throws SQLException{
        String sql = "DELETE FROM TASKS WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a tarefa no banco de dados" + e.getMessage(), e);
            
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Task> getAll(int idProject) throws SQLException{
        
        String sql = "SELECT * FROM TASKS WHERE idProject = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //Lista de tarefas que estão vinculadas ao projeto.
        List<Task> tasks = new ArrayList();
        
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                Task task = new Task();
                
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);
                
            }
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar inserir a tarefa no banco de dados" + e.getMessage(), e);
            
        } finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        return tasks;
        
    }
    
    public Task getById (int id) throws SQLException{
        String sql = "SELECT * FROM TASKS WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                Task task = new Task();
                
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                return task;  
            }
            return new Task(); 
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar buscar o id da tarefa no banco de dados" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
    }
   }
}
