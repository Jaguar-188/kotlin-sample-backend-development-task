package com.dank.dankProject.repository

import com.dank.dankProject.model.UserEducationHistory
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<UserEducationHistory,String> {

    fun findByInstitutionId(@Param("institutionId") institutionId : String) : List<UserEducationHistory>

    fun existsByInstitutionId(@Param("institutionId") institutionId : String) : Boolean

}