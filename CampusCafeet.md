# CampusCaféet

## Uppdrag

Bygg ett beställningssystem som faktiskt skulle kunna användas på en
café- eller fikadag.

**Arbetsform:** 3 personer.

Klassen öppnar ett pop-up-café. Efter tio minuter ligger lappar
överallt: vem beställde kaffe, vilken macka ska göras först och hur
mycket har vi sålt? Er uppgift är att ersätta lapparna med ett enkelt
Java-program i terminalen.

Programmet ska kunna ta emot beställningar, hålla ordning på kön och
visa statistik.

## Det ska kännas som ett riktigt system

-   Varje beställning får ett unikt ordernummer och innehåller en
    produkt.
-   Status är `NY`, `KLAR` eller `HAMTAD`.
-   Beställningarna behandlas i turordning.
-   Kaffe och mackor tillagas, men flaskvatten behöver inte förberedas.
-   Caféet räknar en bekräftad beställning som såld när den registreras,
    även om den inte hämtats ännu.

## Exempel på programmets meny

``` text
=== Välkommen till CampusCaféet! ===

1. Visa produkter och priser
2. Lägg en beställning
3. Visa alla beställningar
4. Visa beställningskön
5. Gör klar nästa beställning
6. Lämna ut färdig beställning
7. Visa dagens statistik
8. Avsluta
```

**Förslag på produkter:** kaffe (25 kr), macka (45 kr), flaskvatten (20
kr). Ni får hitta på egna namn och priser, men systemet ska fungera på
riktigt.

## Så arbetar ni

### Grundkrav

Gör del 1--2, punkt 1--2 i del 3, del 4, punkt 1--3 i del 5 samt del 6.
Menyval 1--8 ska fungera.

### Extra utmaningar

Gör övriga uppgifter, till exempel `Set`, `Map`, `Deque`, sortering och
fördjupad felhantering.

### Git/GitHub

Arbeta i ett gemensamt repository. Alla ska göra minst en commit och
pusha sin ändring.

------------------------------------------------------------------------

## Del 1 -- Starta caféet

Börja med något som fungerar.

1.  Skapa ett Java-projekt i VS Code. Kontrollera att ni kan köra det.
    Använd gruppens gemensamma GitHub-repo och låt alla bidra med kod.
2.  Skriv ut välkomsttexten och menyn. Använd variabler för till exempel
    cafénamn, nästa ordernummer och om caféet är öppet.
3.  Läs användarens val. Använd en `while`-loop för att visa menyn tills
    användaren väljer Avsluta, och en `switch` för menyvalen.
4.  Kontrollera felaktiga menyval med `if/else`. Visa ett begripligt
    meddelande och gå tillbaka till menyn.
5.  Testa `String` och `equals` eller `equalsIgnoreCase` när ni
    exempelvis frågar om användaren vill fortsätta med ja/nej.

## Del 2 -- Produkter och beställningar

Nu ska vi sluta lagra allt i lösa variabler och i stället skapa objekt.

1.  Skapa klassen `Bestallning` med privata fält för ordernummer,
    kundnamn, produkt (typen `Produkt`) och status. En beställning
    innehåller en produkt. Skapa konstruktor, getters och lämpliga
    metoder för ändringar.
2.  Skapa en abstrakt klass `Produkt` med namn och pris. Låt `Kaffe`,
    `Macka` och `Flaskvatten` ärva från `Produkt`. Ge dem var sin
    version av en metod som beskriver produkten (`@Override`).
3.  Skapa interfacet `Tillagbar` med en metod för att förbereda en
    produkt. Låt `Kaffe` och `Macka` implementera det. Flaskvatten
    behöver inte göra det.
4.  Skapa enum `OrderStatus` med `NY`, `KLAR` och `HAMTAD`. Nya
    beställningar får status `NY`, färdigställda får `KLAR`. Vid menyval
    6 får endast en beställning med status `KLAR` lämnas ut och ändras
    till `HAMTAD`.
