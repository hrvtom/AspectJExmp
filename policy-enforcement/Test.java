import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class Test {
    static DefaultTableModel tableModel = new DefaultTableModel();
    static DefaultListModel listModel = new DefaultListModel();

    public static void main(String[] args) throws Exception {
		setupListeners();
		for (int i = 0; i < 10; ++i) {
			System.out.println("Iteration: " + i);
			tableModel.fireTableDataChanged();
			System.gc();
			Thread.sleep(1000);
		}
    }

    public static void setupListeners() {
		TableModelListener testTableListener = new TableModelListener() {
				public void tableChanged(TableModelEvent e) {
					System.out.println(">TableModelListener: tableChanged executed " + this);
				}
			};

		tableModel.addTableModelListener(testTableListener);
		tableModel.addTableModelListener(testTableListener);
		tableModel.fireTableDataChanged();

		ListDataListener testListListener = new ListDataListener() {
			public void contentsChanged(ListDataEvent e) {
				System.out.println(">ListDataListener: contentsChanged executed" + this);
			}
			public void intervalAdded(ListDataEvent e) {
				System.out.println(">ListDataListener: intervalAdded executed"  + this);
			}
			public void intervalRemoved(ListDataEvent e) {
				System.out.println(">ListDataListener: intervalRemoved executed" + this);
			}
			};

		listModel.addListDataListener(testListListener);
		listModel.addListDataListener(testListListener);
		listModel.addListDataListener(testListListener);
    }
}
