package del;

import java.awt.Color;

import javax.swing.JFrame;

public class Form extends JFrame {
	CanvasMy canva;
	Color backCol = new Color(0, 0, 0);

	Form(String ss) {
		super(ss);
		this.canva = new CanvasMy();
		this.canva.setSize(1000, 700);
		this.canva.addKeyListener(null);
		this.canva.setBackground(backCol);
		this.add(this.canva);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void vvv() {

	}
}
