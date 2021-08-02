package com.storyManagement.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "story")
class Story {

    @Id
    var id : String = null.toString()
    var heading : String = null.toString()
    var epicNumber : Long = 0
    var description : String = null.toString()
    var reporter : String = null.toString()
    var assignee : String = null.toString()
    var label : String = null.toString()
    var status : String = null.toString()

    override fun toString(): String {
        return "Story(id='$id', heading='$heading', epicNumber=$epicNumber, description='$description', reporter='$reporter', assignee='$assignee', label='$label', status='$status')"
    }

}