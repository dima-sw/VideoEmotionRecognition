import cv2
import numpy as np
import dlib
import os
from os.path import isfile, join
from os import listdir
import numpy as np
import math
import csv

imgPath=r"C:\Users\TheDimitri\Desktop\imgDataset\\"
labelPath=r"C:\Users\TheDimitri\Desktop\Emotion"

n_points=15

joint_point=6

cartelle=[r"\001",r"\002",r"\003",r"\004",r"\005",r"\006",r"\007",r"\008",r"\009"]
p = r'C:\Users\TheDimitri\Desktop\VideoEmotionRecognition\FacialPoints\customDlibPredictor\essential_predictor.dat'
detector = dlib.get_frontal_face_detector()
predictor = dlib.shape_predictor(p)
dataSet=[]



def make():
    outDirs = 123
    curDirs = 0
    curDirr = ""
    images=0

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
                            diff = []
                            diff.append(label)
                            im2=getPoints(targetDir,onlyfiles[i+1])
                            images+=1
                            for i in range(len(im1)):
                                diff.append(distance(im1[i], im2[i]))
                            im1=im2
                            dataSet.append(diff)
        if (subdir[len(subdir) - 8] == "S" and subdir[len(subdir) - 8:len(subdir) - 4] != curDirr):


            curDirs += 1
            curDirr = subdir[len(subdir) - 8:len(subdir) - 4]

            print("imaggini processate: ", images)
            print(curDirs / outDirs)
            print(subdir)



    with open('ECKdistanceFrame.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerows(dataSet)




def getPoints(subdir, file):
    landmarksPoints = []

    img = cv2.imread(os.path.join(subdir, file))
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    detector = dlib.get_frontal_face_detector()
    predictor = dlib.shape_predictor(p)

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

def distance(p0,p1):
    return math.sqrt((p0[0] - p1[0]) ** 2 + (p0[1] - p1[1]) ** 2)



make()

