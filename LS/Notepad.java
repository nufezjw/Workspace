import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Notepad extends JFrame{
   private final Color colorvalues[] = 
      { Color.black, Color.blue, Color.red, Color.green };   //������ɫ����
   String styleNames[] = { "Bold", "Italic" };//����������
   String fontNames[] = { "����", "�����п�", "����" };//��������
   String[] sizeString = new String[30];//�ֺ�����
   int[] size = new int[30];//���ֺ������Ӧ���ֺ������������������ִ�С
   private JRadioButtonMenuItem colorItems[], fonts[];
   private JCheckBoxMenuItem styleItems[];
   private JTextArea displayText;//�����ı��༭��
   private ButtonGroup fontGroup, colorGroup;//�����飬����ɫ��
   private int style;//������
   private JScrollPane scroll;//Ϊ�ı��༭���ṩ������
   private String selectText = "";//����ı��༭����ѡ�е��ı�����
   private JComboBox styleBox,fontBox,sizeBox;//������
   private JPanel toolPanel;//��Ź�����
   private int rowNumber = 0;

   // set up GUI
   public Notepad()
   {
      super( "���±�" );//����  
      
      //��ʼ�������С����
      for(int i = 0 ; i<size.length;i++){
       sizeString[i] = "" + (i+5) * 2;
       size[i] = (i+5)*2;
      }
      
      Container container = getContentPane();
      container.setLayout(new BorderLayout() );
      
   //ͳ������

           
      toolPanel = new JPanel();
      
      JLabel label1 = new JLabel("��������");
      toolPanel.add(label1);
      fontBox = new JComboBox(fontNames);
      fontBox.addItemListener(  //�¼�����	
       new ItemListener(){

        public void itemStateChanged(ItemEvent event){
         if( event.getStateChange() == ItemEvent.SELECTED){
          displayText.setFont( new Font( fontNames[fontBox.getSelectedIndex()],
               displayText.getFont().getStyle(), displayText.getFont().getSize() ) );

       
         }
        }
       }
      );
      toolPanel.add(fontBox);//���
      
      JLabel label2 = new JLabel("������");
      toolPanel.add(label2);
      String style_name[] = {"����","��б","����","��б�Ӵ���"};//������
      styleBox = new JComboBox(style_name);
      styleBox.addItemListener(   //�¼�����
       new ItemListener(){

        public void itemStateChanged(ItemEvent event){
         if( event.getStateChange() == ItemEvent.SELECTED){
          if(styleBox.getSelectedIndex()==0) style = Font.PLAIN;
          if(styleBox.getSelectedIndex()==1) style = Font.ITALIC;
          if(styleBox.getSelectedIndex()==2) style = Font.BOLD;
          if(styleBox.getSelectedIndex()==3) style = Font.ITALIC+Font.BOLD;
          displayText.setFont( new Font( displayText.getFont().getName(), 
               style, displayText.getFont().getSize() ) );

       
         }
        }
       }
      );
      
      toolPanel.add( styleBox );

      JLabel label3 = new JLabel("�ֺ�");
      toolPanel.add(label3);     
      sizeBox = new JComboBox(sizeString);
      sizeBox.addItemListener(
       new ItemListener(){

        public void itemStateChanged(ItemEvent event){
         if( event.getStateChange() == ItemEvent.SELECTED){
          displayText.setFont( new Font( displayText.getFont().getName(),
               displayText.getFont().getStyle(), size[sizeBox.getSelectedIndex()] ) );

       
         }
        }
       }
      );
      toolPanel.add(sizeBox);
      container.add( toolPanel, BorderLayout.NORTH );
      

      // set up File menu and its menu items
      JMenu fileMenu = new JMenu( "�ļ�(F)" );
      fileMenu.setMnemonic( 'F' );

      // set up About... menu item
      JMenuItem aboutItem = new JMenuItem( "����(A)..." );
      aboutItem.setMnemonic( 'A' );
      fileMenu.add( aboutItem );
      aboutItem.addActionListener(

         new ActionListener() {  // anonymous inner class

            // display message dialog when user selects About...
            public void actionPerformed( ActionEvent event )
            {
               JOptionPane.showMessageDialog( Notepad.this,
                  "ģ����±�����/ncopyright@2005_Qdieyou����κ��һ",
                  "����", JOptionPane.PLAIN_MESSAGE );
               rowNumber = displayText.getRows();
               JOptionPane.showMessageDialog(null,""+ rowNumber);
            }

         }  // end anonymous inner class

      ); // end call to addActionListener
 
      // set up Exit menu item�˳��˵�
      JMenuItem exitItem = new JMenuItem( "Exit" );
      exitItem.setMnemonic( 'x' );
      fileMenu.add( exitItem );
      exitItem.addActionListener(

         new ActionListener() {  // anonymous inner class

            // terminate application when user clicks exitItem
            public void actionPerformed( ActionEvent event )
            {
               System.exit( 0 );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      // create menu bar and attach it to MenuTest window
      JMenuBar bar = new JMenuBar();  
      setJMenuBar( bar );  
      bar.add( fileMenu );  
      
      JMenu editMenu = new JMenu( "�༭(E)" );
      editMenu.setMnemonic( 'E' );
      
      //���Ʋ˵�ѡ��
      JMenuItem copyItem = new JMenuItem( "����(C)" );
      copyItem.setMnemonic( 'C' );
      editMenu.add( copyItem );
      copyItem.addActionListener(
       new ActionListener(){
        public void actionPerformed( ActionEvent event ){
         selectText = displayText.getSelectedText();//���ѡ�е����ݣ���������selectText��
        }
       }
      );
      
      //ճ����ʵ��
      JMenuItem pasteItem = new JMenuItem( "ճ��(P)" );
      pasteItem.setMnemonic( 'P' );
      editMenu.add( pasteItem );
      pasteItem.addActionListener(
       new ActionListener(){
        public void actionPerformed( ActionEvent event ){
         int position = displayText.getCaretPosition();//�����굱ǰλ��
         displayText.insert( selectText,position );//���뵽��굱ǰλ��
        }
       }
      );
      
      JMenuItem swapItem = new JMenuItem( "�滻(R)..." );
      swapItem.setMnemonic( 'R' );
      editMenu.add( swapItem );
      swapItem.addActionListener(
       new ActionListener(){
        public void actionPerformed( ActionEvent event ){
         JPanel swapPanel = new JPanel();
         JLabel lookupLabel = new JLabel("Ҫ�滻������");
         JTextField inputText = new JTextField(10);
         JLabel swapLabel = new JLabel("�滻Ϊ��");
         JTextField changetoText = new JTextField(10);
         swapPanel.add( lookupLabel );
         swapPanel.add( inputText );
         swapPanel.add( swapLabel );
         swapPanel.add( changetoText );
         JOptionPane.showMessageDialog(null,swapPanel);
         String text = displayText.getText();//��������ı�����
         String changeText = text.replace(inputText.getText(),changetoText.getText());//����滻�������
         displayText.setText(changeText);
         
        }
       }
      );
      
      bar.add( editMenu );//add editMenu
      

      // create Format menu, its submenus and menu items
      JMenu formatMenu = new JMenu( "��ʽ(R)" );  
      formatMenu.setMnemonic( 'R' );
   
   //�Զ����еĹ����л�
      JMenuItem changeItem = new JMenuItem( "�Զ�����(W)" );
      changeItem.setMnemonic( 'W' );
      formatMenu.add( changeItem );
      changeItem.addActionListener(
       new ActionListener(){
        boolean var = false;
        public void actionPerformed( ActionEvent event ){
         
         if(var) var = false;
         else var=true;
         displayText.setLineWrap(var);
        }
       }
      );

      // create Color submenu
      String colors[] = { "Black", "Blue", "Red", "Green" };

      JMenu colorMenu = new JMenu( "Color" );
      colorMenu.setMnemonic( 'C' );

      colorItems = new JRadioButtonMenuItem[ colors.length ];
      colorGroup = new ButtonGroup();
      ItemHandler itemHandler = new ItemHandler();

      // create color radio button menu items
      for ( int count = 0; count < colors.length; count++ ) {
         colorItems[ count ] = 
            new JRadioButtonMenuItem( colors[ count ] );
         colorMenu.add( colorItems[ count ] );
         colorGroup.add( colorItems[ count ] );
         colorItems[ count ].addActionListener( itemHandler );
      }

      // select first Color menu item
      colorItems[ 0 ].setSelected( true );  

      // add format menu to menu bar
      formatMenu.add( colorMenu );
      formatMenu.addSeparator();

      // create Font submenu
      JMenu fontMenu = new JMenu( "Font" );
      fontMenu.setMnemonic( 'n' );

      fonts = new JRadioButtonMenuItem[ fontNames.length ];
      fontGroup = new ButtonGroup();

      // create Font radio button menu items
      for ( int count = 0; count < fonts.length; count++ ) {
         fonts[ count ] = new JRadioButtonMenuItem( fontNames[ count ] );
         fontMenu.add( fonts[ count ] );
         fontGroup.add( fonts[ count ] );
         fonts[ count ].addActionListener( itemHandler );
      }

      // select first Font menu item
      fonts[ 0 ].setSelected( true );

      fontMenu.addSeparator();

      // set up style menu items
      

      styleItems = new JCheckBoxMenuItem[ styleNames.length ];


      // create style checkbox menu items
      for ( int count = 0; count < styleNames.length; count++ ) {
         styleItems[ count ] = 
            new JCheckBoxMenuItem( styleNames[ count ] );
         fontMenu.add( styleItems[ count ] );
         StyleHandler styleHandler = new StyleHandler();
         styleItems[ count ].addItemListener( styleHandler );
      }

      // put Font menu in Format menu
      formatMenu.add( fontMenu );

      // add Format menu to menu bar
      bar.add( formatMenu );

      JMenu helpMenu = new JMenu( "����(H)" );  
      helpMenu.setMnemonic( 'H' );
   
   //�����˵���
      JMenuItem helpItem = new JMenuItem( "��������(H)..." );
      helpItem.setMnemonic( 'H' );
      helpMenu.add( helpItem );
      helpItem.addActionListener(
       new ActionListener(){
        public void actionPerformed( ActionEvent event ){
         JTextArea helpText = new JTextArea(
           "��ʽ����Զ�����˵��������һ���л�����/nֻ��ʵ�������ı��ķ������ȵ�����/n"+
           "���ƣ�ճ������ʵ�ֲ��뵽��굱ǰλ��/n��������ʾ����");
         JScrollPane scroller = new JScrollPane(helpText);
         JOptionPane.showMessageDialog(null,scroller);
        }
       }
      );
      bar.add( helpMenu ); //���
     
      // set up label to display text
      displayText = new JTextArea();
      displayText.setForeground( colorvalues[ 0 ] );
      displayText.setFont( new Font( "Serif", Font.PLAIN, 24 ) );//����Ĭ������
      scroll = new JScrollPane( displayText,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
           JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

      container.add( scroll, BorderLayout.CENTER );
      displayText.addKeyListener(  //ͨ����displayTextע������¼�����õ�ǰ�ı��� ����
       new KeyListener(){
        public void keyPressed( KeyEvent event ){
         rowNumber = displayText.getLineCount();//����ı����ĺ���
         setTitle("�ܹ�" + rowNumber +  "��");//���ñ���
        }
        
        public void keyReleased( KeyEvent event ){//��
        }
        public void keyTyped( KeyEvent event ){//��
        }
       }
      );
      


      setSize( 700, 500 );
      setVisible( true );

   } // end constructor


   public static void main( String args[] )
   {
      Notepad application = new Notepad();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   // inner class to handle action events from menu items
   private class ItemHandler implements ActionListener {

      // process color and font selections
      public void actionPerformed( ActionEvent event )
      {
         // process color selection
         for ( int count = 0; count < colorItems.length; count++ )
  
            if ( colorItems[ count ].isSelected() ) {
               displayText.setForeground( colorvalues[ count ] );
               break;
            }
 
         // process font selection
         for ( int count = 0; count < fonts.length; count++ )

            if ( event.getSource() == fonts[ count ] ) {
               displayText.setFont( 
                  new Font( fonts[ count ].getText(), style, 72 ) );
               break;
            }

         repaint();  

      } // end method actionPerformed

   } // end class ItemHandler

   // inner class to handle item events from check box menu items
   private class StyleHandler implements ItemListener {

      // process font style selections
      public void itemStateChanged( ItemEvent e )
      {
         style = 0;

         // check for bold selection
         if ( styleItems[ 0 ].isSelected() )
            style += Font.BOLD;

         // check for italic selection
         if ( styleItems[ 1 ].isSelected() )
            style += Font.ITALIC;

         displayText.setFont( 
            new Font( displayText.getFont().getName(), style, 72 ) );

         repaint();
      }

   } // end class StyleHandler
   


} // end class Notepad