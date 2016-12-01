class Temp {
	public static void main(String[] args) {
		int sizeEstimate=14;
		int finalSize=0;
		LOOP:
		for(int i=sizeEstimate;;i++){
			
			for(int j=2;j<Math.sqrt(i);j++){
				System.out.println("i "+i+" j "+j+" sqrt(i) "+Math.sqrt(i)+" "+(j<Math.sqrt(i)));
				if((i%j)==0)
					continue LOOP;
			}
			System.out.println();
			finalSize=i;
			break;
		}

		System.out.println(finalSize);
	}
}