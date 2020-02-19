package org.reales.consumer

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession


class KafkaConsumer (spark: SparkSession, boostrapServers: String)
{
	/**
	 * Subscribe to a Kafka topic
	 * @param topic Topic to be subscribed
	 * @param offset Possible values: earliest, latest
	 */
	def subscribeKafkaTopic(topic: String, offset: String) =
	{
		// Read Streaming topic
		val df = spark
			.readStream
			.format("kafka")
			.option("kafka.bootstrap.servers", boostrapServers)
    		.option("subscribe", topic)
			.load
		
		// df.selectExpr("CAST(KEY AS STRING)", "CAST(VALUE AS STRING)").as[(String, String)]
		
		val df2 = spark
    		.read
    		.format("kafka")
    		.option("kafka.bootstrap.servers", boostrapServers)
    		.option("subscribe", topic)
    		.option("startingOffsets", offset)
    		.load()
		
		
	}
}
