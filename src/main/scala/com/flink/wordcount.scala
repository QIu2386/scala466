package com.flink

import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._

object WordCount {
    def main(args: Array[String]): Unit = {
        // 1 env  //2 source   //3 transform   //4 sink
        val tool: ParameterTool = ParameterTool.fromArgs(args)
        //        val inputPath: String = tool.get("input")
//        val outputPath: String = tool.get("output")
        val inputPath = "/opt/module/flink-1.7.0/input.txt"
        val outputPath = "/opt/module/flink-1.7.0/output11.txt"
        val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
        env.setParallelism(2)
        val txtDataSet: DataSet[String] = env.readTextFile(inputPath)

        val aggSet: AggregateDataSet[(String, Int)] = txtDataSet.flatMap(_.split(" ")).map((_, 1)).groupBy(0).sum(1)

        aggSet.writeAsCsv(outputPath)

        env.execute()

    }

}
