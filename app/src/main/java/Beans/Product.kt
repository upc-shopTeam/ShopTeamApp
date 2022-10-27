package Beans

class Product {
 var _id: String
 var name:String
 var unitPrice: Number
 var description: String
 var stock: Number
 var img: String
 var campus: String
 var category:String

 constructor(
  name: String,
  unitPrice: Number,
  description: String,
  stock: Number,
  img: String,
  campus: String,
  category: String
 ) {
  this.name = name
  this.unitPrice = unitPrice
  this.description = description
  this.stock = stock
  this.img = img
  this.campus = campus
  this.category = category
 }
}