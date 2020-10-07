"""
Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
"""


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board,i,j,0,word):
                    return True
        return False
    
    def dfs(self,board,i,j,count,word):
        # Already found all letters of word
        if count == len(word):
            return True
        
        # Marker stepped out of bounds
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[i]) or board[i][j] != word[count]:
            return False
        
        # Move and mark empty char as visited
        temp = board[i][j]
        board[i][j] = ' '
        
        # recursively move to all neighboring indices
        found = self.dfs(board,i+1,j,count+1,word) \
            or self.dfs(board,i-1,j,count+1,word) \
            or self.dfs(board,i,j+1,count+1,word) \
            or self.dfs(board,i,j-1,count+1,word)
        
        # restore board index
        board[i][j] = temp
        return found
        