package com.scala

object _match {
    def main(args: Array[String]): Unit = {
        val fdfe = List(1, "1", 1.2)
        for (i <- fdfe) {
            i match {
                case a: Int => println("是一个数字")
                case b: String => println("是一个字符")
                case _ => println("没找到")
            }
        }
        val saffe=new Son
        saffe.test()
        implicit def tests(d:Double):Int={
            d.toInt
        }

        val num2:Int=5.6
    }

}


class Father {
    def test() = {
        println("few")
    }
}

class Son extends Father {
    override def test()={
        val ww=2
        println(ww)

    }
}