package com.scala

object _trait {
    def main(args: Array[String]): Unit = {
        val man=new score
        man.study()
    }
}

trait study{
    def study(): Unit ={
        println("学习")
    }
}
class score extends study {}