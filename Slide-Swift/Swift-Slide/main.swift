//
//  main.swift
//  Swift-Slide
//
//  Created by Omid on 6/21/20.
//  Copyright © 2020 MobileProgramming. All rights reserved.
//

import Foundation

/***** Declaring Constans and Variables *****/

print("\n Outputs of 'Declaring Constans and Variables' part : \n")
let a = 10
// a = 20 Error!!

var b = 10
print("var b = '\(b)'")
b = 20
print("var b now is '\(b)'")

let name : String = "My name"
print(name + " is Omid")

let  π = 3.1415
print("π = \(π) !!!")

// semicolons
let tetha_symbol = "θ"; let tetha_value = 30
print(tetha_symbol + " = \(tetha_value)")

// Integers
let minValue = UInt16.min
let maxValue = UInt16.max

print("Min value of Uint16 is \(minValue) and Max value is \(maxValue)")

// Output is double
let newPi = 3 + 0.1415
print("Is pi equal to zero? \(newPi.isZero)")

// Numeric Literals
let decimalNumber = 10
let binaryNumber = 0b1010
let octalNumber = 0o12
let hexadecimalNumber = 0xa

print("\(decimalNumber) = \(binaryNumber) = \(octalNumber) = \(hexadecimalNumber) !!! :))")

// extra formating make easier to read a number

let oneMillion = 1_000_000
let justOverOneMillion = 1_000_000.000_000_1

print("One million = \(oneMillion) and \(justOverOneMillion) is just over it.")


// integer conversion

let three = 3 // this is int
let pointOneFourOneFiveNine = 0.14159 // this is double
let pi = Double(three) + pointOneFourOneFiveNine // we need conversion here

print("PI is always equal to \(pi) !!")

// Booleans

let True = true
let i = 1

/*
 we can not use i as a boolean
 
 if (i == True) {
    print("Error")
 }

 if (i) {
    print("Error Again!!")
 }

 */

if (i==1) {
    print("Variable i is integer 1 but not a boolean :))")
}

/*
if (Bool(i)) {
    print("we can not convert Int to Bool!")
}
*/

// Tuples

let http404Error = ("Not found", 404)
let (statusMessage, statusCode) = http404Error

print("The status code is \(statusCode) and status message is \(statusMessage) ")
print("Again status code is \(http404Error.1) and status message is \(http404Error.0) ")

var httpStatus = (statusCode: 200, description: "OK")

print("** Code = \(httpStatus.statusCode), Description = \(httpStatus.description)")

httpStatus.statusCode = 404
httpStatus.description = "Not found"

print("** Code = \(httpStatus.statusCode), Description = \(httpStatus.description)")

// Optionals && nil

let possibleNumber = "Ali"

// * no to Int method in swift 2.x and above
// let convertedNumber = possibleNumber.toInt()

let convertedNumber = Int(possibleNumber)

if (convertedNumber != nil) {
    print("\(possibleNumber) has an integer value of \(convertedNumber!)")
} else {
    print("\(possibleNumber) is not an integer!")
}

// Assert

/*
 One level up from print() are assertions, which are debug-only checks that will force your app to crash if a specific condition isn't true.
 These assertion crashes only happen while you’re debugging. When you build a release version of your app – i.e., when you ship your app to the App Store – Xcode automatically disables your assertions so they won’t reach your users. This means you can set up an extremely strict environment while you’re developing, ensuring that all values are present and correct, without causing problems for real users. */



// Arithmetic operantors

print("\n Arithmetic operantors")
print("\(10) / \(2.3) = \(10/2.3) it is exactly as same as \(10.0) / \(2.3) = \(10.0/2.3)")
print("But \(10) / \(3) = \(10/3) and \(10.0) / \(3) = \(10.0/3) or \(10.0) / \(3) = \(10/3.0)")
print("Also for * we have : \(10) * \(3.0) = \(10*3.0) that is a double product.")

// Floating-Point Remainder

print("*** \(8.0) % \(0.3) is Error !!")
print("*** \(8.0) % \(3.0) is Error !!")
print("*** \(8) % \(3) = \(8%3)")
print("*** \(8.0).truncatingRemainder(dividingBy: \(0.3)) = \(8.0.truncatingRemainder(dividingBy: 0.3))")


// Increment and decrement operators

    // ++ and -- was removed from Swift 3. But += and -= remained

// Ternary Condition Operator ( Favorit of hardware developers :)) )

var dadheight = 170.0
let childheight = 120 + 0.2 * dadheight +
    ((dadheight > 150) ? 20 : 5) + ((dadheight > 180) ? 15 : 5);

