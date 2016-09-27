
public class SysLvlRelCalc {
	public double calcInSeries(double[] relsInFocus){
		double outRel = 1;
		int validity = 1;
		for(int i= 0; i<relsInFocus.length; i++){
			if(relsInFocus[i]>1||relsInFocus[i]<0){
				System.out.println("Invalid Reliability Value. Reliability value should be between 0 and 1.");
				validity = 0;
			};
		}

		if(validity == 1){
			for(int i= 0; i<relsInFocus.length; i++){
				outRel = outRel*relsInFocus[i];	
			}
		}
		
		else outRel = 0; 
			
			return outRel;

	}


	public double calcInParallel(double[] relsInFocus){
		double outRel = 1;
		int validity = 1;
		for(int i= 0; i<relsInFocus.length; i++){
			if(relsInFocus[i]>1||relsInFocus[i]<0){
				System.out.println("Invalid Reliability Value. Reliability value should be between 0 and 1.");
				validity = 0;
			};
		}

		if(validity == 1){
			for(int i= 0; i<relsInFocus.length; i++){
				outRel = outRel*(1-relsInFocus[i]);	
			}
		}
		
		else outRel = 1; 
		
		return (1-outRel);
	}
	
}
