package pockergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class pockerList {
public List<pocker> pockerlist;
List<pocker> mixpocker=new ArrayList<pocker>();
public pockerList() {
	this.pockerlist=new ArrayList<pocker>();	
}

/**��ʼ��ʼ���˿���*/
public void newPocker() {
	pocker[] pockers= {new pocker("����","2"),new pocker("����","3"),new pocker("����","4"),new pocker("����","5"),new pocker("����","6"),new pocker("����","7"),new pocker("����","8"),new pocker("����","9"),new pocker("����","10"),new pocker("����","J"),new pocker("����","Q"),new pocker("����","K"),new pocker("����","A"),new pocker("����","2"),new pocker("����","3"),new pocker("����","4"),new pocker("����","5"),new pocker("����","6"),new pocker("����","7"),new pocker("����","8"),new pocker("����","9"),new pocker("����","10"),new pocker("����","J"),new pocker("����","Q"),new pocker("����","K"),new pocker("����","A"),new pocker("÷��","2"),new pocker("÷��","3"),new pocker("÷��","4"),new pocker("÷��","5"),new pocker("÷��","6"),new pocker("÷��","7"),new pocker("÷��","8"),new pocker("÷��","9"),new pocker("÷��","10"),new pocker("÷��","J"),new pocker("÷��","Q"),new pocker("÷��","K"),new pocker("÷��","A"),new pocker("����","2"),new pocker("����","3"),new pocker("����","4"),new pocker("����","5"),new pocker("����","6"),new pocker("����","7"),new pocker("����","8"),new pocker("����","9"),new pocker("����","10"),new pocker("����","J"),new pocker("����","Q"),new pocker("����","K"),new pocker("����","A")};
    pockerlist.addAll(Arrays.asList(pockers));
System.out.println("------------�����˿���-----------");
System.out.println("�´������˿���Ϊ��");
    for(pocker a: pockerlist) {
    	System.out.print(a.getPockerflower()+a.getPockerpoint()+";");
    }
System.out.println("");   
}


//
//public void mixPocker() {
//	Set<pocker> pockerSet;
//	pockerSet=new HashSet<pocker>();
//	System.out.println("----------------��ʼϴ��----------------");
//	pocker[] pockers= {new pocker("����","2"),new pocker("����","3"),new pocker("����","4"),new pocker("����","5"),new pocker("����","6"),new pocker("����","7"),new pocker("����","8"),new pocker("����","9"),new pocker("����","10"),new pocker("����","J"),new pocker("����","Q"),new pocker("����","K"),new pocker("����","A"),new pocker("����","2"),new pocker("����","3"),new pocker("����","4"),new pocker("����","5"),new pocker("����","6"),new pocker("����","7"),new pocker("����","8"),new pocker("����","9"),new pocker("����","10"),new pocker("����","J"),new pocker("����","Q"),new pocker("����","K"),new pocker("����","A"),new pocker("÷��","2"),new pocker("÷��","3"),new pocker("÷��","4"),new pocker("÷��","5"),new pocker("÷��","6"),new pocker("÷��","7"),new pocker("÷��","8"),new pocker("÷��","9"),new pocker("÷��","10"),new pocker("÷��","J"),new pocker("÷��","Q"),new pocker("÷��","K"),new pocker("÷��","A"),new pocker("����","2"),new pocker("����","3"),new pocker("����","4"),new pocker("����","5"),new pocker("����","6"),new pocker("����","7"),new pocker("����","8"),new pocker("����","9"),new pocker("����","10"),new pocker("����","J"),new pocker("����","Q"),new pocker("����","K"),new pocker("����","A")};
//    pockerSet.addAll(Arrays.asList(pockers));
//    System.out.println("----------------ϴ�ƽ�����---------------");
//	
//	}

public void mixPocker() {
	
    Random random=new Random();
    System.out.println("----------------��ʼϴ��----------------");
    for(int i=0;i<52;i++) {  //ע����û���ظ�����
    	int index=random.nextInt(51);
    	pocker randomPocker=pockerlist.get(index);
    	mixpocker.add(randomPocker);	
    }
	
    System.out.println("----------------ϴ�ƽ�����---------------");
}

/*
 * ����������,����ID����������Ϣ
 * */
public void addplayer() {
	List<player> Player=new ArrayList<player>();
	System.out.println("-----------------�������--------------");
	System.out.println("�������1λ��ҵ�id������:");
	Scanner console=new Scanner(System.in);
	System.out.println("������id:");
	String id1=console.next();
	System.out.println("����������:");
	String name1=console.next(); 
	System.out.println("�������2λ��ҵ�id������:");
	System.out.println("������id:");
	String id2=console.next();
	System.out.println("����������:");
	String name2=console.next(); 
	

	player play1 = new player(id1,name1);//����������Ҷ���
	player play2 = new player(id2,name2);
	Player.add(play1);
	Player.add(play2);
	System.out.println("-----��ӭ��ң�"+play1.getName());
    System.out.println("-----��ӭ��ң�"+play2.getName());

    /*��ʼ���Ʋ���*/    
    List<pocker> allopocker1=new ArrayList<pocker>();
    List<pocker> allopocker2=new ArrayList<pocker>();
    List<pocker> allopocker3=new ArrayList<pocker>();
    System.out.println("-------------��ʼ����-----------");
    System.out.println("---��ң�"+play1.getName()+"-����");
    pocker pocker1=mixpocker.get(0);
    allopocker1.add(pocker1);
    
    System.out.println("---��ң�"+play2.getName()+"-����");
    pocker pocker2=mixpocker.get(1);
    allopocker2.add(pocker2);
    
    System.out.println("---��ң�"+play1.getName()+"-����");
    pocker pocker3=mixpocker.get(2);
    allopocker1.add(pocker3);
    
    System.out.println("---��ң�"+play2.getName()+"-����");
    pocker pocker4=mixpocker.get(3);
    allopocker2.add(pocker4);
    System.out.println("-----------���ƽ�����----------");
    
    
    
    /**
     * ����������ҵ����Ʒֱ�����������������ƣ����бȽ�
     */
    System.out.println("-----------��ʼ��Ϸ------------");
    Collections.sort(allopocker1,new pockerComparator());
    System.out.println("��ң�"+play1.getName()+"��������Ϊ��"+allopocker1.get(1).toString());
    Collections.sort(allopocker2,new pockerComparator());
    System.out.println("��ң�"+play2.getName()+"��������Ϊ��"+allopocker2.get(1).toString());
    allopocker3.add(allopocker1.get(1));
    allopocker3.add(allopocker2.get(1));
    Collections.sort(allopocker3,new pockerComparator());
    pocker max=allopocker3.get(1);
    if (allopocker1.contains(max))
       System.out.println("---------��ң�"+play1.getName()+"��ʤ��--------");
    else
       System.out.println("---------��ң�"+play2.getName()+"��ʤ��--------");
    System.out.println("��Ҹ��Ե�����Ϊ��");
    System.out.println(play1.getName()+": "+allopocker1.get(0)+","+allopocker1.get(1));
    System.out.println(play2.getName()+": "+allopocker2.get(0)+","+allopocker2.get(1));
    
}

    





/**
 * mian ����*/

public static void main(String[] args) {
	pockerList p1=new pockerList();
	p1.newPocker();
	p1.mixPocker();
	p1.addplayer();
	
}

}
