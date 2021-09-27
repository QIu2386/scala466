package com.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

//import org.apache.spark.{SparkConf, SparkContext}

object test2 {
  def main(args: Array[String]): Unit = {
    val srkConf: SparkConf = new SparkConf().setAppName("SparkWC").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(srkConf)
    val name=Array(Tuple2(1,"spark"),Tuple2(2,"ty"))
    val score=Array(Tuple2(1,100),Tuple2(2,90))
    val nameRDD: RDD[(Int, String)] = sc.parallelize(name)
    val scorerdd: RDD[(Int, Int)] = sc.parallelize(score)
    nameRDD.join(scorerdd).collect.foreach(println)

  }

}
