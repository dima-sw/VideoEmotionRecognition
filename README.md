
# VideoEmoitionRecognition
  Video Emotion Recognition project in Python. We used both the Landmark strategy and the Motion Blobs strategy. 
  We used LSTM and Conv2D with time distributed neural networks.
  For the landmarks we did not use all 68 landmarks, we created our own custom dlib model that contains only 15 most important landmarks (17,19,21,22,24,26,33,37,40,44,47,48, 51,54,57), this is also included in the project so that you can create different models according to needs (for example, for a mobile application you will use fewer landmarks to have it more responsive even at the expense of a little accuracy).
 


## Credits:
 - CK+ Dataset https://paperswithcode.com/dataset/ck
 - Ibug 300W Dataset https://ibug.doc.ic.ac.uk/resources/300-W/
 - Custom dlib Shape ispirated by -> https://www.pyimagesearch.com/2019/12/16/training-a-custom-dlib-shape-predictor/

