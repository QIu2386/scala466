package com.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.{SparkConf, sql}

object SparkSql {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("Rdd").setMaster("local[*]")

        val sparks: SparkSession = new sql.SparkSession.Builder().config(conf).getOrCreate()

        val frame: DataFrame = sparks.read.json("C:\\Users\\Tong\\Desktop\\scala466\\src\\test\\test.json")

        val listreduce: RDD[(String, Int)] = sparks.sparkContext.makeRDD(List(("lisi", 2), ("lisi", 6), ("zhangsan", 5), ("lisi", 4), ("lisi", 7), ("zhangsan", 1)), 2)

        import sparks.implicits._

        val df: DataFrame = listreduce.toDF("name", "age")

        val ds: Dataset[User] = df.as[User]

        ds.foreach(x => {
            println("name:" + x.name + "," + "age:" + x.age)
        })






        sparks.stop()
    }

}

case class User(name: String, age: Int)


