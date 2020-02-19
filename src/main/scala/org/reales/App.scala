package org.reales

import org.apache.spark.sql.SparkSession
import org.reales.consumer.KafkaConsumer

object App
{
	def main(args: Array[String]): Unit =
	{
		val spark = SparkSession
			.builder()
			.appName("Spark Kafka Application")
			.config("spark.master", "local")
    		.getOrCreate()
		
		val kafkaConsumer = new KafkaConsumer(spark, args(0))
		
		kafkaConsumer.subscribeKafkaTopic(args(1), args(2))
	}
}
