class MyThread implements Runnable{
    private int ticket = 5 ;    // ����һ����5��Ʊ
    public void run(){
    	for(int i=0;i<100;i++) {
    		this.sale();
    	}
    }
    public synchronized void sale() {     
                if(ticket>0){   // ����Ʊ
                    try{
                        Thread.sleep(300) ; // �����ӳ�
                    }catch(InterruptedException e){
                        e.printStackTrace() ;
                    }
                    System.out.println("��Ʊ��ticket = " + ticket-- );
                }
            }

 //   }

    public static void main(String args[]){
        MyThread mt = new MyThread() ;  // �����̶߳���
        Thread t1 = new Thread(mt) ;    // ����Thread����
        Thread t2 = new Thread(mt) ;    // ����Thread����
        Thread t3 = new Thread(mt) ;    // ����Thread����
        t1.start() ;
        t2.start() ;
        t3.start() ;
    }
};