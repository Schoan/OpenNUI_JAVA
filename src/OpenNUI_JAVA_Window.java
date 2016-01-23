import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;


public class OpenNUI_JAVA_Window extends JFrame
{
	Container container;
	GridBagLayout gridBagLayout;
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
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 640, 100};
		gridBagLayout.rowHeights = new int[]{54, 480, 20};
		container.setLayout(gridBagLayout);
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(1, 1, 5, 5);
		//constraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagLayout.setConstraints(container, constraints);
				
		// Logo Image
		JLabel Logo = new JLabel(new String(""), logo_image, SwingConstants.CENTER);
		constraints.anchor = GridBagConstraints.NORTHWEST;
		addComponent(Logo, constraints, 0, 0, 1, 1, 0, 0);
		
		//Rendering panel
		RenderingPanel rp = new RenderingPanel(IMG_PATH+"image.jpg");
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(rp, constraints, 1, 0, 3, 1, 1, 1);
		
		// Status
		constraints.anchor = GridBagConstraints.SOUTHEAST;
		constraints.fill = GridBagConstraints.NONE;
		addComponent(status, constraints, 2, 2, 1, 1, 0, 0);
		
		container.addComponentListener(new ComponentAdapter(){
			@Override
			public void componentResized(ComponentEvent event)
			{
				rp.setImageSize(container.getBounds().getSize());
			}
		});
		
		this.setLocation(screenSize.width/4, screenSize.height/4);
		this.setSize(screenSize.width/2, screenSize.height/2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
	}
	
	private void addComponent(Component c, GridBagConstraints gc, int row, int column, int width, int height, int weightx, int weighty)
	{
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		gridBagLayout.setConstraints(c, gc);
		
		container.add(c, gc);
	}

	//임시 메인파일.
	public static void main(String[] args)
	{
		new OpenNUI_JAVA_Window();
	}
}
