# This is a sample Python script.

import matplotlib.pyplot as plt


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def draw_severity():
    plt.xticks([1, 2, 3, 4])
    plt.grid(linestyle='dotted')
    plt.scatter([1, 2, 3, 4], [1, 2.0 / 3, 1.0 / 3, 0], label="Mały Wpływ")
    plt.scatter([1, 2, 3, 4], [0, 1.0 / 3, 2.0 / 3, 1], label="Duży Wpływ")
    plt.xlabel('Dotkliwość')
    plt.ylabel('Stopień Przynależności')
    plt.title("Funkcja Przynależności Zbioru Rozmytego Dotkliwości")
    plt.legend()
    plt.tight_layout()
    plt.show()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    draw_severity()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
