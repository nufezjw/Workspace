import javax.swing.*;  
import java.awt.*;  
import java.io.*;  
import java.awt.event.*;  
  
public class TxtEditor extends JFrame implements ActionListener{  
  
    String file_name;  
    String file_dir;  
    String tempString;  
    //�ϴα������ļ����͵�ַ  
    String fileName = "";  
     JPanel x=new JPanel();  
     JTextArea wen=new JTextArea(20,50);  
       
       JMenuItem ziti=new  JMenuItem("����");  
       JMenuItem a=new JMenuItem("��ͨ");  
         //����˵���  
       JMenuItem xin=new  JMenuItem("�½�");  
       JMenuItem open=new JMenuItem("��");  
       JMenuItem save=new JMenuItem("���� ");  
       JMenuItem lsave=new  JMenuItem("���Ϊ");  
       JMenuItem tui=new  JMenuItem("�˳�");  
         
       JMenuItem cut=new JMenuItem("���� ");  
       JMenuItem copy=new JMenuItem("����");  
       JMenuItem cast=new  JMenuItem("ճ��");  
       JMenuItem delete=new  JMenuItem("ɾ�� ");  
        
       JMenuItem b=new JMenuItem("����");  
       JMenuItem c=new JMenuItem("б��");  
    TxtEditor(){  
     super ("�ı��༭��       By  ǿ�� V1.0");  
    //СС�Ի���  
       setBounds(250,100,700,450);  
      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
      addWindowListener(new WindowAdapter(){  
       public void windowClosing(WindowEvent e) {  
       int   option=   JOptionPane.showConfirmDialog(   
       TxtEditor.this, "��������˳���... ", "ϵͳ����Ի� ",JOptionPane.YES_NO_OPTION);   
                
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
      //�ȼ�����  
     xin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));  
     open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));  
     save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));  
     cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));  
     copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));  
     cast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));  
   
    //�������  
       // x.add(  
            add(new  JScrollPane (wen));//);//������  
         wen.setFont(new Font("����" , Font.PLAIN ,20));  
        // wen.setBackground(Color.blue);  
         // add(x);  
           
          //�˵����Ĵ���  
           JMenuBar cai=new JMenuBar();  
           this.setJMenuBar(cai);  
           cai.setOpaque(true);  
           JMenu jian=new JMenu("�ļ�");  
           jian.add(xin);  
           jian.add(open);  
           jian.add(save);  
           jian.add(lsave);  
           jian.addSeparator( );  
           jian.add(tui);  
          cai.add(jian);  
            
          JMenu bian= new JMenu("�༭  ");  
          bian.add(cut);  
          bian.add(copy);  
          bian.add(cast);  
          bian.add(delete);  
           cai.add(bian);  
             
            
          JMenu geshi = new JMenu ("��ʽ");  
          JMenu optionsMenu=new JMenu("����");  
          geshi.add(optionsMenu);  
          optionsMenu.add(a);  
          optionsMenu.add(b);  
          optionsMenu.add(c);  
          cai.add(geshi);  
             
             
         //���Ӽ�����  
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
          
        // �ı�������  
         //this.setResizable(false);  
    }   
      
      
    //��д����  
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
          else if("�˳�".equals(actionCommand))  
             System.exit(0);      
              
        }  
          
    }  
        // ��������  
        public void newfile(){  
               
            savefile();  
            wen.setText(null);  
            fileName = "";  
                   
        }  
        //��  
         public void openfile(){  
             String fileName = null;   
             FileDialog df = new FileDialog(this,"���ļ�",FileDialog.LOAD);   
             df.setVisible(true);  
             //�������ļ�  
              File f = new File( df.getDirectory()+df.getFile() );  
              //�õ��ļ���  
              fileName = df.getDirectory()+df.getFile();  
             //�ô��ļ��ĳ��Ƚ���һ���ַ�����  ���ر��ע��  
               char ch[] = new char [(int)f.length()];  
                   //�쳣����  
                     try  
                     {  
                      //�������ݣ��������ַ�����ch��  
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
           
                  //����  
                public void savefile(){  
                    if( fileName.equals("") ){  
                     FileDialog df = new FileDialog(this,"�����ļ�",FileDialog.SAVE);   
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
                  //����ļ��Ѿ������  
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
          
         //���Ϊ  
        public void lsavefile(){  
            FileDialog df = new FileDialog(this,"���Ϊ",FileDialog.SAVE);  
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
          
          //����  
           public void cutfile(){  
              
                     tempString = wen.getSelectedText();   
                     StringBuffer tmp = new StringBuffer ( wen.getText());  
                     int start = wen.getSelectionStart();  
                     int len = wen.getSelectedText().length();   
                     tmp.delete( start , start+len);   
                     wen.setText(tmp.toString());      
            }  
       //����  
       public void copyfile(){  
           tempString = wen.getSelectedText();   
       }  
         
      //ճ��  
       public void castfile(){  
           StringBuffer tmp = new StringBuffer ( wen.getText());  
             //�õ�Ҫճ����λ��  
             int start = wen.getSelectionStart();   
             tmp.insert(start , tempString);  
            //�����ı�����ԭ�ı�   
             wen.setText(tmp.toString());  
            }  
         
       //ɾ��  
       public void deletefile(){  
           StringBuffer tmp = new StringBuffer ( wen.getText());  
           int start = wen.getSelectionStart();   
           int len = wen.getSelectedText().length();   
            tmp.delete( start , start+len);   
            wen.setText(tmp.toString());  
       }  
    //����  
       public void afile(){   
           wen.setFont(new Font("����", Font.PLAIN ,wen.getFont().getSize()) );//��ͨ����  
       }  
         
       public void bfile(){   
           wen.setFont(new Font("����" , Font.BOLD ,wen.getFont().getSize()) );//��������  
             
                  }  
       public void cfile(){  
           wen.setFont(new Font("����" , Font.ITALIC ,wen.getFont().getSize()) );//б������  
       }  
      
    public static void main(String[] args) {  
        TxtEditor w=new TxtEditor();  
        w.pack();  
        w.setVisible(true);  
          
  
    }  }