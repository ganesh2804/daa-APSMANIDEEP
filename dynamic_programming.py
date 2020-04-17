# Python program to find maximum length of
# Snake sequence and print it 

M = 4
N = 4

class Point: 
	def __init__(self, x, y): 
		self.x = x 
		self.y = y 


def findPath(grid, mat, i, j): 
	path = list() 

	pt = Point(i, j) 
	path.append(pt) 

	while (grid[i][j] != 0): 
		if (i > 0 and grid[i][j]-1 == grid[i-1][j]): 
			pt = Point(i-1, j) 
			path.append(pt) 
			i -= 1
		elif (j > 0 and grid[i][j]-1 == grid[i][j-1]): 
			pt = Point(i, j-1) 
			path.append(pt) 
			j -= 1
	return path 


def findSnakeSequence(mat): 

	lookup = [[0 for i in range(N)] for j in range(M)] 

	
	max_len = 0
	max_row = 0
	max_col = 0

	for i in range(M): 
		for j in range(N): 
			if (i or j): 
				if (i > 0 and
					abs(mat[i-1][j] - mat[i][j]) == 1): 
					lookup[i][j] = max(lookup[i][j], 
									lookup[i-1][j] + 1) 
					if (max_len < lookup[i][j]): 
						max_len = lookup[i][j] 
						max_row = i 
						max_col = j 

				if (j > 0 and
					abs(mat[i][j-1] - mat[i][j]) == 1): 
					lookup[i][j] = max(lookup[i][j], 
									lookup[i][j-1] + 1) 
					if (max_len < lookup[i][j]): 
						max_len = lookup[i][j] 
						max_row = i 
						max_col = j 

	print("Maximum length of Snake sequence is:", max_len) 

	path = findPath(lookup, mat, max_row, max_col) 

	print("Snake sequence is:") 
	for ele in reversed(path): 
		print(mat[ele.x][ele.y], 
			" (", ele.x, ", ", ele.y, ")", sep = "") 

mat = [[9, 6, 5, 2], 
	[8, 7, 6, 5], 
	[7, 3, 1, 6], 
	[1, 1, 1, 7]] 

findSnakeSequence(mat) 
