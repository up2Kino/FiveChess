package com.kino.Fivechess1114;

import java.util.HashMap;

public class Computer implements setchess {
	private int[][] dchess;
	private int chessValue[][] = new int[line][line];
	private int q = 0;
	int x;
	int y;
	HashMap<String, Integer> hm = new HashMap<>();

	public Computer(int[][] dchess) {
		this.dchess = dchess;
	}

	public void AI() {
		hm.put("1", 20);
		hm.put("11", 200);
		hm.put("111", 2000);
		hm.put("1111", 10000);
		
		hm.put("2", 20);
		hm.put("22", 200);
		hm.put("222", 2000);
		hm.put("2222", 10000);

		hm.put("12", 10);
		hm.put("112", 100);
		hm.put("1112", 1000);
		hm.put("11112", 8000);
		
		hm.put("21", 10);
		hm.put("221", 100);
		hm.put("2221", 1000);
		hm.put("22221", 8000);
		for (int i = 0; i < dchess.length; i++) {
			for (int j = 0; j < dchess.length; j++) {
				String code = "";
				int color = 0;
				if (dchess[i][j] == 0) {
					// String code="";
					// int color=0;
					// 向下
					for (int m = i + 1; m < dchess.length; m++) {
						if (dchess[m][j] == 0) {
							break;
						} else {
							if (color == 0) {
								color = dchess[m][j];
								code += dchess[m][j];
							} else if (dchess[m][j] == color) {
								code += dchess[m][j];
							} else {
								code += dchess[m][j];
								break;
							}

						}
					}
					Integer value = hm.get(code);
					code = "";
					color = 0;
					if (value != null) {
						chessValue[i][j] += value;
						value = 0;
					}
					// 向上
					for (int m = i - 1; m > 0; m--) {
						if (dchess[m][j] == 0) {
							break;
						} else {
							if (color == 0) {
								color = dchess[m][j];
								code += dchess[m][j];
							} else if (dchess[m][j] == color) {
								code += dchess[m][j];
							} else {
								code += dchess[m][j];
								break;
							}

						}
					}
					value = hm.get(code);
					code = "";
					color = 0;
					if (value != null) {
						chessValue[i][j] += value;
						value = 0;
					}
					// 向左
					for (int m = j - 1; m > 0; m--) {
						if (dchess[i][m] == 0) {
							break;
						} else {
							if (color == 0) {
								color = dchess[i][m];
								code += dchess[i][m];
							} else if (dchess[i][m] == color) {
								code += dchess[i][m];
							} else {
								code += dchess[i][m];
								break;
							}

						}
					}
					value = hm.get(code);
					code = "";
					color = 0;
					if (value != null) {
						chessValue[i][j] += value;
						value = 0;
					}
//					 向右
					for (int m = j + 1; m < dchess.length; m++) {
						if (dchess[i][m] == 0) {
							break;
						} else {
							if (color == 0) {
								color = dchess[i][m];
								code += dchess[i][m];
							} else if (dchess[i][m] == color) {
								code += dchess[i][m];
							} else {
								code += dchess[i][m];
								break;
							}

						}
					}
					value = hm.get(code);
					code = "";
					color = 0;
					if (value != null) {
						chessValue[i][j] += value;
						value = 0;
					}
					// 向右下
					int m=i+1;
					int n=j+1;
					while(m<dchess.length&&n<dchess.length){
							if(dchess[m][n]==0){
								break;
							}else{
								if(color==0){
									color = dchess[m][n];
									code += dchess[m][n];
								}else if(dchess[m][n]==color){
									code +=dchess[m][n];
								}else{
									code +=dchess[m][n];
									break;
								}
							}
							m++;
							n++;
					}
					value = hm.get(code);
					code = "";
					color = 0;
					if (value != null) {
						chessValue[i][j] += value;
						value = 0;
					}
					// 向左上
					m = i-1;
					n = j-1;
					while(m>0&&n>0){
							if(dchess[m][n]==0){
								break;
							}else{
								if(color==0){
									color = dchess[m][n];
									code += dchess[m][n];
								}else if(dchess[m][n]==color){
									code +=dchess[m][n];
								}else{
									code +=dchess[m][n];
									break;
								}
							}
							m--;
							n--;
						
					}
					value = hm.get(code);
					code = "";
					color = 0;
					if (value != null) {
						chessValue[i][j] += value;
						value = 0;
					}
					//向左下
					m = i+1;
					n = j-1;
					while(m<dchess.length&&n>0){
						if(dchess[m][n]==0){
							break;
						}else{
							if(color==0){
								color = dchess[m][n];
								code += dchess[m][n];
							}else if(dchess[m][n]==color){
								code +=dchess[m][n];
							}else{
								code +=dchess[m][n];
								break;
							}
						}
						m++;
						n--;
					
				}
					value = hm.get(code);
					code = "";
					color = 0;
					if (value != null) {
						chessValue[i][j] += value;
						value = 0;
					}
					// 向右上
					m=i-1;
					n=j+1;
					while(m>0&&n<dchess.length){
						if(dchess[m][n]==0){
							break;
						}else{
							if(color==0){
								color = dchess[m][n];
								code += dchess[m][n];
							}else if(dchess[m][n]==color){
								code +=dchess[m][n];
							}else{
								code +=dchess[m][n];
								break;
							}
						}
						m--;
						n++;
					
				}
					value = hm.get(code);
					code = "";
					color = 0;
					if (value != null) {
						chessValue[i][j] += value;
						value = 0;
					}

				}
			}

		}
		for (int i = 0; i < dchess.length; i++) {
			for (int j = 0; j < dchess.length; j++) {
				System.out.print(chessValue[j][i] + " ");
			}
			System.out.println();
		}
//		for (int i = 0; i < line; i++) {
//			for (int j = 0; j < line; j++) {
//				chessValue[i][j] = 0;
//			}
//		}
	}

	// 找到最大的Value值
	public void choose() {
		q = 0;
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				if (q <= chessValue[i][j]) {
					q = chessValue[i][j];
				}
			}
		}
		System.out.println(q);
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				if (q == chessValue[i][j]) {
					x = i;
					y = j;
					break;
				}
			}
		}
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				chessValue[i][j] = 0;
			}
		}
		for (int i = 0; i < dchess.length; i++) {
			for (int j = 0; j < dchess.length; j++) {
				System.out.print(chessValue[j][i] + " ");
			}
			System.out.println();
		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
