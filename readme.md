# Индивидуальная работа номер 2

Из лабораторной работы возьмите текстовый файл с данными и определения структур данных.

Требуется реализовать программу на любом удобном вам языке программирования, в которой реализовано __3 способа сортировки__ массивов данных из созданного файла по ключу. 
Для каждого метода сортировки проанализировать теоретическую и практическую сложности.

## Для каждого алгоритма вывести следующую информацию:

* теоретичекая оценка сложности
* количество сравнений
* количество перестановок
* время выполнения алгоритма

## Методы сортировки

### 1. __Bubble Sort__
<div id="header" align="center">
  <img src="https://i.pinimg.com/originals/a4/b8/ad/a4b8ad55cd4461c0173c92d7735bb106.gif" width="300"/>
</div>
Принцип действий прост: 
обходим массив от начала до конца, 
попутно меняя местами неотсортированные соседние элементы. 
В результате первого прохода на последнее место «всплывёт» максимальный элемент. 
Теперь снова обходим неотсортированную часть массива (от первого элемента до предпоследнего) и 
меняем по пути неотсортированных соседей. Второй по величине элемент окажется на предпоследнем месте. 
Продолжая в том же духе, будем обходить всё уменьшающуюся неотсортированную часть массива, 
запихивая найденные максимумы в конец.

#### Сложность
|             <center>Значение | Временная сложность</center> |
|-----------------------------:|------------------------------|
|         <center>Лучшее время | <center>*O(n)*</center>      |
|         <center>Худшее время | <center>*O(n<sup>2</sup>)*           |
|        <center>Среднее время | <center>*O(n<sup>2</sup>)*           |
|       <center>Затраты памяти | <center>*O(1)*                       |

### 1. __Selection Sort__
<div id="header" align="center">
  <img src="https://i.stack.imgur.com/XNbE0.gif" width="300"/>
</div>
Итак, идея сортировок выбором состоит в следующем: 

1. В неотсортированном подмассиве ищется локальный максимум (минимум). 
2. Найденный максимум (минимум) меняется местами с последним (первым) элементом в подмассиве. 
3. Если в массиве остались неотсортированные подмассивы — возвращаемся к пункту 1.

В моем случае, выбран минимальный элемент. То есть, проходим по массиву в поисках минимального элемента. 
Найденный минимум меняем местами с первым элементом. Неотсортированная часть массива уменьшилась на один элемент 
(не включает первый элемент, куда мы переставили найденный минимум). 
К этой неотсортированной части применяем те же действия — находим минимум и ставим его на первое место в неотсортированной части массива. 
И так продолжаем до тех пор, пока неотсортированная часть массива не уменьшится до одного элемента.

#### Сложность
|             <center>Значение | Временная сложность</center>               |
|-----------------------------:|--------------------------------------------|
|         <center>Лучшее время | <center>*O(n<sup>2</sup>)*</center>        |
|         <center>Худшее время | <center>*O(n<sup>2</sup>)*                 |
|        <center>Среднее время | <center>*O(n<sup>2</sup>)*                 |
|       <center>Затраты памяти | <center>*O(n)* всего, *O(1)* дополнительно |