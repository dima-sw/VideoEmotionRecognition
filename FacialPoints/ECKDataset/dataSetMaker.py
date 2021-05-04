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
from numba import njit,prange, set_num_threads

imgPath=r"C:\Users\TheDimitri\Desktop\imgDataset\\"
labelPath=r"C:\Users\TheDimitri\Desktop\Emotion"
#68 15
n_points=15
#34 6
joint_point=6

cartelle=[r"\001",r"\002",r"\003",r"\004",r"\005",r"\006",r"\007",r"\008",r"\009"]
p = r'C:\Users\TheDimitri\Desktop\VideoEmotionRecognition\FacialPoints\customDlibPredictor\essential_predictor.dat'
detector = dlib.get_frontal_face_detector()
predictor = dlib.shape_predictor(p)
dataSet=[]

def makeXY():
    outDirs = 123
    curDirs = 0
    curDirr = ""
    images = 0
    index = 0
    t1 = time.time()
    for subdir, dirs, files in os.walk(labelPath):
        if (subdir[len(subdir) - 4:] in cartelle):
            if (len(files) > 0):
                if (files[0].endswith(".txt")):
                    with open(os.path.join(subdir, files[0])) as f:
                        label = int(f.readline().strip()[0])

                        imagesPath = imgPath + subdir[len(subdir) - 9:]
                        onlyfiles = [f for f in listdir(imagesPath) if isfile(join(imagesPath, f))]

                        curDir = subdir[len(subdir) - 9:]
                        targetDir = imgPath + curDir
                        #im1 = getPoints(targetDir, onlyfiles[0])
                        #images += 1
                        #diff = np.empty(len(im1) + 2)
                        #diff[0] = index
                        #diff[1] = label
                        #diff[2:]=im1[:]

                        for i in range(len(onlyfiles)):
                            im1 = getPoints(targetDir, onlyfiles[i])
                            diff = np.empty((len(im1)*2) + 2)
                            diff[0] = index
                            diff[1] = label
                            ccount=2
                            for k in range(len(im1)):
                                diff[ccount]=im1[k][0]
                                diff[ccount+1]=im1[k][1]
                                ccount+=2

                            #im2 = getPoints(targetDir, onlyfiles[i + 1])

                            images += 1

                            #distance(im1, im2, len(im1), diff)

                            # for i in range(len(im1)):
                            # diff.append(distance(im1[i], im2[i]))

                            #im1 = im2

                            dataSet.append(diff)



                    index += 1

        if (subdir[len(subdir) - 8] == "S" and subdir[len(subdir) - 8:len(subdir) - 4] != curDirr):
            curDirs += 1
            curDirr = subdir[len(subdir) - 8:len(subdir) - 4]

            print("imaggini processate: ", images, " in ", time.time() - t1)
            print(curDirs / outDirs)
            print(subdir)

    with open('ECKxyFrame.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerows(dataSet)

def make():
    outDirs = 123
    curDirs = 0
    curDirr = ""
    images=0
    index = 0
    t1=time.time()
    for subdir, dirs, files in os.walk(labelPath):
        if(subdir[len(subdir)-4:] in cartelle):
            if(len(files)>0):
                if(files[0].endswith(".txt")):
                    with open(os.path.join(subdir,files[0])) as f:
                        label=int(f.readline().strip()[0])

                        imagesPath=imgPath+subdir[len(subdir)-9:]
                        onlyfiles = [f for f in listdir(imagesPath) if isfile(join(imagesPath, f))]

                        curDir=subdir[len(subdir) - 9:]
                        targetDir=imgPath+curDir
                        im1 = getPoints(targetDir, onlyfiles[0])
                        images+=1
                        for i in range(len(onlyfiles)-1):
                            diff = np.empty(len(im1)+2)
                            diff[0]=index
                            diff[1]=label

                            im2=getPoints(targetDir,onlyfiles[i+1])

                            images+=1

                            distance(im1,im2,len(im1),diff)

                            #for i in range(len(im1)):
                                #diff.append(distance(im1[i], im2[i]))

                            im1=im2
                            dataSet.append(diff)



                    index+=1

        if (subdir[len(subdir) - 8] == "S" and subdir[len(subdir) - 8:len(subdir) - 4] != curDirr):


            curDirs += 1
            curDirr = subdir[len(subdir) - 8:len(subdir) - 4]

            print("imaggini processate: ", images, " in ", time.time()-t1)
            print(curDirs / outDirs)
            print(subdir)



    with open('ECKdistanceFrame68.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerows(dataSet)




def getPoints(subdir, file):
    landmarksPoints = []

    img = cv2.imread(os.path.join(subdir, file))
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)



    faces = detector(img_gray)

    landmarks = predictor(img_gray, faces[0])

    mx=landmarks.part(joint_point).x
    my=landmarks.part(joint_point).y

    for n in range(n_points):
        if(n!=joint_point):
            x = landmarks.part(n).x -mx
            y = landmarks.part(n).y -my
            landmarksPoints.append((x, y))

    points = np.array(landmarksPoints, np.int32)

    return points

@njit(fastmath=True,nogil=True,cache=True, parallel=True)
def distance(p0,p1,lun,diff):

    for i in prange(lun):
        diff[i+2]=square(p0[i],p1[i])



@njit(fastmath=True,nogil=True,cache=True)
def square(p0,p1):
    return math.sqrt((p0[0] - p1[0]) ** 2 + (p0[1] - p1[1]) ** 2)






makeXY()

