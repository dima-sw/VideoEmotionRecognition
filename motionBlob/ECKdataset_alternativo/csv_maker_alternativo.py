import cv2

import dlib
from PIL import Image
import os
from os.path import isfile, join
from os import listdir
import numpy as np

import csv
import time



imgPath=r"C:\Users\TheDimitri\Desktop\imgDataset"
labelPath=r"C:\Users\TheDimitri\Desktop\Emotion"
#68 15
n_points=15
#34 6
joint_point=6
#casc = 'haarcascade_frontalface_default.xml'
#faceCascade = cv2.CascadeClassifier(cv2.data.haarcascades+ 'haarcascade_frontalface_default.xml')
cartelle=[r"\001",r"\002",r"\003",r"\004",r"\005",r"\006",r"\007",r"\008",r"\009"]
#p = r'C:\Users\alexl\OneDrive\Desktop\VideoEmotionRecognition-main\VideoEmotionRecognition-main\FacialPoints\customDlibPredictor\essential_predictor.dat'
detector = dlib.get_frontal_face_detector()
#predictor = dlib.shape_predictor(p)
dataSet=[]

def makeXY():
    curDirs = 0
    curDirr = ""
    n_video = 0
    n_frame=0
    n_pixel=100
    outDirs=123
    t1 = time.time()
    for subdir, dirs, files in os.walk(labelPath):
        if (subdir[len(subdir) - 4:] in cartelle):
            if (len(files) > 0):
                if (files[0].endswith(".txt")):
                    with open(os.path.join(subdir, files[0])) as f:
                        label = int(f.readline().strip()[0])

                        imagesPath = imgPath + subdir[len(subdir) - 9:]+"\processed/"
                        onlyfiles = [f for f in listdir(imagesPath) if isfile(join(imagesPath, f))]

                        for f in (onlyfiles):

                            #path_image=imagesPath+f
                            img1 = cv2.imread(os.path.join(imagesPath,f), cv2.IMREAD_GRAYSCALE)

                            img_r=cv2.resize(img1,(n_pixel,n_pixel))


                            #cv2.imwrite(path_image,img_r)






                            for j in range(len(img_r)):
                                blob=np.zeros(n_pixel+3)
                                count=3
                                blob[0]=n_video
                                blob[1]=n_frame
                                blob[2]=label
                                riga=img_r[j]
                                for r in riga:
                                    blob[count]=r
                                    count+=1


                                dataSet.append(blob)
                            n_frame+=1
                        n_frame=0
                        n_video+=1





        if (subdir[len(subdir) - 8] == "S" and subdir[len(subdir) - 8:len(subdir) - 4] != curDirr):
            curDirs += 1
            curDirr = subdir[len(subdir) - 8:len(subdir) - 4]

            #print("immagini processate: ", images, " in ", time.time() - t1)
            print(curDirs / outDirs)
            #print(subdir)


    with open('ECKFrame100.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerows(dataSet)







def make_square(im, min_size=256, fill_color=(255, 255, 255, 0)):
    x, y = im.size
    #size = max(min_size, x, y)
    size=100
    new_im = Image.new('RGBA', (size, size), fill_color)
    new_im.paste(im, (int((size - x) / 2), int((size - y) / 2)))
    return new_im






makeXY()

