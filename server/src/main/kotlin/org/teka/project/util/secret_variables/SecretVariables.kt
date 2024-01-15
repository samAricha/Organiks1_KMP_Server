package org.teka.project.util.secret_variables

import org.teka.project.util.secret_variables.SecretVariableName


interface SecretVariables {

    fun get(name: SecretVariableName) : String?

    fun get(name: SecretVariableName, defaultValue: String) : String?

    fun require(name: SecretVariableName) : String
}