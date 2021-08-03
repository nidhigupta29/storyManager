package com.storyManagement


import com.storyManagement.controller.StoryController
import com.storyManagement.model.Story
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StoryApplicationTests {

	@Autowired
	lateinit var storyController: StoryController
	val list = mutableListOf<Story>()

	@Test
	fun contextLoads() {
	}

	@Test
	fun addStoryTest(){
		val story: Story = Story("12","AB",23,"KJ","IO","JK","WE","TY")
		storyController.saveOrUpdateStory(story)
		assertEquals(200, storyController.saveOrUpdateStory(story).statusCode.value())
	}

	@Test
	fun sortByStatusTest(){
		val story: Story = Story("12","AB",23,"KJ","IO","JK","WE","TY")
		storyController.updateStatus(story, "done")
		assertEquals(200, storyController.updateStatus(story, "done").statusCodeValue)
		assertEquals("done", storyController.storyService.findByEpicNumber(23).status)
	}

}
