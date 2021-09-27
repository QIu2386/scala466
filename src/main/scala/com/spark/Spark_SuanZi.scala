package com.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_SuanZi {
    def main(args: Array[String]): Unit = {

        val conf: SparkConf = new SparkConf().setAppName("Rdd").setMaster("local[*]")

        val sc = new SparkContext(conf)

//        val listRdd: RDD[Int] = sc.makeRDD(List(1,2,3,7,8,9,9,3,45,36,6),4)
//
//        val fil: RDD[Int] = listRdd.filter(_%2==0)
//
//        fil.foreach(println)
//
//        val array: Array[Array[Int]] = fil.glom().collect()
//
//        array.flatMap(x=>x).foreach(println)


        val listreduce: RDD[(String, Int)] = sc.makeRDD(List(("lisi", 2), ("lisi", 6), ("zhangsan", 5), ("lisi", 4), ("lisi", 7), ("zhangsan", 1)), 2)

//        val new_rdd: RDD[(String, Int)] = listreduce.reduceByKey(_+_)
//        new_rdd.foreach(println)

//        val unit: RDD[(String, Int)] = listreduce.groupByKey().map(x=>(x._1,x._2.sum))
//        unit.foreach(println)

//        val agg_rdd: RDD[(String, Int)] = listreduce.aggregateByKey(0)(Math.max(_,_),_+_)
//        agg_rdd.foreach(println)

//        val Combine_Rdd: RDD[(String, (Int, Int))] = listreduce.combineByKey((_,1),(acc:(Int,Int),v)=>((acc._1+v,acc._2+1)),(acc1:(Int,Int),acc2:(Int,Int))=>(acc1._1+acc2._1,acc1._2+acc2._2))
//        Combine_Rdd.foreach(println)

//            val stringToLong: collection.Map[String, Long] = listreduce.countByKey()
//            stringToLong.foreach(println)

//        val jsonFile: RDD[String] = sc.textFile("C:\\Users\\Tong\\Desktop\\scala466\\src\\test\\test.json")
//        val jsonRdd: RDD[Option[Any]] = jsonFile.map(JSON.parseFull)
//        jsonRdd.foreach(println)
//        val list_new=sc.makeRDD(List(1,2,3))
//        list_new.foreach(println)

        val aggWord: RDD[(String, Int)] = listreduce.aggregateByKey(0)(_+_,_+_)
        val foldWord: RDD[(String, Int)] = listreduce.foldByKey(0)(_+_)
        foldWord.foreach(println)




    }

}
