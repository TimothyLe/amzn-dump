/**

An item is represented as an asterisk ('*' = ascii decimal 42)
A compartment is represented as a pair of pipes that may or may not have items between them ('|' = ascii decimal 124).

Example

s = '|**|*|*'

startIndices = [1, 1]

endIndices = [5, 6]

The string has a total of 2 closed compartments, one with 2 items and one with 1 item. For the first pair of
indices, (1, 5), the substring is '|**|*'. There are 2 items in a compartment.

For the second pair of indices, (1, 6), the substring is '|**|*|' and there are 2 + 1 = 3 items in compartments.

Both of the answers are returned in an array, [2, 3].

Function Description .

Complete the numberOfItems function in the editor below. The function must return an integer array that contains
the results for each of the startIndices[i] and endIndices[i] pairs.

numberOfItems has three parameters:

s: A string to evaluate

startIndices: An integer array, the starting indices.

endIndices: An integer array, the ending indices.

Constraints

1 ≤ m, n ≤ 105
1 ≤ startIndices[i] ≤ endIndices[i] ≤ n
Each character of s is either '*' or '|'

Input Format For Custom Testing

The first line contains a string, S.
The next line contains an integer, n, the number of elements in startIndices.
Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, startIndices[i].
The next line repeats the integer, n, the number of elements in endIndices.
Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, endIndices[i].

Sample Case 0
Sample Input For Custom Testing

STDIN Function

*|*| -> s = "*|*|"

1 -> startIndices[] size n = 1
1 -> startIndices = 1
1 -> endIndices[] size n = 1
3 -> endIndices = 3

** Sample Output**
0

Explanation
s = *|*|

n = 1
startIndices = [1]
n = 1
startIndices = [3]

The substring from index = 1 to index = 3 is '|'. There is no compartments in this string.

Sample Case 1
Sample Input For Custom Testing

STDIN Function

*|*|*| -> s = "*|*|*|"
1 -> startIndices[] size n = 1
1 -> startIndices = 1
1 -> endIndices[] size n = 1
6 -> endIndices = 6

Sample Output
2

Explanation
s = '*|*|*|'
n = 1
startIndices = [1]
n = 1
startIndices = [1]

The substring from index = 1 to index = 6 is '||*|'. There are two compartments in this string at (index = 2,
index = 4) and (index = 4, index = 6). There are 2 items between these compartments.
 */

//TODO: create python version
public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {

    int n = startIndices.size();
    List<Integer> result = new ArrayList<>();
    HashMap<Integer, Integer> sum = new HashMap<>();
    int[] lr = new int[s.length()];
    int curBuffer = 0;
    int curSum = 0;
    int marker = 0;
    boolean open = false;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '|') {
            if(open){
                curSum += curBuffer;
            }
            else{
                open = true;
            }
            marker = i;
            sum.put(i, curSum);
            curBuffer = 0;
        }
        else {
            curBuffer++;
        }
        lr[i] = marker;
    }
    
    open = false;
    marker = s.length() - 1;
    int[] rl = new int[s.length()];
    for (int i = s.length() - 1; i >= 0; i--) {
        char c = s.charAt(i);
        if (c == '|') {
            marker = i;
        }
        rl[i] = marker;
    }

    for (int i = 0; i < n; i++) {
        int start = startIndices.get(i) - 1;
        int end = endIndices.get(i) - 1;
        start = rl[start];
        end = lr[end];

        if(start >= end) {
            result.add(0);
        }
        else {
            result.add(sum.get(end) - sum.get(start));
        }
    }

    return result;
}