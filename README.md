Задание 3 номер 7

Написать программу для вычисления значения выражения, представленного в обратной польской записи.

Обычная запись  =>  Обратная польская запись

(b + c) * d  =>  b c + d *

a + (b + c) * d  =>  a b c + d * +

(6 + 8)/2 + 11  =>  6 8 + 2 / 11 +

Подсказка: просматривая строку, в которой записано выражение, анализируем очередной символ. Если это число, то записываем его в стек. Если это знак операции, то достаём два элемента из стека, выполняем арифметическую операцию, определяемую этим знаком, и заносим результат в стек.


видео: https://youtu.be/fR1AZBCYOws

<!--  -->
![image](https://user-images.githubusercontent.com/71376506/185749405-d39b2701-3738-42ed-aafe-01869757585d.png)

