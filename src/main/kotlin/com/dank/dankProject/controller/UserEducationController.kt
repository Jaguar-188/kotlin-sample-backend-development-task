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
    @Operation(summary = "This API endpoint adds the record/document to the collection..",
               description = "Provide the details by excluding userId field as it is auto-generated..",
               method = "POST")
    fun saveUserEducationDetails(@RequestBody userDetails: UserEducationHistory)
    : UserEducationHistory = userEducationService.saveUserEducationDetails(userDetails);


    @GetMapping("api/education/getAllUsersEducationHistory")
    @Operation(summary = "This API endpoint fetches all the user's education history..",
               description = "Doesn't need to provide any thing as request parameter..",
               method = "GET")
    fun getAllUsersEducationHistory() : List<UserEducationHistory> = userEducationService.getUserEducationDetails();

    @GetMapping("api/education/getUsersEducationHistory/{userId}")
    @Operation(summary = "This API endpoint fetches all the education history of requested user..",
               description = "Provide any userId from the collection..",
               method = "GET")
    fun getUserEducationHistoryUsingId(@PathVariable("userId") userId: String)
    : Optional<UserEducationHistory> = userEducationService.getUserEducationHistoryUsingId(userId);

    @PutMapping("api/education/updateUsersEducationHistory")
    @Operation(summary = "This API endpoint updates the education history of requested user..",
               description = "Provide the updated request body along with userId..",
               method = "PUT")
    fun updateUserEducationHistory(@RequestBody userDetails: UserEducationHistory)
    : UserEducationHistory = userEducationService.updateUserEducationHistory(userDetails);

    @DeleteMapping("api/education/deleteUsersEducationHistory/{userId}")
    @Operation(summary = "This API endpoint deletes all the education history of requested user..",
               description = "Provide the userId from the collection..",
               method = "DELETE")
    fun deleteUserEducationHistory(@PathVariable("userId") userId: String)
    : Unit = userEducationService.deleteUserEducationHistory(userId);

    @GetMapping("api/education/getUsersEducationHistoryUsingInstitutionId/{institutionId}")
    @Operation(summary = "This API endpoint fetches the records using institutionId and some other requested parameters..",
               description = "Provide institutionId which is a required parameter and sort options if required",
               method = "GET")
    fun getUsersEducationHistoryUsingInstitutionId(@PathVariable("institutionId") institutionId : String,
                                                   @RequestParam(required = false, defaultValue = "") sortBy: String,
                                                   @RequestParam(required = false, defaultValue = "") sortDirection: String,
                                                   @RequestParam(required = true, defaultValue = "0") pageNumber: String,
                                                   @RequestParam(required = true, defaultValue = "1") pageSize: String)
    : List<UserEducationHistory> = userEducationService.getUsersEducationHistoryUsingInstitutionId(institutionId,
            sortBy,sortDirection,pageNumber,pageSize);

}