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


def draw_duration():
    plt.xticks(range(0, 24))
    plt.grid(linestyle='dotted')
    plt.plot([0, 1.5, 3], [1, 1, 0], label="Krótki Czas Trwania")
    plt.plot([1.5, 3, 5.5, 7], [0, 1, 1, 0], label="Średni Czas Trwania")
    plt.plot([5.5, 7, 12], [0, 1, 1], label="Długi Czas Trwania")
    plt.xlabel('Czas Trwania W Godzinach')
    plt.ylabel('Stopień Przynależności')
    plt.title("Funkcja Przynależności Zbioru Rozmytego Czasu Trwania Wypadku")
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_distance():
    # plt.xticks(range(0, 24))
    plt.grid(linestyle='dotted')
    plt.plot([0, 0.5, 1], [1, 1, 0], label="Krótka Odległość")
    plt.plot([0.5, 1, 3], [0, 1, 1], label="Długa Odległość")
    plt.xlabel('Długość Trasy Dotknięta Wypadkiem w Milach')
    plt.ylabel('Stopień Przynależności')
    plt.title("Funkcja Przynależności Zbioru Rozmytego Odległości Wypadku")
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_temperature():
    plt.grid(linestyle='dotted')
    plt.plot([-16, 14, 23], [1, 1, 0], '#0000CD', label="Bardzo Niska Temperatura")
    plt.plot([14, 23, 44, 54], [0, 1, 1, 0], '#1E90FF', label="Niska Temperatura")
    plt.plot([44, 54, 63, 71], [0, 1, 1, 0], '#FFD700', label="Średnia Temperatura")
    plt.plot([63, 71, 80, 90], [0, 1, 1, 0], '#FF4500', label="Wysoka Temperatura")
    plt.plot([80, 90, 104], [0, 1, 1], '#FF0000', label="Bardzo Wysoka Temperatura")
    plt.xlabel('Temperatura W Stopniach Fahrenheita')
    plt.ylabel('Stopień Przynależności')
    plt.title("Funkcja Przynależności Zbioru Rozmytego\nTemperatury W Momencie Wypadku")
    plt.legend()
    plt.tight_layout()
    plt.show()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    draw_temperature()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
