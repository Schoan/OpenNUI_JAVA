import java.awt.Graphics;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class RenderingPanel extends JPanel
{
	private static String Path = "";
	private static int width=1920;
	private static int height=1080;
	private BufferedImage image;
	byte[] img_bytes = null; // 여기에 전달되어오는 byte array를 준다.
	
	RenderingPanel(String path)
	{
		Path = path;
		Init();
	}
	
	public static void SetSize(int w, int h)
	{
		width = w;
		height = h;
	}
	
	private void Init()
	{
		System.out.println(Path);
		
		try
		{
			OutputStream os = Rendering(extractBytes(Path));
		} catch (IOException ioe) { System.out.println ("ERROR : " +ioe) ;}
		
		
	}
	
	public byte[] extractBytes (String ImageName) throws IOException {
		 // open image
		 File imgPath = new File(ImageName);
		 BufferedImage bufferedImage = ImageIO.read(imgPath);
		 // get DataBufferBytes from Raster
		 WritableRaster raster = bufferedImage .getRaster();
		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

		 return ( data.getData() );
	}
			
	private OutputStream Rendering(byte[] bytess) throws IOException
	{
		//image_bytes[] = 
		OutputStream stream = null;
		//bufferedimage image
		image = createRGBImage(bytess, width, height);
		System.out.println(image.getWidth()+" * "+image.getHeight());
		//BufferedImage image = createRGBImage(img_bytes, width, height);
		
		/*
		try 
		{
		    ImageIO.write(image, "PNG", stream);
			//ImageIO.write(image, "PNG", imgFile);
		}		
		finally 
		{
		    //stream.close();
		}*/
		Graphics g = image.getGraphics();
		paint(g);
		
		return stream;
	}
	
	public void paint(Graphics g)
	{
		if(this.image != null)
		{
			g.drawImage(image, 0, 0, this);
			g.drawRect(0, 0, image.getWidth(), image.getHeight());
		}
	}
	
	private BufferedImage createRGBImage(byte[] bytes, int width, int height) 
	{
	    DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
	    ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
	    return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width, height, width * 3, 3, new int[]{0, 1, 2}, null), false, null);
	}
}
