# VingerCodeSwing

Изначально идеей было написать шифратор Виженера но потом решил добавлять разные шифры в один интерфейс.
![Скриншот программы](https://mygemorr.ru/pictures/git/Vigenera.png)

Программа шифратор и дешифратор, состоит из двух текстовых полей , одно из которых служит для ввода обычного текста, второе для зашифрованного. Двух кнопок «зашифровать» и «расшифровать» и выпадающего меню для выбора шифра.

Для шифровки сообщения выберите тип шифра который вам нужен. Далее в поле для обычного текста напишите текст который требуется зашифровать. Потом в зависимости от шифра потребуется указать ключ или число или ничего, далее нажать кнопку «Зашифровать». В поле зашифрованного текста тут же появиться текст в уже зашифрованном виде.

Если текст требуется расшифровать то зашифрованный текст следует ввести в поле для зашифрованного текста. После этого если шифр предполагается ключ или цифру или ничего. Ввести его в соответствующие поле для ввода . Нажать кнопку расшифровать. И расшифрованный текст появиться в поле обычного текста.

Существует также возможность загрузки зашифрованного или простого текста из txt файла для этого потребуется открыть меню «Файл» - «Открыть» и там выбрать нужный пункт «Зашифрованный» или «Обычный» после чего откроется стандартное диалоговое окно выбора где следует указать нужный файл.

Так же существует возможность сохранить информацию сохранены будут сразу оба варианта. Для этого следует выбрать меню «Файл» - «Сохранить» откроется стандартное диалоговое окно где следует выбрать куда сохранить файл. Файл будет сохранен с расширением txt
На данный момент программа версии 0,01 . Поддерживает 3 шифра

1. Элемент списка	Шифр Виженера - метод полиалфавитного шифрования буквенного текста с использованием ключевого слова. Шифр Виженера состоит из последовательности нескольких шифров Цезаря с различными значениями сдвига. Значение сдвига берется из буквы ключа, точнее ее позиции в алфавите.
2.	Шифр Цезаря - это вид шифра подстановки, в котором каждый символ в открытом тексте заменяется символом, находящимся на некотором постоянном числе позиций левее или правее него в алфавите. Например, в шифре со сдвигом вправо на 3, А была бы заменена на Г, Б станет Д, и так далее.
3.	Шифр A1Z26 - Из названия понятно, что каждой букве просто присваивается её порядковый номер в алфавите. (В русском языке существует две интерпритации сего шифра - А1Я33 и А1Я32. Во втором случае из алфавита выкидывается буква "ё"). В программе реализован А1Я33 Шифр тут работает не в совсем классическом варианте буквы разделяется не  символом - , а сдвух сторон отмечаються символом & это позволяет добовлять в шифр цифры.
4.	Шифр Атбаш – Правило шифрования Атбаш состоит в замене n-й буквы алфавита буквой с номером m − n + 1, где m — число букв в алфавите. Пример для русского алфавита выглядит так:
абвгдеёжзийклмнопрстуфхцчшщъыьэюя (исходный текст)
яюэьыъщшчцхфутсрпонмлкйизжёедгвба (зашифрованный текст)
5.  Base64 — стандарт кодирования двоичных данных при помощи только 64 символов ASCII.

jar файл для запуска можно взять [тут](https://github.com/AlexanderPanshin/VingerCodeSwing/tree/master/out/artifacts/VingerCodeSwing_jar)
