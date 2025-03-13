package Client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JMenuBar;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.Dimension;
import javax.swing.Box;
import java.awt.TextArea;
import java.awt.List;
import java.awt.Canvas;

public class design {
	 public static void main(String[] args) {
	      
	      JFrame f = new JFrame("A JFrame");
	      
	      JMenuBar menuBar = new JMenuBar();
	      menuBar.setMargin(new Insets(28, 28, 0, 0));
	      menuBar.setForeground(new Color(0, 128, 255));
	      f.setJMenuBar(menuBar);
	      
	      JTextPane textPane = new JTextPane();
	      menuBar.add(textPane);
	      
	      JTextPane textPane_1 = new JTextPane();
	      menuBar.add(textPane_1);
	      
	      JTextPane textPane_2 = new JTextPane();
	      f.getContentPane().add(textPane_2, BorderLayout.NORTH);
	      
	      JButton btnNewButton = new JButton("Click Here");
	      btnNewButton.setPreferredSize(new Dimension(30, 23));
	      btnNewButton.setMinimumSize(new Dimension(30, 10));
	      btnNewButton.setActionCommand("Click Here");
	      f.getContentPane().add(btnNewButton, BorderLayout.CENTER);
	      
	      List list = new List();
	      f.getContentPane().add(list, BorderLayout.EAST);
	      
	      Canvas canvas = new Canvas();
	      f.getContentPane().add(canvas, BorderLayout.WEST);
	      
	      Canvas canvas_1 = new Canvas();
	      f.getContentPane().add(canvas_1, BorderLayout.SOUTH);
	      
	    }
}
