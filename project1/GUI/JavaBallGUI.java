package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JavaBallGUI extends JFrame implements ActionListener
{
	private JButton addRef,alloRef,showChart,exitWindow,searchRef,reSet;
	private JTextField searchContent;
	private JTable table;
	
//	/**表格中的表头喝表数据*/
//	Object[][] cellData = {{"row1-col1", "row1-col2"},{"row2-col1", "row2-col2"}};
//	String[] columnNames = {"col1", "col2"};
	
	
	public JavaBallGUI() {
		setTitle("JavaBall");
		setSize(600,500);
		setLocation(700,700);
	
		setLocationRelativeTo(null);
		addRef=new JButton("Add Referees");
		alloRef=new JButton("Allocate Referees");
		showChart=new JButton("Show Chart");
		exitWindow=new JButton("Exit");
		searchRef=new JButton("Search");
		reSet=new JButton("Reset");
		
		table=new JTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        int count=7;
        tableModel.setColumnCount(count);
		
		
	    searchContent=new JTextField("Please enter Name or ID");
	    
	    /**增加头部文件*/
	    JPanel headerpan=new JPanel();
		headerpan.add(addRef);
		headerpan.add(alloRef);
		headerpan.add(showChart);
		headerpan.add(reSet);
		add(headerpan,"North");
 		
		/**增加底部框框*/
		JPanel bottompan=new JPanel();
		bottompan.add(searchContent);
		bottompan.add(searchRef);
		bottompan.add(exitWindow);
		add(bottompan,"South");
		
		/**添加表格*/
		add(table,"Center");
		
		
		
		
		
		/**disable the button*/
//		exitWindow.setEnabled(false);
		
		/**exit the window*/
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	/*searchContent 使得聚集焦点*/ 	
		searchContent.requestFocus();
		/**addActionListener*/
		
		addRef.addActionListener(this);
		alloRef.addActionListener(this);
		showChart.addActionListener(this);
		exitWindow.addActionListener(this);
		searchRef.addActionListener(this);
		reSet.addActionListener(this);
		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    String text;
		if(e.getSource()==addRef) 
			//弹出来框框  ( INFORMATION_MESSAGE ,WARNING_MESSAGE,QUESTION_MESSAGE,ERROR_MESSAGE)
			JOptionPane.showMessageDialog(null,"This is a message", "window title",JOptionPane.ERROR_MESSAGE);
		
		else if (e.getSource()==alloRef)
			System.out.println("allo");
		else if (e.getSource()==showChart)
			System.out.println("chart");
		else if(e.getSource()=="exit")
			System.out.println("exit");
		else if(e.getSource()==searchContent)
		{
			text=searchContent.getText();
			try {
				int n=Integer.parseInt(text.trim());
				System.out.println("Integer value="+n);	
			}
			catch(NumberFormatException x) {
				System.out.println(text+"is not a Number");
			}
//	
				
			}
			
		}
			
			
		}
	
 

