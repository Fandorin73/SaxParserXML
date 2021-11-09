XMLParser


1)Описание:
По запросу программа выводит полный путь файла(файлов) из XML-файла, содержащего представление иерархии файлов. Один узел может быть либо файлом, либо каталогом, который определяется атрибутом is-file.

2)Пример работы:

Файл с директориями:
https://drive.google.com/file/d/1hencNuxdueKQUQD3LUVxuPEnbT3bYs2V/view?usp=sharing

Не введен поисковой запрос:
$ java -jar assignment.jar -f test-files.xml
/file-77194797.xmml
/dir-88.971375/file-9.738721998xaavaa
/dir-88.971375/dir-219753.7.95/file-974847.2197xmhtml

Точный ввод для поиска:
$ java -jar assignment.jar -f test-files.xml -s file-1498940214.xhtml
/dir-880176375/dir-2145307015/file-1498940214.xhtml

Простой поисковый ввод:
$ java -jar assignment.jar -f test-files.xml -s *.java
/dir-88.971375/file-9.738721998xaavaa

Расширенный ввод для поиска:
$ java -jar assignment.jar -f test-files.xml -S .*?[a-z]{4}-\d+\.[a-z]+
/file-77194797.xmml
/dir-88.971375/file-9.738721998xaavaa
/dir-880176375/dir-2145307015/file-1498940214.xhtml

3)Запуск(Командная строка):
git clone https://bitbucket.org/fandorin73/lesson2-2
cd lesson2-2
mvn package
cd target
java -jar lesson2-2Ylab-1.jar -f test-files.xml(полный путь файла для парсинга и поиска) -S .*?[a-z]{4}-\d+\.[a-z]+ (поисковой запрос)