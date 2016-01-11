import java.awt.*;

import javax.swing.*;


public class OpenNUI_JAVA_Window extends JFrame
{
	Container container;
	GridBagLayout layout;
	GridBagConstraints constraints;
	static final String IMG_PATH = OpenNUI_JAVA_Window.class.getResource("").getPath()+"image/";
	String logo_img = IMG_PATH+"logo.png";
	ImageIcon logo_image = new ImageIcon(IMG_PATH+"logo.png");
	ImageIcon connected = new ImageIcon(IMG_PATH+"connected.png");
	ImageIcon disconnected = new ImageIcon(IMG_PATH+"disconnected.png");
	JLabel status = new JLabel(new String("Status : Not Connected"), disconnected, JLabel.CENTER);
	
	public OpenNUI_JAVA_Window()
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}
		
		SwingUtilities.updateComponentTreeUI(OpenNUI_JAVA_Window.this);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		System.out.println("해상도 : " + screenSize.width + "x" + screenSize.height);
		container = getContentPane();
		container.setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5,5,5,5);
		constraints.fill = GridBagConstraints.BOTH;

		// Logo Image
		JLabel Logo = new JLabel(new String(""), logo_image, JLabel.CENTER);
		addComponent(Logo, 0, 0, 1, 1);
		
		//Rendering panel
		//JPanel renderingPanel = new JPanel();
		JButton renderingPanel = new JButton("rendering Panel will be here");
		
		addComponent(renderingPanel, 1, 0, 3, 3);
		
		// Status 
		addComponent(status, 4, 2, 1, 1);
		
		this.setLocation(screenSize.width/4, screenSize.height/4);
		this.setSize(screenSize.width/2, screenSize.height/2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//pack();
	}
	
	private void addComponent(Component c, int row, int column, int width, int height)
	{
		constraints.gridx = column;
		constraints.gridy = row;
		
		constraints.gridwidth = width;
		constraints.gridheight = height;
		
		container.add(c, constraints);
	}

	//임시 메인파일.
	public static void main(String[] args)
	{
		new OpenNUI_JAVA_Window();
	}
}
