class DVDInfo implements Comparable<DVDInfo> {
	String title;
	String genre;
	String leadActor;

	DVDInfo(String t,String g,String l){
		title=t;
		genre=g;
		leadActor=l;
	}
	public int compareTo(DVDInfo d){
		return title.compareTo(d.title);
	}

	public String toString(){
		return title+" "+genre+" "+leadActor+"\n";
	}

}

class DVDInfoTest{
	public static void main(String[] args) {
		DVDInfo d1=new DVDInfo("ZNMD","cool","Farhan Akhtar");
		DVDInfo d2=new DVDInfo("Aie Dil Hai Mushkil","love story","Ranbeer Kapoor");

		if(d1.compareTo(d2)<0)
			System.out.println(d1);
		else
			System.out.println(d2);

	}
}