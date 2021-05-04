# Zadanie 3 - Eshop
B-OOP 2021

Vašou úlohou je naprogramovať aplikačný server v jazyku Java s pomocou frameworku Spring.

Aplikačný server umožňuje správu tovaru, skladu a nákupných košíkov.
Webové rozhranie (API), ako aj objekty, ktoré sa používajú na komunikáciu s vonkajším svetom sú definované v zadaní a musi byť použité na komunikáciu cez webové služby. Mimo webového rozhrania môžete použiť ďalšie objekty podľa vášho návrhu, ak to uznáte za vhodné.

Špecifikáciu webového rozhrania, ktoré má aplikácia poskytovať nájdete tu: https://app.swaggerhub.com/apis-docs/sk-stuba-fei-uim-oop/OOP_Zadanie_3/1.0.0

Pokiaľ je v API uvedené, že sa má vrátiť kód 404 a v popise nie je povedané kedy, je ho potrebné vrátiť v prípade, že poskytnuté ID v systéme neexistuje.

### Popis systému

Podrobný popis jednotlivých operácii je uvedený v špecifikácii API.

Systém umožňuje pridávanie a odoberanie produktov zo sortimentu obchodu. Ďalej umožňuje úpravu existujúcich produktov, ako aj navýšenie stavu produktov na sklade.

Systém umožňuje vytváranie a vymazávanie objednávok. Do objednávok je možné pridávať produkty v určenom množstve (pokiaľ je produktu na sklade dostatok). Systém ďalej umožňuje zaplatenie ešte nezaplatených objednávok. Do zaplatených objednávok nie je možné pridávať ďalšie položky.

## Automatizované testy

Projekt obsahuje automatizované testy. Testy sa **NESPÚŠŤAJÚ** automaticky pri git push. Pokiaľ si chcete overiť na koľko vaša implementácia spĺňa testy musíte si ich spustiť sami. Testy sa dajú spustiť 2 spôsobmi:
* cez Maven, spustením _test_ lifecycle-u (bočné menu > maven > _projekt_ > lifecycle > test)
* spustením testov rovno z triedy ktorá ich obsahuje (nachádza sa v src/test/sk/.../oop/assignment3/Assignment3Tests.java)

## Hodnotenie

Zadanie je hodnotené 15 bodmi. **Odovzdaný program musí byť skompilovateľný, inak je
hodnotený 0 bodmi**. Skompilovateľnosť zadania kontroluje aj github pipeline. Hlavný dôraz v hodnotení sa kladie na objektový prístup a princípy OOP,
okrem iného:

* vhodné pomenovanie tried, metód a premenných v jednotnom jazyku (názvy tried s veľkým počiatočným písmenom, názvy metód s malým),
* vhodné použitie modifikátorov prístupu (public, private, poprípade protected) na obmedzenie prístupu k metódam a atribútom,
* využitie dedenia a polymorfizmu,
* použitie výnimiek na ošetrenie nedovoleného správania (nehádzať a nezachytávať všeobecnú triedu Exception),
* nepoužívajte nested classy,
* vo vašich triedach nevytvárajte statické metódy ani nekonštantné statické premenné (v zadaní nie sú potrebné),
* hlavná trieda (main) môže obsahovať len kód potrebný na inicializáciu aplikácie pomocou Spring frameworku,
* vo svojom riešení môžete použiť knižnicu lombok a jej anotácie. Potrebná dependencia je už pridaná v _pom.xml_ súbore.

10 bodov je možné získať za automatizované testy. Za 9 a menej prejdených testov je udelených 0 bodov za každý ďalší test je udelených 0.5 bodu. Vo výnimočných prípadoch môžeme udeliť za testy menej bodov.

## Odovzdávanie
Zadanie si naklonujte z repozitára zadania výhradne pomocou poskytnutej linky cez GitHub Classroom (pokiaľ si vygenerujete vlastný repozitár pomocou tlačidla "Use this template" z template repozitára, my váš repozitár neuvidíme a nebudeme ho hodnotiť!). Svoje vypracovanie nahrajte do pre vás vytvoreného repozitára pre toto zadanie pomocou programu Git (git commit + git push).
Skontrolujte si, či sa váš repozitár nachádza pod skupinov **Interes-Group**, inak nemáme prístup ku vášmu repozitáru a zadanie sa nepovažuje za odovzdané. Vypracovanie môžete "pusho-vať" priebežne. Hodnotiť sa bude iba _master_ branch. Zadanie je nutné vypracovať do **21.5.2021 23:00**.

