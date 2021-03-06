// Начало лекции 10 минут ???

val l1 = list(3, -4, 15)
l1 foreach {x => println(x) }
l1 filter {_>0}
l1 map {_*2}
l1 forall {_>0} // проверка на условие для всех элементов

// На выходе получается тип от выражения слева (то есть от списков получаются списки, от seq - seq и т.д.)

// Получает элемент, а возвращает коллекцию элементов (selectMany в c#)
//  3, 6, -4, -8, 15, 30
l1 flatmap {x => List(x, x*2)}


// 1 to 5 это класс Range, который перебирается от 1 до 5 включительно
for(x <- 1 to 5)
    println(x)
// Если не хочется перебирать 5, то
for(x <- t until 5)
    println(x)
// У Range есть следующий метод
for(x <- 1 to 5 by 2) // 1, 3, 5
    println(x)

// for как такого нету. Это синтаксический сахар над операциями над коллекциями
// for выглядит так:
(1 to 5) foreach { x => 
    println(x)
}

// У Range есть свой оптимизированный foreach и 
// т.к. foreach метод класса Range, 
// foreach выполняется хорошо и быстро


//
for {
    // Вложенные друг в друга циклы
    x <- 1 to 3
    y <- 1 to 2
} {
    println(s"x = $x y = $y")
}

//
for {
    // Вложенные друг в друга циклы
    x <- 1 to 3
    if x < 2
} {
    println(x) // 1
}

// 
val w = for {
    x <- List(2,-3,15)
    y - 2 * x
    if math.abs(y) < 10
} {
    println(y) 
} yield y // Собирает всё, что не вошло в цикл, в List

// Если хочется табулировать два значения разом, то
l1 zip l2 // Берет элемент N из l1 и N из l2, делая из них кортеж

for((x,y) <- (0 to 5) zip (100 to 95 by -1)) {
}

 // tuple означает кортеж по английски



// Разберем match
// matсh сравнивает с паттернами
// pattern - образец для сравнения
// Его усеченой версией является switch
// В match где-то 8 паттернов и еще можно писать свои
val x = io.StdIn.readInt()
val str_x = x match {
    // Провалов не существует (break нету)

    // Виды образцов:
    // 1) Константный образец
    case 1 => "one"
    case 2 => "two"
    // 2) Образец wildcart - "совпадает всегда"
    // Это не default (его нет).
    case _ => "много"
    // 3) Образец "переменная" - "совпадает всегда" и
    // при этом тело функции содержит эту переменную.
    // Значение не из выражения match, а из того, с чем сопоставлено,
    // т.е. n == n
    case n => s"x = $n"
}
println(str_x)

// getClass возвращает настоящий тип (например, если тип Any, а на самом деле String, то String)
