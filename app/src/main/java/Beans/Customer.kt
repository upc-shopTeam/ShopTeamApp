package Beans

class Customer {
    var _id: String
    var name:String
    var email: String
    var phoneNumber:String
    var photo: String

    constructor(_id: String, name: String, email: String, phoneNumber: String, photo: String) {
        this._id = _id
        this.name = name
        this.email = email
        this.phoneNumber = phoneNumber
        this.photo=photo
    }
}