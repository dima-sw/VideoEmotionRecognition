import numpy as np

a = np.array([1, 1, 2, 2, 3, 3])


np.insert(a, 1, 5)

a=np.insert(a, 1, 5, axis=0)

print(a)