
package com.mycompany.todoapp2;

import controller.ProjectController;
import controller.TaskController;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;
import model.Task;


public class TodoApp2 {

    public static void main(String[] args) throws SQLException {
        
        ProjectController projectController = new ProjectController();

//Inserção
        
//        Project project = new Project();
//        project.setName("Projeto Criado Todoapp2");
//        project.setDescription("Descrição do Projeto Todoapp2");
//        project.setUpdatedAt(new Date());
        
//        try {
//            projectController.save(project);
//        } catch (SQLException ex) {
//            Logger.getLogger(TodoApp2.class.getName()).log(Level.SEVERE, null, ex);
//        }

//Atualização

//        Project project = new Project();
//        project.setId(1);
//        project.setName("Novo Projeto teste");
//        project.setDescription("Nova Descrição do Projeto");
//        project.setUpdatedAt(new Date());
//        
//        try {
//            projectController.update(project);
//        } catch (SQLException ex) {
//            Logger.getLogger(TodoApp2.class.getName()).log(Level.SEVERE, null, ex);
//        }

//Busca dos projetos
        
//        List<Project> projects = projectController.getAll();
//        System.out.println("Total de projetos: " + projects.size());
//        
//        projectController.removeById(1);
//        
//        projects = projectController.getAll();
//        System.out.println("Total de projetos: " + projects.size());
             

    TaskController taskController = new TaskController();
    
//Inserção
//    Task task = new Task();
//    task.setIdProject(2);
//    task.setName("Fazer o código fonte Todoapp2");
//    task.setDescription("Descrição da task Todoapp2");
//    task.setNotes("Notes da task");
//    task.setDeadline(new Date());
//    task.setUpdatedAt(new Date());
//    taskController.save(task);

//Atualização
//    Task task = new Task();
//    task.setId(1);
//    task.setIdProject(2);
//    task.setName("Update Fazer o código fonte");
//    task.setDescription("Update Descrição da task");
//    task.setNotes("Update Notes da task");
//    task.setDeadline(new Date());
//    task.setUpdatedAt(new Date());    
//    
//    taskController.update(task);

//Busca de todas as tarefas
        List<Task> tasks = taskController.getAll(2);
        System.out.println("Total de tarefas: " + tasks.size());
        
//Remoção da tarefa
//        taskController.removeById(1);
//        
//        tasks = taskController.getAll(2);
//        System.out.println("Total de tarefas: " + tasks.size());


    }

    
}
