package com.miniT;

import java.awt.Color;

import javax.swing.JFrame;

public class Form extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4448912228470100184L;
	CanvasMy canva;
	Color backCol = new Color(0, 0, 0);

	Form(String ss, CanvasMy canva) {
		super(ss);
		Trak.getT();
		this.canva = canva;
		this.canva.addKeyListener(new KeyLis(canva, new Car(canva)));
		this.setLocation(700, 10);
		this.canva.setSize(1000, 855);
		this.canva.setFocusable(rootPaneCheckingEnabled);
		this.canva.addKeyListener(null);
		this.canva.setBackground(backCol);
		this.add(this.canva);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		// canva.Ani
	}

}
