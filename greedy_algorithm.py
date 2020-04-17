n = int(input("Enter n(size of both the strings): "))
s = input("Enter the string s: ")
t = input("Enter the string t: ")

def func(g):
    x = ord(g[0])
    y = ord(g[1])

    return min((y-x)%26, (y-(x+13)%26)%26+1)

print(sum(map(func,zip(s,t))),"DAYS")