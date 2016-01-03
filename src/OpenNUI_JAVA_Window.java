import java.awt.*;
import javax.swing.*;


public class OpenNUI_JAVA_Window extends JFrame{
	
	public OpenNUI_JAVA_Window(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("해상도 : " + screenSize.width + "x" + screenSize.height);
		this.setSize(screenSize.width-50, screenSize.height-100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//임시 메인파일.
	public static void main(String[] args)
	{
		new OpenNUI_JAVA_Window();
	}
}
