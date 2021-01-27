package com.tutorials.rdd

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object ReadMultipleFilesInRDD
{
  def main(args: Array[String]): Unit =
  {
    /**
     * Inicilizamos los Logger que solo muestre por consola ERROR y WARM
     * */
    Logger.getLogger("org").setLevel(Level.ERROR)
    Logger.getLogger("spark").setLevel(Level.WARN)

    /**
     * Iniciamos la Session de Saprk
     * */
    val spark:SparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate()

    /**
     * Spark Leer todos los archivos de texto de un directorio en un solo RDD
     * */
    val textFilePath ="/input/texfiles_rdd/*"
    val rdd = spark.sparkContext.textFile(textFilePath)
    rdd.foreach(f=>{
      println(f)
    })







  }

}
