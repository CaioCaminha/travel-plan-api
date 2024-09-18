package com.example.domain

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val name: String,
    val description: String,
    val priority: Priority = Priority.LOW,
)

enum class Priority {
    LOW, MEDIUM, HIGH, VITAL
}