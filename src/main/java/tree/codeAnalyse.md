# Code Analyse

## Was sind Vorteile, was sind Nachteile dieser Modellierung?

### Vorteile

- Ein Vorteil dieser Modellierung ist es, dass er aufgrund der Generic - Implementierung sehr gut mit jeglicher Art von Daten gefüllt werden kann.
- Außerdem hat eine Node immer irgendeinen Inhalt, nur Empty Nodes sind wirklich "leer".

### Nachteile

- Ein Nachteil der Modellierung ist, dass sie extrem viele leere Objekte beim erstellen des oder einfügen in den Baum erstellt. Jeder Aufruf der addData() Methode wandert durch den gesamten Baum bis er ein leeres Platzhalter-Objekt findet, welches sich doppelt an jedem leaf des Baums findet. Während des wanderns durch den Baum wird an jeder Node ein neues Node-Objekt erstellt, was den Heap zumüllt.
- Ein weiterer Nachteil ist, dass der Baum durch eine recht verzweigte Struktur zwischen den Klassen sehr schlecht lesbar ist.
- Außerdem ist der Baum nicht optimal angelegt, da er nicht gelevelt ist.

## Was musste getan werden, um die selbst implementierten Bäume in Schleifen nutzen zu können?

Um foreach schleifen nutzen zu können, musste der Tree das Iterable-Interface implementieren, welches in for-each schleifen mit inbegriffen ist. Für den Tree musste außerdem ein Iterator existieren, über den iteriert werden kann, der auch alle Elemente des Trees erfasst.

## Wie funktioniert der TreeIterator?

Beim erstellen des Iterators wird ein großer Stack initiiert. Am Start wird auf diesen Stack jede einzelne Node gepusht, die man findet wenn man von der jetzigen node das linke Kind aufruft, inklusive der jetzigen node. Dabei wird die "letzte" Node, also die am Ende der leftChild() Schleife liegt, zuletzt auf den Stack gelegt. Diese Node ist zugleich auch die "kleinste" Node des Baumes. Beim aufrufen von next() auf dem Iterator wird diese Node auch geliefert. Gleichzeitig wird jedoch auf den Stack das rightChild() dieser Node und alle dem Child folgenden Left nodes gelegt, wodurch das nächste mit next() aufgerufene Element effektiv die "zweitkleinste" Node des Baumes ist. Mit dieser Methodik wird der gesamte Baum durchlaufen, bis man bei der größten Node angekommen ist.
