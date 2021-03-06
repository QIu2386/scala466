package com.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
object KafkaStreaming {
    def main(args: Array[String]): Unit = {
        // 使用SparkStreaming完成WordCount

        // Spark配置对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming01_WordCount")

        // 实时数据分析环境对象
        // 采集周期：以指定的时间为周期采集实时数据
        val streamingContext = new StreamingContext(sparkConf, Seconds(5))

        // 从Kafka中采集数据
        //streamingContext.receiverStream(new MyReceiver("linux1", 9999))
        val kafkaDStream: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream(
            streamingContext,
            "192.168.1.102:2181",
            "atguigu",
            Map("atguigu" -> 3)
        )
        kafkaDStream.count().print()

        // 将采集的数据进行分解（扁平化）
        val wordDStream: DStream[String] = kafkaDStream.flatMap(t=>t._2.split(" "))

        // 将数据进行结构的转换方便统计分析
        val mapDStream: DStream[(String, Int)] = wordDStream.map((_, 1))

        // 将转换结构后的数据进行聚合处理
        val wordToSumDStream: DStream[(String, Int)] = mapDStream.reduceByKey(_+_)

        // 将结果打印出来
        wordToSumDStream.print()

        // 不能停止采集程序
        //streamingContext.stop

        // 启动采集器
        streamingContext.start()
        // Drvier等待采集器的执行
        streamingContext.awaitTermination()
    }

}
