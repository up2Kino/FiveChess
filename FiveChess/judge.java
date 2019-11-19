package com.kino.Fivechess1114;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class judge implements setchess {
	private int[][] dchess;
//	private ChessTable che;
	public judge(int[][] array){
		this.dchess = array;
	}
	
	public int jd(int x,int y){
		int i = 0;
//		||count2(x,y)>=5||count3(x,y)>=5
		if(count(x,y)>=5||count1(x,y)>=5||count2(x,y)>=5||count3(x,y)>=5){
			if(dchess[x][y]==1){
				JOptionPane.showMessageDialog(null, "黑棋赢");
				i = 1;
//				this.restart();
			}else if(dchess[x][y]==2){
				JOptionPane.showMessageDialog(null, "白棋赢");
//				this.restart();
				i = 1;

			}
		}
		return i;
		
		
	}
//	public void save(int x,int y){
//		chess1[i]=x;
//		chess2[i]=y;
//		i++;
//	}
		
	
	private int count(int x,int y){
		int count = 0;
		//往右数
		for(int i= x+1;i<dchess.length;i++){
			if(dchess[x][y]==dchess[i][y]){
				count++;
			}else{break;}
			
		}
		//往左数
		for(int i= x;i>=0;i--){
			if(dchess[x][y]==dchess[i][y]){
				count++;
			}else{break;}
		}
		return count;
		
	}
	private int count1(int x,int y){
		int count = 0;
		//往下数
		for(int i= y+1;i<dchess.length;i++){
			if(dchess[x][y]==dchess[x][i]){
				count++;
			}else{break;}
			
		}
		//往左数
		for(int i= y;i>=0;i--){
			if(dchess[x][y]==dchess[x][i]){
				count++;
			}else{break;}
		}
		return count;
		
	}
	private int count2(int x,int y){
		int count = 0;
		//往左上数
		int i=x;
		int j=y;
		while(j>=0&&i>=0){
			if(dchess[x][y]==dchess[i][j]){
				count++;
			}else{break;}
			i--;
			j--;
				
		}
		//往右下数
		int n=x+1;
		int m=y+1;
		while(m<dchess.length&&n<dchess.length){
			if(dchess[x][y]==dchess[n][m]){
				count++;
			}else{break;}
			n++;
			m++;
		}
		return count;
	}
	private int count3(int x,int y){
		int count = 0;
		//往左下数
		int i=x;
		int j=y;
		while(i<dchess.length&&j>=0){
			if(dchess[x][y]==dchess[i][j]){
				count++;
			}else{break;}
			i++;
			j--;
				
		}
		//往右上数
		int n=x-1;
		int m=y+1;
		while(n>0&&m<dchess.length){
			if(dchess[x][y]==dchess[n][m]){
				count++;
			}else{break;}
			n--;
			m++;
		}
		return count;
		
	}
//	public void setche(ChessTable che){
//		this.che =che;
//	}
//	public void restart(){
//			for (int i = 0; i < line; i++) {
//				for (int j = 0; j < line; j++) {
//					this.dchess[i][j] = 0;
//				}
//			}
//			che.repaint();
//	}
}
	
