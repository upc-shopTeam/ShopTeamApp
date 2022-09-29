package Beans

class Product {
 var _id: String
 var name:String
 var unitPrice: String
 var description: String
 var stock: Number
 var img: String
 var campus: String
 var __v: Number
 var category:String

 constructor(
  _id: String,
  name: String,
  unitPrice: String,
  description: String,
  stock: Number,
  img: String,
  campus: String,
  __v:Number,
  category: String
 ) {
  this._id = _id
  this.name = name
  this.unitPrice = unitPrice
  this.description = description
  this.stock = stock
  this.img = img
  this.campus = campus
  this.__v = __v
  this.category = category
 }
}