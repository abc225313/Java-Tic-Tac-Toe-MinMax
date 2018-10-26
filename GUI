# Tic-Tac-Toe

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//資管二乙 陳冠霖

public class AI {
	private String change="";
	private JFrame jframe;
	private Think think;
	static int count=0;
	protected int []cheeseborad=new int[9];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AI window = new AI();
					window.jframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		jframe = new JFrame();
		jframe.setSize(450, 450);
		jframe.getContentPane().setLayout(new GridLayout(3,3));
		final Button button[] = new Button[9];
		for (int  i= 0;i< button.length;i++) {  
			button[i] = new Button();
			jframe.getContentPane().add(button[i]);
			button[i].addActionListener(
	                    new ActionListener() {
	                        public void actionPerformed(ActionEvent e) {
	                        	think=new Think();//創電腦的物件
	                            for (int j = 0; j <button.length; j++){
	                            	if (e.getSource() == button[j]) {//玩家出手
	                                    if(cheeseborad[j]==0)
	                                    {	
	                                    	cheeseborad[j]=1;
	                                    	///<<跑出cheeseborad
	                                    	if(WinOrLose()){ break;}
	                                    	cheeseborad=think.choice(cheeseborad);//電腦出手
		                                    for(int i=0;i<9;i++)
		                                    {
		                                    	if(i==2||i==5){
		                                    		change="\n\n\n";
		                                    	}
		                                    	else if (i==8) {
		                                    		change="\n\n\n\n\n";
												}
		                                    	else{
		                                    		change="		";
		                                    	}
		                                    	if(cheeseborad[i]==2){
		                                    		button[i].setLabel("X");
		                                    	}
		                                    	else if (cheeseborad[i]==1) {
													button[i].setLabel("O");
												}
		                                    	
		                                    	System.out.print(cheeseborad[i]+change);//顯示棋盤狀況
		                                    	count++;
		                                    }
		                                    if(WinOrLose()){ break;}
		                                    if(count>=45){
	                                    		System.out.print("平手\n");
	                                    		break;
	                                    	}	
		                                   										        
		                                    
	                                    }
	                                    else {
											System.out.print("This is not empty\n");
										}
	                                    
	                                    	
	                                    
	                                }
	                            }
	                        }
	                    });

		}
		
	}
	public boolean WinOrLose(){//<<判斷是否獲勝
		
		int f=0,f1=1,f2=2;
		int s=0,s1=3,s2=6;
		for(int i=0;i<3;i++){
			if(cheeseborad[f]==cheeseborad[f1]&&cheeseborad[f]==cheeseborad[f2]){
				if(cheeseborad[f]==1){
					System.out.print("PLAYER WIN!!!\n");
					return true;
				}
				else if(cheeseborad[f]==2){
					System.out.print("AI WIN!!!\n");
					return true;
				}
				
			}
			else if(cheeseborad[s]==cheeseborad[s1]&&cheeseborad[s]==cheeseborad[s2]){
				if(cheeseborad[s]==1){
					System.out.print("PLAYER WIN!!!\n");
					return true;

				}
				else if(cheeseborad[s]==2){
					System.out.print("AI WIN!!!\n");
					return true;
					
				}
				
			}
			f=f2+1;f1=f+1;f2=f1+1;
			s++;s1++;s2++;
		}
		
		
		if(cheeseborad[0]==cheeseborad[4]&&cheeseborad[0]==cheeseborad[8]){
			if(cheeseborad[0]==1){
				System.out.print("PLAYER WIN!!!\n");
				return true;
			}
			else if(cheeseborad[0]==2){
				System.out.print("AI WIN!!!\n");
				return true;
			}
			
		}
		else if(cheeseborad[2]==cheeseborad[4]&&cheeseborad[2]==cheeseborad[6]){
			if(cheeseborad[2]==1){
				System.out.print("PLAYER WIN!!!\n");
				return true;
			}
			else if(cheeseborad[2]==2){
				System.out.print("AI WIN!!!\n");
				return true;
			}
			
		}
		
		return false;
	}
	

}

