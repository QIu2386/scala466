package com.scala

import java.io.FileNotFoundException
import org.apache.hadoop.mapred.InvalidInputException
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import scala.util.control._

object break {
    def main(args: Array[String]): Unit = {
        val tuple: (Int, String) = (1, "ar")
        val sffwr = List(1, 2, 4, 6, 7)
//        for (e <- sffwr) {
//            println(e)
//        }
        Breaks.breakable(
            for (i <- 0 until 10) {
                println(i)
                if (i == 5) {
                    Breaks.break
                }
            }
        )
        // 0,1,2,3,4,5


        for (i <- 0 until 10) {
            Breaks.breakable {
                if (i == 3 || i == 6) {
                    Breaks.break
                }
                println(i)
            }
        }
        //0,1,2,4,5,7,8,9

        try {
            val conf: SparkConf = new SparkConf().setAppName("Rdd").setMaster("local[*]")

            val sc = new SparkContext(conf)
            val json: RDD[String] = sc.textFile("C:\\Users\\Tong\\Desktop\\scala466\\src\\test\\test100.json")

            json.foreach(println)
        } catch {
            case ex: InvalidInputException => println("找不到文件")

            case asf: ClassNotFoundException => println("找不到类")

        }
    }

}