import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author thejussinghj
 *
 */
public class AllSubsets {

	public static List<List<Integer>> subset(int[] nums){
		List<List<Integer>> finalList = new ArrayList<>();
		computeSubset(0, nums, new ArrayList<Integer>(), finalList);
		return finalList;
	}
	private static void computeSubset(int i, int[] nums, ArrayList<Integer> arrayList, List<List<Integer>> finalList) {
		if(i == nums.length){
			finalList.add(new ArrayList<>(arrayList));
			return;
		}
		else{
			computeSubset(i+1, nums, arrayList, finalList);
			arrayList.add(nums[i]);
			computeSubset(i+1, nums, arrayList, finalList);
			int index = arrayList.indexOf(nums[i]);
			arrayList.remove(index);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2, 3, 4, 5};
		System.out.println(subset(nums));
	}

}
