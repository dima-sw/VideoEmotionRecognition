import cv2
import numpy as np
import dlib
import os
from os.path import isfile, join
from os import listdir
import numpy as np
import math
import csv
import time

#Path della cartella delle immagini
imgPath=r"C:\Users\TheDimitri\Desktop\imgDataset\\"
#Path della cartella delle emozioni
labelPath=r"C:\Users\TheDimitri\Desktop\Emotion"


#68 15 quanti landmark predice il nostro predictor
n_points=15
#34 6 dove si trova la punta del naso (se il nostor predictor fa il predict dei 68 punti allora la punta del naso stara' alla posizione 34
#invece se utilizziamo il nostro custom predictor che fa il predict di 15 landmark allora la punta del naso stara' alla posizione 6
joint_point=6

#Nomi delle cartelle che contengono le label o frame di video
cartelle=[r"\001",r"\002",r"\003",r"\004",r"\005",r"\006",r"\007",r"\008",r"\009"]

#Path del nostro custom predictor
p = r'C:\Users\TheDimitri\Desktop\VideoEmotionRecognition\FacialPoints\customDlibPredictor\essential_predictor.dat'
#Detector di dlib
detector = dlib.get_frontal_face_detector()
#predictor
predictor = dlib.shape_predictor(p)
#dataSet
dataSet=[]

