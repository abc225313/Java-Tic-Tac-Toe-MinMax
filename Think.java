import java.util.ArrayList;
import java.util.Random;

public class Think {
	ArrayList<Integer>choice;
	Random random;
	private int none=0;
	static int i=0;static int check=0;
	public int [] choice(int []cheeseborad){
		choice=new ArrayList<Integer>();
		random=new Random();
		if(i==0)//第一輪當玩家下時,能夠選擇的區域
		{
			i++;
		
				if (cheeseborad[4]==1) {
					if(cheeseborad[0]==0){
						choice.add(0);
					}
					if(cheeseborad[2]==0){
						choice.add(2);
					}
					if(cheeseborad[6]==0){
						choice.add(6);
					}
					if(cheeseborad[8]==0){
						choice.add(8);
					}
				}
				else if (cheeseborad[1]==1||cheeseborad[3]==1||cheeseborad[5]==1||cheeseborad[7]==1) {
					if(cheeseborad[1]==1){
						choice.add(6);
						choice.add(8);
					}
					else if(cheeseborad[3]==1){
						choice.add(2);
						choice.add(8);
					}
					else if(cheeseborad[5]==1){
						choice.add(0);
						choice.add(6);
					}
					else if(cheeseborad[7]==1){
						choice.add(0);
						choice.add(2);
					}
					int index = random.nextInt(choice.size());
					cheeseborad[choice.get(index)]=2;
					return cheeseborad;
				}
				
				else if(cheeseborad[4]==0){
					choice.add(4);
				}
			
			int index = random.nextInt(choice.size());
			cheeseborad[choice.get(index)]=2;
			
	   }
		
		else
		{
			cheeseborad=checkCheeseborad(cheeseborad,2);//查看能否贏
		}	
			
		
		return cheeseborad;
	}
	int[] checkCheeseborad(int []cheeseborad,int enemy){//他查看了是否能贏或是必須防守的情況
		int f=0,f1=1,f2=2;
		int s=0,s1=3,s2=6;
		for (int i = 0; i < 3; i++) {
			if(cheeseborad[f]==enemy&&cheeseborad[f2]==enemy||cheeseborad[f1]==enemy&&cheeseborad[f2]==enemy||cheeseborad[f]==enemy&&cheeseborad[f1]==enemy){
				if(cheeseborad[f]==0||cheeseborad[f1]==0||cheeseborad[f2]==0){
					if(cheeseborad[f]==0){
						cheeseborad[f]=2;
						none++;
					}
					else if (cheeseborad[f1]==0&&none==0) {
						cheeseborad[f1]=2;
						none++;
					}
					else if (cheeseborad[f2]==0&&none==0) {
						cheeseborad[f2]=2;
						none++;
					}

				}
				
			}
			if(cheeseborad[s]==enemy&&cheeseborad[s2]==enemy||cheeseborad[s1]==enemy&&cheeseborad[s2]==enemy||cheeseborad[s]==enemy&&cheeseborad[s1]==enemy){
				if(cheeseborad[s]==0||cheeseborad[s1]==0||cheeseborad[s2]==0){
					if(cheeseborad[s]==0&&none==0){
						cheeseborad[s]=2;
						none++;
					}
					else if (cheeseborad[s1]==0&&none==0) {
						none++;
						cheeseborad[s1]=2;
						

					}
					else if (cheeseborad[s2]==0&&none==0) {
						cheeseborad[s2]=2;
						none++;
					}
				}
				
				
			}
			f=f2+1;f1=f+1;f2=f1+1;
			s++;s1++;s2++;
			
		}
		if(cheeseborad[0]==enemy&&cheeseborad[4]==enemy||cheeseborad[0]==enemy&&cheeseborad[8]==enemy||cheeseborad[4]==enemy&&cheeseborad[8]==enemy){
			if(cheeseborad[0]==0||cheeseborad[4]==0||cheeseborad[8]==0){
				if(cheeseborad[0]==0&&none==0){
					cheeseborad[0]=2;
					none++;
				}
				else if (cheeseborad[4]==0&&none==0) {
					cheeseborad[4]=2;
					none++;
				}
				else if (cheeseborad[8]==0&&none==0) {
					cheeseborad[8]=2;
					none++;
				}
			}
			
					
			
		}
		if(cheeseborad[2]==enemy&&cheeseborad[4]==enemy||cheeseborad[2]==enemy&&cheeseborad[6]==enemy||cheeseborad[4]==enemy&&cheeseborad[6]==enemy&&none==0){
			if(cheeseborad[2]==0||cheeseborad[4]==0||cheeseborad[6]==0){
				if(cheeseborad[2]==0&&none==0){
					cheeseborad[2]=2;
					none++;
				}
				else if (cheeseborad[4]==0&&none==0) {
					cheeseborad[4]=2;
					none++;
				}
				else if (cheeseborad[6]==0&&none==0) {
					cheeseborad[6]=2;
					none++;
					
				}
			}
			
		}
		if(none==0&&enemy==2){
			cheeseborad=checkCheeseborad(cheeseborad,1);//如果獲勝不了,改丟其他參數 查看防守與否
		}
		else if(none==0&&enemy==1){
			cheeseborad=MinMax(cheeseborad);//如果無須防守,則選擇MIN MAX
		}
		
		return cheeseborad;
		
	}
	int []MinMax(int []cheeseborad){
		int check=0;
		int big=1;
		int []max=Max(cheeseborad,-1);
		int	[]min=Min(cheeseborad,1);
		int []sum=new int[9];
		for(int i=0;i<3;i+=2){
			if(cheeseborad[4]==1&&cheeseborad[i]==0){
				cheeseborad[i]=2;
				check++;
				break;
			}
		}
		if(check==0)
		{
			for(int i=6;i<9;i+=2){
				if(cheeseborad[4]==1&&cheeseborad[i]==0){
					cheeseborad[i]=2;
					check++;
					break;
				}
			}
			
		}
		

		if(check==0)
		{
			for(int i=0;i<9;i++)
			{							
				sum[i]=min[i]+max[i];//之所以加是因為我MAX那邊本身是負數
				if(sum[big]<=sum[i]){
					big=i;
				}
				
			}
			if(cheeseborad[big]!=0){
				for(int i=0;i<9;i++){
					if(sum[i]==sum[big]){
						if(cheeseborad[i]==0){
							big=i;
							cheeseborad[big]=2;
							break;
						}
						else if (cheeseborad[i]!=0&&i==8) {
							for(int i1=0;i1<9;i1++){
								if(cheeseborad[i1]==0){
									cheeseborad[i1]=2;
									break;
								}
							}
						}
						
					}
				}
			}
			if(cheeseborad[big]==0){
				cheeseborad[big]=2;
			}
			
			
				
		}
		
		return cheeseborad;
	}
	int	[] Min(int []cheeseborad,int add){//<<min max
		int []min=new int[9];
		int f=0,f1=1,f2=2;
		int s=0,s1=3,s2=6;
		for(int i1=0;i1<3;i1++)
		{
			if(check>0){break;}
			if(!(cheeseborad[f]==1)&&!(cheeseborad[f1]==1)&&!(cheeseborad[f2]==1)){//這邊我採用了費式數列檢查迴圈本來要跑9次而縮減3倍
				if(cheeseborad[f]==0){
					min[f]+=add;
				}
					
				if(cheeseborad[f1]==0){		
					min[f1]+=add;
							
				}
				if(cheeseborad[f2]==0)
				{
					min[f2]+=add;
				}
						
						
					
			}
					
			if(!(cheeseborad[s]==1)&&!(cheeseborad[s1]==1)&&!(cheeseborad[s2]==1)){		
				if(cheeseborad[s]==0){
					min[s]+=add;
							
				}
				if(cheeseborad[s1]==0)
				{
					min[s1]+=add;
				}
				if(cheeseborad[s2]==0){
					min[s2]+=add;
				}
						
						
			}
				f=f2+1;f1=f+1;f2=f1+1;
				s++;s1++;s2++;
				
		}
				
			if(!(cheeseborad[0]==1)&&!(cheeseborad[4]==1)&&!(cheeseborad[8]==1)){
				if(cheeseborad[0]==0){
					min[0]+=add;
				}
				if(cheeseborad[4]==0){
					min[4]+=add;
				}
				if(cheeseborad[8]==0){
					min[8]+=add;
				}
					
					
			}
			if(!(cheeseborad[2]==1)&&!(cheeseborad[4]==1)&&!(cheeseborad[6]==1)){
				if(cheeseborad[2]==0){
					min[2]+=add;
						
				}
				if(cheeseborad[4]==0){
					min[4]+=add;
				}
				if(cheeseborad[6]==0){
					min[6]+=add;
				}
			}

			
			
			return min;
	}
	int	[] Max(int []cheeseborad,int reduce){
		int []max=new int[9];
		int f=0,f1=1,f2=2;
		int s=0,s1=3,s2=6;
		for(int i1=0;i1<3;i1++)
		{
			if(check>0){break;}
			if(cheeseborad[f]==1||cheeseborad[f1]==1||cheeseborad[f2]==1){
				if(cheeseborad[f]==0){
					max[f]+=reduce;
				}
					
				if(cheeseborad[f1]==0){		
					max[f1]+=reduce;
							
				}
				if(cheeseborad[f2]==0)
				{
					max[f2]+=reduce;
				}
				
			}
					
			if(cheeseborad[s]==1||cheeseborad[s1]==1||cheeseborad[s2]==1){		
				if(cheeseborad[s]==0){
					max[s]+=reduce;
							
				}
				if(cheeseborad[s1]==0)
				{
					max[s1]+=reduce;
				}
				if(cheeseborad[s2]==0){
					max[s2]+=reduce;
				}
						
						
			}
				f=f2+1;f1=f+1;f2=f1+1;
				s++;s1++;s2++;
				
		}
				
			if(cheeseborad[0]==1||cheeseborad[4]==1||cheeseborad[8]==1){
				if(cheeseborad[0]==0){
					max[0]+=reduce;
				}
				if(cheeseborad[4]==0){
					max[4]+=reduce;
				}
				if(cheeseborad[8]==0){
					max[8]+=reduce;
				}
					
					
			}
			if(cheeseborad[2]==1||cheeseborad[4]==1||cheeseborad[6]==1){
				if(cheeseborad[2]==0){
					max[2]+=reduce;
						
				}
				if(cheeseborad[4]==0){
					max[4]+=reduce;
				}
				if(cheeseborad[6]==0){
					max[6]+=reduce;
				}
			}

		
		
		return max;
		
	}
	
	
	
	

}
