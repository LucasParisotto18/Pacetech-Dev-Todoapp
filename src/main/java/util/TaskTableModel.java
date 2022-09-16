/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author Lucas
 */
public class TaskTableModel extends AbstractTableModel{ //essa classe herda algumas coisas do AbstractTableModel
    
    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"}; //colunas q vao aparecer na tabela
    List<Task> tasks = new ArrayList(); //criando, e iniciando a lista vazia
    

    @Override
    public int getRowCount() { // vai me dizer quantas tarefas eu ja tenho (linhas)
     return tasks.size();
    }

    @Override
    public int getColumnCount() { //dizer quantas colunas eu tenho (colunas)
       return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){ //metodo bota o nome das colunas 
        return columns[columnIndex];
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){ //poder editar a coluna x 
        return columnIndex == 3; //mesma coisa q o if embaixo 
             
//        if (columnIndex == 3) //especificar q so pode editar a coluna 3
//            return true;
//        else
//            return false;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){ //me retorna qual a classe de cada coluna, se é string, int, boolean,...
        
        if (tasks.isEmpty()){
            return Object.class;
        }
       return this.getValueAt(0, columnIndex).getClass();
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { //vai dizer qual o determinado valor em cada linha e coluna e bota na jtable

        switch (columnIndex) {
            case 0: //quando for a primeira coluna (a contagem começa pelo zero retorna o nome da tarefa
                return tasks.get(rowIndex).getName();

            case 1:
                return tasks.get(rowIndex).getDescription();
                
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/y");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
    
            case 3:
                return tasks.get(rowIndex).isIsCompleted();
                  
            case 4:
                return "";
            
            case 5:
                return"";
                
            default:
                return "Dados não encontrados";

        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        tasks.get(rowIndex).setIsCompleted((boolean)aValue);// faz o check funcionar
    }
    

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


}
