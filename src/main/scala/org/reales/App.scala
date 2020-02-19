package org.reales

import org.apache.spark.sql.SparkSession

/**
 * Hello world!
 *
 */
object App
{
	def main(strings: Array[String]): Unit =
	{
		val spark = SparkSession
			.builder()
			.appName("Spark Kafka Application")
    		.getOrCreate()
		
		
	}
}
