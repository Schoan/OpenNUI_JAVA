import java.awt.*;
import javax.swing.*;


public class OpenNUI_JAVA_Window extends JFrame
{
	
	public OpenNUI_JAVA_Window()
	{
		Container container = getContentPane();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		System.out.println("해상도 : " + screenSize.width + "x" + screenSize.height);
		
		Panel panel = new Panel();
		panel.setLayout(new BorderLayout());
		container.add(panel);
		
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(tk.getImage("\\image\\logo.png"), 0);
		JImagePanel imagePanel = new JImagePanel(tk.getImage("\\image\\logo.png"));
		panel.add(imagePanel, BorderLayout.NORTH);
		
		
		this.setSize(screenSize.width-50, screenSize.height-100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class JImagePanel extends JPanel
	{
		private Image image;
		public JImagePanel(Image img)
		{
			this.image = img;
		}
		
		public void paintComponent(Graphics g)
		{
			g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	//임시 메인파일.
	public static void main(String[] args)
	{
		new OpenNUI_JAVA_Window();
	}
}
