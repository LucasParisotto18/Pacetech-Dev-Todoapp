/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author Lucas
 */

// metodo que coloca cor no fundo do prazo atrasado ou nao
public class DeadlineColumnCellRederer extends DefaultTableCellRenderer {
    
    
   @Override
   public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col){
       
       JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col); //pega a classe do DefaultTableCellRenderer (com o super) que ja seria
                                                                                                                  //exibida normalmente e define ela na label e a partir dai faz as customizaçoes
      
      label.setHorizontalAlignment(CENTER);
       
      TaskTableModel  taskModel = (TaskTableModel) table.getModel();
      Task task = taskModel.getTasks().get(row); //pega a tarefa que coresponde a linha selecionada 
      
      if (task.getDeadline().after(new Date())){ //conferir se  o prazo é depois de hj 
          label.setBackground(Color.GREEN);
      } else {
          label.setBackground(Color.RED);
      }
      
       return label;
   }
    
}
