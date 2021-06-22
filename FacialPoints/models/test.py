import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Dropout, LSTM
import matplotlib.pyplot as plt

from FacialPoints.ECKDataset.loadDataset import loadCSV,parseCSV

#Carico feature e label del dataset
X,Y=loadCSV(r"C:\Users\TheDimitri\Desktop\VideoEmotionRecognition\FacialPoints\ECKDataset\ECKxyFrame.csv")
#Faccio lo split per il training (percentage) e per la validation (percentage2)
xt,xv,yt,yv=parseCSV(X,Y,percentage2=0.2,percentage=0.8)
print(tf.__version__)
print(xt.shape)
#Modello sequenziale
model = Sequential()
#I parametri sono stati scelti dopo molteplici test
model.add(LSTM(64, input_shape=(xt.shape[1:])))
model.add(Dropout(0.2))

model.add(Dense(32)) 
model.add(Dropout(0.2))

#8 sono le emozioni da predire
model.add(Dense(8, activation='softmax'))
#scrivo l'optimizer
opt = tf.keras.optimizers.Adam(lr=0.003, decay=1e-6)
# Compile model
model.compile(
    loss='sparse_categorical_crossentropy',
    optimizer=opt,
    metrics=['accuracy'],
)
#mi salvo il training
history=model.fit(xt,
          yt,
          epochs=1000,
          validation_data=(xv, yv))



print(history.history.keys())

#Visualizzo il grafico dell'accuratezza
plt.plot(history.history['accuracy'])
plt.plot(history.history['val_accuracy'])
plt.title('model accuracy')
plt.ylabel('accuracy')
plt.xlabel('epoch')
plt.legend(['train', 'test'], loc='upper left')
plt.show()
#Visualizzo il grafico della loss
plt.plot(history.history['loss'])
plt.plot(history.history['val_loss'])
plt.title('model loss')
plt.ylabel('loss')
plt.xlabel('epoch')
plt.legend(['train', 'test'], loc='upper left')
plt.show()

"standart scaler"