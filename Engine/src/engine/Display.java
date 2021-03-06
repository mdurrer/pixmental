/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import javax.swing.JFrame;
/**
 *
 * @author michael
 */
public class Display extends Canvas {
    private final JFrame m_frame;
    private BufferedImage m_displayImage;
    private  Bitmap  m_frameBuffer;
    private  byte[] m_displayComponents;
    private final BufferStrategy m_bufferStrategy;
    private final Graphics m_graphics;
    public Bitmap GetFrameBuffer() { return m_frameBuffer; }

    public Display(int width, int height, String title)
    {
        Dimension size = new Dimension(width,height);
        m_frameBuffer = new Bitmap(width,height);

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        
        m_displayImage = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);  
        m_displayComponents = 
        ((DataBufferByte)m_displayImage.getRaster().getDataBuffer()).getData();
        //Creates images used for display.
        m_frameBuffer = new Bitmap(width, height);
        m_displayImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        m_displayComponents = 
                ((DataBufferByte)m_displayImage.getRaster().getDataBuffer()).getData();

        m_frameBuffer.Clear((byte)0x80);
	m_frameBuffer.DrawPixel(100, 100, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0xFF);
        /*
        for (int i=0;i<=100;i++)
        {
                m_frameBuffer.DrawPixel(100+i, 100+i, (byte)0x00, (byte)0x00, (byte)0xFF, (byte)0x00);
    
        }
        */
        m_frame = new JFrame();
        m_frame.add(this);
        m_frame.pack();
        m_frame.setResizable(false);
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setLocationRelativeTo(null);
        m_frame.setTitle("Software Rendering");
        m_frame.setVisible(true);
        createBufferStrategy(1);
        m_bufferStrategy = getBufferStrategy();
        m_graphics = m_bufferStrategy.getDrawGraphics();
        
    }
    
	public void SwapBuffers()
	{
		//Display components should be the byte array used for displayImage's pixels.
		//Therefore, this call should effectively copy the frameBuffer into the
		//displayImage.
		m_frameBuffer.CopyToByteArray(m_displayComponents);
		m_graphics.drawImage(m_displayImage, 0, 0, m_frameBuffer.GetWidth(),m_frameBuffer.GetHeight(),null);
                m_bufferStrategy.show();
        }

}