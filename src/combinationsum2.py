"""
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
"""

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        # DP approach        
                
        candidates.sort()
        result = []
        self.findComb(candidates, target, [], result)
        return result
    
    def findComb(self,candidates,target,curr,result):
        # print(curr)
        # add combination found
        if target == 0:
            # print(curr)
            result.append(curr[:])
            return

        # nothing to add
        if target < 0:
            return

        for i in range(len(candidates)):
            if i > 0 and candidates[i] == candidates[i-1]:
                continue

            if target-candidates[i] < 0 :
                break

            curr.append(candidates[i])
            # recursive call to reduce target
            self.findComb(candidates[i+1:],target - candidates[i],curr,result)
            curr.pop()