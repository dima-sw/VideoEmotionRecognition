import cv2
import numpy as np
import dlib
import os
from pathlib import Path
import pandas as pd
import time
rootdir=r'C:\Users\TheDimitri\Desktop\imgDataset'
p = r'C:\Users\TheDimitri\Desktop\VideoEmotionRecognition\FacialPoints\customDlibPredictor\essential_predictor.dat'
detector = dlib.get_frontal_face_detector()
predictor = dlib.shape_predictor(p)
for subdir, dirs, files in os.walk(rootdir):
    for file in files:

            if file.endswith(".png") or file.endswith(".jpg") or file.endswith(".jpeg"):

                img = cv2.imread(os.path.join(subdir, file))


                img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)



                faces = detector(img_gray)

                for face in faces:

                    landmarks = predictor(img_gray, face)

                    landmarks_points = []

                    for n in range(15):

                        x = landmarks.part(n).x
                        y = landmarks.part(n).y
                        landmarks_points.append((x, y))



                        #convexhull = cv2.convexHull(points)
                        """Add to var csv"""
                        cv2.circle(img, (x, y), 2, (0, 0, 255), -1)

                    points = np.array(landmarks_points, np.int32)

                    direct=subdir+r"\68"
                    Path(direct).mkdir(parents=True, exist_ok=True)
                    """WRITE INTO CSV FILE"""
                    cv2.imwrite(os.path.join(direct,file), img)




