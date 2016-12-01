import java.util.*;

class BinaryHeap {
	int[] arr;
	int count=0;

	public BinaryHeap(){
		arr =new int[]{0,9,4,7,2,8,2,6,0,0,0,0,0,0,0,0,0,0};
		count=7;
	}
	public BinaryHeap(int c){
		arr=new int[c];
	}

	public int removeMin(){
		int min=arr[1];
		arr[1]=arr[count];
		count--;
		int i=1;

		while((2*i)<=count){
			int left=2*i;
			int right=(2*i)+1;
			boolean flag=false;
			if(right<=count){
				if(arr[left]<=arr[right] && arr[left]<=arr[i]){
					int temp=arr[left];
					arr[left]=arr[i];
					arr[i]=temp;
					flag=true;
					i=left;
				}
				else if(arr[right]<=arr[left] && arr[right]<=arr[i]){
					int temp=arr[right];
					arr[right]=arr[i];
					arr[i]=temp;
					flag=true;
					i=right;
				}
			}
			else{
				if(arr[left]<=arr[i]){
					int temp=arr[left];
					arr[left]=arr[i];
					arr[i]=temp;
					flag=true;
					i=left;
				}
			}
			if(flag==false){
				break;
			}
		}

		return min;

	}

	public void heapify(int i){
		while(2*i<=count){
			int left=2*i;
			int right=(2*i)+1;
			boolean flag=false;
			if(right<=count){//right exists
				if(arr[left]<=arr[right] && arr[left]<=arr[i]){
					int temp=arr[left];
					arr[left]=arr[i];
					arr[i]=temp;
					i=left;
					flag=true;
				}
				else if(arr[right]<=arr[left] && arr[right]<=arr[i]){
					int temp=arr[right];
					arr[right]=arr[i];
					arr[i]=temp;
					i=right;
					flag=true;
				}
			}else{//only left
				if(arr[left]<=arr[i]){
					int temp=arr[left];
					arr[left]=arr[i];
					arr[i]=temp;
					flag=true;
					i=left;
				}
			}
			if(flag=false)
				break;
		}
	}

	public void bottomUpHeap(){
		int i=count/2;

		while(i>0){
			heapify(i);
			i--;
		}
	}

	public void insert(int item){
		//System.out.println(count);
		arr[++count]=item;
		//print(arr);
		int i=count;
		while(i>0){
			if(arr[i]<arr[i/2]){
				int temp=arr[i];
				arr[i]=arr[i/2];
				arr[i/2]=temp;
				i=i/2;
			}
			else
				break;
		}
	}

	public void print(){
		for (int i=1; i<=count;i++ ) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

class HeadTest {
	public static void main(String[] args) {
		BinaryHeap heap1=new BinaryHeap(20);

		System.out.println("Heap1:");
		heap1.insert(3);
		heap1.insert(5);
		heap1.insert(4);
		heap1.insert(9);
		heap1.insert(6);
		heap1.insert(11);
		heap1.insert(8);
		heap1.insert(17);
		heap1.insert(10);

		
		heap1.print();

		System.out.println("printing removeMin:");
		while(heap1.count!=0){
			System.out.print(heap1.removeMin()+" ");
		}
		System.out.println("\nHeap 2:");
		BinaryHeap heap2=new BinaryHeap();
		heap2.print();

		heap2.bottomUpHeap();

		heap2.print();
		System.out.println("printing removeMin:");
		while(heap2.count!=0){
			System.out.print(heap2.removeMin()+" ");
		}
		
		
	}

	
}