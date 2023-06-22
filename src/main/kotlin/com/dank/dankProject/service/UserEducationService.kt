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
    fun getUsersEducationHistoryUsingInstitutionId(institutionId: String,
                                                   sortBy : String,
                                                   sortDirection : String,
                                                   pageNumber : String,
                                                   pageSize : String)
    : List<UserEducationHistory> {
        lateinit var userDetailResponse: List<UserEducationHistory>
        lateinit var pageable : Pageable;
        if (userRepository.existsByInstitutionId(institutionId))
        {
            if (sortBy.isNotEmpty() && sortDirection.isNotEmpty())
            {
                if (sortBy.contentEquals("name"))
                {
                    if (sortDirection.contentEquals("asc"))
                    {
                        pageable = PageRequest.of(Integer.parseInt(pageNumber),
                                                  Integer.parseInt(pageSize),
                                                  Sort.by(Sort.Direction.ASC,sortBy));
                        userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable)
                    } else if (sortDirection.contentEquals("desc"))
                    {
                        pageable = PageRequest.of(Integer.parseInt(pageNumber),
                                                  Integer.parseInt(pageSize),
                                                  Sort.by(Sort.Direction.DESC,sortBy));
                        userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable);
                    }
                }
                if (sortBy.contentEquals("email"))
                {
                    if (sortDirection.contentEquals("asc"))
                    {
                        pageable = PageRequest.of(Integer.parseInt(pageNumber),
                                                  Integer.parseInt(pageSize),
                                                  Sort.by(Sort.Direction.ASC,sortBy));
                        userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable)
                    } else if (sortDirection.contentEquals("desc"))
                    {
                        pageable = PageRequest.of(Integer.parseInt(pageNumber),
                                                  Integer.parseInt(pageSize),
                                                  Sort.by(Sort.Direction.DESC,sortBy));
                        userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable)
                    }
                }
            }
            else
            {
                pageable = PageRequest.of(Integer.parseInt(pageNumber),
                                          Integer.parseInt(pageSize));
                userDetailResponse = userRepository.findByInstitutionId(institutionId,pageable);
            }
        }
        else
        {
            throw Exception("InstitutionId Not Found Exception");
        }
        return userDetailResponse
    }
}