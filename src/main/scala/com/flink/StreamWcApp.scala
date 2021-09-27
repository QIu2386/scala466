package com.flink

import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

object StreamWcApp {
    def main(args: Array[String]): Unit = {
        //从外部命令中获取参数
        val tool: ParameterTool = ParameterTool.fromArgs(args)
        //        val host: String = tool.get("host")
//        val port: Int = tool.get("port").toInt
//        val host="192.168.1.103"
        val host = "192.168.101.56"
        val port = 7777

        //创建流处理环境
        val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
        //接收socket文本流
        val textDstream: DataStream[String] = env.socketTextStream(host, port)
        // flatMap和Map需要引用的隐式转换
        import org.apache.flink.api.scala._
        //处理 分组并且sum聚合
        val dStream: DataStream[(String, Int)] = textDstream.flatMap(_.split(" ")).filter(_.nonEmpty).map((_, 1)).keyBy(0).sum(1)
        //打印
        dStream.print()

        env.execute()
    }

}
