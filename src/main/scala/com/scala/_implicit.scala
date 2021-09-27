package com.scala

object _implicit {
    def main(args: Array[String]): Unit = {
        implicit class test2(m: test1) {
            def sayhi = println("hi")

        }
        val fdsfef = new test1
        fdsfef.sayhi
        fdsfef.sayhello()
    }

}


class test1 {
    def sayhello(): Unit = println("hello")

}
