package com.storyManagement.controller

import com.storyManagement.error.StoryNotFoundException
import com.storyManagement.model.Story
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.assertThrows

@SpringBootTest
internal class StoryControllerTest {

    @Autowired
    lateinit var storyController: StoryController
    val list = mutableListOf<Story>()

    @Test
    fun contextLoads() {
    }

    @Test
    fun getStoryByStatus() {
        val story: Story = Story("786", "Heading", 12, "This a test class", "Nidhi", "Rishi", "FMO", "don")
        assertThrows(StoryNotFoundException::class.java, { storyController.getStoryByStatus("don") })

    }

}