print("Dad height is \(dadheight) and child height is \(childheight)")

// Range Operator

print("\n   Swift has range operator like python ")
for index in 1...5 {
    print ("\(index) ");
}



/*****  Strings, Arrays and dictionary  ******/

print("\n Outputs of 'Strings, Arrays and dictionary' part : \n")

var orginalString = "Ali"
var copyString = orginalString
copyString += "Reza"

print("Orginal string is \(orginalString) and copied one is \(copyString)")

var myName = String()
for char in copyString {
    myName += String(char)
    print("\(myName)")
}

// ** after swift1 we do not have count element
print("AliReza has \((copyString.characters.count)) characters")


// String Equality

let name1 = "Ali"
var name2 = "Ali"
(name1 == name2) ? print("These two strings are equal !") : print("These two strings are not equal !!")

// Prefix

print("Has '\(copyString)' 'Ali' prefix? \(copyString.hasPrefix(orginalString))")
print("Uppercase of \(copyString) is \(copyString.uppercased()) and it's lowercase is \(copyString.lowercased())")


// Arrays

// Array types are now written with the brackets around the element type

var shoppingList : [String] = ["Milk", "Egg"]
shoppingList.append(contentsOf: ["Flour", "Baking Powder"])

print("  Shooping list contains :")
for index in 0..<shoppingList.count {
    print("   - \(shoppingList[index])")
}

print("shoppingList[1...3] = \(shoppingList[1...3])")


// enumerated

print("  Shooping list contains :")
for (index, value) in shoppingList.enumerated() {
    print("  \(index+1). \(value) ")
}

var fibonacci : [Int] = [1, 1]

for index in 2..<15 {
    fibonacci.append(contentsOf: [fibonacci[index-2] + fibonacci[index-1]])
}

print("Fibonacci : \(fibonacci)")


// dictionaries

var airports: Dictionary<String, Int> = ["IR" : 2, "UK" : 5]
airports["Ca"] = 4
airports["IR"] = 1
airports["UK"] = nil

print("  Dictionary contains data of following countries:")
for (countries, _) in airports {
    print("  - \(countries)")
}

/***** Loops and conditions *****/

print("\n Outputs of 'Loops and conditions' part : \n")

let base = 7
let power = 5
var ans = 1
for _ in 1...power {
    ans *= base
}

print("\(base) ^ \(power) = \(ans)")

// C style :')
//**** C-style for statement has been removed in Swift 3 :(((
/*
    for (var i = 0; i < 3; i+=1) {
        print("We Love C style for loop ! :)")
    }
*/

// Switch Case !

let memory = 27

switch (memory % 16) {
case 0:
    print("We need \(memory/16) words")
case 1...7:
    print("We need \(memory/16) words and \(memory%16) bits")
case 8:
    print("We need \(memory/16) words and 1 Byte")
case 9...15:
    print("We need \(memory/16) words and 1 Byte and \(memory%16 - 8) bits")
default:
    print("Error!")
}

// Tuples

let somePoint = (0, 4)
switch somePoint {
case (0, 0):
    print("(0, 0) is at the origin")
case (_, 0):
    print("(\(somePoint.0), 0) is on the x-axis")
case (0, _):
    print("(0, \(somePoint.1)) is on the y-axis")
case (-2...2, -2...2):
    print("(\(somePoint.0), \(somePoint.1)) is inside the box")
default:
    print("(\(somePoint.0), \(somePoint.1)) is outside the box")
}

// break and continue

exit : for x in 1...3 {
    for y in 1...3 {
        if y == 2 {
            continue exit
        }
        if x==2 && y==2 {
            break exit
        }
        print("x = \(x), y = \(y)")
    }
}

//***** Functions *****//

print("\n Outputs of 'Functions' part : \n")

func sayHi(personName: String) {
    print("Hi \(personName)")
}

sayHi(personName: "Ali")

func join(String s1: String, toString s2: String, withJoiner joiner: String) -> String {
    return s1+joiner+s2
}

print("Join of Ali and Nazari with joiner _ is '\(join(String: "Ali", toString: "Nazari", withJoiner: "_"))'")

func joinWithDefaultJoiner(String s1: String, toString s2: String, withJoiner joiner: String = " ") -> String {
    return s1+joiner+s2
}

print("Join of Ali and Nazari with nondefined joiner is '\(joinWithDefaultJoiner(String: "Ali", toString: "Nazari"))'")

