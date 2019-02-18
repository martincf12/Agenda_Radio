package Clases;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class CellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(null);
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        boolean oddRow = (row % 2 == 0);

        Color c = new Color(199,250,214);
        Color a = new Color(255,255,255);  
        Color b = new Color(9,124,43);

        if (oddRow)
        {
            setBackground(c);
        }else 
        { 
            setBackground(a);
        }
        
        if (isSelected)
        {
            this.setForeground(Color.WHITE);
            this.setBackground(b);
            this.setOpaque(true);
        }else
        {
            this.setForeground(Color.BLACK);
        }  
        
        return this;
    }

}
