"""
Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not amount:
            return 0
        if max(coins) < amount and len(coins) < 2 and amount % max(coins):
            return -1
        
        dp = [10000] * (amount+1)
        # print(dp)
        dp[0] = 0
        for i in range(1, amount+1):
            if i == amount:
                print(dp)
            for c in coins:
                if 0 <= i-c < amount+1:
                    dp[i] = min(dp[i], dp[i-c]+1)
        # print(dp)
        return dp[-1] if dp[-1] != 10000 else -1