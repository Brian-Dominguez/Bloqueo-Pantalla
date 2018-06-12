import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMySQL {

    public String db = "bdusuario";
    public String url = "jdbc:mysql://localhost/" + db + "?useServerPrepStmts=true";
    public String user = "root";
    public String pass = "halomexico117";
    Connection link;
   public Connection Conectar(){
      try{
           //Class.forName("org.gjt.mm.mysql.Driver");
           Class.forName("org.gjt.mm.mysql.Driver");
           link = DriverManager.getConnection(this.url, this.user, this.pass);
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
       return link;
   }
 
   public ResultSet consultarUsuario(){
	   ResultSet rsClientes = null;
	   try{
		   PreparedStatement stConsultar = link.prepareStatement("Select Usuario, Password from iniciousuario");
		  rsClientes = stConsultar.executeQuery();
		  //stConsultar.close();
	   }catch (Exception e){
		   System.out.println("Error" + e);
	   }
	return rsClientes;
}
   
   public int InsertarCliente(String usu, String pas){
	   int numRegs = 0;
	   try
	   {
	   PreparedStatement stInsertar = link.prepareStatement("insert into iniciousuario (Usuario, Password) "+"values(?,?)");
	   	stInsertar.setString(1, usu);
	   stInsertar.setString(2, pas);
	  
	   
	    numRegs = stInsertar.executeUpdate();	   
	  
	   stInsertar.close();
   }
   catch(SQLException e)
   {
	   e.printStackTrace();
   }
   
   return numRegs;
   }
   
   public int ActualizarUsuario(String usu, String pass){
	   int numRegs = 0;
	   int id_actualizar=1;
   try
   {

	   PreparedStatement stActualizar = link.prepareStatement("UPDATE iniciousuario SET Usuario='"+usu+"', Password='"+pass+"' WHERE ID="+id_actualizar);
    numRegs=stActualizar.executeUpdate();
   
    stActualizar.close();
    
    if(numRegs>0)
    {
    	 JOptionPane.showMessageDialog(null, "Datos Actualizados");
    }else
    {
    	 JOptionPane.showMessageDialog(null, "No se guardaron los datos");
    }
   }

   catch (SQLException ex)

   {

   	JOptionPane.showMessageDialog(null, ex);

   }
   return numRegs;
   }
   
   public ResultSet iniciar(String usu, String passw){
	ResultSet Usuario = null;
	
	 String SQL="SELECT * FROM iniciousuario WHERE Usuario=? AND Password=? ";
	try
	{
		link = DriverManager.getConnection(this.url, this.user, this.pass);
		  PreparedStatement stInicio = link.prepareStatement(SQL);
		  stInicio.setString(1,usu);
		  stInicio.setString(2,passw);
	
	Usuario=stInicio.executeQuery();
	stInicio.close();
	}catch(SQLException ex)
	{
		
	}
	   return Usuario;
   }
}