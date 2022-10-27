package Beans

import java.util.*

class Order {
    var _id: String
    var date: Date
    var customer: String
    var employee:String

    constructor( _id:String,date:Date, customer:String, employee:String) {
        this.date = date
        this.customer = customer
        this.employee = employee
        this._id = _id
    }
}