import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Dropout, LSTM, ActivityRegularization, Flatten   #, CuDNNLSTM
from tensorflow.keras.regularizers import l2
import matplotlib.pyplot as plt
from time import time
#from FacialPoints.ECKDataset.
from loadDataset import loadCSV,parseCSV

X,Y=loadCSV(r"C:\Users\alexl\OneDrive\Desktop\VideoEmotionRecognition-main\VideoEmotionRecognition-main\motionBlob\ECKdataset\ECKFrame20.csv")

xt,xv,yt,yv=parseCSV(X,Y,percentage2=0.2,percentage=0.8)

print(tf.__version__)
#print(xt.shape)

#for i in range(2,50):
#seed=1

#tf.random.set_seed(seed)
model = Sequential()
# IF you are running with a GPU, try out the CuDNNLSTM layer type instead (don't pass an activation, tanh is required)
model.add(LSTM(256, input_shape=(xt.shape[1:]),activation='relu'))
model.add(Dropout(0.2))
#model.add(LSTM(64, activation='relu'))
#model.add(Dropout(0.2))
model.add(Dense(256, activation='relu'))

model.add(Dropout(0.2))
#model.add(Dense(64, activation='relu'))
#model.add(Dropout(0.2))
#model.add(Flatten())
model.add(Dense(8, activation='softmax'))
opt = tf.keras.optimizers.Adam(lr=0.003, decay=1e-6)
# Compile model
t=time()
model.compile(
    loss='sparse_categorical_crossentropy',
    optimizer=opt,
    metrics=['accuracy'],
)
history=model.fit(xt,
                  yt,
                  epochs=1000,
                  validation_data=(xv, yv))


print(history.history.keys())

t2=time()-t
print(t2)
# summarize history for accuracy
plt.plot(history.history['accuracy'])
plt.plot(history.history['val_accuracy'])
plt.title('model accuracy')
plt.ylabel('accuracy')
plt.xlabel('epoch')
plt.legend(['train', 'test'], loc='upper left')
plt.show()
#plt.savefig(r"C:\Users\alexl\OneDrive\Desktop\seed\acc_"+str(50)+".png",dpi=200)
plt.clf()
#summarize history for loss
plt.plot(history.history['loss'])
plt.plot(history.history['val_loss'])
plt.title('model loss')
plt.ylabel('loss')
plt.xlabel('epoch')
plt.legend(['train', 'test'], loc='upper left')
#plt.savefig(r"C:\Users\alexl\OneDrive\Desktop\seed\loss_"+str(50)+".png",dpi=200)
plt.show()
plt.clf()

"standart scaler"