V projekte upravujte iba súbory v priečinku _src/main_ a jeho podpriečinkoch. Ostatné súbory je upravovať zakázané (predovšetkým súbory _pom.xml_, súbory obsahujúce github pipeline-y a súbory obsahujúce automatizované testy).

Vo svojom github účte si nastavte svoje meno (settings > profile > name), aby bolo možné priradiť riešenie ku študentovy. **Pokiaľ nebude možné spárovať študenta s riešením je zadanie hodnotené 0 bodmi!**


# Assignment 3 - Eshop

B-OOP 2021

Your task is to create an application server using Java with the Spring framework.

Application server  enables management of goods, warehouse and shopping carts. Web Interface (API), and also the objects that are used to communicate with the outside world are defined in the specification and must be used to communicate through web services. Outside the web interface you can use any other objects according to your design, if you deem it appropriate.

Web interface specification that the application has to follow can be found here: https://app.swaggerhub.com/apis-docs/sk-stuba-fei-uim-oop/OOP_Zadanie_3/1.0.0

If the specification states that a 404 code should be returned, and the description does not say when, it is necessary to return if given ID does not exist in the system.

### System description

A detailed description of each operation is given in the API specification.

The system allows adding and removing of products from the store's selection of goods. Furthermore, it allows editing of existing products as well as increase the amount of products in stock.

The system allows you to create and delete orders (shopping carts). It is possible to add products into orders in the specified quantity (if there is enough of the product in stock). The system also allows the payment of yet unpaid orders. It is not possible to add additional items to paid orders.

## Automated tests
Project contains automated tests. Tests **DO NOT** run automatically on git push. If you want to verify how much of your implementation passes the tests, you must run them yourself. Tests can be run in 2 ways:

* using Maven, by launching lifecycle (side menu> maven> project> lifecycle> test)
* by running tests directly from the class that contains them (located in src/test/sk/.../oop/assignment3/Assignment3Tests.java)

## Evaluation

You can get 15 points for this assignment. **The program must be able to compile, otherwise 0 points are given for the assigment**.

The github pipeline checks whether the program can be compiled. The main focus during grading is put on object-oriented approach and OOP principles used by the solution.

Including, but not limited to:

* appropriate naming of classes, methods and variables in a single language (class names starting with a capital letter, method names starting with a lowercase letter),

* appropriate use of access modifiers (public, private, or protected) when restricting access to class methods and attributes,

* the use of inheritance and polymorphism,

* usage of exceptions when handling undesired behavior (do not catch or throw the instances of the generic Exception class),

* don't use nested classes,

* don't use static methods, or non-constant static variables (you don't need them to complete the assignment),

* don't put any logic into the main method and its class. The main method should only be used to initialize application using the Spring framework,

* you can use the lombok library and its annotations in your solution. The necessary dependency is already present in the _pom.xml_ file.

10 points are received by passing automated tests. For 9 or less passed tests 0 points are awarded. For each passed test above 9, 0.5 points is awarded. In special circumstances we can give fewer points for passed tests.

## Handing in the assigment

Clone the assignment from the repository created from this template by the provided link trough GitHub Classroom (if you create your own repository with the "use this template" button, we won't be able to see your repository, and we won't be able to grade it!). Upload your solutions to your repository using the Git version control system (git commit + git push).

Make sure, that your repository was created under the **Interes-Group** group, otherwise we won't be able to access your repository, and the assignment will not be graded.

You can push commits to the repository while you work - you don't have to push everything at once. Only the code in the _master_ branch will be graded. You have until **21.5.2021 23:00** to complete the assignment.

Only edit files in the _src/main_ folder or its sub-folders. You mustn't change any other files in the repository (especially the _pom.xml_ file, and the github pipeline files).

You have to have your name set in your github account (settings > profile > name), so that we can match students with their assignments. **If we are unable to match a student with their assignment, the student will receive 0 points for the assignment!**
