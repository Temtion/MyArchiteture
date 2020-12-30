package com.temption.myarchitecture.server.dto

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/30 10:52
 */

data class DouBanResp(
    val count: Int,
    val start: Int,
    val topics: List<Topic>,
    val total: Int
)

data class Topic(
    val alt: String,
    val author: Author,
    val comments_count: Int,
    val content: String,
    val created: String,
    val id: String,
    val is_private: Boolean,
    val like_count: Int,
    val locked: Boolean,
    val photos: List<Photo>,
    val screenshot_title: String,
    val screenshot_type: String,
    val screenshot_url: String,
    val share_url: String,
    val title: String,
    val updated: String
)

data class Size(
    val height: Int,
    val width: Int
)

data class Photo(
    val alt: String,
    val author_id: String,
    val creation_date: String,
    val id: String,
    val layout: String,
    val seq_id: String,
    val size: Size,
    val title: String,
    val topic_id: String
)

data class Author(
    val alt: String,
    val avatar: String,
    val id: String,
    val is_suicide: Boolean,
    val large_avatar: String,
    val name: String,
    val type: String,
    val uid: String
)