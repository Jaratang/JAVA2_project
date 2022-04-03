package Project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Kiosk_1 extends JFrame{
	Kiosk_1(){
		setTitle("키오스크");
		showNorth();
		showWest();
		showEast();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
	}
	
	void showNorth() //키오스크 제목
	{
		JPanel title = new JPanel();
		
		JLabel l1 = new JLabel("키오스크 프로그램", JLabel.CENTER);
		l1.setFont(new Font("맑은고딕", Font.BOLD, 50));
		title.add(l1);
		
		add(title, BorderLayout.NORTH);
	}
	
	void showWest()
	{
		JPanel menus = new JPanel(new GridLayout(3,2));
		menus.setPreferredSize(new Dimension(370,500));
		
		JScrollBar bar = new JScrollBar(JScrollBar.VERTICAL);	//수평 스크로바 생성
		bar.setValues(0,20,0,30); //초기값(0), 단추크기(20), 범위(0~120)
		
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		JButton b5 = new JButton();
		JButton b6 = new JButton();
		
		menus.add(b1);
		menus.add(b2);
		menus.add(b2);
		menus.add(b3);
		menus.add(b4);
		menus.add(b5);
		menus.add(b6);
		
		add(menus, BorderLayout.WEST);
		add(bar, BorderLayout.CENTER);
	}
	
	void showEast()
	{
		JPanel lists = new JPanel();
		lists.setPreferredSize(new Dimension(400,600));
		
		JLabel label = new JLabel("선택 목록"); 
		label.setFont(new Font("맑은고딕", Font.BOLD, 20));
		lists.add(label);
		
		JTextArea area = new JTextArea(20,35);
		area.setEditable(false);
		lists.add(area);
		
		add(lists, BorderLayout.EAST);
	}
	
	void showSouth()
	{
		JPanel panel = new JPanel();
		JLabel label = new JLabel("총 금액 >>"); 
		label.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		JTextArea area = new JTextArea(10,10);
		area.setEditable(false);
		
		JButton check = new JButton("계산");
		JButton reset = new JButton("처음으로");
		
		panel.add(label);
		panel.add(area);
		panel.add(check);
		panel.add(reset);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Kiosk_1();
	}

}
	