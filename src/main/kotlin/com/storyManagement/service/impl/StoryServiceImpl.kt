package com.storyManagement.service.impl

import com.storyManagement.model.Story
import com.storyManagement.repository.StoryRepository
import com.storyManagement.service.StoryService
import org.springframework.stereotype.Service

@Service
class StoryServiceImpl( val storyRepository: StoryRepository) : StoryService {

    override fun findAll(): List<Story> {
        return storyRepository.findAll()
    }

    override fun saveOrUpdateStudent(story: Story): Story {
        return storyRepository.save(story)
    }

    override fun findAllByOrderByEpicNumber(): List<Story>? {
        return storyRepository.findAllByOrderByEpicNumber()
    }

    override fun findByStatus(status: String): List<Story> {
        return storyRepository.findByStatus(status)
    }

    override fun deleteStory(story: Story) {
        return storyRepository.delete(story)
    }

    override fun findByEpicNumber(epicNumber: Long): Story {
        return storyRepository.findByEpicNumber(epicNumber)
    }
}