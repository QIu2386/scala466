package com.scala

import java.io.FileNotFoundException
import scala.beans.BeanProperty

object plus {
    def main(args: Array[String]): Unit = {
        lazy val dsfe = sum2(3)
        println(dsfe)
    }

    def sum2(i: Int): Int = {
        i * 2
    }

    try {
        val int=1
        val integral=0
        println(int/integral)

    } catch {
        case e: FileNotFoundException => ()
        case b: ClassNotFoundException => ()
        case c: Exception => println("saf")
    }
    val person: Person = new Person(2)
    println(person.show(8))

        val car = new Car
        //使用
        car.name = "奔驰" //底层是 car.name.$eq()
        car.setName("路虎")
        println(car.name) //底层使用的是car.name()
        println(car.getName)


}

class Person(ife: Int) {
    def show(ys: Int): Int = {
        ys
    }


}

class Car {
    @BeanProperty var name: String = "baoma"


}