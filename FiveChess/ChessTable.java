package com.kino.Fivechess1114;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.kino.drawn1102v1.image;

public class ChessTable extends JPanel implements setchess {
	private int dchess[][] = new int[line][line];

	public static void main(String[] args) {
		ChessTable che = new ChessTable();
		che.Start();
	}

	/**
	 * ��������
	 */
	public void Start() {
		/**
		 * ������������
		 */
		JFrame jf = new JFrame("������");
		jf.setSize(940, 820);
		jf.setLocationRelativeTo(jf);
		jf.setDefaultCloseOperation(3);
		jf.add(this);
		this.setBackground(new Color(246, 247, 180));
		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(140, 0));
		jf.add(jp, BorderLayout.EAST);
		jp.setBackground(new Color(246, 247, 180));
		JButton jbu = new JButton("���¿�ʼ");
		jp.add(jbu);
		JButton jbu1 = new JButton("�˻���ս");
		jp.add(jbu1);
		JButton jbu2 = new JButton("˫�˶�ս");
		jp.add(jbu2);
		JButton jbu3 = new JButton("����");
		jp.add(jbu3);
		JButton jbu4 = new JButton("�˳�");
		jp.add(jbu4);
		jf.setVisible(true);

		/**
		 * ��ȡ����
		 */
		Graphics gr = this.getGraphics();

		/**
		 * ����������
		 */
		mouse mo = new mouse();

		/**
		 * �����������
		 */
		this.addMouseListener(mo);
		/**
		 * ����¼�������
		 */
		jbu.addActionListener(mo);
		jbu1.addActionListener(mo);
		jbu2.addActionListener(mo);
		jbu3.addActionListener(mo);
		jbu4.addActionListener(mo);
		/**
		 * ���ݻ�������
		 */
		mo.setG(gr);
		mo.setDC(dchess);
		mo.setJP(this);
		mo.setJF(jf);

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		for (int i = 0; i < line; i++) {
			g.drawLine(x0, y0 + i * size, x0 + (line - 1) * size, y0 + i * size);
			g.drawLine(x0 + i * size, y0, x0 + i * size, y0 + (line - 1) * size);
		}
		for (int m = 0; m < dchess.length; m++) {
			for (int n = 0; n < dchess.length; n++) {
				if (dchess[n][m] == 1) {
					g.setColor(Color.BLACK);
					g.fillOval((x0 + n * size) - size / 2, (y0 + m * size) - size / 2, size, size);
				} else if (dchess[n][m] == 2) {
					g.setColor(Color.white);
					g.fillOval((x0 + n * size) - size / 2, (y0 + m * size) - size / 2, size, size);
				}
			}
		}

	}


}
