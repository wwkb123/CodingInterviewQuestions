import Queue as queue
def answer(l):
    l.sort()
    q0 = queue.Queue()
    q1 = queue.Queue()
    q2 = queue.Queue()
    sum = 0
    for num in l:
        sum = sum + num
        if(num%3==0):
            q0.put(num)  #remainder is 0
        elif(num%3==1):
            q1.put(num)  #remainder is 1
        else:
            q2.put(num)  #remainder is 2

if(sum%3==1):
    # remove one number whose remainder is 1, so the new sum%3 == 0
    if(not q1.empty()):
        q1.get()
        else:
            # remove two numbers whose remainders are 2, so the new sum%3 == 0
            if(not q2.empty()):
                q2.get()
            else:
                return 0
            if(not q2.empty()):
                q2.get()
            else:
                return 0

elif(sum%3==2):
    # remove one number whose remainders is 2, so the new sum%3 == 0
    if(not q2.empty()):
        q2.get()
        else:
            # remove two numbers whose remainders are 1, so the new sum%3 == 0
            if(not q1.empty()):
                q1.get()
            else:
                return 0
            if(not q1.empty()):
                q1.get()
            else:
                return 0
    l = []
    while(not q0.empty()):
        l.append(q0.get())
while(not q1.empty()):
    l.append(q1.get())
    while(not q2.empty()):
        l.append(q2.get())
l.sort() #sort the array
l = l[::-1] #reverse the array
if(l == []):
    return 0
    else:
        result = ''.join(map(str, l))
        return int(result) #concatenate the reversed array and return it
