package com.github.footballclubsubmission

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.club_list_item.view.*
import org.jetbrains.anko.image

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/16/2018
 *  check https://github.com/KeiLazu for more
 */
class ClubAdapter(private val _context: Context, private val _clubs: List<ModelClub>, private val _listener: (ModelClub) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(_parent: ViewGroup, _viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(_context).inflate(R.layout.club_list_item, _parent, false)
    )

    override fun getItemCount(): Int = _clubs.size

    override fun onBindViewHolder(_holder: ViewHolder, _position: Int) {
        _holder.bind(_clubs.get(_position), _listener)
    }


    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(_club: ModelClub, listener: (ModelClub) -> Unit) {
            itemView.club_list_item_tv_club_name.text = _club._clubName
            _club._clubImage?.let {
                Picasso.get().load(it).resize(50,50).into(itemView.club_list_item_img_club)
            }
            containerView.setOnClickListener {
                listener(_club)
            }
        }

    }

}