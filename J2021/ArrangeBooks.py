shelf = input()
# A function to count the number of books
def get_count(shelf : str) -> list:
    count = [0, 0, 0]
    for book in shelf:
        if book == 'L':
            count[0] += 1
        elif book == 'M':
            count[1] += 1
        else:
            count[2] += 1
    return count

# Counting the number of Large, Medium and Small books in the shelf
L_total_count, M_total_count, S_total_count= get_count(shelf)

# Counting the number of Large, Medium and Small books in each section
section_L = get_count(shelf[:L_total_count])
section_M = get_count(shelf[L_total_count:L_total_count+M_total_count])
section_S = get_count(shelf[L_total_count+M_total_count:])

# Counting the number of single swap needed
singleSwap = min(section_L[1], section_M[0]) + min(section_L[2],section_S[0]) +min(section_M[2],section_S[1])



# Updating the count of each section after all single swap
s = 0

if section_L[1] < section_M[0]:
    s = section_L[1]
else:
    s = section_M[0]
section_L[1] -= s
section_M[0] -= s
section_L[0] += s
section_M[1] += s

s = 0

if section_L[2] < section_S[0]:
    s = section_L[2]
else:
    s = section_S[0]
section_L[2] -= s
section_S[0] -= s
section_L[0] += s
section_S[2] += s

s = 0

if section_M[2] < section_S[1]:
    s = section_M[2]
else:
    s = section_S[1]
section_M[2] -= s
section_S[1] -= s
section_M[1] += s
section_S[2] += s

# Counting the number of double swap needed

doubleSwap = 2* (section_L[1] + section_L[2])

# Printing the output
print(singleSwap+doubleSwap)
