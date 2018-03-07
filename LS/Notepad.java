import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Notepad extends JFrame{
   private final Color colorvalues[] = 
      { Color.black, Color.blue, Color.red, Color.green };   //定义颜色数组
   String styleNames[] = { "Bold", "Italic" };//定义风格数组
   String fontNames[] = { "宋体", "华文行楷", "隶书" };//字体数组
   String[] sizeString = new String[30];//字号数组
   int[] size = new int[30];//与字号数组对应的字号整数，用于设置文字大小
   private JRadioButtonMenuItem colorItems[], fonts[];
   private JCheckBoxMenuItem styleItems[];
   private JTextArea displayText;//定义文本编辑区
   private ButtonGroup fontGroup, colorGroup;//字体组，跟字色组
   private int style;//字体风格
   private JScrollPane scroll;//为文本编辑区提供滚动条
   private String selectText = "";//存放文本编辑区中选中的文本内容
   private JComboBox styleBox,fontBox,sizeBox;//工具栏
   private JPanel toolPanel;//存放工具栏
   private int rowNumber = 0;

   // set up GUI
   public Notepad()
   {
      super( "记事本" );//标题  
      
      //初始化字体大小数组
      for(int i = 0 ; i<size.length;i++){
       sizeString[i] = "" + (i+5) * 2;
       size[i] = (i+5)*2;
      }
      
      Container container = getContentPane();
      container.setLayout(new BorderLayout() );
      
   //统计行数

           
      toolPanel = new JPanel();
      
      JLabel label1 = new JLabel("字体名称");
      toolPanel.add(label1);
      fontBox = new JComboBox(fontNames);
      fontBox.addItemListener(  //事件处理	
       new ItemListener(){

        public void itemStateChanged(ItemEvent event){
         if( event.getStateChange() == ItemEvent.SELECTED){
          displayText.setFont( new Font( fontNames[fontBox.getSelectedIndex()],
               displayText.getFont().getStyle(), displayText.getFont().getSize() ) );

       
         }
        }
       }
      );
      toolPanel.add(fontBox);//添加
      
      JLabel label2 = new JLabel("字体风格");
      toolPanel.add(label2);
      String style_name[] = {"常规","倾斜","粗体","倾斜加粗体"};//字体风格
      styleBox = new JComboBox(style_name);
      styleBox.addItemListener(   //事件处理
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

      JLabel label3 = new JLabel("字号");
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
      JMenu fileMenu = new JMenu( "文件(F)" );
      fileMenu.setMnemonic( 'F' );

      // set up About... menu item
      JMenuItem aboutItem = new JMenuItem( "关于(A)..." );
      aboutItem.setMnemonic( 'A' );
      fileMenu.add( aboutItem );
      aboutItem.addActionListener(

         new ActionListener() {  // anonymous inner class

            // display message dialog when user selects About...
            public void actionPerformed( ActionEvent event )
            {
               JOptionPane.showMessageDialog( Notepad.this,
                  "模拟记事本程序/ncopyright@2005_Qdieyou——魏逢一",
                  "关于", JOptionPane.PLAIN_MESSAGE );
               rowNumber = displayText.getRows();
               JOptionPane.showMessageDialog(null,""+ rowNumber);
            }

         }  // end anonymous inner class

      ); // end call to addActionListener
 
      // set up Exit menu item退出菜单
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
      
      JMenu editMenu = new JMenu( "编辑(E)" );
      editMenu.setMnemonic( 'E' );
      
      //复制菜单选项
      JMenuItem copyItem = new JMenuItem( "复制(C)" );
      copyItem.setMnemonic( 'C' );
      editMenu.add( copyItem );
      copyItem.addActionListener(
       new ActionListener(){
        public void actionPerformed( ActionEvent event ){
         selectText = displayText.getSelectedText();//获得选中的内容，并保存在selectText里
        }
       }
      );
      
      //粘贴的实现
      JMenuItem pasteItem = new JMenuItem( "粘贴(P)" );
      pasteItem.setMnemonic( 'P' );
      editMenu.add( pasteItem );
      pasteItem.addActionListener(
       new ActionListener(){
        public void actionPerformed( ActionEvent event ){
         int position = displayText.getCaretPosition();//获得鼠标当前位置
         displayText.insert( selectText,position );//插入到鼠标当前位置
        }
       }
      );
      
      JMenuItem swapItem = new JMenuItem( "替换(R)..." );
      swapItem.setMnemonic( 'R' );
      editMenu.add( swapItem );
      swapItem.addActionListener(
       new ActionListener(){
        public void actionPerformed( ActionEvent event ){
         JPanel swapPanel = new JPanel();
         JLabel lookupLabel = new JLabel("要替换的内容");
         JTextField inputText = new JTextField(10);
         JLabel swapLabel = new JLabel("替换为：");
         JTextField changetoText = new JTextField(10);
         swapPanel.add( lookupLabel );
         swapPanel.add( inputText );
         swapPanel.add( swapLabel );
         swapPanel.add( changetoText );
         JOptionPane.showMessageDialog(null,swapPanel);
         String text = displayText.getText();//获得整个文本内容
         String changeText = text.replace(inputText.getText(),changetoText.getText());//获得替换后的内容
         displayText.setText(changeText);
         
        }
       }
      );
      
      bar.add( editMenu );//add editMenu
      

      // create Format menu, its submenus and menu items
      JMenu formatMenu = new JMenu( "格式(R)" );  
      formatMenu.setMnemonic( 'R' );
   
   //自动换行的功能切换
      JMenuItem changeItem = new JMenuItem( "自动换行(W)" );
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

      JMenu helpMenu = new JMenu( "帮助(H)" );  
      helpMenu.setMnemonic( 'H' );
   
   //帮助菜单项
      JMenuItem helpItem = new JMenuItem( "帮助主题(H)..." );
      helpItem.setMnemonic( 'H' );
      helpMenu.add( helpItem );
      helpItem.addActionListener(
       new ActionListener(){
        public void actionPerformed( ActionEvent event ){
         JTextArea helpText = new JTextArea(
           "格式里的自动换行说明：单击一次切换功能/n只能实现整个文本的风格，字体等的设置/n"+
           "复制，粘贴可以实现插入到鼠标当前位置/n标题栏显示行数");
         JScrollPane scroller = new JScrollPane(helpText);
         JOptionPane.showMessageDialog(null,scroller);
        }
       }
      );
      bar.add( helpMenu ); //添加
     
      // set up label to display text
      displayText = new JTextArea();
      displayText.setForeground( colorvalues[ 0 ] );
      displayText.setFont( new Font( "Serif", Font.PLAIN, 24 ) );//设置默认字体
      scroll = new JScrollPane( displayText,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
           JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

      container.add( scroll, BorderLayout.CENTER );
      displayText.addKeyListener(  //通过对displayText注册键盘事件来获得当前文本的 行数
       new KeyListener(){
        public void keyPressed( KeyEvent event ){
         rowNumber = displayText.getLineCount();//获得文本区的函数
         setTitle("总共" + rowNumber +  "行");//设置标题
        }
        
        public void keyReleased( KeyEvent event ){//空
        }
        public void keyTyped( KeyEvent event ){//空
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