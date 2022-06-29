# Backtracking

1. Stellen Sie mit dem Befehl
   ```
   java --version
   ```
   im Terminal sicher, dass die neuste Version von java installiert ist.
4. Extrahieren Sie die Heruntergeladene Datei.
5. Öffnen sie ein Terminal und navigieren sie zum Pfad 
   ```
   src/main/java/de/hsrm/ads
   ```
   der Zip-Datei.
   
7. Führen sie mit dem Befehl 
   ```
   java AIO.java
   ```
   das Programm aus.
   AIO.java gibt hierbei die Ausgaben der einzelnen-Teilaufgaben zusammen aus.
   Alternativ können Sie die einzelnen Teilaufgaben mit 
   ```
   java Reverse.java
   java RucksackBacktracking.java
   java RucksackGreedy.java
   ```
   ausgeben lassen.

Weitere Dokumentation finden Sie im Quellcode oder unter [https://luca910.github.io/backtracking](https://luca910.github.io/Backtracking/)

Aufgabe 2:\
Zu zeigen:\
	∃c,n_0  :2^n≤c∗2^n  für alle n≥n_0\
	wähle c=2 und n=100

f(n)=2∗f(n−1)                     f(0)=1            n∈N

f(1)=2∗1=2\
f(2)=2∗f(1)=4\
f(3)=2∗f(2)=8\
f(4)=2∗f(3)=16\
f(5)=2∗f(4)=32\
f(6)=2∗f(5)=64\
f(7)=2∗f(6)=128\
f(8)=2∗f(7)=256=2∗2∗2∗2∗2∗2∗2∗2\
…\
f(n)=2^n∈O(2^n)

IA\
Für den Anfang wird n=1000 eingesetzt um zu prüfen, ob es Stimmt.\
Es lässt sich bestätigen, da\
2^n≤2∗2^n

n=1000:    2^1000≤2∗2^1000\
		2^1000≤2^1001

IV\
Durch den Anfang wissen wir, dass\
2^n≤2∗2^n


IS\
Zu zeigen ist, dass das auch für n+1gilt.\
Da 2^(n+1)=2∗2^n  ist, kann die IV eingesezt werden.

n→n+1:\
	2^(n+1)=2∗2^n ≤┴IV 2∗2∗2^n=2^(n+2)

Da 2∗2∗2^n=2^(n+2)  ist haben wir gezeigt, dass 2^(n+1)≤2∗2^(n+1)\
![image](https://user-images.githubusercontent.com/41526150/176511195-16aeeb99-3900-422a-bf0c-64a7d90c55ea.png)
