package com.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
    def main(args: Array[String]): Unit = {

        val wordcount: SparkConf = new SparkConf().setMaster("local").setAppName("wordcount")

        val sc = new SparkContext(wordcount)

      val word: RDD[(String, Int)] = sc.textFile("C:\\Users\\Tong\\Desktop\\498.txt").flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)

      word.foreach(println)


//      sc.textFile("/home/atguigu/wordcount.txt").flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).saveAsTextFile("/home/atguigu/sad55fdlv54")


//        val list=sc.makeRDD(List(1,2,3,4,5,6))
//        list.saveAsTextFile("/home/atguigu/711")

        sc.stop()

    }
}
