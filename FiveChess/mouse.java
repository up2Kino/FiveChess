package com.kino.Fivechess1114;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class mouse extends MouseAdapter implements setchess, ActionListener {
	private Graphics g;
	private Color b = Color.black;
	private Color w = Color.white;
	private Color t;
	private String name = "双人对战";
	String na;
	private int[][] dchess;
	private int[] chess1 = new int[line * line];
	private int[] chess2 = new int[line * line];
	private int j = 1;
	int i = 0;
	int k = 2;
	int l;
	private judge jd;
	private Computer com;
	private ChessTable che;
	private JFrame jf;

	public void setG(Graphics g) {
		this.g = g;
	}

	public void setDC(int[][] dchess) {
		this.dchess = dchess;
		jd = new judge(dchess);
		com = new Computer(dchess);

	}

	public void setJP(ChessTable che) {
		this.che = che;
//		jd.setche(che);
	}

	public void setJF(JFrame jf) {
		this.jf = jf;
	}

	public void mouseClicked(MouseEvent e) {
		if (name.equals("双人对战")) {
			int x = e.getX();
			int y = e.getY();
			t = b;
			g.setColor(t);
			for (int i = 0; i < line; i++) {
				if (x > (x0 + i * size) - size / 2 && x < (x0 + i * size) + size / 2) {
					for (int u = 0; u < line; u++) {
						if ((y > (y0 + u * size) - size / 2 && y < (y0 + u * size) + size / 2) && dchess[i][u] == 0) {
							g.fillOval((x0 + i * size) - size / 2, (y0 + u * size) - size / 2, size, size);
							dchess[i][u] = j;
							jd.jd(i, u);
							save(i, u);
							l = j;
							j = k;
							k = l;

							t = w;
							w = b;
							b = t;
						}
					}
				}
			}
		} else if (name.equals("人机对战")) {
			int x = e.getX();
			int y = e.getY();
			t = b;
			g.setColor(t);
			for (int i = 0; i < line; i++) {
				if (x > (x0 + i * size) - size / 2 && x < (x0 + i * size) + size / 2) {
					for (int u = 0; u < line; u++) {
						if ((y > (y0 + u * size) - size / 2 && y < (y0 + u * size) + size / 2) && dchess[i][u] == 0) {
							g.fillOval((x0 + i * size) - size / 2, (y0 + u * size) - size / 2, size, size);
							dchess[i][u] = j;
							jd.jd(i, u);
							save(i, u);
							l = j;
							j = k;
							k = l;

							t = w;
							w = b;
							b = t;
							
							if(jd.jd(i,u)==1){
								return;
							}
							
							com.AI();
							com.choose();
							int m = com.getX();
							int n = com.getY();
							t = b;
							g.setColor(t);
							if (dchess[m][n] == 0) {
								g.fillOval((x0 + m * size) - size / 2, (y0 + n * size) - size / 2, size, size);
								dchess[m][n] = j;
								jd.jd(m, n);
								save(m, n);
								l = j;
								j = k;
								k = l;

								t = w;
								w = b;
								b = t;
								if(jd.jd(i,u)==1){
									return;
								}
							}
						}
					}
				}
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		na = name;
		name = e.getActionCommand();
		if (name.equals("重新开始")) {
			System.out.println(name);
			for (int i = 0; i < line; i++) {
				for (int j = 0; j < line; j++) {
					this.dchess[i][j] = 0;
				}
			}
			che.repaint();
			name = na;
			System.out.println(name);
		}
		if (name.equals("悔棋")) {
			i--;
			int x = chess1[i];
			int y = chess2[i];
			dchess[x][y] = 0;
			t = w;
			w = b;
			b = t;
			che.repaint();
			name = na;
			System.out.println(name);
		}
		if (name.equals("退出")) {
			System.exit(0);
		}

	}

	public void save(int x, int y) {
		chess1[i] = x;
		chess2[i] = y;
		i++;
	}
}