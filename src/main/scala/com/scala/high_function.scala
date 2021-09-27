package com.scala


object high_function {
    def main(args: Array[String]): Unit = {
        def test(f: Double => Double, n1: Double) = {
            f(n1) //调用f函数
        }
        //
        def sum(d: Double): Double = {
            d + d
        }
        val res = test(sum, 6.0)
        println("res=" + res)

    }

}
