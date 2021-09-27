package com.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
        val streamingContext = new StreamingContext(conf,Seconds(3))
        val socke: ReceiverInputDStream[String] = streamingContext.socketTextStream("192.168.1.104",9999)
        val wordStream: DStream[String] = socke.flatMap(_.split(" "))
        val wordSum: DStream[(String, Int)] = wordStream.map((_,1)).reduceByKey(_+_)
        wordSum.print()
        streamingContext.start()
        streamingContext.awaitTermination()



    }

}
