package panels;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import directions.Direction;
import directions.LoadSprite;

public class DirectionPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int panelSize = 20;
	private static final int flagSize = 10;
	
	Direction main;
	Direction secondary;
	JLabel flag;
	boolean active;
	
	public DirectionPanel(Direction main, Direction secondary) throws IOException
	{
		
		this.main = main;
		this.secondary = secondary;
		this.setSize(new Dimension(panelSize,panelSize));
		this.setMaximumSize(new Dimension(panelSize,panelSize));
		this.setMinimumSize(new Dimension(panelSize,panelSize));
		this.setPreferredSize(new Dimension(panelSize,panelSize));
		setLayout(new GridBagLayout());
		flag = new JLabel();

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		this.add(flag,c);		
		active = true;
		//canMove();
	}
	
	public DirectionPanel(Direction main) throws IOException
	{
		this(main,main);
	}
	
	public void canMove() throws IOException
	{
		String path =  ".\\img\\green.png";
		int size = active?panelSize:flagSize;
		ImageIcon img = LoadSprite.getSprite(size,path);
		flag.setIcon(img);
	}
	
	public void canTurn() throws IOException
	{
		String path =  ".\\img\\yellow.png";
		int size = active?panelSize:flagSize;
		ImageIcon img = LoadSprite.getSprite(size,path);
		flag.setIcon(img);
	}
	
	public void none()
	{
		flag.setIcon(null);
	}
}
