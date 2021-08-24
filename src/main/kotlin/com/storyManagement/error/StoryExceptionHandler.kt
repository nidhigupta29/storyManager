package com.storyManagement.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class StoryExceptionHandler {

    @ExceptionHandler
    fun handleException(exc : StoryNotFoundException) : ResponseEntity<StoryErrorResponse> {
        val storyErrorResponse = StoryErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exc.message,
            System.currentTimeMillis())

        return ResponseEntity(storyErrorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleGenericException(exc : Exception) : ResponseEntity<StoryErrorResponse> {
        val storyErrorResponse = StoryErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            exc.message,
            System.currentTimeMillis()
        )

        return ResponseEntity(storyErrorResponse, HttpStatus.BAD_REQUEST)
    }

}