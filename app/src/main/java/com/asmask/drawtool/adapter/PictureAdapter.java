package com.asmask.drawtool.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asmask.drawtool.R;
import com.asmask.drawtool.bean.Picture;


/**
 * 描述：图片adapter
 */
public class PictureAdapter extends BaseAblistViewAdapter<Picture> {

    public PictureAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_picture, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView
                    .findViewById(R.id.tv_name);
            viewHolder.ivPicture = (ImageView) convertView
                    .findViewById(R.id.iv_picture);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picture item = getItem(position);
        viewHolder.tvName.setText(item.getName());
        viewHolder.ivPicture.setImageResource(item.getContentId());
        return convertView;
    }

    private final class ViewHolder {
        ImageView ivPicture;
        TextView tvName;
    }
}
