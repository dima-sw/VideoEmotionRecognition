import pandas as pd
import numpy as np



def loadCSV(csvFile):
    css=pd.read_csv(csvFile)
    datax=[]
    datay=[]
    tmpx=[]
    tmpy=[]
    indx=-1
    curIndx=-1
    max=-1
    min=9999999
    dimension=0

    curidx=1
    previdx=1
    counter=0

    temp=[]
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

    #dimension=int(sum(temp) / len(temp)) *2

    print(dimension)

    for index, row in css.iterrows():

        if indx==-1:
            indx=row[0]
        curIndx = row[0]
        if indx!=curIndx:

            indx=curIndx
            c = 0
            while len(tmpx)<dimension:
                tmpx.insert(c,[0]*28)
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

            if datax==[]:
                datax=np.asarray([np.asarray(tmpx)])
                datay.append(tmpy[0])
            else:
                datax=np.vstack((datax,np.asarray([np.asarray(tmpx)])))
                datay.append(tmpy[0])
            tmpx=[]
            tmpy=[]



        tmpy.append(row[1])
        tmpx.append(list(row[2:30]))

        if max< np.amax(tmpx):
            max=np.amax(tmpx)
        if min>np.amin(tmpx):
            min=np.amin(tmpx)
    print(max,min)

    datax= np.asarray(datax)

    datay=np.array(datay)

    """min_max_scaler = preprocessing.MinMaxScaler()
    x_scaled = min_max_scaler.fit_transform(datax)
    df = pd.DataFrame(x_scaled)"""
    #datax=preprocessing.normalize(datax)

    norm = np.linalg.norm(datax)
    #for i in range(datax.shape[0]):
    #print(norm,max)
    #datax/=norm
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