"""Crea il dataset tenendo conto per ogni frame le coordinate (x,y) di ogni landmark"""
def makeXY():
    """Queste variabili serviranno per tenere traccia della % di progresso"""
    outDirs = 123
    curDirs = 0
    curDirr = ""
    images = 0
    index = 0

    t1 = time.time()
    # Per ogni file di ogni sottocartella della cartella delle label
    for subdir, dirs, files in os.walk(labelPath):
        # Se ci troviamo in una cartella che possa contenere il file txt delle emozioni (scartando le altre cartelle)
        if (subdir[len(subdir) - 4:] in cartelle):
            # Se ci sta al meno un File
            if (len(files) > 0):
                # Se il File e' txt
                if (files[0].endswith(".txt")):
                    # Apro il file
                    with open(os.path.join(subdir, files[0])) as f:
                        # Estraggo la label
                        label = int(f.readline().strip()[0])
                        # Prendo la cartella del video alla quale la label si riferisce
                        imagesPath = imgPath + subdir[len(subdir) - 9:]
                        # Prendo tutti i nomi dei file dei frame del video
                        onlyfiles = [f for f in listdir(imagesPath) if isfile(join(imagesPath, f))]
                        # Prendo il nome della cartella
                        curDir = subdir[len(subdir) - 9:]
                        # Creo il percorso per la cartella corrente del video
                        targetDir = imgPath + curDir

                        #Per ogni frame del video
                        for i in range(len(onlyfiles)):
                            #Estraggo i punti dei landmark del video
                            im1 = getPoints(targetDir, onlyfiles[i])
                            #Creo il numpyArray per la riga del dataset
                            diff = np.empty((len(im1)*2) + 2)
                            #in posizione 0 troviamo l'index
                            diff[0] = index
                            #in posizione 1 troviamo la label
                            diff[1] = label
                            #indice
                            ccount=2
                            #per ogni landmark
                            for k in range(len(im1)):
                                #aggiungo il valore di x del punto corrente
                                diff[ccount]=im1[k][0]
                                #aggiungo il valore di y del punto corrente
                                diff[ccount+1]=im1[k][1]
                                ccount+=2



                            images += 1


                            #Aggiungo la riga al dataset
                            dataSet.append(diff)



                    index += 1
        #Serve per aggiornare la % del progresso
        if (subdir[len(subdir) - 8] == "S" and subdir[len(subdir) - 8:len(subdir) - 4] != curDirr):
            curDirs += 1
            curDirr = subdir[len(subdir) - 8:len(subdir) - 4]

            print("imaggini processate: ", images, " in ", time.time() - t1)
            print(curDirs / outDirs)
            print(subdir)
    #Creo il file del dataset
    with open('ECKxyFrame.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerows(dataSet)



"""Crea il dataset calcolando le distanze che hanno i punti dei landmark frame per frame"""

def make():
    """Queste variabili serviranno per tenere traccia della % di progresso"""
    outDirs = 123
    curDirs = 0
    curDirr = ""
    images=0
    index = 0
    t1=time.time()

    #Per ogni file di ogni sottocartella della cartella delle label
    for subdir, dirs, files in os.walk(labelPath):
        #Se ci troviamo in una cartella che possa contenere il file txt delle emozioni (scartando le altre cartelle)
        if(subdir[len(subdir)-4:] in cartelle):
            #Se ci sta al meno un File
            if(len(files)>0):
                #Se il File e' txt
                if(files[0].endswith(".txt")):

                    #Apro il file
                    with open(os.path.join(subdir,files[0])) as f:
                        #Estraggo la label
                        label=int(f.readline().strip()[0])
                        #Prendo la cartella del video alla quale la label si riferisce
                        imagesPath=imgPath+subdir[len(subdir)-9:]
                        #prendo tutti i nomi dei file dei frame del video
                        onlyfiles = [f for f in listdir(imagesPath) if isfile(join(imagesPath, f))]
                        #Prendo il nome della cartella
                        curDir=subdir[len(subdir) - 9:]
                        #Creo il percorso per la cartella corrente del video
                        targetDir=imgPath+curDir
                        #Prendo i punti della prima immagine
                        im1 = getPoints(targetDir, onlyfiles[0])
                        images+=1
                        #Itero per i restanti frame
                        for i in range(len(onlyfiles)-1):
                            #Creo il numpy Array diff che conterrà la prima o successiva riga del dataset
                            diff = np.empty(len(im1)+2)
                            #la posizione 0 sara' per l'indice
                            diff[0]=index
                            #la posizione 1 sara' per la label
                            diff[1]=label
                            #prendo i punti del frame successivo
                            im2=getPoints(targetDir,onlyfiles[i+1])

                            images+=1
                            #calcolo la distanza dei punti dei landmark dei due frame
                            distance(im1,im2,len(im1),diff)


                            #Immagine 1 contera' ora l'ultimo frame da cui abbiamo estratto i landmark
                            im1=im2
                            #appendo la riga alla lista del dataset
                            dataSet.append(diff)



                    index+=1
        #Questo serve solamente per tenere traccia della %
        if (subdir[len(subdir) - 8] == "S" and subdir[len(subdir) - 8:len(subdir) - 4] != curDirr):


            curDirs += 1
            curDirr = subdir[len(subdir) - 8:len(subdir) - 4]

            print("imaggini processate: ", images, " in ", time.time()-t1)
            print(curDirs / outDirs)
            print(subdir)


    #Creo ora il dataset
    with open('ECKdistanceFrame68.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerows(dataSet)



"""Questa funzione prende in input la sottocartella e il file e restituisce i landmark di quel file"""
def getPoints(subdir, file):
    #Conterra' i punti dei landmark
    landmarksPoints = []
    #leggo l'immagine
    img = cv2.imread(os.path.join(subdir, file))
    #la trasformo in scala di grigio
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)


    #trovo il volto
    faces = detector(img_gray)
    #faccio il predict dei landmark
    landmarks = predictor(img_gray, faces[0])

    #prendo i valori della x e della y della punta del naso
    mx=landmarks.part(joint_point).x
    my=landmarks.part(joint_point).y

    #Per i restanti landmark (tranne la punta del naso)
    for n in range(n_points):
        if(n!=joint_point):
            #mi prendo la x e la y del punto e ci sottraggo il valore della x e della y della punta del naso
            x = landmarks.part(n).x -mx
            y = landmarks.part(n).y -my
            #aggiungo (x,y) al dataset
            landmarksPoints.append((x, y))
    #Trasformo tutto in numpyArray
    points = np.array(landmarksPoints, np.int32)

    return points

#Calcolo la distanza dei punti dei landmark del primo frame e del secondo
def distance(p0,p1,lun,diff):
    for i in range(lun):
        diff[i+2]=square(p0[i],p1[i])



#il calcolo effettivo della distanza teorema di pitagora
def square(p0,p1):
    return math.sqrt((p0[0] - p1[0]) ** 2 + (p0[1] - p1[1]) ** 2)






makeXY()

