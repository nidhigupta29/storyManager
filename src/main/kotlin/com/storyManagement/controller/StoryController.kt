package com.storyManagement.controller

import com.storyManagement.model.Story
import com.storyManagement.service.StoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal


@RestController
@RequestMapping("/story")
class StoryController(val storyService: StoryService) {

    @GetMapping(value = ["/"])
    fun getAllStory() : List<Story> {
        return storyService.findAll()
    }

    @GetMapping("/user")
    fun user(principal: Principal?): Principal? {
        return principal
    }


    @PostMapping(value = ["/"])
    fun saveStory(@RequestBody story: Story): ResponseEntity<*> {
        storyService.saveStory(story)
        return ResponseEntity<Any?>("Story card added successfully", HttpStatus.OK)
    }

    @GetMapping(value = ["/orderByEpic"])
    fun findAllByOrderByEpicNumber(): List<Story?>? {
        return storyService.findAllByOrderByEpicNumber()
    }

    @GetMapping(value = ["/status"])
    fun getStoryByStatus(@RequestParam(name = "status") status: String): List<Story> {
        return storyService.findByStatus(status)
    }

    @DeleteMapping(value = ["/{epicNumber}"])
    fun deleteStory(@PathVariable epicNumber : Long) : ResponseEntity<*> {
        storyService.deleteStory(storyService.findByEpicNumber(epicNumber))
        return ResponseEntity<Any?>("Story card deleted successfully", HttpStatus.OK)
    }

    @PutMapping(value = ["/{status}"])
    fun updateStatus(@RequestBody story: Story, @PathVariable("status") status: String) : ResponseEntity<*> {
        story.status = status
        storyService.saveStory(story)
        return ResponseEntity<Any?>("Story card status updated successfully", HttpStatus.OK)
    }



}