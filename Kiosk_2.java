package Project;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Kiosk_2 extends JFrame{
	private JButton [] fruits = new JButton [6];
	private String [] names = {"A = 100원", "B = 200원", "C = 300원", "D = 400원", "E = 500원","F = 600원"};
	private JLabel sumLabel;
	JTextArea area;	//이벤트 소스가 될 컴포넌트들
	JButton check, reset;	//계산, 초기화 버튼 기능
	
	Kiosk_2(){
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
		
		//JScrollBar bar = new JScrollBar(JScrollBar.VERTICAL);	//수평 스크로바 생성
		//bar.setValues(0,20,0,30); //초기값(0), 단추크기(20), 범위(0~120)
		
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
		private int sum = 0; // 가격의 합
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
			sumLabel.setText(sum + "원");
		}
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
		
		sumLabel = new JLabel("0원");
		
		JButton check = new JButton("계산");
		JButton reset = new JButton("처음으로");
		
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
	