package com.example.kotlin.test

/**
 * Description: <A009_when 表达式 + 密封类><br>
 * Author:      mxdl<br>
 * Date:        2025/3/5<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

fun handleResult(result: Result) = when (result) {
    is Result.Success -> println("Success: ${result.data}")
    is Result.Error -> println("Error: ${result.message}")
    Result.Loading -> println("Loading...")
}