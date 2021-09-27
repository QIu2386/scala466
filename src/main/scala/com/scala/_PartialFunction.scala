package com.scala

object _PartialFunction {

    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3, 4, "abc")
        val f1 = new PartialFunction[Any,Int] {

            //对传入的数据，进行判断(过滤)，如果返回true,就处理该元素
            //否则，过滤掉该元素
            override def isDefinedAt(x: Any): Boolean = {
                println("aaa")
                x.isInstanceOf[Int]
            }

            //如果isDefinedAt 为true, 就会调用apply去处理元素
            override def apply(v1: Any): Int = {
                println("bbb")
                v1.asInstanceOf[Int] + 1
            }
        }
        println("f1=" + f1) // <funtion1>
        //调用偏函数不能使用map,而是collect
        val list2 = list.collect(f1) //
        println("list2=" + list2)
    }

}

