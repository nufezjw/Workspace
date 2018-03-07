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

/**开始初始化扑克牌*/
public void newPocker() {
	pocker[] pockers= {new pocker("黑桃","2"),new pocker("黑桃","3"),new pocker("黑桃","4"),new pocker("黑桃","5"),new pocker("黑桃","6"),new pocker("黑桃","7"),new pocker("黑桃","8"),new pocker("黑桃","9"),new pocker("黑桃","10"),new pocker("黑桃","J"),new pocker("黑桃","Q"),new pocker("黑桃","K"),new pocker("黑桃","A"),new pocker("红桃","2"),new pocker("红桃","3"),new pocker("红桃","4"),new pocker("红桃","5"),new pocker("红桃","6"),new pocker("红桃","7"),new pocker("红桃","8"),new pocker("红桃","9"),new pocker("红桃","10"),new pocker("红桃","J"),new pocker("红桃","Q"),new pocker("红桃","K"),new pocker("红桃","A"),new pocker("梅花","2"),new pocker("梅花","3"),new pocker("梅花","4"),new pocker("梅花","5"),new pocker("梅花","6"),new pocker("梅花","7"),new pocker("梅花","8"),new pocker("梅花","9"),new pocker("梅花","10"),new pocker("梅花","J"),new pocker("梅花","Q"),new pocker("梅花","K"),new pocker("梅花","A"),new pocker("方块","2"),new pocker("方块","3"),new pocker("方块","4"),new pocker("方块","5"),new pocker("方块","6"),new pocker("方块","7"),new pocker("方块","8"),new pocker("方块","9"),new pocker("方块","10"),new pocker("方块","J"),new pocker("方块","Q"),new pocker("方块","K"),new pocker("方块","A")};
    pockerlist.addAll(Arrays.asList(pockers));
System.out.println("------------创建扑克牌-----------");
System.out.println("新创建的扑克牌为：");
    for(pocker a: pockerlist) {
    	System.out.print(a.getPockerflower()+a.getPockerpoint()+";");
    }
System.out.println("");   
}


//
//public void mixPocker() {
//	Set<pocker> pockerSet;
//	pockerSet=new HashSet<pocker>();
//	System.out.println("----------------开始洗牌----------------");
//	pocker[] pockers= {new pocker("黑桃","2"),new pocker("黑桃","3"),new pocker("黑桃","4"),new pocker("黑桃","5"),new pocker("黑桃","6"),new pocker("黑桃","7"),new pocker("黑桃","8"),new pocker("黑桃","9"),new pocker("黑桃","10"),new pocker("黑桃","J"),new pocker("黑桃","Q"),new pocker("黑桃","K"),new pocker("黑桃","A"),new pocker("红桃","2"),new pocker("红桃","3"),new pocker("红桃","4"),new pocker("红桃","5"),new pocker("红桃","6"),new pocker("红桃","7"),new pocker("红桃","8"),new pocker("红桃","9"),new pocker("红桃","10"),new pocker("红桃","J"),new pocker("红桃","Q"),new pocker("红桃","K"),new pocker("红桃","A"),new pocker("梅花","2"),new pocker("梅花","3"),new pocker("梅花","4"),new pocker("梅花","5"),new pocker("梅花","6"),new pocker("梅花","7"),new pocker("梅花","8"),new pocker("梅花","9"),new pocker("梅花","10"),new pocker("梅花","J"),new pocker("梅花","Q"),new pocker("梅花","K"),new pocker("梅花","A"),new pocker("方块","2"),new pocker("方块","3"),new pocker("方块","4"),new pocker("方块","5"),new pocker("方块","6"),new pocker("方块","7"),new pocker("方块","8"),new pocker("方块","9"),new pocker("方块","10"),new pocker("方块","J"),new pocker("方块","Q"),new pocker("方块","K"),new pocker("方块","A")};
//    pockerSet.addAll(Arrays.asList(pockers));
//    System.out.println("----------------洗牌结束！---------------");
//	
//	}

public void mixPocker() {
	
    Random random=new Random();
    System.out.println("----------------开始洗牌----------------");
    for(int i=0;i<52;i++) {  //注意牌没有重复的张
    	int index=random.nextInt(51);
    	pocker randomPocker=pockerlist.get(index);
    	mixpocker.add(randomPocker);	
    }
	
    System.out.println("----------------洗牌结束！---------------");
}

/*
 * 添加两个玩家,输入ID和姓名等信息
 * */
public void addplayer() {
	List<player> Player=new ArrayList<player>();
	System.out.println("-----------------创建玩家--------------");
	System.out.println("请输入第1位玩家的id和姓名:");
	Scanner console=new Scanner(System.in);
	System.out.println("请输入id:");
	String id1=console.next();
	System.out.println("请输入姓名:");
	String name1=console.next(); 
	System.out.println("请输入第2位玩家的id和姓名:");
	System.out.println("请输入id:");
	String id2=console.next();
	System.out.println("请输入姓名:");
	String name2=console.next(); 
	

	player play1 = new player(id1,name1);//创建两个玩家对象
	player play2 = new player(id2,name2);
	Player.add(play1);
	Player.add(play2);
	System.out.println("-----欢迎玩家："+play1.getName());
    System.out.println("-----欢迎玩家："+play2.getName());

    /*开始发牌操作*/    
    List<pocker> allopocker1=new ArrayList<pocker>();
    List<pocker> allopocker2=new ArrayList<pocker>();
    List<pocker> allopocker3=new ArrayList<pocker>();
    System.out.println("-------------开始发牌-----------");
    System.out.println("---玩家："+play1.getName()+"-拿牌");
    pocker pocker1=mixpocker.get(0);
    allopocker1.add(pocker1);
    
    System.out.println("---玩家："+play2.getName()+"-拿牌");
    pocker pocker2=mixpocker.get(1);
    allopocker2.add(pocker2);
    
    System.out.println("---玩家："+play1.getName()+"-拿牌");
    pocker pocker3=mixpocker.get(2);
    allopocker1.add(pocker3);
    
    System.out.println("---玩家："+play2.getName()+"-拿牌");
    pocker pocker4=mixpocker.get(3);
    allopocker2.add(pocker4);
    System.out.println("-----------发牌结束！----------");
    
    
    
    /**
     * 对于两个玩家的手牌分别进行排序，输出最大手牌，进行比较
     */
    System.out.println("-----------开始游戏------------");
    Collections.sort(allopocker1,new pockerComparator());
    System.out.println("玩家："+play1.getName()+"最大的手牌为："+allopocker1.get(1).toString());
    Collections.sort(allopocker2,new pockerComparator());
    System.out.println("玩家："+play2.getName()+"最大的手牌为："+allopocker2.get(1).toString());
    allopocker3.add(allopocker1.get(1));
    allopocker3.add(allopocker2.get(1));
    Collections.sort(allopocker3,new pockerComparator());
    pocker max=allopocker3.get(1);
    if (allopocker1.contains(max))
       System.out.println("---------玩家："+play1.getName()+"获胜！--------");
    else
       System.out.println("---------玩家："+play2.getName()+"获胜！--------");
    System.out.println("玩家各自的手牌为：");
    System.out.println(play1.getName()+": "+allopocker1.get(0)+","+allopocker1.get(1));
    System.out.println(play2.getName()+": "+allopocker2.get(0)+","+allopocker2.get(1));
    
}

    





/**
 * mian 方法*/

public static void main(String[] args) {
	pockerList p1=new pockerList();
	p1.newPocker();
	p1.mixPocker();
	p1.addplayer();
	
}

}
