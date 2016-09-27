
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.List;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.*;

public class database {

	static void insert  (String s1,String s2,String s3,String s4, String a, String b,int c, double d) throws Exception{

		//Accessing Driver from the JAR file
		Class.forName("com.mysql.jdbc.Driver");

		//Creating a variable for the connection called "con"
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reliability","root","");

		PreparedStatement statement = (PreparedStatement) con.prepareStatement("INSERT INTO `abcd`(`relation`, `superunit`, `subunit`, `isLowest`,`componentReliabilty`) VALUES ('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"',"+d+")");

		boolean result = statement.execute();


	}



	public static void calculate() throws Exception{

		Class.forName("com.mysql.jdbc.Driver");

		//Creating a variable for the connection called "con"
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reliability","root","");

		String sql = "SELECT `relation`, `superunit`, `subunit`, `isLowest` FROM `abcd`";
		PreparedStatement statement  = (PreparedStatement)con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);

		int len = 0;
		while(rs.next())
			len++;

		//int pAddress[] = new int[len];
		String[] pAddress=new String[len];
		//int sAddress[] = new int[len];
		String[] sAddress=new String[len];
		int aCount[] =new int[len];

		//Array a = rs.getArray("relation");	

		String[] relation = new String[len];

		rs.first();
		relation[0] = rs.getString("relation");

		int i = 1;
		while(rs.next()){
			relation[i] = rs.getString("relation");
			i++;
		}

		String[] superunit = new String[len];
		rs.first();
		superunit[0] = rs.getString("superunit");
		i = 1;
		while(rs.next()){
			superunit[i++] = rs.getString("superunit");
		}

		String[] subunit = new String[len];
		rs.first();
		subunit[0] = rs.getString("subunit");
		i = 1;
		while(rs.next()){
			subunit[i++] = rs.getString("subunit");
		}


		//String pAddress = Arrays.toString(pAddress[len]);
		//String sAddress = Integer.toString(sAddress[len]);
		pAddress[0] ="1."; 
		sAddress[0] = "1.";aCount[0] =1 ;
		for(i = 1; i < len; i++){
			int count = 0;
			for(int j = 0; j < i; j++){
				if(relation[i].equals(relation[j])){
					if(superunit[i].equals(superunit[j])){
						count++;
					}
				}
			}
			int j = 0;
			for(; j < i; j++){
				if(subunit[j].equals(superunit[i])){

					pAddress[i] = pAddress[j];
					sAddress[i] = sAddress[j];
					aCount[i] = count+1;
					if(relation[i].equals("Series")){
						//sAddress[i] = sAddress[i] * 10 + count + 1;
						sAddress[i] = sAddress[i]+(count+1)+".";
					}
					else{
						//pAddress[i] = pAddress[i] * 10 + count + 1;
						pAddress[i] = pAddress[i]+(count+1)+".";
					}
					break;
				}
			}
			if(j == i){
				if(relation[i].equals("Series")){
				
				
					sAddress[i] = "2.";
					pAddress[i] = "1.";
				}
				else{
					sAddress[i] = "1.";
					pAddress[i] = "2.";
				}
				aCount[i] = count+1;
			}

		}
		for(i = 0; i < len; i++){
			String s = "UPDATE `abcd` SET `pAddress`='"+pAddress[i]+"',`sAddress`='"+sAddress[i]+"',`aCount`= "+aCount[i]+" WHERE id = "+(i+1);
			statement  = (PreparedStatement)con.prepareStatement(s);
			statement.execute();


			//System.out.println(pAddress[i]+"\t"+sAddress[i]);	
		}
		//Reliability.calculateReliability(); 
	}

	static String[][] getValues()
	{

		String[][] arr;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reliability","root","");
			//java.sql.Statement stmt = con.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, 
			//      ResultSet.CONCUR_READ_ONLY);
			//    java.sql.ResultSet rslt = stmt.executeQuery("SELECT * FROM abcd");
			String sql ="select `subunit`, `sAddress`, `pAddress`, `isLowest` FROM abcd";
			PreparedStatement statement  = (PreparedStatement)con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);
			try{
				//while (rs.next())
				//System.out.println((rs.getString(1) + " " + rs.getString(2))+" "+rs.getString(3) + " "+rs.getString(3) + " "+rs.getString(4) + " "+rs.getString(5) + " "+rs.getString(6) + " "+rs.getString(7) + " "+rs.getString(8) + " "+rs.getString(9) );

			}
			catch(Exception e){}

			// to get row count and column count
			/////////////////////////////////////
			int rowSize = 0;
			try {
				rs.last();
				rowSize = rs.getRow();
				rs.beforeFirst();
			}
			catch(Exception e) {

			}

			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnSize = rsmd.getColumnCount();

			arr = new String[rowSize][columnSize];

			int i =0;
			while(rs.next() && i<rowSize)
			{
				for(int j=1;j<columnSize;j++){
					arr[i][j] = rs.getString(j+1);
				}
				i++;
			}


			rs.close();
			//stmt.close();
			con.close();

			String[][] Data = new String[arr.length][arr[0].length+2];

			
			for(int u = 0; u<arr.length;u++){
				for(int v=0; v<arr[0].length; v++){

					Data[u][v] = arr[u][v];					
					System.out.print(arr[u][v]+"               ");
				}
				System.out.println();
			}

System.out.println("---------------------------------------");

			for(int u = 0; u<arr.length;u++){
				for(int v=0; v<arr[0].length; v++){

					Data[u][v] = arr[u][v];					
					System.out.print(Data[u][v]+"               ");
				}   
				System.out.println();
			}
			

			for( i=1;i<Data.length;i++){

				if (Data[i][arr[0].length-1].matches("1")){
					
//					System.out.println(i+"sadasd");

					Data[i][arr[0].length]="2000";
					Data[i][arr[0].length+1]="0.2";
					
				}
			}

			System.out.println("---------------------------------------");

			for(int u = 0; u<arr.length;u++){
				for(int v=0; v<arr[0].length+2; v++){

					System.out.print(Data[u][v]+"             ");
				}
				System.out.println();
			}
			System.out.println("------------------------------");
			codeTransfer(Data);
		
		}catch (Exception e) {
		}

		return null;

	}

	  static void codeTransfer(String[][] Data1){

		StringToArray StrToArrObject = new StringToArray();
		String[][] Data = StrToArrObject.getData();
		StrToArrObject.printData(Data);
		System.out.println("------------------------S Address----------------");
		StrToArrObject.getIntSAdd(Data);
		System.out.println("------------------------P Address----------------");
		StrToArrObject.getIntPAdd(Data);
		StrToArrObject.getIntIsLMA(Data);
		StrToArrObject.getDoubleEta(Data);
		StrToArrObject.getDoubleBeta(Data);
		StrToArrObject.calculateRelaibility(StrToArrObject.getDoubleEta(Data), StrToArrObject.getDoubleBeta(Data), StrToArrObject.getIntIsLMA(Data), 5000);


		RelCalcLogic RCLObject = new RelCalcLogic();
		RCLObject.Logic(StrToArrObject);

	  }

}

