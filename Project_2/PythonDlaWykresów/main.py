import matplotlib.pyplot as plt
import numpy as numpy


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


# def draw_severity():
#     plt.xticks([1, 2, 3, 4])
#     plt.grid(linestyle='dotted')
#     plt.plot([1, 2, 3, 4], [1, 2.0 / 3, 1.0 / 3, 0], '--')
#     plt.plot([1, 2, 3, 4], [0, 1.0 / 3, 2.0 / 3, 1], '--')
#     plt.scatter([1, 2, 3, 4], [1, 2.0 / 3, 1.0 / 3, 0], label="Mały Wpływ")
#     plt.scatter([1, 2, 3, 4], [0, 1.0 / 3, 2.0 / 3, 1], label="Duży Wpływ")
#     plt.xlabel('Dotkliwość')
#     plt.ylabel('Stopień Przynależności')
#     plt.legend()
#     plt.tight_layout()
#     plt.show()


def draw_duration():
    plt.xticks(range(0, 24))
    plt.grid(linestyle='dotted')
    plt.plot([0, 1], [1, 0], label="Poniżej Godziny")
    plt.plot([0, 2, 4], [0, 1, 0], label="Około Dwóch Godzin")
    plt.plot([2, 4, 6], [0, 1, 0], label="Około Czterech Godzin")
    plt.plot([4, 6, 8], [0, 1, 0], label="Około Sześciu Godzin")
    plt.plot([6, 8, 12], [0, 1, 1], label="Ponad Sześć Godzin")
    plt.xlabel('Czas trwania utrudnień w ruchu spowodowanych przez wypadek w godzinach')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_distance():
    # plt.xticks(range(0, 24))
    plt.grid(linestyle='dotted')
    plt.plot([0, 0.5], [1, 0], label="Poniżej Pół Mili")
    plt.plot([0, 1, 2], [0, 1, 0], label="Około Jednej Mili")
    plt.plot([1, 3, 5], [0, 1, 0], label="Około Trzech Mil")
    plt.plot([3, 5, 6], [0, 1, 1], label="Ponad Trzy Mile")
    plt.xlabel('Długość Trasy Dotknięta Wypadkiem w Milach')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_temperature():
    plt.grid(linestyle='dotted')
    plt.plot([-16, 14, 23], [1, 1, 0], '#0000CD', label="Bardzo Zimno")
    plt.plot([14, 23, 44, 54], [0, 1, 1, 0], '#1E90FF', label="Zimno")
    plt.plot([44, 54, 63, 71], [0, 1, 1, 0], '#FFD700', label="Umiarkowanie")
    plt.plot([63, 71, 80, 90], [0, 1, 1, 0], '#FF4500', label="Ciepło")
    plt.plot([80, 90, 104], [0, 1, 1], '#FF0000', label="Bardzo Ciepło")
    plt.xlabel('Temperatura W Stopniach Fahrenheita')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_humidity():
    plt.grid(linestyle='dotted')
    plt.plot([4, 20], [1, 0], label="Bardzo Suche Powietrze")
    plt.plot([4, 20, 30, 40], [0, 1, 1, 0], label="Suche Powietrze")
    plt.plot([30, 40, 60, 70], [0, 1, 1, 0], label="Umiarkowana Wilgotność powietrza")
    plt.plot([60, 70, 80, 90], [0, 1, 1, 0], label="Wilgotne Powietrze")
    plt.plot([80, 90, 100], [0, 1, 1], label="Bardzo Wilgotne Powietrze")
    plt.xlabel('Wilgotność Powietrza')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_pressure():
    plt.grid(linestyle='dotted')
    plt.plot([27, 27.5], [1, 0], label="Bardzo Niskie Ciśnienie")
    plt.plot([27, 27.5, 28, 28.5], [0, 1, 1, 0], label="Niskie Ciśnienie")
    plt.plot([28, 28.5, 29, 29.5], [0, 1, 1, 0], label="Umiarkowane Ciśnienie")
    plt.plot([29, 29.5, 30, 30.5], [0, 1, 1, 0], label="Wysokie Ciśnienie")
    plt.plot([30, 30.5, 32], [0, 1, 1], label="Bardzo Wysokie Ciśnienie")
    plt.xlabel('Ciśnienie w Calach Rtęci')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_visibility():
    plt.grid(linestyle='dotted')
    plt.scatter([0], [1], label="Brak Widoczności")
    plt.plot([0, 0.1, 0.3], [1, 1, 0], '#651fff', label="Słaba Widoczność")
    plt.plot([0.1, 0.3, 0.7, 1], [0, 1, 1, 0], 'g', label="Ograniczona Widoczność")
    plt.plot([0.7, 1, 2, 3], [0, 1, 1, 0], 'r', label="Dobra Widoczność")
    plt.plot([2, 3, 5], [0, 1, 1], 'c', label="Pełna Widoczność")
    plt.xlabel('Widoczność W Milach')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_wind_speed():
    plt.grid(linestyle='dotted')
    plt.scatter([0], [1], label="Brak Wiatru")
    plt.plot([0, 3, 3.5], [1, 1, 0], '#651fff', label="Słaby Wiatr")
    plt.plot([3, 3.5, 8, 9], [0, 1, 1, 0], 'g', label="Umiarkowany Wiatr")
    plt.plot([8, 9, 17, 20], [0, 1, 1, 0], 'r', label="Silny Wiatr")
    plt.plot([17, 20, 27, 30], [0, 1, 1, 0], 'm', label="Wicher")
    plt.plot([27, 30, 40], [0, 1, 1], 'c', label="Huragan")
    plt.xlabel('Prędkość Wiatru w Milach na Godzinę')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_principation():
    plt.grid(linestyle='dotted')
    plt.scatter([0], [1], label="Brak Opadów")
    plt.plot([0, 0.1, 0.2], [1, 1, 0], '#651fff', label="Niewielkie Opady")
    plt.plot([0.1, 0.2, 0.3, 0.35], [0, 1, 1, 0], 'g', label="Umiarkowane Opady")
    plt.plot([0.3, 0.35, 0.4, 0.45], [0, 1, 1, 0], 'c', label="Duże Opady")
    plt.plot([0.4, 0.45, 0.5], [0, 1, 1], 'r', label="Bardzo Duże Opady")
    plt.xlabel('Opady w Calach')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    plt.tight_layout()
    plt.show()


