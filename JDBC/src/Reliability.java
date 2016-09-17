import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

public class Reliability implements Comparable<Reliability>{


	private static String pAddress;
	private static String sAddress;
	private double componentReliability;
	private boolean psflag = false;
	private int id;
		
	static void calculateReliability() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		//Creating a variable for the connection called "con"
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reliability","root","");
		
		String sql = "SELECT `id`, `pAddress`, `sAddress`, `componentReliabilty` FROM `abcd`";
		PreparedStatement statement  = (PreparedStatement)con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);
		int len = 0;
		while(rs.next())
			 len++;
		
		Reliability reliability[] = new Reliability[len];
		rs.first();
		int i = 0;
		while(rs.next()){
			//reliability[i].id = rs.getInt("id");
			 reliability[i].pAddress = rs.getString("pAddress");
			reliability[i].sAddress = rs.getString("sAddress");
			//reliability[i].componentReliability = rs.getDouble("componentReliability");
			i++;
			
		
		}
	
		int len1=pAddress.length();	
		int len2=sAddress.length();
		int len3=pAddress.length()+sAddress.length();
	
		Arrays.sort(reliability);
		
		}

	@Override
	public int compareTo(Reliability arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	   }
		
		

			