import time

import cv2
import numpy as np
import dlib
import os
from pathlib import Path
import math

rootdir=r'C:\Users\TheDimitri\Desktop\imgDataset'

cartelle=[r"\001",r"\002",r"\003",r"\004",r"\005",r"\006",r"\007",r"\008",r"\009"]

landmarksDifferences = [] #np.zeros((68,), dtype=int)
landmarksAVGDifference=[]

p = r'C:\Users\TheDimitri\Desktop\Code\Predictor68Landmarks\shape_predictor_68_face_landmarks.dat'

outDirs=123
curDirs=0
curDir=""
def getPoints(subdir, file):
    landmarksPoints = []

    img = cv2.imread(os.path.join(subdir, file))
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    detector = dlib.get_frontal_face_detector()
    predictor = dlib.shape_predictor(p)

    faces = detector(img_gray)

    landmarks = predictor(img_gray, faces[0])
    for n in range(0, 68):
        x = landmarks.part(n).x
        y = landmarks.part(n).y
        landmarksPoints.append((x, y))
    points = np.array(landmarksPoints, np.int32)

    return points

def distance(p0,p1):
    return math.sqrt((p0[0] - p1[0]) ** 2 + (p0[1] - p1[1]) ** 2)


for subdir, dirs, files in os.walk(rootdir):

    if(subdir[len(subdir)-4:] in cartelle):
        diff=[]
        firstImgPoints=getPoints(subdir,files[0])
        lastImgPoints=getPoints(subdir,files[len(files)-1])

        for i in range(len(firstImgPoints)):
            diff.append(distance(firstImgPoints[i],lastImgPoints[i]))

        landmarksDifferences.append(diff)
    if (subdir[len(subdir) - 8] == "S" and subdir[len(subdir) - 8:len(subdir) - 4] != curDir):
        curDirs += 1
        curDir = subdir[len(subdir) - 8:len(subdir) - 4]
        print(curDirs / outDirs)




for i in range(68):
    sum=0
    for j in range(len(landmarksDifferences)):
        sum+=landmarksDifferences[j][i]
    sum /= len(landmarksDifferences)
    landmarksAVGDifference.append(sum)

print(landmarksAVGDifference)


with open('landmarksAVGDistance.txt', 'w') as filehandle:
    for listitem in landmarksAVGDifference:
        filehandle.write('%s\n' % listitem)


landmarks = []


with open('landmarksAVGDistance.txt', 'r') as filehandle:
    for line in filehandle:
        # remove linebreak which is the last character of the string
        currentPlace = line[:-1]
        landmarks.append(currentPlace)

print(landmarks)