def my_gauss(x, sigma: float = 1, h: float = 1, mid: float = 0) -> float:
    from math import exp, pow
    variance = pow(sigma, 2)
    return h * exp(-pow(x - mid, 2) / (2 * variance))


def draw_quantificators():
    plt.grid(linestyle='dotted')
    x_axis = numpy.arange(0, 1, 0.001)
    y_axis_niewiele = [my_gauss(x, 0.1, 1, 0) for x in x_axis]
    y_axis_ok_14 = [my_gauss(x, 0.1, 1, 1 / 4) for x in x_axis]
    y_axis_ok_pol = [my_gauss(x, 0.1, 1, 1 / 2) for x in x_axis]
    y_axis_wieksz = [my_gauss(x, 0.1, 1, 3 / 4) for x in x_axis]
    y_axis_praw_wszy = [my_gauss(x, 0.1, 1, 1) for x in x_axis]
    plt.plot(x_axis, y_axis_niewiele, label="Niewiele")
    plt.plot(x_axis, y_axis_ok_14, label="Około 1/4")
    plt.plot(x_axis, y_axis_ok_pol, label="Około połowy")
    plt.plot(x_axis, y_axis_wieksz, label="Większość")
    plt.plot(x_axis, y_axis_praw_wszy, label="Prawie Wszystkie")
    plt.xlabel('Stosunek liczby obiektów posiadających cechę do wszystkich rozważanych obiektów')
    plt.ylabel('Stopień Przynależności')
    plt.title("Wykres Funkcji Przynależności Kwantyfikatorów Lingwistycznych")
    plt.legend()
    plt.tight_layout()
    plt.show()


def draw_pressure_gauss():
    plt.grid(linestyle='dotted')
    x_axis = numpy.arange(27, 32, 0.001)
    y_axis_niewiele = [my_gauss(x, 0.3, 1, 27) for x in x_axis]
    y_axis_ok_14 = [my_gauss(x, 0.3, 1, 27.75) for x in x_axis]
    y_axis_ok_pol = [my_gauss(x, 0.3, 1, 28.75) for x in x_axis]
    y_axis_wieksz = [my_gauss(x, 0.3, 1, 29.75) for x in x_axis]
    plt.plot([30, 30.5, 32], [0, 1, 1], label="Bardzo Wysokie Ciśnienie")
    plt.plot(x_axis, y_axis_niewiele, label="Bardzo Niskie Ciśnienie")
    plt.plot(x_axis, y_axis_ok_14, label="Niskie Ciśnienie")
    plt.plot(x_axis, y_axis_ok_pol, label="Umiarkowane Ciśnienie")
    plt.plot(x_axis, y_axis_wieksz, label="Wysokie Ciśnienie")
    plt.xlabel('Ciśnienie w Calach Rtęci')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    # plt.tight_layout()
    plt.show()

# TODO: POPRAWIC!
def draw_humidity_gauss():
    plt.grid(linestyle='dotted')
    x_axis = numpy.arange(4, 100, 0.001)
    y_axis_niewiele = [my_gauss(x, 8, 1, 4) for x in x_axis]
    y_axis_ok_14 = [my_gauss(x, 8, 1, 25) for x in x_axis]
    y_axis_ok_pol = [my_gauss(x, 8, 1, 50) for x in x_axis]
    y_axis_wieksz = [my_gauss(x, 8, 1, 75) for x in x_axis]
    plt.plot([80, 90, 100], [0, 1, 1], label="Bardzo Wilgotne Powietrze")
    plt.plot(x_axis, y_axis_niewiele, label="Bardzo Suche Powietrze")
    plt.plot(x_axis, y_axis_wieksz, label="Wilgotne Powietrze")
    plt.plot(x_axis, y_axis_ok_14, label="Suche Powietrze")
    plt.plot(x_axis, y_axis_ok_pol, label="Umiarkowana Wilgotność powietrza")
    plt.xlabel('Ciśnienie w Calach Rtęci')
    plt.ylabel('Stopień Przynależności')
    plt.legend()
    # plt.tight_layout()
    plt.show()


def draw_absolute_quantificators():
    plt.grid(linestyle='dotted')
    plt.plot([0, 10], [1, 0], label="Poniżej 10")
    plt.plot([0, 20, 40], [0, 1, 0], label="Okolo 20")
    plt.plot([10, 40, 60, 90], [0, 1, 1, 0], label="Około 50")
    plt.plot([50, 90, 110, 150], [0, 1, 1, 0], label="Około 100")
    plt.plot([100, 150, 200], [0, 1, 0], label="Między 100 a 200")
    plt.plot([150, 190, 210, 250], [0, 1, 1, 0], label="Około 200")
    plt.plot([200, 250], [0, 1], label="Ponad 200")
    plt.xlabel('Absolutna wartość liczby obiektów posiadających cechę')
    plt.ylabel('Stopień Przynależności')
    plt.title("Wykres Funkcji Przynależności Kwantyfikatorów Lingwistycznych")
    plt.legend()
    plt.tight_layout()
    plt.show()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    draw_absolute_quantificators()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
