XMLParser


1)Предоставляется XML-файл, содержащий представление иерархии файлов. Один узел может быть либо файлом, либо каталогом, который определяется атрибутом is-filex.
По запросу программа выводит полный путь файла(файлов).

2)Пример работы:
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

3)Запуск:

