import matplotlib.pyplot as plt
import pandas as pd

# k
# data = [[1, 0.58, 0.49, 0.58, 0.53],
#         [2, 0.61, 0.46, 0.61, 0.52],
#         [3, 0.61, 0.46, 0.61, 0.53],
#         [4, 0.62, 0.52, 0.62, 0.57],
#         [5, 0.62, 0.52, 0.62, 0.56],
#         [6, 0.62, 0.52, 0.62, 0.56],
#         [7, 0.61, 0.51, 0.61, 0.56],
#         [8, 0.61, 0.48, 0.61, 0.54],
#         [9, 0.61, 0.37, 0.61, 0.46],
#         [50, 0.61, 0.37, 0.61, 0.46],
#         ]
#
# df = pd.DataFrame(data, columns=["k", "Accuracy", "Precision", "Recall", "F1"])
# df.plot(x="k", y=["Accuracy", "Precision", "Recall", "F1"], kind="bar", figsize=(9, 8), rot=0)
# plt.grid(color='grey', linestyle='dashed', linewidth=0.5)
# plt.show()

# metryka
data = [["Euklidesowa", 0.95, 0.95, 0.95, 0.95],
        ["Czebyszewa", 0.63, 0.62, 0.63, 0.63],
        ["Uliczna", 0.96, 0.96, 0.96, 0.96],
        ]

df = pd.DataFrame(data, columns=["Metryka", "Accuracy", "Precision", "Recall", "F1"])
df.plot(x="Metryka", y=["Accuracy", "Precision", "Recall", "F1"], kind="bar", figsize=(9, 8), rot=0)
plt.grid(color='grey', linestyle='dashed', linewidth=0.5)
plt.show()

# # cechy
data = [["c1,  c2, c5,\nc6, c11", 0.60, 0.43, 0.60, 0.50],
        ["c3, c4,\nc5, c7", 0.94, 0.95, 0.94, 0.95],
        ["c3", 0.95, 0.95, 0.95, 0.95],
        ["c4", 0.72, 0.72, 0.72, 0.72],
        ["c3, c4", 0.95, 0.96, 0.95, 0.96],
        ["c6, c7, c8,\nc9, c10", 0.60, 0.52, 0.60, 0.56],
        ["c1, c3, c4", 0.62, 0.55, 0.62, 0.58],
        ]


df = pd.DataFrame(data, columns=["Cechy", "Accuracy", "Precision", "Recall", "F1"])
df.plot(x="Cechy", y=["Accuracy", "Precision", "Recall", "F1"], kind="bar", figsize=(8, 8), rot=0)
plt.grid(color='grey', linestyle='dashed', linewidth=0.5)
plt.show()


# # proporcje
# data = [[10, 0.59, 0.43, 0.71, 0.64],
#         [25, 0.85, 0.95, 0.81, 0.83],
#         [50, 0.91, 0.95, 0.90, 0.91],
#         [70, 0.93, 0.72, 0.93, 0.93],
#         [95, 0.98, 0.96, 0.97, 0.98],
#         ]
#
#
# df = pd.DataFrame(data, columns=["Proporcje", "Accuracy", "Precision", "Recall", "F1"])
# df.plot(x="Proporcje", y=["Accuracy", "Precision", "Recall", "F1"], kind="bar", figsize=(8, 8), rot=0)
# plt.grid(color='grey', linestyle='dashed', linewidth=0.5)
# plt.show()
