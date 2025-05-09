//Menentukan package tempat file ini berada (com.example.utspemmob1)
package com.example.utspemmob1

//Import library Android dan eksternal
//LayoutInflater, View, ViewGroup: digunakan untuk men-inflate (membuat tampilan dari layout XML)
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//ImageView, TextView: komponen UI
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
// @NonNull: anotasi agar parameter tidak boleh null (tidak wajib dipakai jika pakai Kotlin)
import androidx.annotation.NonNull
// RecyclerView, RecyclerView.Adapter: komponen dan adapter RecyclerView
import androidx.recyclerview.widget.RecyclerView
// Glide: library untuk memuat gambar dari URL ke ImageView
import com.bumptech.glide.Glide

// Mendeklarasikan AdapterList, sebuah kelas turunan dari RecyclerView.Adapter
// Menerima parameter itemLists, yaitu list data dari tipe ItemList (judul, subjudul, gambar)
// ViewHolder didefinisikan di dalam kelas
class AdapterList(private val itemLists: List<ItemList>) : RecyclerView.Adapter<AdapterList.ViewHolder>(){
    // Fungsi ini dipanggil saat RecyclerView butuh ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // LayoutInflater digunakan untuk mengubah file XML item_data.xml menjadi objek View
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
            // ViewHolder(view) akan menyimpan view yang di-inflate
        return ViewHolder(view)
    }

    // Mengisi data ke dalam elemen UI berdasarkan posisi data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // itemLists[position]: ambil item dari list berdasarkan urutan
        val item = itemLists[position]
        // Mengisi TextView dan ImageView di ViewHolder dengan data
        holder.judul.text = item.judul
        holder.subJudul.text = item.subJudul
        // Glide digunakan untuk memuat gambar dari URL ke ImageView
        Glide.with(holder.imageView.context)
            .load(item.imageUrl)
            .into(holder.imageView)
    }

    // Mengembalikan jumlah item dalam list, untuk menentukan berapa banyak item yang akan ditampilkan
    override fun getItemCount(): Int = itemLists.size

    // ViewHolder menyimpan referensi ke elemen tampilan agar tidak bolak-balik mencari findViewById()
    // Digunakan untuk mengikat data ke UI
    class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.item_image)
        val judul: TextView = itemView.findViewById(R.id.title)
        val subJudul: TextView = itemView.findViewById(R.id.sub_title)
    }
}
