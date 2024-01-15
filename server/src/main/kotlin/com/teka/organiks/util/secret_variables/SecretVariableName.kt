package com.teka.organiks.util.secret_variables

sealed class SecretVariableName(val value: String) {
    data object ServerHost : SecretVariableName(value = "APP_HOST")
    data object ServerPort : SecretVariableName(value = "APP_PORT")
    data object AtApiKey : SecretVariableName(value = "AT_API_KEY")
    data object AtApiUserName : SecretVariableName(value = "AT_USERNAME_KEY")
    //class bcs of the variable passed
    data class DynamicEnvVariable(private val myEnvVariable: String) : SecretVariableName(value = myEnvVariable)

}