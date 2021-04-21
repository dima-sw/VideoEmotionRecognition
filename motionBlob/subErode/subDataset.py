import cv2
import numpy as np
import dlib
import os
from pathlib import Path
import math


rootdir=r'C:\Users\TheDimitri\Desktop\imgDataset'

cartelle=[r"\001",r"\002",r"\003",r"\004",r"\005",r"\006",r"\007",r"\008",r"\009"]

outDirs=123
curDirs=0
curDir=""
casc = 'haarcascade_frontalface_default.xml'
faceCascade = cv2.CascadeClassifier(casc)
for subdir, dirs, files in os.walk(rootdir):

    if(subdir[len(subdir)-4:] in cartelle):
        img1 = cv2.imread(os.path.join(subdir, files[0]), cv2.IMREAD_GRAYSCALE)
        direct = subdir + r"\processed"
        Path(direct).mkdir(parents=True, exist_ok=True)
        for i in range(len(files)-1):
            img2 = cv2.imread(os.path.join(subdir, files[i+1]), cv2.IMREAD_GRAYSCALE)
            img3 = img1 - img2

            faces = faceCascade.detectMultiScale(img1, 1.3, 5)

            for (x, y, w, h) in faces:
                v_img3 = img3[y:y + h, x:x + w]

            kernel = np.ones((5, 5), np.uint8)
            erode_img3 = cv2.erode(v_img3, kernel)

            cv2.imwrite(os.path.join(direct,files[i]), erode_img3)

            img1=img2
    if (subdir[len(subdir) - 8] == "S" and subdir[len(subdir) - 8:len(subdir) - 4] != curDir):
        curDirs += 1
        curDir = subdir[len(subdir) - 8:len(subdir) - 4]
        print(curDirs / outDirs)