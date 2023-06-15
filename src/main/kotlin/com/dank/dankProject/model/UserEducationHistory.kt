package com.dank.dankProject.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/***
 * UserEducation Entity
 */

@Document("user")
class UserEducationHistory() {

    @Id
    lateinit var userId: String
    lateinit var publicId: String
    lateinit var institutionId: String
    lateinit var degree: String

    constructor(userId: String, publicId: String,institutionId: String,degree: String) : this() {
        this.userId = userId
        this.publicId = publicId
        this.institutionId = institutionId
        this.degree = degree
    }
}