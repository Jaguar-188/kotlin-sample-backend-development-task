package com.dank.dankProject.repository

import com.dank.dankProject.model.UserEducationHistory
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<UserEducationHistory,String> {


}