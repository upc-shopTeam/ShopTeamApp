package Beans

class Category {
    var _id: String
    var name: String
    var img: String

    constructor( _id:String,name: String,img: String) {
        this.name = name
        this.img=img
        this._id=_id
    }
}