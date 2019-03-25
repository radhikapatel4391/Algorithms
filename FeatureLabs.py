#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'cacheContents' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts 2D_INTEGER_ARRAY callLogs as parameter.
#

def cacheContents(callLogs):
    timeToItemCountDict, itemPriorityDict,maxTime = createDictionaries(callLogs)   
    dictDefault = {}    
    for time in range(1,maxTime+1):
        itemToCountDict = timeToItemCountDict.get(time,dictDefault) # item with count of calls at a specific time 
        for item in itemPriorityDict:
            # current status of the item
            priority = itemPriorityDict[item][0]
            isInCache = itemPriorityDict[item][1]

            # update the priority of the item
            if item in itemToCountDict:
                priority += 2*itemToCountDict[item]  
            else:    
                priority = max(priority-1, 0)

            # update cache status of the item
            if priority > 5:                    
                isInCache = True
            elif priority <= 3:
                isInCache = False

            # set new status of the item
            itemPriorityDict[item] = [priority, isInCache]

    # find items exist in cache and return
    cacheList = []
    for item in itemPriorityDict:
        if itemPriorityDict[item][1]:
            cacheList +=[item]
    if len(cacheList) == 0:
        return [-1]
    return sorted(cacheList)
'''
create timeToItemCountDict and itemPriorityDict
timeToItemCountDict = {timeStamp : {itemNumber:NoOfcalls}}
itemPriorityDict = {itemNumber:[priority,isInCache]}
'''
def createDictionaries(callLogs):
    timeToItemCountDict = {} #key = time stamp,value = dict{item,count}
    itemPriorityDict = {} # key = item,value = priority
    maxTimeSatmp = 0
    for list in callLogs:
        time = list[0]
        item = list[1]

        #Max time stamp
        if maxTimeSatmp<time:
            maxTimeSatmp = time

        # update itemPriorityDict
        if item not in itemPriorityDict:
            itemPriorityDict[item] = [0,False]

        # update timeToItemCountDict
        if time not in timeToItemCountDict:
            timeToItemCountDict[time] = {item:1}
        else:
            dict = timeToItemCountDict[time]
            if item in dict:
                dict[item] +=1
            else:
                dict[item] = 1
            timeToItemCountDict[time] = dict
    return timeToItemCountDict,itemPriorityDict,maxTimeSatmp

if __name__ == '__main__':