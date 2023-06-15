package com.dank.dankProject.service

import com.dank.dankProject.model.UserEducationHistory
import com.dank.dankProject.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.Exception

/**
 * Service Layer
 */

@Service
class UserEducationService(private var userRepository : UserRepository) {

    /***
     * Retrieves all the data present in collection
     */
    fun getUserEducationDetails() : List<UserEducationHistory> = userRepository.findAll();

    /***
     * Creates a new entry/record in collection
     */
    fun saveUserEducationDetails(userDetails :UserEducationHistory): UserEducationHistory = userRepository.save(userDetails)

    /***
     * Retrieves record/document of a particular user from collection
     */
    fun getUserEducationHistoryUsingId(userId: String)
    : Optional<UserEducationHistory> = userRepository.findById(userId);

    /***
     * Updates record/document of a requested user from collection
     */
    fun updateUserEducationHistory(userDetails: UserEducationHistory): UserEducationHistory {
        return if (userRepository.existsById(userDetails.userId)){
            userRepository.save(
                    UserEducationHistory(
                            userId = userDetails.userId,
                            publicId = userDetails.publicId,
                            institutionId = userDetails.institutionId,
                            degree = userDetails.degree
                    )
            )
        } else {
            throw Exception("User Not Found Exception")
        }
    }

    /***
     * Deletes record/document of requested user from collection
     */
    fun deleteUserEducationHistory(userId: String) : Unit {
        return if (userRepository.existsById(userId)){
            userRepository.deleteById(userId)
        } else {
            throw Exception("User Not Found Exception")
        }
    }
}