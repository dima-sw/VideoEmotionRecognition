import time
import cv2
import numpy as np

img1 = cv2.imread('01.png', cv2.IMREAD_GRAYSCALE)
img2 = cv2.imread('02.png', cv2.IMREAD_GRAYSCALE)
img3 = img1 - img2

cv2.imwrite('03.png', img3)
casc = 'haarcascade_frontalface_default.xml'

faceCascade = cv2.CascadeClassifier(casc)

faces = faceCascade.detectMultiScale(img1, 1.3, 5)

print ("Found {0} faces!".format(len(faces)))

for (x, y, w, h) in faces:
    v_img3 = img3[y:y+h, x:x+w]

ticks = time.time()

faces = faceCascade.detectMultiScale(img2, 1.3, 5)
print ("Found {0} faces!".format(len(faces)))

ticks1 = time.time() - ticks
print(ticks1)

for (x, y, w, h) in faces:
        v_img3_2 = img3[y:y+h, x:x+w]

cv2.imwrite('v_03_2.png', v_img3_2)

print ("Found {0} faces!".format(len(faces)))

cv2.imwrite('v_03.png', v_img3)
kernel = np.ones((5, 5), np.uint8)

# Using cv2.erode() method
erode_img3 = cv2.erode(v_img3, kernel)

cv2.imwrite('erode_03_10.png', erode_img3)

#mm = np.where(erode_img3>125, 255, 0)
#cv2.imwrite('mmm.png', mm)