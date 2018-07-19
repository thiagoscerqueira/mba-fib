
# Avaliação "Desenvolvimento em Ambiente iOS"

A fim de facilitar a realização da avaliação, todos os exercícios referem-se somente a linguagem Swift.

Para cada exercício, há somente uma opção correta. Caso a alternativa seja "Código não compila" ou "Código compila, mas resulta em erro fatal", explique qual o problema que impede a execução.

São 39 questões, portanto, cada uma vale 10/39 ponto. Caso alguma questão seja inválida, i.e. nenhuma das respostas se aplica (o que não é para acontecer), ela será removida da contagem e o valor das questões remanescentes será recalculado.

A data final de entrega é 20/07/2018 23:59. A entrega deve ser feita para o email luiz.warg@gmail.com, com o assunto "[FIB/IOS] Avaliação - <seu_nome>" e as respostas podem ser uma mera cópia deste markdown, com as opções escolhidas checkadas.

Este markdown pode ser melhor visualizado no [StackEdit](https://stackedit.io/app), que permite, inclusive, checkar as respostas.

Os trechos de código dos exercícios podem ser testados online no [repl.it](https://repl.it/repls/BrightIndolentShell), além de, possivelmente, outros ambientes REPL Swift online.

**Atenção:** durante a realização dos exercícios, prestar muita atenção aos trechos de código e as respostas. Há "pegadinhas".

## Questões

**1. Qual a saída produzida pelo seguinte trecho de código?**
```swift
struct Spaceship {
    var name: String {
        willSet {
            print("I'm called \(newValue)!")
        }
    }
}

var serenity = Spaceship(name: "Serenity")
serenity.name = "TARDIS"
```
- [ ] "I'm called Serenity"
- [x] "I'm called TARDIS"
- [ ] "I'm called Serenity", "I'm called TARDIS"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**2. Qual a saída produzida pelo seguinte trecho de código?**
```swift
struct Starship {
    var name: String
}

let tardis = Starship(name: "TARDIS")
var enterprise = tardis
enterprise.name = "Enterprise"

print(tardis.name)
```
- [x] "TARDIS"
- [ ] "Enterprise"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**3. Qual a saída produzida pelo seguinte trecho de código?**
```swift
for i in 1...3 {
    print(i)
}
```
- [ ] "1", "2"
- [ ] "2"
- [x] "1", "2", "3"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**4. Qual a saída produzida pelo seguinte trecho de código?**
```swift
enum Weather {
    case sunny
    case cloudy
    case windy(speed: Int)
}

let today: Weather = .windy(speed: 10)

switch today {
case .sunny, .cloudy:
    print("It's not that windy")
case .windy(let speed) where speed >= 10:
    print("It's very windy")
default:
    print("It's a bit windy")
}
```
- [ ] "It's not that windy"
- [x] "It's very windy"
- [ ] "It's a bit windy"
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**5. Qual a saída produzida pelo seguinte trecho de código?**
```swift
for i in 3...1 {
    print(i)
}
```
- [ ] "1", "2"
- [ ] "1", "2", "3"
- [ ] "2"
- [ ] "3", "2"
- [ ] "3", "2", "1"
- [ ] nada
- [x] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**6. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let names = ["Serenity", "Sulaco", "Enterprise", "Galactica"]

if let last = names.last {
    print(last)
}
```
- [ ] "Serenity"
- [x] "Galactica"
- [ ] "Optional(Serenity)"
- [ ] "Optional(Galactica)"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**7. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let i = 3

switch i {
case 1:
    print("Number was 1")
case 2:
    print("Number was 2")
case 3:
    print("Number was 3")
}
```
- [ ] "Number was 1"
- [ ] "Number was 2"
- [ ] "Number was 3"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [x] Código não compila

**8. Qual a saída produzida pelo seguinte trecho de código?**
```swift
final class Dog {
    func bark() {
        print("Woof!")
    }
}

class Corgi : Dog {
    override func bark() {
        print("Yip!")
    }
}

let muttface = Corgi()
muttface.bark()
```
- [ ] "Woof"
- [ ] "Yip!"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [x] Código não compila

**9. Qual a saída produzida pelo seguinte trecho de código?**
```swift
class Starship {
    var type: String
    var age: Int
}

let serenity = Starship(type: "Firefly", age: 24)
print(serenity.type)
```
- [ ] "Firefly"
- [ ] "" (string vazia)
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [x] Código não compila

**10. Ao final do trecho de código seguinte, qual será o conteúdo do array `names`?**
```swift
let names = [String]()
names.append("Amy")
names.append("Clara")
names.append("Rory")
```
- [ ] ["Amy", "Clara", "Rory"]
- [ ] ["Amy"]
- [ ] ["Rory"]
- [ ] [ ] (array vazio)

**11. Ao final do trecho de código seguinte, qual será o conteúdo da constante `j`?**
```swift
let i = "5"
let j = i + i
```
- [ ] "5"
- [ ] 55
- [x] "55"
- [ ] 10
- [ ] "" (string vazia)
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**12. Ao final do trecho de código seguinte, qual será o conteúdo do array `third`?**
```swift
let first = ["Sulaco", "Nostromo"]
let second = ["X-Wing", "TIE Fighter"]
let third = first + second
```
- [ ] ["Nostromo", "Sulaco", "TIE Fighter", "X-Wing"]
- [ ] ["X-Wing", "TIE Fighter", "Sulaco", "Nostromo"]
- [ ] ["Sulaco", "Nostromo"]
- [x] ["Sulaco", "Nostromo", "X-Wing", "TIE Fighter"]
- [ ] [ ] (array vazio)
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**13. Ao final do trecho de código seguinte, qual será o valor da constante `num`?**
```swift
let num = UInt.min
```
- [ ] -9223372036854775808
- [ ] 9223372036854775807
- [ ] 32767
- [ ] -32767
- [x] 0
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**14. Qual a saída produzida pelo seguinte trecho de código?**
```swift
func sayHello(to name: String) -> String {
    return "Howdy, \(name)!"
}

print("\(sayHello(to: "Jayne"))")
```
- [ ] "(String) - > (String)"
- [ ] "Howdy, \(name)!"
- [x] "Howdy, Jayne!"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**15. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let names = ["Chris", "Joe", "Doug", "Jordan"]

if let name = names[1] {
    print("Brought to you by \(name)")
}
```
- [ ] "Brought to you by Optional(Joe)"
- [ ] "Brought to you by Chris"
- [ ] "Brought to you by Joe"
- [ ] "Brought to you by Jordan"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [x] Código não compila

**16. Ao final do trecho de código seguinte, qual o conteúdo da constante `numbers`?**
```swift
let numbers = [1, 2, 3].map { [$0, $0] }
```
- [ ] [1, 2, 3]
- [ ] [3, 2, 1]
- [x] [[1, 1], [2, 2], [3, 3]]
- [ ] [[1, 1], [1, 2], [1, 3]]
- [ ] [[1, 1], [2, 1], [3, 1]]
- [ ] [ ] (array vazio)
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**17. Ao final do trecho de código seguinte, qual o conteúdo da constante `names`?**
```swift
var names = [String]()
names.reserveCapacity(2)
names.append("Amy")
names.append("Rory")
names.append("Clara")
```
- [ ] ["Amy", "Rory"]
- [ ] ["Rory", "Clara"]
- [x] ["Amy", "Rory", "Clara"]
- [ ] [] (array vazio)
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**18. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let numbers = Array(1..<10)
print(numbers.count)
```
- [x] "9"
- [ ] "10"
- [ ] "11"
- [ ] "0"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**19. Qual a saída produzida pelo seguinte trecho de código?**
```swift
enum MyError: Error {
    case broken
    case busted
    case badgered
}

func willThrowAnError() throws {
    throw MyError.busted
}

do {
    try willThrowAnError()
} catch MyError.busted {
    print("Code was busted!")
} catch {
    print("Code just didn't work")
}
```
- [x] "Code was busted"
- [ ] "Code just didn't work"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**20. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let number = 5

switch number {
case 0..<5:
    print("First group")
case 5...10:
    print("Second group")
case 0...5:
    print("Third group")
default:
    print("Fourth group")
}
```
- [ ] "First group"
- [x] "Second group"
- [ ] "Third group"
- [ ] "Fourth group"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**21. Qual a saída produzida pelo seguinte trecho de código?**
```swift
func fizzbuzz(number: Int) -> String {
    switch (number % 3 == 0, number % 5 == 0) {
    case (true, false):
        return "Fizz"
    case (false, true):
        return "Buzz"
    case (true, true):
        return "FizzBuzz"
    default:
        return String(number)
    }
}

print(fizzbuzz(number: 15))
```
- [ ] "Fizz"
- [ ] "Buzz'
- [x] "FizzBuzz"
- [ ] "15"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**21. Qual a saída produzida pelo seguinte trecho de código?**
```swift
func greet(names: String...) {
    print("Criminal masterminds:", names.joined(separator: ", "))
}

greet(names: "Malcolm", "Kaylee", "Zoe")
```
- [ ] "Criminal masterminds:", ["Macolm", "Kaylee", "Zoe"]
- [ ] "Criminal masterminds:", "Macolm", "Kaylee", "Zoe"
- [ ] "Criminal masterminds:", "Macolm, Kaylee, Zoe"
- [x] "Criminal masterminds: Macolm, Kaylee, Zoe"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**22. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let people = [String](repeating: "Malkovitch", count: 2)
print(people)
```
- [x] ["Malkovitch", "Malkovitch"]
- [ ] ["Malkovitch, Malkovitch"]
- [ ] "Malkovitch", "Malkovitch"
- [ ] "Malkovitch, Malkovitch"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**23. Ao final do trecho de código seguinte, qual será o tamanho do array `result`?**
```swift
let numbers = [1, 3, 5, 7, 9]
let result = numbers.filter { $0 >= 5 }
```
- [ ] 0
- [ ] 1
- [ ] 2
- [x] 3
- [ ] 4
- [ ] 5

**24. Dado o código seguinte e assumindo que NÃO é feito *cast* algum, selecione a opção correta.**
```swift
var foo: Float = 32
var bar: Double = 32
```
- [ ] Ambas as variáveis podem ser atribuídas uma a outra
- [ ] `foo` pode ser atribuída a `bar`, mas o contrário não é possível
- [ ] `bar` pode ser atribuída a `foo`, mas o contrário não é possível
- [x] Nenhuma variável pode ser atribuída a outra
- [ ] Nenhuma das anteriores

**25. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let names = ["Simon", "River", "Book"]

names.forEach {
    print($1)
}
```
- [ ] "Simon", "River", "Book"
- [ ] "River"
- [ ] "River", "Book"
- [ ] "", "", ""
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [x] Código não compila

**26. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let names = ["Pilot": "Wash", "Doctor": "Simon"]
let doctor = names["doctor"] ?? "Bones"
print(doctor)
```
- [ ] "nil"
- [ ] "Simon"
- [ ] "Optional(Simon)"
- [x] "Bones"
- [ ] "Simon", "Bones"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**27. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let userLoggedIn: Bool? = false

if !userLoggedIn! {
    print("Message one")
} else {
    print("Message two")
}
```
- [x] "Message one"
- [ ] "Message two"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**28. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let point = (556, 0)
switch point {
case (let x, 0):
    print("X was \(x)")
case (0, let y):
    print("Y was \(y)")
case let (x, y):
    print("X was \(x) and Y was \(y)")
}
```
- [x] "X was 556"
- [ ] "Y was 0"
- [ ] "X was 556 and Y was 0"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**29. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let numbers = [1, 3, 5, 7, 9]
let result = numbers.map { $0 * 10 }
print(numbers)
```
- [x] "[1, 3, 5, 7, 9]"
- [ ] "[10, 30, 50, 70, 90]"
- [ ] "250"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**30. Qual a saída produzida pelo seguinte trecho de código?**
```swift
func foo(_ number: Int) -> Int {
    func bar(_ number: Int) -> Int {
        return number * 5
    }

    return number * bar(3)
}

print(foo(2))
```
- [ ] "10"
- [ ] "15"
- [ ] "2"
- [ ] "3"
- [x] "30"
- [ ] "nada"
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**31. No código seguinte, qual o tipo da constante `testVar`?**
```swift
let names = ["Pilot": "Wash", "Doctor": "Simon"]

for (key, value) in names.enumerated() {
    let testVar = value
}
```
- [ ] (String, String) - tupla
- [ ] String
- [ ] [String, String]
- [ ] Entry<String, String>
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**32. Qual a saída produzida pelo seguinte trecho de código?**
```swift
struct NirvanaFan {
    static var favoriteSong = "Smells like teen spirit"
    var name: String
    var age: Int
}

let fan = TaylorFan(name: "James", age: 25)
print(fan.favoriteSong)
```
- [ ] "Smells like teen spirit"
- [ ] "nil"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [x] Código não compila

**33. No código seguinte, qual o valor da constante `result`?**
```swift
let numbers = [1, 3, 5, 7, 9]
let result = numbers.reduce(0, +)
```
- [ ] "1, 3, 5, 7, 9"
- [ ] "13579"
- [ ] (1, 3, 5, 7, 9) - tupla
- [ ] 0
- [ ] 1
- [x] 25
- [ ] [1, 3, 5, 7, 9]

**34. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let names = ["River", "Kaylee", "Zoe"]
let result = names.sorted { $0 > $1 }
print(result)
```
- [ ] "[\"Kaylee\", \"River\", \"Zoe\"]"
- [ ] "[\"Kaylee\"]"
- [x] "[\"Zoe\", \"River\", \"Kaylee\"]"
- [ ] "[\"Zoe\"]"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**35. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let names: [String?] = ["Barbara", nil, "Janet", nil, "Peter", nil, "George"]

if let firstName = names.first {
    print(firstName)
}
```
- [ ] "Barbara"
- [x] "Optional(\"Barbara\")
- [ ] "nil"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**37. Qual a saída produzida pelo seguinte trecho de código?**
```swift
func foo(_ function: (Int) -> Int) -> Int {
    return function(function(5))
}

func bar(_ number: Int) -> Int {
    return number * 3
}

print(foo(bar))
```
- [ ] 15
- [ ] 3
- [ ] 45
- [ ] 5
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**38. Ao final do trecho de código seguinte, qual o valor da constante `result`?**
```swift
func fetchCrewMember() -> (job: String, name: String) {
    return ("Public Relations", "Jayne")
}

let result = fetchCrewMember().0
```
- [ ] "Jayne"
- [ ] "Public Relations"
- [ ] ("Public Relations", "Jayne") - tupla
- [ ] (0) - tupla
- [ ] ["Public Relations", "Jayne"]
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila

**39. Qual a saída produzida pelo seguinte trecho de código?**
```swift
let string: String = String(describing: String.self)
print(string)
```
- [ ] ""
- [ ] "String"
- [ ] "Swift.String"
- [ ] "nil"
- [ ] nada
- [ ] Código compila, mas resulta em erro fatal
- [ ] Código não compila
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTM1NTAzODA4MSwtMTUyMzgyMzA1NywzND
QwODg1MzUsMTg3OTYwMTcxMSwtNzQ3MzQ5NTUzLDk1ODI1NDI3
OSwtNzY2Mzk0MDg5LC03ODI0OTc0MzMsMjA0ODM2Mjc2N119
-->