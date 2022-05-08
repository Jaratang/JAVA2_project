package Kosk_201810459;

import java.awt.*;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.*;

public class Kiosk_re extends JFrame{
	private JButton [] menus_b = new JButton [6];
	//메뉴 항목에 따라 목록 구성
	private int [] check = {1,2,3,4};
	private String [] Category = {"세트메뉴","단품","음료","디저트"};
	private String [] Set_Menu = {"1번세트","2번세트","3번세트","4번세트","5번세트","6번세트"};
	private String [] Piece_Menu = {"1번","2번","3번","4번","5번","6번"};
	private String [] Drink_Menu = {"1음료","2음료","3음료","4음료","5음료","6음료"};
	private String [] Dessert_Menu = {"1디저트","2디저트","3디저트","4디저트","5디저트","6디저트"};
	//선택목록 출력
	private Vector<String> v = new Vector<String>();
	private JList<String> Check_List = new JList<String>(v);
	//최종 결제금액 출력
	private JLabel total_gap;	
	
	Kiosk_re() {
		setTitle("키오스크");
		
		North_Banner();
		West_Menus();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,700);
		setResizable(false);	//창 크기변경X
		setLocationRelativeTo(null);	//창이 가운데 나오게
		setVisible(true);
	}
	
	void North_Banner() {
		JPanel banner = new JPanel(new FlowLayout());
		banner.setPreferredSize(new Dimension(500, 130));	
		
		ImageIcon image1 = new ImageIcon("src/Kosk_201810459/images/3.jpg");
		JLabel ad1 = new JLabel(image1);
		banner.add(ad1);
		
		add(banner, BorderLayout.NORTH);
	}
	
	void West_Menus() {
		JPanel p1 = new JPanel(new GridLayout(0,2));
		JPanel p2 = new JPanel(new GridLayout(3,0));
		JPanel p3 = new JPanel(new GridLayout(0,2));
		JPanel West = new JPanel(new GridLayout(3,0));
		
		//p1에 대한 정보
		JLabel choice1 = new JLabel("선택 >>");
		p1.add(choice1);

		JComboBox<String> choice2 = new JComboBox<String>();
		
		for(int i=0;i<Category.length;i++) 
		{	
			choice2.addItem(Category[i]);		
			p1.add(choice2);
		}
		
		//p2에 대한 정보(선택 메뉴에 따른 차별화 필요)
		if(choice2.getSelectedIndex() == 0) 
		{	
			for(int i=0;i<Set_Menu.length;i++) 
			{
				menus_b[i] = new JButton(Set_Menu[i]);
				p2.add(menus_b[i]);
			}
		}
		else if(choice2.getSelectedIndex() == 1) 
		{	
			for(int i=0;i<Piece_Menu.length;i++) 
			{
				menus_b[i] = new JButton(Piece_Menu[i]);
				p2.add(menus_b[i]);
			}
		}
		else if(choice2.getSelectedIndex() == 2) 
		{	
			for(int i=0;i<Drink_Menu.length;i++) 
			{
				menus_b[i] = new JButton(Drink_Menu[i]);
				p2.add(menus_b[i]);
			}
		}
		else if(choice2.getSelectedIndex() == 3) 
		{	
			for(int i=0;i<Dessert_Menu.length;i++) 
			{
				menus_b[i] = new JButton(Dessert_Menu[i]);
				p2.add(menus_b[i]);
			}
		}
		
		//p3에 대한 정보
		JButton LB = new JButton();
		JButton RB = new JButton();
		
		p3.add(LB);
		p3.add(RB);
		
		West.add(p1); West.add(p2); West.add(p3);
		add(West, BorderLayout.WEST);
	}
	
	void East_Menu()
	{
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel(new GridLayout(3,0));
		JPanel p3 = new JPanel(new GridLayout(0,2));
		JPanel East = new JPanel(new GridLayout(3,0));
		
		//p1에 대한 정보
		Check_List.setVisibleRowCount(15);
		Check_List.setFixedCellWidth(250);
		
		p1.add(Check_List);
		
		//p2에 대한 정보
		JLabel hap = new JLabel("< 금액 : ");
		total_gap = new JLabel("0원");
		
		p2.add(hap);
		p2.add(total_gap);
		
		//p3에 대한 정보
		JButton check = new JButton("계산");
		JButton reset = new JButton("처음으로");
		
		p3.add(check);
		p3.add(reset);
		
		East.add(p1); East.add(p2); East.add(p3);
		add(East, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		new Kiosk_re();
	}

}
