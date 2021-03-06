import javax.swing.*;  
import java.awt.*;  
import java.io.*;  
import java.awt.event.*;  
  
public class TxtEditor extends JFrame implements ActionListener{  
  
    String file_name;  
    String file_dir;  
    String tempString;  
    //上次保存后的文件名和地址  
    String fileName = "";  
     JPanel x=new JPanel();  
     JTextArea wen=new JTextArea(20,50);  
       
       JMenuItem ziti=new  JMenuItem("字体");  
       JMenuItem a=new JMenuItem("普通");  
         //定义菜单项  
       JMenuItem xin=new  JMenuItem("新建");  
       JMenuItem open=new JMenuItem("打开");  
       JMenuItem save=new JMenuItem("保存 ");  
       JMenuItem lsave=new  JMenuItem("另存为");  
       JMenuItem tui=new  JMenuItem("退出");  
         
       JMenuItem cut=new JMenuItem("剪切 ");  
       JMenuItem copy=new JMenuItem("复制");  
       JMenuItem cast=new  JMenuItem("粘贴");  
       JMenuItem delete=new  JMenuItem("删除 ");  
        
       JMenuItem b=new JMenuItem("粗体");  
       JMenuItem c=new JMenuItem("斜体");  
    TxtEditor(){  
     super ("文本编辑器       By  强凯 V1.0");  
    //小小对话框  
       setBounds(250,100,700,450);  
      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
      addWindowListener(new WindowAdapter(){  
       public void windowClosing(WindowEvent e) {  
       int   option=   JOptionPane.showConfirmDialog(   
       TxtEditor.this, "你真的想退出吗... ", "系统和你对话 ",JOptionPane.YES_NO_OPTION);   
                
              if(option==JOptionPane.YES_OPTION)   
                  if(e.getWindow()   ==   TxtEditor.this)   
                  {   
                         System.exit(0);   
                         }   
                         else   
                         {   
                         return;   
                           
                         }   
   }      
   });  
      //热键设置  
     xin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));  
     open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));  
     save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));  
     cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));  
     copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));  
     cast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));  
   
    //定义面板  
       // x.add(  
            add(new  JScrollPane (wen));//);//滚动条  
         wen.setFont(new Font("楷体" , Font.PLAIN ,20));  
        // wen.setBackground(Color.blue);  
         // add(x);  
           
          //菜单栏的创建  
           JMenuBar cai=new JMenuBar();  
           this.setJMenuBar(cai);  
           cai.setOpaque(true);  
           JMenu jian=new JMenu("文件");  
           jian.add(xin);  
           jian.add(open);  
           jian.add(save);  
           jian.add(lsave);  
           jian.addSeparator( );  
           jian.add(tui);  
          cai.add(jian);  
            
          JMenu bian= new JMenu("编辑  ");  
          bian.add(cut);  
          bian.add(copy);  
          bian.add(cast);  
          bian.add(delete);  
           cai.add(bian);  
             
            
          JMenu geshi = new JMenu ("格式");  
          JMenu optionsMenu=new JMenu("字体");  
          geshi.add(optionsMenu);  
          optionsMenu.add(a);  
          optionsMenu.add(b);  
          optionsMenu.add(c);  
          cai.add(geshi);  
             
             
         //增加监听器  
         xin.addActionListener(this);  
         open.addActionListener(this);  
         save.addActionListener(this);  
         lsave.addActionListener(this);  
         tui.addActionListener(this);  
         cut.addActionListener(this);  
         copy.addActionListener(this);  
         cast.addActionListener(this);  
         delete.addActionListener(this);  
         ziti.addActionListener(this);  
         a.addActionListener(this);  
         b.addActionListener(this);  
         c.addActionListener(this);  
          
        // 文本框锁定  
         //this.setResizable(false);  
    }   
      
      
    //重写方法  
    public void actionPerformed(ActionEvent e){  
          
        String actionCommand=e.getActionCommand();  
        if(e.getSource()instanceof JMenu);  
        {  
          if(e.getSource()==xin){  
            newfile();    
          }  
             
          else if(e.getSource()==open){      
            openfile();  
            }  
         else if(e.getSource()==save){  
          savefile();  
           }  
          else if(e.getSource()==lsave){  
            lsavefile();  
           }  
          else if(e.getSource()==cut){  
            cutfile();  
            }  
          else if(e.getSource()==copy){  
             copyfile();  
            }  
          else if(e.getSource()==cast){  
              castfile();  
          }  
          else if(e.getSource()==delete){  
              deletefile();  
          }  
          else if(e.getSource()==a){  
              afile();  
             }  
          else if(e.getSource()==b){  
              bfile();  
          }  
          else if(e.getSource()==c){  
              cfile();  
          }  
          else if("退出".equals(actionCommand))  
             System.exit(0);      
              
        }  
          
    }  
        // 方法定义  
        public void newfile(){  
               
            savefile();  
            wen.setText(null);  
            fileName = "";  
                   
        }  
        //打开  
         public void openfile(){  
             String fileName = null;   
             FileDialog df = new FileDialog(this,"打开文件",FileDialog.LOAD);   
             df.setVisible(true);  
             //建立新文件  
              File f = new File( df.getDirectory()+df.getFile() );  
              //得到文件名  
              fileName = df.getDirectory()+df.getFile();  
             //用此文件的长度建立一个字符数组  （特别标注）  
               char ch[] = new char [(int)f.length()];  
                   //异常处理  
                     try  
                     {  
                      //读出数据，并存入字符数组ch中  
                      BufferedReader bw = new BufferedReader( new FileReader(f) );       
                      bw.read(ch);       
                            bw.close();  
                     }  
                     catch( FileNotFoundException fe ){  
                      System.out.println("file not found");  
                      System.exit(0);  
                     }  
                     catch( IOException ie){  
                      System.out.println("IO error");  
                      System.exit(0);  
                     }  
                      
                     String s =new String (ch);  
                     wen.setText(s);  
                     }  
           
                  //保存  
                public void savefile(){  
                    if( fileName.equals("") ){  
                     FileDialog df = new FileDialog(this,"保存文件",FileDialog.SAVE);   
                     df.addWindowListener( new WindowAdapter(){   
                 public void windowClosing(WindowEvent ee){  
                   System.exit(0);  
                  }  
                 });  
                 df.setVisible(true);  
                 String s = wen.getText();  
                  
                 try  
                 {  
                  File f = new File( df.getDirectory()+df.getFile());  
                  fileName = df.getDirectory()+df.getFile();  
                  BufferedWriter bw = new BufferedWriter( new FileWriter (f));  
                  bw.write(s , 0 , s.length());  
                  bw.close();  
                 }  
                 catch(FileNotFoundException fe_){  
                  System.out.println("file not found");  
                  System.exit(0);  
                 }  
                 catch( IOException ie_)  
                 {  
                  System.out.println(" IO error");  
                  System.exit(0);  
                 }    
                  }  
                  //如果文件已经保存过  
                 else   
                 {  
                  String s = wen.getText();  
                   
                 try  
                 {  
                  File f = new File( fileName );  
                   
                  BufferedWriter bw = new BufferedWriter( new FileWriter (f));  
                  bw.write(s , 0 , s.length());  
                  bw.close();  
                   
                 }  
                 catch(FileNotFoundException fe_){  
                  System.out.println("file not found");  
                  System.exit(0);  
                 }  
                 catch( IOException ie_)  
                 {  
                  System.out.println(" IO error");  
                  System.exit(0);  
                 }  
                   
                 }     
                       
                }  
          
         //另存为  
        public void lsavefile(){  
            FileDialog df = new FileDialog(this,"另存为",FileDialog.SAVE);  
            df.addWindowListener( new WindowAdapter(){  
                  public void windowClosing(WindowEvent ee){  
                   System.exit(0);  
                  }  
                 });  
                 df.setVisible(true);  
                 String s = wen.getText();  
                 try  
                 {  
                  File f = new File( df.getDirectory()+df.getFile());  
                  BufferedWriter bw = new BufferedWriter( new FileWriter (f));  
                  bw.write(s , 0 , s.length());  
                  bw.close();  
                 }  
                 catch(FileNotFoundException fe_){  
                  System.out.println("file not found");  
                  System.exit(0);  
                 }  
                 catch( IOException ie_)  
                 {  
                  System.out.println(" IO error");  
                  System.exit(0);  
                 }       
                }  
          
          //剪切  
           public void cutfile(){  
              
                     tempString = wen.getSelectedText();   
                     StringBuffer tmp = new StringBuffer ( wen.getText());  
                     int start = wen.getSelectionStart();  
                     int len = wen.getSelectedText().length();   
                     tmp.delete( start , start+len);   
                     wen.setText(tmp.toString());      
            }  
       //复制  
       public void copyfile(){  
           tempString = wen.getSelectedText();   
       }  
         
      //粘贴  
       public void castfile(){  
           StringBuffer tmp = new StringBuffer ( wen.getText());  
             //得到要粘贴的位置  
             int start = wen.getSelectionStart();   
             tmp.insert(start , tempString);  
            //用新文本设置原文本   
             wen.setText(tmp.toString());  
            }  
         
       //删除  
       public void deletefile(){  
           StringBuffer tmp = new StringBuffer ( wen.getText());  
           int start = wen.getSelectionStart();   
           int len = wen.getSelectedText().length();   
            tmp.delete( start , start+len);   
            wen.setText(tmp.toString());  
       }  
    //字体  
       public void afile(){   
           wen.setFont(new Font("楷体", Font.PLAIN ,wen.getFont().getSize()) );//普通文字  
       }  
         
       public void bfile(){   
           wen.setFont(new Font("楷体" , Font.BOLD ,wen.getFont().getSize()) );//粗体文字  
             
                  }  
       public void cfile(){  
           wen.setFont(new Font("楷体" , Font.ITALIC ,wen.getFont().getSize()) );//斜体文字  
       }  
      
    public static void main(String[] args) {  
        TxtEditor w=new TxtEditor();  
        w.pack();  
        w.setVisible(true);  
          
  
    }  }