func arithmeticMean(numbers: Double...) -> Double {
    var total: Double = 0
    for number in numbers {
        total += number
    }
    
    return total / Double(numbers.count)
}

print("Arithmetic mean of 3, 6, and 10 is \(arithmeticMean(numbers : 3, 6, 10))")


// var for function parameter not works
/*
func magicRepeatString(var string : String, count: Int) -> String {
    var result : String
    for index in 1...count {
        string += string
        result += string
    }
    return result
}

print("3 times of Omid is \(magicRepeatString(string: "Omid", count: 3)) !!!")

*/

/**** inout before a parameter name is not allawed
func swapi(inout a: Int, inout b: Int) {
    let tempA = a
    a = b
    b = tempA
}
*/

func swapi(a: inout Int, b: inout Int) {
    let tempA = a
    a = b
    b = tempA
}

/*
let aa = 2
let bb = 3
swapi(a : aa, b : bb)
*/
// Error. We can not pass immutable value as inout argument

var aa = 2
var bb = 3
swapi(a: &aa, b: &bb)

print("\(aa), \(bb)")


func chooseStepFunction (backwards : Bool) -> (Int) -> Int {
    func stepForward(input: Int) -> Int { return input + 1 }
    func stepBackward(input: Int) -> Int { return input - 1 }
    return backwards ? stepBackward : stepForward;
}

var currentValue = -4
let moveNearToZero = chooseStepFunction(backwards: (currentValue > 0))

while (currentValue != 0) {
    print("\(currentValue) ...")
    currentValue = moveNearToZero(currentValue)
}

print("Zero !!")

var students = ["Reza", "Omid", "Ali"]
students.sort(by : {(s1: String, s2: String) -> Bool in return s1 > s2})
print("Students' name sorted in reverse : \(students)")

