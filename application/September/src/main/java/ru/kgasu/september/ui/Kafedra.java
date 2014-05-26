package ru.kgasu.september.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

import java.awt.Color;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 * @author DarkRaha
 * 
 */
public class Kafedra extends JFrame implements TreeSelectionListener {

	private static final long serialVersionUID = 1L;
	private JTree tree; // ���� ������
	private JTextField jtf = new JTextField();

	public Kafedra() {
		// ------------------------------------------
		//  ���������� � ��������� ���������
		Container c = getContentPane(); // ���������� ������� ����
		c.setLayout(new BorderLayout()); // �������� �����������

		// -------------------------------------------
		// ���������� ������
		// �������� �����
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("����������");

		// �������� ���� �������� �����
		DefaultMutableTreeNode lvl1node1 = new DefaultMutableTreeNode(
				"���������"); // ����� ������
		DefaultMutableTreeNode lvl1node2 = new DefaultMutableTreeNode(
				"����������"); // ����� ������
		DefaultMutableTreeNode lvl1node3 = new DefaultMutableTreeNode("�������"); // �����
																					// ������

		// ���������� �� �������� �����
		root.add(lvl1node1);
		root.add(lvl1node2);
		root.add(lvl1node3);

		lvl1node1.add(new DefaultMutableTreeNode(
				"�������� ����������� � �������"));
		lvl1node1.add(new DefaultMutableTreeNode(
				"�������� ������������ ����������"));
		// ��������� �������� �������� (������) ������ �����
		lvl1node2.add(new DefaultMutableTreeNode("������������ ���������"));
		lvl1node2.add(new DefaultMutableTreeNode("��������� �����������"));
		lvl1node2.add(new DefaultMutableTreeNode("��������� �������"));
		lvl1node2.add(new DefaultMutableTreeNode(
				"���������-��������������� ���������"));
		lvl1node2.add(new DefaultMutableTreeNode(
				"��������� ����� ������������-�������������� ����������"));
		lvl1node2.add(new DefaultMutableTreeNode("������������ ���������"));
		// ������� ������� ���������� � ��������� ������� ������
		tree = new JTree(root);
		tree.addTreeSelectionListener(this);

		tree.setCellRenderer(new DefaultTreeCellRenderer() {

			@Override
			public Component getTreeCellRendererComponent(JTree tree,
					Object value, boolean selected, boolean expanded,
					boolean leaf, int row, boolean hasFocus) {
				// TODO Auto-generated method stub
				JLabel label = new JLabel(value.toString());
				if (tree.getPathForRow(row).getPathCount()==2) {
					label.setIcon(new ImageIcon("vuz.png"));
				}

				return label;

			}

		});

		// ��������� �������� ���������� � ����
		c.add(new JScrollPane(tree));

		c.add(jtf, BorderLayout.SOUTH);

		// -------------------------------------------
		// ��������� ����
		setTitle("�������"); // ��������� ����
		// ����������� ������� ����
		setPreferredSize(new Dimension(640, 480));
		// ��������� ���������� ��� �������� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); // ������������� ����������� �������
		setVisible(true); // ���������� ����
	}

	// ������ �������� ����������
	public static void main(String args[]) {
		new Kafedra();
	}

	// ����� ���������� TreeSelectionListener
	public void valueChanged(TreeSelectionEvent arg0) {
		jtf.setText("old selection: " + arg0.getOldLeadSelectionPath()
				+ ";  new selection: "
				// ������ ��� ���� ��������������� � ������ ������� toString
				+ arg0.getNewLeadSelectionPath().toString());
	}

}
