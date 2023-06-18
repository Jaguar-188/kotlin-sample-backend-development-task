package com.dank.dankProject.model

import org.springframework.beans.factory.annotation.Autowired
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
    lateinit var institutionName: String
    lateinit var degree: String
    lateinit var name: String
    lateinit var email: String
    lateinit var mobileNumber: String

    @Autowired
    constructor(userId: String, publicId: String,institutionId: String,institutionName: String,degree: String,name: String,
                email: String,mobileNumber: String) : this() {
        this.userId = userId
        this.publicId = publicId
        this.institutionId = institutionId
        this.institutionName = institutionName
        this.degree = degree
        this.name = name
        this.email = email
        this.mobileNumber = mobileNumber
    }
}