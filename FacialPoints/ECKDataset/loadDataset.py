import pandas as pd
import numpy as np

from sklearn import preprocessing

def loadCSV(csvFile):
    css=pd.read_csv(csvFile)
    datax=[]
    datay=[]
    for index, row in css.iterrows():
        datay.append(row[0])
        datax.append(row[1:15])
    datax= np.array(datax)
    datay=np.array(datay)

    min_max_scaler = preprocessing.MinMaxScaler()
    x_scaled = min_max_scaler.fit_transform(datax)
    df = pd.DataFrame(x_scaled)

    datax/=np.amax(datax)

    return datax,datay

def parseCSV(X, Y, percentage=0.8,percentage2=0.2, random_state=1):
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

