package Beans

class Customer {
    var name:String
    var email: String
    var phoneNumber:String
    var photo: String

    constructor( name: String, email: String, phoneNumber: String, photo: String) {

        this.name = name
        this.email = email
        this.phoneNumber = phoneNumber
        this.photo=photo
    }
}