5.  Skriv metoder för att registrera en beställning och visa ett kvitto.
    Använd parametrar, `return`, `void` och en liten
    `static`-hjälpmetod. Överlagra gärna kvittometoden med två
    parameterlistor. Låt kunden bekräfta med tecknet J/N (`char`).

### Tänk på designvalet

-   En kaffe **ÄR** en produkt (`extends`).
-   En kaffe **KAN** tillagas (`implements`).

Lagra gärna beställningens produkt som `Produkt` -- då kan samma kod
hantera kaffe, macka och vatten.

## Del 3 -- Samlingar och en riktig kö

När en person beställer räcker det inte längre att ha en enda variabel.
Nu ska caféet hålla reda på flera beställningar samtidigt.

1.  Spara alla beställningar i en `List<Bestallning>`, exempelvis en
    `ArrayList`. De ska gå att visa i efterhand med ordernummer,
    kundnamn, produkt och status.
2.  Använd en `Queue<Bestallning>` för väntande beställningar. Vid "Gör
    klar nästa beställning" behandlas den äldsta först. Kör
    `Tillagbar`-metoden för kaffe och macka; flaskvatten blir `KLAR`
    direkt. Är kön tom, visa ett meddelande.
3.  **Extra:** Använd ett `Set<String>` för att få fram vilka olika
    produkter som har beställts. En produkt ska bara visas en gång i
    denna sammanställning.
4.  **Extra:** Använd en `Map<String, Integer>` för att räkna hur många
    av varje produkt som har sålts. Exempel: `Kaffe → 3`, `Macka → 2`.
5.  **Extra:** Spara namnen på kunderna i en lista, sortera en kopia med
    `Collections.sort` och låt användaren se namnen i bokstavsordning
    under statistik.
6.  **Extra:** Använd även en `Deque<Bestallning>` som historik över
    senast färdigställda beställningar. Visa de tre senaste, med den
    senaste först.

## Del 4 -- Dagens siffror

1.  Dela in dagen i tre pass: förmiddag, lunch och eftermiddag. Använd
    en `int[]` med tre platser för att räkna hur många order som
    registrerats under varje pass.
2.  Fråga vilket pass ordern hör till när ni registrerar den. Öka rätt
    plats i arrayen.
3.  Använd en enhanced loop för att räkna totalt antal beställningar
    från arrayen.
4.  Räkna ut dagens omsättning från bekräftade beställningar och deras
    genomsnittliga ordervärde. Om inga beställningar finns, visa 0 kr i
    stället för att dividera med noll.

Visa åtminstone: antal beställningar, omsättning och antal per pass.

**Extra:** antal per produkt, unika produkter och sorterade kundnamn.

## Del 5 -- Felhantering

Ett användbart program måste fungera även när någon skriver fel eller
matar in ett ogiltigt värde.

1.  Använd vanlig `if`-kontroll för förväntade fel, exempelvis menyval
    utanför 1--8 eller att en produkt inte finns på menyn.
2.  Låt en konstruktor eller metod kasta `IllegalArgumentException` med
    `throw` om den får information som aldrig är tillåten, exempelvis
    ett negativt pris eller ett tomt kundnamn.
3.  Läs ett menyval som text och omvandla det med `Integer.parseInt`.
    Fånga `NumberFormatException` med `try-catch` och låt användaren
    prova igen.
4.  **Extra:** Ta reda på vad `e.getMessage()` och en stack trace visar.
    Testa att medvetet skapa ett fel under utvecklingen, följ
    anropskedjan och rätta sedan tillbaka koden.

## Del 6 -- Clean Code

1.  Dela upp programmet i metoder med tydliga namn, så att `main` främst
    styr programflödet. Undvik långa metoder som gör allting.
2.  Använd `private` för fält som inte ska ändras fritt. Följ Javas
    namnstandard: klasser i `PascalCase`, variabler och metoder i
    `camelCase`.
3.  Gör minst en refaktorering: förbättra struktur eller namn utan att
    förändra vad programmet gör. Testa igen efteråt.
