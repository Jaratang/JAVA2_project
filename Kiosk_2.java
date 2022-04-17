package Project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Kiosk_2 extends JFrame{
	private JButton [] fruits = new JButton [6];
	private String [] names = {"A = 100��", "B = 200��", "C = 300��", "D = 400��", "E = 500��","F = 600��"};
	private JLabel sumLabel;
	JTextArea area;	//�̺�Ʈ �ҽ��� �� ������Ʈ��
	JButton check, reset;	//���, �ʱ�ȭ ��ư ���
	
	Kiosk_2(){
		setTitle("Ű����ũ");
		showNorth();
		showWest();
		showEast();
		showSouth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
	}
	
	void showNorth() //Ű����ũ ����
	{
		JPanel title = new JPanel();
		
		JLabel l1 = new JLabel("Ű����ũ ���α׷�", JLabel.CENTER);
		l1.setFont(new Font("�������", Font.BOLD, 50));
		title.add(l1);
		
		add(title, BorderLayout.NORTH);
	}
	
	void showWest()	//��ư Ŭ���� �׼��̺�Ʈ ���� 
	{
		JPanel menus = new JPanel(new GridLayout(3,0));
		menus.setPreferredSize(new Dimension(370,500));
		
		//JScrollBar bar = new JScrollBar(JScrollBar.VERTICAL);	//���� ��ũ�ι� ����
		//bar.setValues(0,20,0,30); //�ʱⰪ(0), ����ũ��(20), ����(0~120)
		
		ImageIcon b1_icon = new ImageIcon("");
		ImageIcon b2_icon = new ImageIcon("");
		ImageIcon b3_icon = new ImageIcon("");
		ImageIcon b4_icon = new ImageIcon("");
		ImageIcon b5_icon = new ImageIcon("");
		ImageIcon b6_icon = new ImageIcon("");
		
		MyItemListener listener = new MyItemListener();
		for(int i=0;i<fruits.length;i++) {
			fruits[i] = new JButton(names[i]);
			menus.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}
		
		add(menus, BorderLayout.WEST);
		//add(bar, BorderLayout.CENTER);
	}
	
	class MyItemListener implements ItemListener{
		private int sum = 0; // ������ ��
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(e.getItem() == fruits[0])
					sum += 100;
				else if(e.getItem() == fruits[1])
					sum += 200;
				else if(e.getItem() == fruits[2])
					sum += 300;
				else if(e.getItem() == fruits[3])
					sum += 400;
				else if(e.getItem() == fruits[4])
					sum += 500;
				else 
					sum += 600;
			}
			else {
				if(e.getItem() == fruits[0])
					sum -= 100;
				else if(e.getItem() == fruits[1])
					sum -= 200;
				else if(e.getItem() == fruits[2])
					sum -= 300;
				else if(e.getItem() == fruits[3])
					sum -= 400;
				else if(e.getItem() == fruits[4])
					sum -= 500;
				else 
					sum -= 600;
			}
			sumLabel.setText(sum + "��");
		}
	}
	
	void showEast()
	{
		JPanel lists = new JPanel();
		lists.setPreferredSize(new Dimension(400,600));
		
		JLabel label = new JLabel("���� ���"); 
		label.setFont(new Font("�������", Font.BOLD, 20));
		lists.add(label);
		
		JTextArea area = new JTextArea(20,35);
		area.setEditable(false);
		lists.add(area);
		
		add(lists, BorderLayout.EAST);
	}
	
	void showSouth()
	{
		JPanel panel = new JPanel();
		JLabel label = new JLabel("�� �ݾ� >>"); 
		label.setFont(new Font("�������", Font.BOLD, 15));
		
		sumLabel = new JLabel("0��");
		
		JButton check = new JButton("���");
		JButton reset = new JButton("ó������");
		
		panel.add(label);
		panel.add(sumLabel);
		panel.add(check);
		panel.add(reset);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Kiosk_2();
	}

}
	