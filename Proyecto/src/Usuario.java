import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Usuario  extends JComponent implements Runnable
 {
	 // private Vector Usuario=new Vector();
	 // private Vector Contrase�as=new Vector();
	private Thread hilo;
	/*private static final int SIZE = 40;
	private static final Dimension PREFERRED_DIMENSION = new Dimension(SIZE, SIZE);
	 private static final int STROKE_WIDTH = SIZE / 10;
	private static final int MARGIN = SIZE / STROKE_WIDTH;*/
	
	  private String Usuario;
	  private String Contrase�a;
	 public String UsuarioIng;
	  public String Contrase�aIng;
	  
	
	int cont;
	  public Usuario(String Usu, String pass) 
	  {
	  this.UsuarioIng=Usu;
	  this.Contrase�aIng=pass;
	  
	  }
	  
	  
	  
    	public void action()
    	{
    		
    		
    		System.out.println(this.Usuario);
    		  System.out.println(this.Contrase�a);
	    if(Usuario==UsuarioIng && Contrase�a==Contrase�aIng)
	        {	
	        	JOptionPane.showMessageDialog(null, "Ususario y contase�a coreectos", "Acceso concedido",JOptionPane.INFORMATION_MESSAGE);
	        	
	        }
	        else
	        {
	        	cont= cont+1;
	        	
	        	JOptionPane.showMessageDialog(null, "El usuario o la contrase�a son incorrectos","Acceso denegado",JOptionPane.ERROR_MESSAGE);
	        	if(cont>=3){
	        		JOptionPane.showMessageDialog(null, "Numero de intentos permitidos","Cerrando ventana",JOptionPane.ERROR_MESSAGE);	
	        	}
	        }
	        	
	}
		
    	/*public synchronized void addBloqueoListener(BloqueoListener listener){
    		BloqueoListener.addElement(listener);
    	}*/
		
		  public String getUsuarioIng() {
				return UsuarioIng;
			}

			public void setUsuarioIng(String usuarioIng) {
				UsuarioIng = usuarioIng;
			}

			public String getContrase�aIng() {
				return Contrase�aIng;
			}

			public void setContrase�aIng(String contrase�aIng) {
				Contrase�aIng = contrase�aIng;
			}
			public String getUsuario()
			{
				return Usuario;
			}
			public void setUsuario(String usuario)
			{
				this.Usuario=usuario;
				
			}
			
			public String getContrase�a()
			{
				return Contrase�a;
			}
			public void setContrase�a(String contrase�a)
			{
				this.Contrase�a=contrase�a;
				  
			}
			public void start ()
		    {
		        if (hilo == null) {
		            hilo = new Thread((Runnable) this, "comp");
		            hilo.start();
		        }
		    }
			  /*public void paintComponent(Graphics g){
				  Graphics2D g2 = (Graphics2D) g.create();
			        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			                RenderingHints.VALUE_ANTIALIAS_ON);
			        
			        
			        g2.setStroke(new BasicStroke(STROKE_WIDTH));
			        g2.setPaint(new GradientPaint(0,0,Color.GRAY,SIZE,0,Color.DARK_GRAY));
			        //g2.drawLine(MARGIN,MARGIN,getWidth() - MARGIN,getHeight() - MARGIN);
			        g2.drawRect(MARGIN, MARGIN, MARGIN+10,MARGIN+10);
			        g2.drawArc(MARGIN-4,MARGIN-5,30,40, 60, 60);
			        g2.setColor(Color.RED);
			        g2.fillRect(MARGIN, MARGIN, MARGIN+10,MARGIN+10);
			  }*/

		    public void run () {
		        while (true) {
		            this.repaint();
		            try {
		                Thread.sleep(1000);
		            } catch (Exception e) {
		            }
		        }
		    }

		    public void stop () {
		    	hilo.stop();
		        hilo = null;
		    }
 }


