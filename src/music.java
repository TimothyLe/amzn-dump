/**
Example

n = 3

songs = [37, 23, 60]
One pair of songs can be chosen whose combined duration is a multiple of a whole minute (37 + 23 = 60) and the
return value would be 1. While the third song is a single minute long, songs must be chosen in pairs.
Function Description

Complete the function getSongPairCount in the editor below.

getSongPairCount has the following parameter:

int songs[n]: array of integers representing song durations in seconds

Returns:

long: the total number of songs pairs that add up to a multiple of 60 seconds. If there are no suitable pairs,
return 0.

Constraints

1 ≤ n ≤ 105
1 ≤ songs[i] ≤ 1000, where 0 ≤ i < n

Input Format For Custom Testing
Input from stdin will be processed as follows and passed to the function.

The first line contains an integer, n, that denotes the number of elements in songs.

The next n lines each contain an integer that describes songs[i] and denotes the duration of the ith song
(in seconds).

Sample Case 0
Sample Input For Custom Testing

STDIN Function

4 -> songs[] size n = 4
10 -> songs = [10, 50, 90, 30]
50
90
30
Sample Output

2
Explanation

The first and second songs pair to 60 seconds. The third and fourth songs pair to 120 seconds. No other pairs
will satisfy the requirement.

Sample Case 1
Sample Input For Custom Testing

STDIN Function

5 -> songs[] size n = 5
30 -> songs = [30, 20, 150, 100, 40]
20
150
100
40
Sample Output

3
Explanation

There are three pairs of songs whose whole duration is a multiple of a whole minute. They are 20 + 100, 30 + 150,
and 20 + 40 corresponding to (1, 3), (0, 2) and (1, 4).

Sample Case 2
Sample Input For Custom Testing

STDIN Function

3 -> songs[] size n = 3
60 -> songs = [60, 60, 60]
60
60
Sample Output

3
Explanation

There are three pairs of songs that end in whole minutes. They are (0, 1), (1, 2) and (0, 2).
*/

//TODO: create python version
public static void main(String[] args) {
	int[] nums1 = { 37, 23, 60 };
	int[] nums2 = { 10, 50, 90, 30 };
	int[] nums3 = { 30, 20, 150, 100, 40 };
	int[] nums4 = { 60, 60, 60 };
	System.out.println(solve(nums1));
	System.out.println(solve(nums2));
	System.out.println(solve(nums3));
	System.out.println(solve(nums4));
}

private static int solve(int[] nums) {
	Map<Integer, Integer> map = new HashMap<>();
	int res = 0;
	for(int n : nums) {
		n = n%60;
		if(map.containsKey(60 - n == 60 ? 0 : 60 - n))
			res += map.get(60 - n == 60 ? 0 : 60 - n);
		map.put(n, map.getOrDefault(n, 0) + 1);
	}
	return res;
}