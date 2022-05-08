package Kosk_201810459;

import java.awt.*;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.*;

public class Kiosk_re extends JFrame{
	private JButton [] menus_b = new JButton [6];
	//�޴� �׸� ���� ��� ����
	private int [] check = {1,2,3,4};
	private String [] Category = {"��Ʈ�޴�","��ǰ","����","����Ʈ"};
	private String [] Set_Menu = {"1����Ʈ","2����Ʈ","3����Ʈ","4����Ʈ","5����Ʈ","6����Ʈ"};
	private String [] Piece_Menu = {"1��","2��","3��","4��","5��","6��"};
	private String [] Drink_Menu = {"1����","2����","3����","4����","5����","6����"};
	private String [] Dessert_Menu = {"1����Ʈ","2����Ʈ","3����Ʈ","4����Ʈ","5����Ʈ","6����Ʈ"};
	//���ø�� ���
	private Vector<String> v = new Vector<String>();
	private JList<String> Check_List = new JList<String>(v);
	//���� �����ݾ� ���
	private JLabel total_gap;	
	
	Kiosk_re() {
		setTitle("Ű����ũ");
		
		North_Banner();
		West_Menus();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,700);
		setResizable(false);	//â ũ�⺯��X
		setLocationRelativeTo(null);	//â�� ��� ������
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
		
		//p1�� ���� ����
		JLabel choice1 = new JLabel("���� >>");
		p1.add(choice1);

		JComboBox<String> choice2 = new JComboBox<String>();
		
		for(int i=0;i<Category.length;i++) 
		{	
			choice2.addItem(Category[i]);		
			p1.add(choice2);
		}
		
		//p2�� ���� ����(���� �޴��� ���� ����ȭ �ʿ�)
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
		
		//p3�� ���� ����
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
		
		//p1�� ���� ����
		Check_List.setVisibleRowCount(15);
		Check_List.setFixedCellWidth(250);
		
		p1.add(Check_List);
		
		//p2�� ���� ����
		JLabel hap = new JLabel("< �ݾ� : ");
		total_gap = new JLabel("0��");
		
		p2.add(hap);
		p2.add(total_gap);
		
		//p3�� ���� ����
		JButton check = new JButton("���");
		JButton reset = new JButton("ó������");
		
		p3.add(check);
		p3.add(reset);
		
		East.add(p1); East.add(p2); East.add(p3);
		add(East, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		new Kiosk_re();
	}

}
