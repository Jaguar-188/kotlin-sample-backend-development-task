package com.dank.dankProject.service

import com.dank.dankProject.model.UserEducationHistory
import com.dank.dankProject.repository.UserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
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
                            institutionName = userDetails.institutionName,
                            degree = userDetails.degree,
                            name = userDetails.name,
                            email = userDetails.email,
                            mobileNumber = userDetails.mobileNumber
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

    /***
     * Fetches all the records/documents of requested institutionId from collection with requested
     * parameters
     */
    fun getUsersEducationHistoryUsingInstitutionId(institutionId: String,sortBy : String,
                                                   sortDirection : String,
                                                   pageNumber : String,
                                                   pageSize : String)
    : List<UserEducationHistory> {
        lateinit var userDetailResponse: List<UserEducationHistory>
        lateinit var pageable : Pageable;
        if (userRepository.existsByInstitutionId(institutionId)) {
            pageable = PageRequest.of(Integer.parseInt(pageNumber),Integer.parseInt(pageSize));
            if (sortBy.isNotEmpty() && sortDirection.isNotEmpty()) {
                if (sortBy.contentEquals("name")) {
                    if (sortDirection.contentEquals("asc")) {
                        userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable).sortedBy { it.name }
                    } else if (sortDirection.contentEquals("desc")) {
                        userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable).sortedByDescending { it.name }
                    }
                }
                if (sortBy.contentEquals("email")) {
                    if (sortDirection.contentEquals("asc")) {
                        userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable).sortedBy { it.email }
                    } else if (sortDirection.contentEquals("desc")) {
                        userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable).sortedByDescending { it.email }
                    }
                }
            }
            else {
                userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable);
            }
        }
        else {
            throw Exception("InstitutionId Not Found Exception");
        }
        return userDetailResponse
    }
}