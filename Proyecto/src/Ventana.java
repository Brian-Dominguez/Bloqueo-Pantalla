import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame implements BloqueoListener
{
	ConexionMySQL Interfazmysql;
	
    java.sql.Connection conexion;
	    private JButton btnEntrar;
	    private JButton btnSalir;
	    private JButton btnActualizar;
	    private JButton btnBloquear;
	    private JButton btnConectar;
	    private JButton btnConsulta;
	   private JPanel panelPrinc;
	   private JPanel panelBloq;
	   private JTextField passIng;
	    private JTextField userIng;
	    private JTextField passBloq;
	    private JTextField userBloq;
	    private DefaultTableModel modelo;
	    
	    public Ventana (String Titulo, boolean v)  {
	    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	 this.setTitle(Titulo);
	        this.setUndecorated(v);//quita bordes a jframe
	    	this.setVisible(true);
	    	this.setResizable(false);
	    	
	    	//this.setLocationRelativeTo(null);
	        //this.setDefaultCloseOperation( DO_NOTHING_ON_CLOSE  );//evita cerra jframe con ALT+C
	        //this.setExtendedState( MAXIMIZED_BOTH );//maximizado
	        //this.setAlwaysOnTop(true);//siempre al frente  
	        dosPaneles() ;
	        
	    }
	     
	        public  void dosPaneles()
	        {
	    	 panelPrinc = new JPanel();
	        panelPrinc.setBackground(Color.GREEN);
	        panelPrinc.setLayout(new GridBagLayout());
	        panelPrinc.setVisible(true);
	        panelPrinc.setBounds(350,160,500,350);
	        
	       
	       panelBloq  = new JPanel();   	 
	    	 panelBloq.setBackground(Color.RED);
	    	 panelBloq.setLayout(new GridBagLayout());
	    	  panelBloq.setVisible(false);
	    	  panelBloq.setBounds(350,160,400,300);
	    	 
	    	 Panel1();
	    	 Panel2();
	    	
	         getContentPane().setLayout(null);
	        //getContentPane().add(lblTitulo,BorderLayout.NORTH);
	         getContentPane().add(panelPrinc);
	         getContentPane().add(panelBloq);
	     
	        }
	        
	    	 public void Panel1()
	    	 {
	    		 JLabel lblUsuario = new JLabel("Usuario: ");
	 	        GridBagConstraints restricciones = new GridBagConstraints();
	 	        restricciones.gridx = 0;
	 	        restricciones.gridy = 0;
	 	        restricciones.anchor = GridBagConstraints.WEST;
	 	        restricciones.insets.set(40, 40, 5, 5);
	 	        panelPrinc.add(lblUsuario, restricciones);
	 	       
	 	        JLabel lblClave = new JLabel("Contraseña: ");
	 	        restricciones.gridx = 0;
	 	        restricciones.gridy = 1;
	 	        restricciones.anchor = GridBagConstraints.WEST;
	 	        restricciones.insets.set(5, 40, 5, 5);
	 	       panelPrinc.add(lblClave, restricciones);

	 	        userIng = new JTextField();
	 	       userIng.setPreferredSize(new Dimension(200, 32));
	 	        restricciones.gridx = 1;
	 	        restricciones.gridy = 0;
	 	        restricciones.gridwidth = 2;
	 	        restricciones.anchor = GridBagConstraints.NORTHWEST;
	 	        restricciones.insets.set(40, 5, 5, 40);
	 	       panelPrinc.add(userIng, restricciones);

	 	        passIng = new JTextField();
	 	       passIng.setPreferredSize(new Dimension(200, 32));
	 	        restricciones.gridx = 1;
	 	        restricciones.gridy = 1;
	 	        restricciones.gridwidth = 2;
	 	        restricciones.anchor = GridBagConstraints.NORTHWEST;
	 	        restricciones.insets.set(5, 5, 5, 40);
	 	       panelPrinc.add(passIng, restricciones);

	 	        
	 	        btnActualizar = new JButton("Actualizar");
	 	       btnActualizar.setActionCommand("btnActualizar");
	 	        restricciones = new GridBagConstraints();
	 	        restricciones.gridx = 1;
	 	        restricciones.gridy = 2;
	 	        restricciones.anchor = GridBagConstraints.NORTHWEST;
	 	        restricciones.insets.set(30, 10, 40, 0);
	 	       panelPrinc.add(btnActualizar, restricciones);
	 	        
	 	       
	 	        btnBloquear = new JButton("Bloquear");
	 	       btnBloquear.setActionCommand("btnBloquear");
	 	       restricciones = new GridBagConstraints();
	 	       restricciones.gridx = 3;
	 	       restricciones.gridy = 2;
	 	       restricciones.anchor =GridBagConstraints.NORTHWEST;
	 	       restricciones.insets.set(30, 10, 40, 0);
	 	      panelPrinc.add(btnBloquear, restricciones);
	 	      

	 	        btnConectar = new JButton("Conectar");
	 	       btnConectar.setActionCommand("btnConectar");
	 	       restricciones = new GridBagConstraints();
	 	       restricciones.gridx = 0;
	 	       restricciones.gridy = 2;
	 	       restricciones.anchor =GridBagConstraints.NORTHWEST;
	 	       restricciones.insets.set(30, 10, 40, 0);
	 	      panelPrinc.add(btnConectar, restricciones);
	 	      
	 	     btnConsulta = new JButton("Consultar");
	 	    btnConsulta.setActionCommand("btnConsulta");
	 	        restricciones = new GridBagConstraints();
	 	        restricciones.gridx = 2;
	 	        restricciones.gridy = 2;
	 	        restricciones.anchor = GridBagConstraints.NORTHWEST;
	 	        restricciones.insets.set(30, 10, 40, 0);
	 	       panelPrinc.add(btnConsulta, restricciones);
	 	       
	 	      modelo = new DefaultTableModel();
	 		 JTable tabla = new JTable(modelo);
	 		 restricciones.gridx = 1;//columna
	 		 restricciones.gridy = 4;//fila
	 		 restricciones.gridwidth = 1;
	 		 restricciones.gridheight = 1;
	 		 restricciones.weightx = 0.5;
	 		 restricciones.weighty = 0.5;
	 		 restricciones.fill=GridBagConstraints.CENTER;
	 		 restricciones.anchor = GridBagConstraints.CENTER;
	 		 panelPrinc.add(tabla, restricciones);
	 	 
		        //Vincular oyente al componente
		      btnBloquear.addActionListener(this);
		        btnConsulta.addActionListener(this);
		        btnConectar.addActionListener(this);
		        btnActualizar.addActionListener(this);
	    }
	   
	    private void Panel2() 
	    {
	    
	        JLabel lblUsuario = new JLabel("Usuario: ");
	        GridBagConstraints restricciones = new GridBagConstraints();
	        restricciones.gridx = 0;
	        restricciones.gridy = 0;
	        restricciones.anchor = GridBagConstraints.WEST;
	        restricciones.insets.set(40, 40, 5, 5);
	        panelBloq.add(lblUsuario, restricciones);
	       
	        JLabel lblClave = new JLabel("Contraseña: ");
	        restricciones.gridx = 0;
	        restricciones.gridy = 1;
	        restricciones.anchor = GridBagConstraints.WEST;
	        restricciones.insets.set(5, 40, 5, 5);
	        panelBloq.add(lblClave, restricciones);

	        userBloq = new JTextField();
	        userBloq.setPreferredSize(new Dimension(200, 32));
	        restricciones.gridx = 1;
	        restricciones.gridy = 0;
	        restricciones.gridwidth = 2;
	        restricciones.anchor = GridBagConstraints.NORTHWEST;
	        restricciones.insets.set(40, 5, 5, 40);
	        panelBloq.add(userBloq, restricciones);

	        passBloq = new JTextField();
	        passBloq .setPreferredSize(new Dimension(200, 32));
	        restricciones.gridx = 1;
	        restricciones.gridy = 1;
	        restricciones.gridwidth = 2;
	        restricciones.anchor = GridBagConstraints.NORTHWEST;
	        restricciones.insets.set(5, 5, 5, 40);
	        panelBloq.add(passBloq , restricciones);

	        
	        btnSalir = new JButton("Cancelar");
	        btnSalir.setActionCommand("btnSalir");
	        restricciones = new GridBagConstraints();
	        restricciones.gridx = 2;
	        restricciones.gridy = 2;
	        restricciones.anchor = GridBagConstraints.NORTHWEST;
	        restricciones.insets.set(30, 10, 40, 0);
	        panelBloq.add(btnSalir, restricciones);
	        
	       
	        btnEntrar = new JButton("Entrar");
	        btnEntrar.setActionCommand("btnEntrar");
	       restricciones = new GridBagConstraints();
	       restricciones.gridx = 1;
	       restricciones.gridy = 2;
	       restricciones.anchor =GridBagConstraints.NORTHWEST;
	       restricciones.insets.set(30, 0, 40, 0);
	       panelBloq.add(btnEntrar, restricciones);

	        //Vincular oyente al componente
	      btnEntrar.addActionListener(this);
	        btnSalir.addActionListener(this);
	    }
	    
	    public static void main(String args[]) {
	               Ventana Vent= new Ventana("Ventana",false); 
	               
	               Vent.setSize(1200,700);
	               Vent.setLocation(150,50);
	               //Vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	           // Vent.setVisible(true);
	            
	    }
	  
	    int cont;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("btnEntrar"))
	            {
					
					/*String Usuario=userBloq.getText();
	    			String Contraseña=passBloq.getText();
	    			Usuario Envio=new Usuario(Usuario,Contraseña);
	    			Envio.action();*/
	    			 
	    			ResultSet Inicio = Interfazmysql.iniciar(userBloq.getText(),passBloq.getText());
	    			if(Inicio != null)
	    			{
	    				JOptionPane.showMessageDialog(null, "Desbloqueado");
	    				panelPrinc.setVisible(true);
	    				panelBloq.setVisible(false);
	    				lipiarBloq();
	    			}else
	    			{
	    				JOptionPane.showMessageDialog(null, "Aun Bloqueado");
	    			}
	   	        
	   	        
	             }
				if (e.getActionCommand().equals("btnBloquear"))
	            {
					
					 Ventana Vent= new Ventana("Ventana",true);
					panelPrinc.setVisible(false);
					panelBloq.setVisible(true);
					 
					
	            }
				if (e.getActionCommand().equals("btnConectar")){
					// TODO Auto-generated method stub	
					Interfazmysql = new ConexionMySQL();
					conexion = Interfazmysql.Conectar();
			        java.sql.Connection cn = Interfazmysql.Conectar();
			        if(conexion !=null){
			                JOptionPane.showMessageDialog(null, "Conectado");
			     
			   }
			  } else if (e.getActionCommand().equals("btnConsulta")){
					ResultSet regsClientes = Interfazmysql.consultarUsuario();
					// Creamos las columnas.
					modelo.addColumn("Usuario");
					modelo.addColumn("Password");
					try {
						int cont=0;
						while (regsClientes.next()){
							cont ++;
										// Se crea un array que será una de las filas de la tabla.
										   Object [] fila = new Object[2]; // Hay 2 columnas en la tabla
										   
										// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
										   for (int i=0;i<2;i++)
										      fila[i] = regsClientes.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
										   // Se añade al modelo la fila completa.
										   modelo.addRow(fila); 
						}
						JOptionPane.showMessageDialog(null, "Filas en la tabla: " + cont, "Cantidad de Filas", JOptionPane.WARNING_MESSAGE);
						regsClientes.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  }else if(e.getActionCommand().equals("btnActualizar")){
					  Usuario envio=new Usuario("","");
					  String Usuario=userIng.getText();
		    			String Contraseña=passIng.getText();
		    			 envio.setUsuario(Usuario);
						  envio.setContraseña(Contraseña);

					  int numRegs=Interfazmysql.ActualizarUsuario(Usuario, Contraseña);
					  JOptionPane.showMessageDialog(null, "Datos Actualizados: " + numRegs, "Cantidad de datos que se actualizaron", JOptionPane.WARNING_MESSAGE);
					  lipiarIng();
					 
					}
			}	
			public void lipiarBloq()
			{
				userBloq.setText(null);
				passBloq.setText(null);
			}
			public void lipiarIng()
			{
				userIng.setText(null);
				passIng.setText(null);
			}
	    }    	