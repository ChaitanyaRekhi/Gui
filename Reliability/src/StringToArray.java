
public class StringToArray {
	int NoOfRows, NoOfColumns, maxLevelCount;
	int[][] intSAdd;;
	int[][] intPAdd;
	int[] intIsLMA;
	double[] intrRel;

	
	
	public String[][] getData(){
 
		String[][] Data = {{"System", "0.",   "1.",   "0", "",      ""}, 
							{"1",     "1.",   "1.",   "1", "10000", "2.5"},
							{"2",     "2.",   "1.",   "1", "10000", "2.5"},
							{"A",     "3.",   "1.",   "0", "",      ""},
							{"B",     "3.",   "1.1.", "0", "",      ""},
							{"3",     "3.1.", "1.1.", "1", "15000", "2.5"},
							{"4",     "3.2.", "1.1.", "1", "12000", "2.5"},
							{"C",     "3.",   "1.2.", "0", "",      ""},
							{"5",     "3.1.", "1.2.", "1", "12000", "2.5"},
							{"6",     "3.2.", "1.2.", "1", "10000", "2.5"}}; 

		
//		String[][] Data = { 
//				{"1",     "1.",   "1.",   "1", "10000", "2.5"},
//				{"A",     "2.",   "1.",   "0", "",      ""},
//				{"B",     "2.",   "1.1.", "0", "",      ""},
//				{"2",     "2.1",   "1.1.", "1", "15000", "2.5"},
//				{"3",     "2.2.", "1.1.", "1", "12000", "2.5"},
//				{"C",     "2.", "1.2.", "0", "",      ""},
//				{"5",     "2.1.", "1.2.", "1", "12000", "2.5"},
//				{"6",     "2.2.", "1.2.", "1", "10000", "2.5"}}; 

		
		NoOfRows = Data.length;
		NoOfColumns = Data[0].length;
		
		return Data;
	}





	public void printData(String[][] Data){

		for(int i = 0 ; i<Data.length; i++){
			for(int j = 0 ; j<Data[0].length; j++){
				System.out.print(Data[i][j]+"\t\t");		
			}
			System.out.println();
		}
		//		System.out.println("Data.length: "+ Data.length);
		//		System.out.println("Data[0].length: "+ Data[0].length);
	}






	public int[][] getIntSAdd(String[][] Data){

		maxLevelCount = 0;
		for(int i=0; i<Data.length; i++){

			int j = 0; char charInFocus;
			int levelCount = 0;

			charInFocus = Data[i][1].charAt(0);		//1 should be the position of series address in data; 2 should be the parallel address in data. 
			while(j<Data[i][1].length()){
				charInFocus = Data[i][1].charAt(j);
				if (charInFocus == '.'){
					levelCount++;
				}
				j++;
			}

			if(levelCount > maxLevelCount){
				maxLevelCount = levelCount;
			}
		}
				System.out.println("maxLevelCount: "+maxLevelCount);

		int startIndex, endIndex, j, k;
		intSAdd = new int[NoOfRows][maxLevelCount];
		
		for(int i = 0; i<Data.length; i++){

			startIndex=0;
			k=0; j=0;
			String subStringInFocus;

			while(k<Data[i][1].length()){

				if(Data[i][1].charAt(k)=='.'){
					endIndex=k;
					subStringInFocus = Data[i][1].substring(startIndex, endIndex);
					intSAdd[i][j] = Integer.parseInt(subStringInFocus);
					startIndex=k+1;
					j++;
				}
				k++;
			}
		}

//		for(int i = 0 ; i<Data.length; i++){
//			for(int n = 0 ; n<maxLevelCount; n++){
//				System.out.print(intSAdd[i][n]+"\t");
//			}
//			System.out.println();
//		}
		return intSAdd;
	}






	public int[][] getIntPAdd(String[][] Data){

		int maxLevelCount = 0;
		for(int i=0; i<Data.length; i++){

			int j = 0; char charInFocus;
			int levelCount = 0;

			charInFocus = Data[i][2].charAt(0);		//1 should be the position of series address in data; 2 should be the parallel address in data. 
			while(j<Data[i][2].length()){
				charInFocus = Data[i][2].charAt(j);
				if (charInFocus == '.'){
					levelCount++;
				}
				j++;
			}

			if(levelCount > maxLevelCount){
				maxLevelCount = levelCount;
			}
		}
		//		System.out.println("maxLevelCount: "+maxLevelCount);

		int startIndex, endIndex, j, k;
		intPAdd = new int[NoOfRows][maxLevelCount];
		
		for(int i = 0; i<Data.length; i++){

			startIndex=0;
			k=0; j=0;
			String subStringInFocus;

			while(k<Data[i][2].length()){

				if(Data[i][2].charAt(k)=='.'){
					endIndex=k;
					subStringInFocus = Data[i][2].substring(startIndex, endIndex);
					intPAdd[i][j] = Integer.parseInt(subStringInFocus);
					startIndex=k+1;
					j++;
				}
				k++;
			}
		}

//		for(int i = 0 ; i<Data.length; i++){
//			for(int n = 0 ; n<maxLevelCount; n++){
//				System.out.print(intPAdd[i][n]+"\t");
//			}
//			System.out.println();
//		}
		return intPAdd;
	}



	public int[] getIntIsLMA(String[][] Data){
		intIsLMA = new int[NoOfRows];
		for(int i = 0; i<Data.length; i++){
			intIsLMA[i] = Integer.parseInt(Data[i][3]);				
		}
		return intIsLMA;
	}





	public double[] getDoubleEta(String[][] Data) {

		double[] doubleEta = new double[Data.length];

		for(int i = 0; i<Data.length; i++){
			if(Data[i][4].isEmpty()==false){
				doubleEta[i] = Double.parseDouble(Data[i][4]);
			}
		}
		return doubleEta;
	}





	public double[] getDoubleBeta(String[][] Data) {

		double[] doubleBeta = new double[Data.length];

		for(int i = 0; i<Data.length; i++){
			if(Data[i][5].isEmpty()==false){
				doubleBeta[i] = Double.parseDouble(Data[i][5]);				
			}
		}
		return doubleBeta;
	}

	
	
	
	public double[] calculateRelaibility(double[] doubleEta, double[] doubleBeta, int[] intIsLMA, double time){

		intrRel = new double[NoOfRows];

		for(int i=0; i<doubleEta.length; i++){
		
			if(intIsLMA[i]==1){
			intrRel[i] = Math.pow(Math.E, (-1)*(Math.pow((time/doubleEta[i]), doubleBeta[i])));
			}
						
		}
		
		return intrRel;

	}

}
