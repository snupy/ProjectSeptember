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
	private JTree tree; // наше дерево
	private JTextField jtf = new JTextField();

	public Kafedra() {
		// ------------------------------------------
		//  добавление и настройка компонент
		Container c = getContentPane(); // клиентская область окна
		c.setLayout(new BorderLayout()); // выбираем компоновщик

		// -------------------------------------------
		// построение дерева
		// корневая ветка
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Математика");

		// создание трех дочерних веток
		DefaultMutableTreeNode lvl1node1 = new DefaultMutableTreeNode(
				"Институты"); // будет листом
		DefaultMutableTreeNode lvl1node2 = new DefaultMutableTreeNode(
				"Факультеты"); // будет веткой
		DefaultMutableTreeNode lvl1node3 = new DefaultMutableTreeNode("Кафедры"); // будет
																					// листом

		// добавление их корневой ветке
		root.add(lvl1node1);
		root.add(lvl1node2);
		root.add(lvl1node3);

		lvl1node1.add(new DefaultMutableTreeNode(
				"Институт архитектуры и дизайна"));
		lvl1node1.add(new DefaultMutableTreeNode(
				"Институт транспортных сооружений"));
		// добавляем дочерние элементы (листья) второй ветке
		lvl1node2.add(new DefaultMutableTreeNode("Строительный факультет"));
		lvl1node2.add(new DefaultMutableTreeNode("Факультет архитектуры"));
		lvl1node2.add(new DefaultMutableTreeNode("Факультет дизайна"));
		lvl1node2.add(new DefaultMutableTreeNode(
				"Инжинерно-технологический факультет"));
		lvl1node2.add(new DefaultMutableTreeNode(
				"Факультет общей архитектурно-художественной подготовки"));
		lvl1node2.add(new DefaultMutableTreeNode("Автодорожный факультет"));
		// создаем элемент управления с указанным деревом данных
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

		// добавляем элементы управления в окно
		c.add(new JScrollPane(tree));

		c.add(jtf, BorderLayout.SOUTH);

		// -------------------------------------------
		// настройка окна
		setTitle("Кафедра"); // заголовок окна
		// желательные размеры окна
		setPreferredSize(new Dimension(640, 480));
		// завершить приложение при закрытии окна
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); // устанавливаем желательные размеры
		setVisible(true); // отображаем окно
	}

	// запуск оконного приложения
	public static void main(String args[]) {
		new Kafedra();
	}

	// метод интерфейса TreeSelectionListener
	public void valueChanged(TreeSelectionEvent arg0) {
		jtf.setText("old selection: " + arg0.getOldLeadSelectionPath()
				+ ";  new selection: "
				// второй раз явно преобразовываем в строку методом toString
				+ arg0.getNewLeadSelectionPath().toString());
	}

}
