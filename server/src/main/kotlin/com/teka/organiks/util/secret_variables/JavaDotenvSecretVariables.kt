package com.teka.organiks.util.secret_variables


class JavaDotenvSecretVariables: SecretVariables {
    override fun get(name: SecretVariableName): String? {
        return System.getenv(name.value)
    }

    override fun get(name: SecretVariableName, defaultValue: String): String {
        return System.getenv(name.value) ?: defaultValue
    }

    override fun require(name: SecretVariableName): String {
        return get(name) ?: throw IllegalArgumentException("'${name.value}' env variable required")
    }
}