let digitNames = [0: "Zero", 1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five", 6: "Six", 7: "Seven", 8: "Eight", 9: "Nine", 10: "Ten"]
let numbers = [16, 58, 510]

let string = numbers.map {
    (n: Int) -> String in
    var output = ""
    var tmp = n
    while tmp > 0 {
        output = digitNames[tmp%10]! + output
        tmp/=10
    }
    return output
}

print("\(numbers) = \(string)")

// Enumerations

enum CompassPont {
    case North
    case South
    case East
    case West
}

var direction : CompassPont
direction = .West

switch direction {
case .West:
    print("This is West")
default:
    print("This is not West")
}

enum Barcode {
    case UPCA(Int, Int, Int)
    case QRCode(String)
}

var productBarcode = Barcode.UPCA(8, 85909_51226, 3)

switch productBarcode {
case .UPCA(let numberSystem, let identifier, let check):
    print("UPC-A with value of \(numberSystem), \(identifier), \(check).")
    
case .QRCode(let productCode):
    print("QR code with value of \(productCode)")
}

//***** Classses and Stuctures *****//

print("\n Outputs of 'Classes and Structures' part : \n")

class student {
    var name : String?
    var score = 0
}

let studentA = student()
studentA.score = 15
let studentB = studentA
let studentC = studentB
studentC.score = 20
print("A score : \(studentA.score); B score : \(studentB.score); C score : \(studentC.score)")

if (studentC === studentA) {
    print("A and C reffer to same student!")
}

struct Point {
    var x = 0.0, y = 0.0
}

struct Size {
    var width = 0.0, height = 0.0
}

struct Rect {
    var orgin = Point()
    var size = Size()
    var center: Point {
        get {
            let centerX = orgin.x + (size.width / 2)
            let centerY = orgin.y + (size.height / 2)
            return Point(x: centerX, y: centerY)
        }
        set(newCenter) {
            orgin.x = newCenter.x - (size.width / 2)
            orgin.y = newCenter.y - (size.height / 2)
        }
    }
    
    var area : Double {
        return size.width * size.height
    }
}

var square = Rect(orgin: Point(x: 0, y: 0), size: Size(width: 5, height: 5))
print("Square center is at (\(square.center.x), \(square.center.y)) with Area = \(square.area)")

square.center = (Point(x: 10, y: 10))
print("Square center is at (\(square.center.x), \(square.center.y)) with Area = \(square.area)")

class StepCounter {
    var totalStep: Int = 0 {
        willSet(newSteps) {
            print("\nAbout to set totalStep to \(newSteps)")
        }
        didSet {
            if(totalStep >= oldValue) {
                print("Added \(totalStep - oldValue) steps")
            } else {
                print("Removed \(oldValue - totalStep) steps")
            }
        }
    }
}

let stepCounter = StepCounter()
stepCounter.totalStep = 200
stepCounter.totalStep = 360
stepCounter.totalStep = 270

class Counter {
    var count: Int = 0
    func incrementBy(amount: Int, numberOfTimes: Int) {
        count += amount * numberOfTimes
    }
}

let counter = Counter()

// Not work without identifier
// counter.incrementBy(5, numberOfTimes: 3)
counter.incrementBy(amount: 5, numberOfTimes: 3)
print("Count = \(counter.count)")

// Subscripts

struct TimesTable {
    let multiplier: Int
    subscript(index: Int) -> Int {
        return multiplier * index
    }
}

let threeTimesTable = TimesTable(multiplier : 3)
print("six times three is \(threeTimesTable[6])")


// Inheritance

class Vehicle {
    var numberOfWheels: Int
    var numberOfPassengers: Int
    func description() -> String {
        return "\(numberOfWheels) wheels; and it has \(numberOfPassengers) passanger"
    }
    init() {
        numberOfWheels = 0
        numberOfPassengers = 1
        print("Vehicle init Finished!")
    }
}

class Bicycle: Vehicle {
    override init() {
        super.init()
        numberOfWheels = 2
        print("Bicycle init Finished!")
        
    }
}

print("Bicycle has \(Bicycle().description())")

// Overriding and Initializer Inheritance

class Car: Vehicle {
    var speed: Double = 0.0
    override init() {
        super.init()
        numberOfPassengers = 5
        numberOfWheels = 4
        print("Car init Finished!")
    }
    init(speed : Double) {
        super.init()
        numberOfPassengers = 5
        numberOfWheels = 4
        self.speed = speed
        print("Car init Finished!")
        
    }
    override func description() -> String {
        return super.description() + ";" + "traveling at \(speed) mph"
    }
}

class SpeedLimitedCar: Car {
    override var speed: Double {
        get {
            return super.speed
        }
        set {
            super.speed = min(newValue, 40.0)
        }
    }
}

var speedLimitedCar = SpeedLimitedCar(speed: 60.0)
print("Speed limeted car has \(speedLimitedCar.description())")

speedLimitedCar = SpeedLimitedCar()
speedLimitedCar.speed = 60.0
print("Speed limeted car has \(speedLimitedCar.description())")

// ARC

class Person {
    let name: String
    init(name: String) {
        self.name = name
        print("\(name) is being initialized")
    }
    deinit {
        print("\(name) is being deinitialized")
    }
}

var reference1: Person?
var reference2: Person?
var reference3: Person?

reference1 = Person(name: "Ali")
reference2 = reference1
reference3 = reference2

print("reference1 = nil")
reference1 = nil

print("reference2 = nil")
reference2 = nil

print("reference3 = nil")
reference3 = nil

// Strong Reference Cycle

class Owner {
    let name: String
    init(name : String) {
        self.name = name
    }
    var apartmant: Apartment?
    deinit {
        print("\(name) is being deinitialized")
    }
}

class Apartment {
    let number: Int
    init(number: Int) {
        self.number = number
    }
    var tenant: Owner?
    deinit {
        print("Apartment #\(number) is being deinitialized")
    }
}

var Adam: Owner?
var number742: Apartment?

Adam = Owner(name: "Adam Zadeh")
number742 = Apartment(number: 742)

Adam!.apartmant = number742
number742!.tenant = Adam

Adam = nil
number742 = nil
// ARC do nothing in this case !!!

// Weak refrence and Optional Chaning

class OwnerWeak {
    let name: String
    init(name : String) {
        self.name = name
    }
    var apartmant: ApartmentWeak?
    deinit {
        print("\(name) is being deinitialized")
    }
}

class ApartmentWeak {
    let number: Int
    init(number: Int) {
        self.number = number
    }
    weak var tenant: OwnerWeak?
    deinit {
        print("Apartment #\(number) is being deinitialized")
    }
}

var john : OwnerWeak?
var number743 : ApartmentWeak?

john = OwnerWeak(name: "John")
number743 = ApartmentWeak(number: 743)

john!.apartmant = number743
number743!.tenant = john

john = nil
if number743?.tenant?.name != nil {
    print("\(number743?.tenant?.name)")
} else {
    print("Owner is not available")
}
number743 = nil

// Unowned references

// It is just like weak reference, but it assume to always have a value. So an unowned reference is always defined as a non-optional type


// ERROR ???!! :??
/*
class Country {
    let name: String
    let capitalCity: City!
    init(name: String, capitalName: String) {
        self.name = name
        self.capitalCity = City(name: capitalName, country: self)
    }
}

class City {
    let name: String
    unowned let country: Country
    init(name: String, country: Country) {
        self.name = name
        self.country = country
    }
}

var country = Country(name: "Canada", capitalName: "Ottawa")
print("\(country.name)'s capital city is called \(country.capitalCity.name)")
*/

// Resolving Strong Reference Cycles for Closures

class HTMLElement {
    let name: String
    let text: String?
    
    lazy var asHTML: () -> String = {
        [unowned self] in
        if let text = self.text {
            return "<\(self.name)>\(text)</\(self.name)>"
        } else {
            return "<\(self.name) />"
        }
    }
    
    init(name: String, text:String? = nil) {
        self.name = name
        self.text = text
    }
    
    deinit {
        print("\(name) is being deinitialized")
    }
}

var paragraph: HTMLElement? = HTMLElement(name:"p", text:"hello, world")
print(paragraph!.asHTML())
paragraph = nil // ARC deinit it :)

// Type Casting, Downcasting, and Any

class MediaItem {
    var name: String
    init(name: String) {
        self.name = name
    }
}

class Movie: MediaItem {
    var director: String
    init(name: String, director: String) {
        self.director = director
        super.init(name: name)
    }
}

class Song: MediaItem {
    var artist: String
    init(name: String, artist: String) {
        self.artist = artist
        super.init(name: name)
    }
}

var movieCount = 0
var songCount = 0

// Any can represent an instance of any type at all, including function types and optional types
// AnyObject can represent an instance of any class type

var library : [Any] = [1]
library.append(0)
library.append(Movie(name: "Moon", director: "Duncan"))
library.append(Song(name: "Mother", artist: "Json"))
library.append("Salam")
library.append(3.14159)

for item in library {
    if let media = item as? MediaItem {
        print("This is a media : ")
        if let movie = media as? Movie {
            print("Movie name: '\(movie.name)', dir. \(movie.director)")
        } else if let song = media as? Song {
            print("Song name: '\(song.name)', by \(song.artist)")
        } else {
            print("This Media is not Song or Movie")
        }
    } else {
        print("\(item) is not media")
    }
}

// extention
extension Int {
    func repetitions(task: () -> ()) {
        for _ in 1...self {
            task()
        }
    }
}

3.repetitions {
    print("Hello :))")
}

// protocol

protocol Named {
    var name: String{get}
}

protocol Aged {
    var age: Int{get}
}

struct Ensan: Named, Aged {
    var name: String
    var age: Int
}

func wishHappyBirthday(celebrator: Named & Aged) {
    print("Happy birthday \(celebrator.name) - you are \(celebrator.age)!")
}

let birthdayPerson = Ensan(name: "Ali", age: 21)
wishHappyBirthday(celebrator: birthdayPerson)

// Generics

func swapTwoValue<T> (a: inout T, b: inout T) {
    let tmpA = a
    a = b
    b = tmpA
}

var numA = 20
var numB = 30
print("A = \(numA) and B = \(numB)")

swapTwoValue(a: &numA, b: &numB)
print("A = \(numA) and B = \(numB)")

// Associated Types and Where Clauses

/*
protocol Container {
    typealias ItemType = String
    mutating func append(item: ItemType)
    var count: Int {get}
    subscript(i: Int) -> ItemType {get}
}

func allItemsMatch<
    C1: Container, C2: Container>
    (someContainer: C1, anotherContainer: C2) -> Bool
    where C1.ItemType == C2.ItemType, C1.ItemType: Equatable {
    
        if someContainer.count != anotherContainer.count {
            return false
        }
        
        for i in 0...someContainer.count {
            if (someContainer[i] != anotherContainer[i]) {
                return false
            }
        }
        
        return true
}

var stackOfString = Array<String>()
stackOfString.append("uno")
stackOfString.append("dos")
stackOfString.append("tres")

var arrayOfStrings = ["uno", "dos", "tres"]

if allItemsMatch(someContainer:
    stackOfString, anotherContainer: arrayOfStrings) {
    print("All items match")
} else {
    print("Not all items match")
}

*/

// Operator Function

prefix operator *
prefix func * (value: Int) -> Int {
    var ans = 1
    for _ in 1...value {
        ans *= value
    }
    return ans
}

print("We Love customized operator : *4 = \(*4)")

infix operator ^^
func ^^ (lhs: Int, rhs: Int) -> Int {
    var ans = 1
    for _ in 1...rhs {
        ans *= lhs
    }
    return ans
}

print("2^10 = \(2 ^^ 10)")
