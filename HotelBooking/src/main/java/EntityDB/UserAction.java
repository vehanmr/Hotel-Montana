package EntityDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import DB.ConnectionPro;
import Model.UserModel;

public class UserAction {
	
	public static boolean saveuser(UserModel user)
	{
		boolean set=false;
		try
		{
			
			Connection con=ConnectionPro.createconnection();
			String query="INSERT INTO `users`( `full_name`, `email`, `contact_no`, `gender`, `password`, `category`) VALUES(?,?,?,?,?,?)";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1, user.getName());
			pt.setString(2, user.getEmail());
			pt.setInt(3, user.getContact());
			pt.setString(4, user.getGender());
			pt.setString(5, user.getPassword());
			pt.setString(6, user.getCat());
			pt.executeUpdate();
			set=true;
			
		}
		catch(Exception ex)
		{
			System.out.print(ex);
		}
		return set;
		
		
	}
	
	

}
