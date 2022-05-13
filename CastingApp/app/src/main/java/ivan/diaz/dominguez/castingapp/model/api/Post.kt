package ivan.diaz.dominguez.castingapp.model.api

data class Post (
    var id: String,
    var name: String,
    var gender: String,
    var age:Number,
    var eye_color: String,
    var hair_color: String,
    var checked : Boolean = false
)
