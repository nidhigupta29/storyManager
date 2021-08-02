package com.storyManagement.repository

import com.storyManagement.model.Story
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StoryRepository : MongoRepository<Story, String> {

    fun findAllByOrderByEpicNumber(): List<Story>?
    fun findByStatus(status: String?): Story
    fun findByEpicNumber(epicNumber: Long): Story


}