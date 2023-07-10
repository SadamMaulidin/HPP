package com.example.hpp

class Profile {
    var bussiness_name: String? = null
    var bussiness_type: String? = null
    var address: String? = null
    var phone_num: String? = null
    var owner: String? = null

    constructor() {}
    constructor(
        bussiness_name: String?,
        bussiness_type: String?,
        address: String?,
        phone_num: String?,
        owner: String?
    ) {
        this.bussiness_name = bussiness_name
        this.bussiness_type = bussiness_type
        this.address = address
        this.phone_num = phone_num
        this.owner = owner
    }
}