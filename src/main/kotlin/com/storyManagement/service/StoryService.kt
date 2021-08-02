package com.storyManagement.service

import com.storyManagement.model.Story
import org.springframework.stereotype.Service

@Service
interface StoryService {

    fun findAll(): List<Story>
    fun saveOrUpdateStudent(story: Story): Story
    fun findAllByOrderByEpicNumber(): List<Story>?
    fun findByStatus(status: String): Story
    fun deleteStory(story: Story)
    fun findByEpicNumber(epicNumber: Long): Story

}