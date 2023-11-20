package com.example.finalbs_

data class Comments (
    val events: List<Event>,
    val info: Info,
    val schedule: Schedule
)

data class Event(
    val end: String,
    val note: String,
    val start: String
)

data class Info(
    val name: String,
    val region: String
)

data class Schedule(
    val days: List<Day>,
    val source: String
)

data class Day(
    val date: String,
    val name: String,
    val stages: List<List<String>>
)
