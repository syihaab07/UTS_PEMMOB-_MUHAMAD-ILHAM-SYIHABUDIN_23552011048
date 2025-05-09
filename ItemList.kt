//Baris ini menyatakan bahwa file ItemList.kt berada dalam package com.example.utspemmob1
//Ini membantu pengelompokan file dan menghindari konflik nama antar kelas di aplikasi
package com.example.utspemmob1

//Mendeklarasikan data class bernama ItemList
//Data class digunakan untuk menyimpan data sederhana (seperti model atau entitas)
//Secara otomatis menyediakan fungsi-fungsi seperti toString(), equals(), hashCode(), dan copy()
data class ItemList(

    //Properti pertama dari ItemList, menyimpan teks judul artikel/berita
    //Tipe datanya adalah String dan dapat diubah (var)
    var judul: String,

    //Properti kedua, digunakan untuk menyimpan deskripsi pendek atau isi ringkas dari artikel
    var subJudul: String,

    //Properti ketiga, menyimpan URL gambar yang berkaitan dengan artikel
    var imageUrl: String
)
