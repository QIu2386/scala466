package com.scala

object ByteShort {
    def main(args: Array[String]): Unit = {
        val r1: Byte = 127
        val r2: Short = 32767
        val r3: Int = 2147483647
        val r4: Long = 9223372036854775807L
        val r5: Float = 18888888888888888888888888888888888888F
        val r6: Double = 1888888888888888888888888888888888888D
        val r8: Boolean = true
        val r7: Char = '8'
        val r9: String = "af"

        val and = r4 < r5 && r2 < r6
        println(and)
        val or = r4 > r5 || r2 < r6
        println(or)
        val fei = !(r4 > r5 || r2 < r6)
        println(fei)

       

    }

}
