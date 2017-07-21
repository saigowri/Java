public class Map-Filter-Reduce-Implementation {

	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5};
		Integer[] newarray = MyMap.map(new MapFunction(){
			public Integer executeMap(Integer n){
				return 2*n;
			}
		}, arr);
		System.out.println("Double value of elements:");
		for(Integer n : newarray)
			System.out.println(n);
		Integer[] newarray1 = MyFilter.filter(new FilterFunction(){
			public Integer[] executeFilter(Integer[] n){
				int j = 0;
				Integer[] arr = new Integer[n.length];
				for(int i=0;i<n.length;i++){
					if(n[i]%2==1){
						arr[j] = n[i];
						j++;
					}
				}
				return arr;
			}
		}, arr);
		System.out.println("Filtered odd elements:");
		for(Integer n : newarray1){
			if(n!=null)
				System.out.println(n);
		}
		int acc = 5;
		System.out.println("Reduced sum with accumulator "+acc+" is "+ MyReduce.reduce(acc,new ReduceFunction(){
			public Integer executeReduce(Integer acc, Integer[] n){
				int sum = acc;
				for(int i=0;i<n.length;i++)
					sum+=n[i];
				return sum;
			}
		}, arr));
	}
}

interface MapFunction {
	public Integer executeMap(Integer n);
}

interface FilterFunction {
	public Integer[] executeFilter(Integer[] n);
}

interface ReduceFunction {
	public Integer executeReduce(Integer acc, Integer[] n);
}

class MyMap {
	public static Integer[] map(MapFunction f, Integer[] arr){
		Integer[] newarr = new Integer[arr.length];
		for(int i=0; i<arr.length; i++){
			newarr[i] = f.executeMap(arr[i]);
		}
		return newarr;
	}
}

class MyFilter {
	public static Integer[] filter(FilterFunction f, Integer[] arr){
		return f.executeFilter(arr);
	}
}

class MyReduce {
	public static Integer reduce(Integer acc, ReduceFunction f, Integer[] arr){
		return f.executeReduce(acc, arr);
	}
}
