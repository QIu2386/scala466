package com.scala

import scala.collection.mutable

object seq_set_map {
    def main(args: Array[String]): Unit = {
        import scala.collection.immutable
//        var stringFofsad=Array(1,2,43,4)
//        stringFofsad(2)=2321
//        println(stringFofsad.mkString(","))
//        println(stringFofsad)
        val set01 = Set(1, 2, 4, "abc")
        println(set01)
        val set02 = mutable.Set(1, 2, 4, "abc")
        println(set02)


        var map1=Map("li"->50,"wang"->450,"zhao"->30,"qiu"->2)
        println(map1("li"))
        val bool: Boolean = map1.contains("qiu")
        println(bool)
        println(map1.getOrElse("zhao1",0))
        map1=map1-"wang"
        println(map1)
    }

}
