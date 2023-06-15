package com.dank.dankProject.controller

import com.dank.dankProject.model.UserEducationHistory
import com.dank.dankProject.service.UserEducationService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Business/Controller Layer
 */

@RestController
@RequestMapping("/v1")
class UserEducationController(private val userEducationService: UserEducationService) {

    @PostMapping("/api/education/saveUsersEducationHistory")
    @Operation(description = "This API endpoint adds the record/document to the collection..",
               method = "POST")
    fun saveUserEducationDetails(@RequestBody userDetails: UserEducationHistory)
    : UserEducationHistory = userEducationService.saveUserEducationDetails(userDetails);


    @GetMapping("api/education/getAllUsersEducationHistory")
    @Operation(description = "This API endpoint fetches all the user's education history..",
               method = "GET")
    fun getAllUser() : List<UserEducationHistory> = userEducationService.getUserEducationDetails();

    @GetMapping("api/education/getUsersEducationHistory/{userId}")
    @Operation(description = "This API endpoint fetches all the education history of requested user..",
            method = "GET")
    fun getUserEducationHistoryUsingId(@PathVariable("userId") userId: String)
    : Optional<UserEducationHistory> = userEducationService.getUserEducationHistoryUsingId(userId);

    @PutMapping("api/education/updateUsersEducationHistory")
    @Operation(description = "This API endpoint updates the education history of requested user..",
            method = "PUT")
    fun updateUserEducationHistory(@RequestBody userDetails: UserEducationHistory)
    : UserEducationHistory = userEducationService.updateUserEducationHistory(userDetails);

    @DeleteMapping("api/education/deleteUsersEducationHistory/{userId}")
    @Operation(description = "This API endpoint deletes all the education history of requested user..",
            method = "DELETE")
    fun deleteUserEducationHistory(@PathVariable("userId") userId: String)
    : Unit = userEducationService.deleteUserEducationHistory(userId);

}