package com.example.myapplication.model

import com.google.gson.annotations.SerializedName


data class ApiListResponse (

	@SerializedName("status") val status : String,
	@SerializedName("copyright") val copyright : String,
	@SerializedName("num_results") val num_results : Int,
	@SerializedName("results") val result : List<ResultList>
)

data class ResultList (

	@SerializedName("abstract") val abstract : String,
	@SerializedName("published_date") val publishedDate : String,
	@SerializedName("byline") val byline : String
)