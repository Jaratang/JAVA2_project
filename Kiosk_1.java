package Project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Kiosk_1 extends JFrame{
	JTextArea area, area2;	//이벤트 소스가 될 컴포넌트들
	JButton check, reset;
	
	
	Kiosk_1(){
		setTitle("키오스크");
		showNorth();
		showWest();
		showEast();
		showSouth();
		
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
	
	void showWest()	//버튼 클릭시 액션이벤트 설정 
	{
		JPanel menus = new JPanel(new GridLayout(3,0));
		menus.setPreferredSize(new Dimension(370,500));
		
		JScrollBar bar = new JScrollBar(JScrollBar.VERTICAL);	//수평 스크로바 생성
		bar.setValues(0,20,0,30); //초기값(0), 단추크기(20), 범위(0~120)
		
		ImageIcon b1_icon = new ImageIcon("src/project/images/1.jpg");
		ImageIcon b2_icon = new ImageIcon("src/project/images/2.jpg");
		ImageIcon b3_icon = new ImageIcon("src/project/images/3.jpg");
		ImageIcon b4_icon = new ImageIcon("src/project/images/4.jpg");
		ImageIcon b5_icon = new ImageIcon("src/project/images/5.jpg");
		ImageIcon b6_icon = new ImageIcon("src/project/images/6.jpg");
		
		JButton b1 = new JButton(b1_icon);
		JButton b2 = new JButton(b2_icon);
		JButton b3 = new JButton(b3_icon);
		JButton b4 = new JButton(b4_icon);
		JButton b5 = new JButton(b5_icon);
		JButton b6 = new JButton(b6_icon);
		
		menus.add(b1);
		menus.add(b2);
		menus.add(b2);
		menus.add(b3);
		menus.add(b4);
		menus.add(b5);
		menus.add(b6);
		
		add(menus, BorderLayout.WEST);
		add(bar, BorderLayout.CENTER);
		
		ActionListener listener1 = e -> {
			if(e.getSource() == b1) 
				area.setText("1번 메뉴");
			else if(e.getSource() == b2)
				area.setText("2번 메뉴");	
			else if(e.getSource() == b3)
				area.setText("3번 메뉴");	
			else if(e.getSource() == b4)
				area.setText("4번 메뉴");	
			else if(e.getSource() == b5)
				area.setText("5번 메뉴");	
			else if(e.getSource() == b6)
				area.setText("6번 메뉴");	
		};
		
		b1.addActionListener(listener1);
		b2.addActionListener(listener1);
		b3.addActionListener(listener1);
		b4.addActionListener(listener1);
		b5.addActionListener(listener1);
		b6.addActionListener(listener1);
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
		label.setFont(new Font("맑은고딕", Font.BOLD, 15));
		
		JTextArea area2 = new JTextArea(1,8);
		area2.setEditable(false);
		
		JButton check = new JButton("계산");
		JButton reset = new JButton("처음으로");
		
		panel.add(label);
		panel.add(area2);
		panel.add(check);
		panel.add(reset);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Kiosk_1();
	}

}
	