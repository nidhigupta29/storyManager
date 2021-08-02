package com.storyManagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EnableMongoRepositories("com.storyManagement.repository")
class StoryApplication

fun main(args: Array<String>) {
	runApplication<StoryApplication>(*args)
}
