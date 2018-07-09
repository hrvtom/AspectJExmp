import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.lang.Thread;

public class Test extends JFrame {
    public static void main(String[] args) {
	Test appFrame = new Test();
	DefaultTableModel tableModel = new DefaultTableModel(3,4);
	JTable table = new JTable(tableModel);
	appFrame.getContentPane().add(table);

	appFrame.pack();
	appFrame.setVisible(true);

	tableModel.setValueAt("[0,0]", 0, 0);
	sleep(5000);
	tableModel.removeRow(1);
	sleep(5000); 	// this prevents Exception, Probably this thread(removing) 
					// and invoker thread are simultaneously updating table

	EventQueue.invokeLater(new ValueSetter(tableModel, "[0,1]", 0, 1));
    }

	private static void sleep(long millis){
		try{
			Thread.sleep(5000);
		}catch (Exception e){
			Thread.dumpStack();
		}
		
	}
	
    private static class ValueSetter implements Runnable {
		TableModel _model;
		Object _value;
		int _row;
		int _column;

		public ValueSetter(TableModel model, 
				   Object value, int row, int column) {
			_model = model;
			_value = value;
			_row = row;
			_column = column;
		}

		public void run() {
			_model.setValueAt(_value, _row, _column);
		}
	
    }
}

