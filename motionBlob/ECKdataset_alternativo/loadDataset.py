import pandas as pd
import numpy as np
import csv


def loadCSV(csvFile,shape):

    css=pd.read_csv(csvFile)
    datax=[]
    datay=[]
    tmpx=[]
    tmpy=[]
    frame_indx=-1
    vid_indx=-1
    curIndx=-1
    max=-1
    min=9999999
    dimension=0


    previdx=1
    counter=0

    temp=[]

    video=[]
    dataset=[]
    for index, row in css.iterrows():

        curidx=row[0]
        if(curidx!=previdx):
            temp.append(counter)
            if(counter>dimension):
                dimension=counter
                ii=index
            previdx=curidx
            counter=0
        counter+=1


    dimension/=shape
    print(dimension)
    ds=0
    with open(csvFile) as file:
        reader = csv.reader(file)
        for row in reader:

            if frame_indx==-1:
                frame_indx=row[1]
                vid_indx=row[0]
            cur_vidIndx = row[0]
            cur_frameIndx=row[1]

            if frame_indx!=cur_frameIndx:

                frame_indx=curIndx
                video.append(tmpx)

                tmpx=[]



            if cur_vidIndx!=vid_indx:
                vid_indx=cur_vidIndx
                c = 0
                my_matrix = [([0.0] * shape) for i in range(shape)]

                while len(video)<dimension:
                    video.insert(c,my_matrix)
                    if (c == 0):
                        c = -1
                    else:
                        c = 0
                c=0
                while len(tmpx)>dimension:

                    tmpx.pop(c)
                    if(c==0):
                        c=-1
                    else:
                        c=0
                dataset.append(video)
                datay.append(tmpy)
                video=[]
                ds += 1
                print(ds)


            tmpy=float(row[2])

            row2=[float(item) for item in row[3:shape+3]]

            tmpx.append(row2)

            if max< np.amax(tmpx):
                max=np.amax(tmpx)
            if min>np.amin(tmpx):
                min=np.amin(tmpx)
    print(max,min)
    #print(dataset)
    datax= np.array(dataset)
    print(datax)
    print(np.array(datax[0][0][0]))
    print(len(dataset[0][0][0]), len(dataset[1][0][0]),len(dataset[0][1][0]))

    datay=np.array(datay)

    datax= (datax-min)/(max-min)
    print(datax)
    return datax,datay

def parseCSV(X, Y, percentage=0.7,percentage2=0.3, random_state=1):
    # Defining a fixed random seed
    np.random.seed(random_state)

    # Checks if `X` and `Y` have the same size
    if X.shape[0] != Y.shape[0]:
        exit(-1)

    # Gathering the indexes
    idx = np.random.permutation(X.shape[0])
    print(X.shape)
    # Calculating where sets should be halted
    halt = int(len(X) * percentage)
    halt2 = int(len(X) * percentage2)
    # Gathering two new sets from `X`
    X_1, X_2 = X[idx[:halt], :], X[idx[halt:halt + halt2], :]

    # Gathering two new sets from `Y`
    Y_1, Y_2 = Y[idx[:halt]], Y[idx[halt:halt + halt2]]

    return X_1, X_2, Y_1, Y_2

