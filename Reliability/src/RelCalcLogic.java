import java.util.HashSet;
import java.util.Set;

//import reliabilityCalculation.StringToArray;
//import reliabilityCalculation.SysLvlRelCalc;
public class RelCalcLogic {
	Set<Integer> toBeFilledSet = new HashSet<Integer>();
	Set<Integer> sameLevelSet = new HashSet<Integer>();
	Set<Integer> focusParallelSet = new HashSet<Integer>();
	Set<Integer> focusSeriesSet = new HashSet<Integer>();
	Set<Integer> DNDSet = new HashSet<Integer>();

	SysLvlRelCalc SLRCObject = new SysLvlRelCalc();

	public void Logic(StringToArray Object){

		int levelIterator = Object.maxLevelCount;


		while(levelIterator>0){
			int index=2;
			while(index<=Object.NoOfRows){
				if(Object.intIsLMA[index-1]==0 && Object.intPAdd[index-1][levelIterator-1]!=0){
					toBeFilledSet.add(index);
				}
				index++;
			}

			int index1=2;
			while(index1<=Object.NoOfRows){
				if(Object.intPAdd[index1-1][levelIterator-1]!=0&& toBeFilledSet.contains(index1)==false && DNDSet.contains(index1)==false){
					sameLevelSet.add(index1);
				}
				index1++;
			}

			System.out.println("Set Thory1: "+toBeFilledSet+" | "+sameLevelSet+" | "+focusSeriesSet);
			for(int l=0; l<10; l++){
				System.out.println((l+1)+" | "+Object.intIsLMA[l]+" | "+Object.intrRel[l]);
			}


			
			for(int i: toBeFilledSet){
				int a=0, b=0;

				for(int j: sameLevelSet){

					for(int k = 0; k < levelIterator; k++){

						if(Object.intSAdd[i-1][k] != 0 && Object.intSAdd[j-1][k] != Object.intSAdd[i-1][k]) a=1;
						if(Object.intPAdd[i-1][k] != 0 && Object.intPAdd[j-1][k] != Object.intPAdd[i-1][k]) b=1;

					}
					if(a==0 && b==0){
						focusSeriesSet.add(j);
						DNDSet.add(j);
					}a=0; b=0;
				}

				double[] relsInFocus = new double[focusSeriesSet.size()];
				int count=0;

				for(int v: focusSeriesSet){
					relsInFocus[count]= Object.intrRel[v-1];
					count++;
				}

				Object.intrRel[i-1] = SLRCObject.calcInSeries(relsInFocus);
				Object.intIsLMA[i-1]=1;

				System.out.println("Set Thory Series: "+toBeFilledSet+" | "+sameLevelSet+" | "+focusSeriesSet+" | "+focusParallelSet);
				for(int l=0; l<10; l++){
					System.out.println((l+1)+" | "+Object.intIsLMA[l]+" | "+Object.intrRel[l]);
					}

				focusSeriesSet.removeAll(focusSeriesSet);
			}


			levelIterator--;
			DNDSet.addAll(toBeFilledSet);
			toBeFilledSet.removeAll(toBeFilledSet);
			sameLevelSet.removeAll(sameLevelSet);

		}

	}



}
