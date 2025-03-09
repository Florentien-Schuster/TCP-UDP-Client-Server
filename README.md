# UDP & TCP Client-Server Anwendung

## Beschreibung
Dieses Projekt enthält eine einfache UDP-Client-Server-Anwendung & eine einfache TCP-Client-Server-Anwendung in Java. 
Der **Client** sendet eine Sequenz von Ganzzahlen an den **Server**, der die empfangenen Zahlen überprüft und meldet, wenn eine Zahl fehlt oder nicht der erwarteten Reihenfolge entspricht.

## Voraussetzungen
- Java 8 oder höher

## Installation
1. **Repository klonen:**
   ```sh
   git clone <repository-url>
   cd <repository-name>
   ```
2. **Kompilieren der Java-Dateien:**
   ```sh
   javac UDPClient.java UDPServer.java
   ```
   oder
   
   ```sh
   javac TCPClient.java TCPServer.java
   ```

## Verwendung
### 1. Server starten
Öffne ein Terminal und führe den folgenden Befehl aus:
```sh
java UDPServer
```
oder

```sh
java TCPServer
```
Der Server wird auf Port **2345** lauschen und empfangene Daten analysieren.

### 2. Client starten
In einem zweiten Terminal-Fenster führe den Client aus:
```sh
java UDPClient <Server-IP> <Port>
```
oder

```sh
java TCPClient <Server-IP> <Port>
```
Ersetze `<Server-IP>` mit der IP-Adresse des Servers (z. B. `localhost` für lokale Tests) und `<Port>` mit `2345`.

Beispiel UDP:
```sh
java UDPClient localhost 2345
```
Beispiel TCP:
```sh
java TCPClient localhost 2345
```

## Funktionsweise
- Der **Client** sendet Zahlen von `0` bis `1.000.000` an den Server.
- Der **Server** überprüft, ob alle Zahlen in der richtigen Reihenfolge eintreffen.
- Falls eine Zahl fehlt oder eine falsche Reihenfolge erkannt wird, gibt der Server eine Fehlermeldung aus.



